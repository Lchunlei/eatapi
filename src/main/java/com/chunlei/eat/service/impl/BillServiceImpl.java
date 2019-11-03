package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.BillInfo;
import com.chunlei.eat.entity.FoodInfo;
import com.chunlei.eat.entity.QrCode;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.mapper.*;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.req.MakeOrder;
import com.chunlei.eat.model.resp.CtmBill;
import com.chunlei.eat.model.resp.UserRate;
import com.chunlei.eat.service.BillService;
import com.chunlei.eat.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillInfoMapper billInfoMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private QrCodeMapper qrCodeMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过菜谱下单
     * */
    @Override
    @Transactional
    public void makeBill(MakeOrder makeOrder, ApiResp resp) {
        Integer uid = TokenUtil.getUidByToken(makeOrder.geteToken());
        Integer sid = TokenUtil.getSidByToken(makeOrder.geteToken());
        //其中shopId就是传来的桌码ID
        if(makeOrder.getShopId()==null||makeOrder.getShopId().equals(0)){
            //没有扫桌码直接下单、只允许商家自己下单，顾客必须扫码下单
            if(sid==null){
                //商家带客下单,商家没有登录
                resp.respErr(MsgConstant.NOT_LOGIN);
            }else {
                //商家代客下单
                ShopInfo shopInfo = shopMapper.findShopById(sid);
                if(shopInfo.getUserRole().equals(1)){
                    //店长
                    for(FoodInfo b:makeOrder.getBillInfos()){
                        FoodInfo foodInfo = foodMapper.findFoodById(b.getFoodId());
                        if(shopInfo.getShopId().equals(b.getShopId())&&foodInfo.getFoodName().equals(b.getFoodName())){
                            //菜单校验完毕，入库
                            BillInfo billInfo = new BillInfo(0,shopInfo.getShopId(),0,foodInfo.getFoodId(),foodInfo.getFoodName(),b.getCount(),b.getFoodPrice()*b.getCount());
                            billInfoMapper.insertOne(billInfo);
                        }else {
                            resp.respErr(MsgConstant.OPE_ERR);
                            throw new RuntimeException("菜品信息不合规！！");
                        }
                    }
                }else {
                    //店员
                    for(FoodInfo b:makeOrder.getBillInfos()){
                        FoodInfo foodInfo = foodMapper.findFoodById(b.getFoodId());
                        if(shopInfo.getMySid().equals(b.getShopId())&&foodInfo.getFoodName().equals(b.getFoodName())){
                            //菜单校验完毕，入库
                            BillInfo billInfo = new BillInfo(0,shopInfo.getMySid(),0,foodInfo.getFoodId(),foodInfo.getFoodName(),b.getCount(),b.getFoodPrice()*b.getCount());
                            billInfoMapper.insertOne(billInfo);
                        }else {
                            resp.respErr(MsgConstant.OPE_ERR);
                            throw new RuntimeException("菜品信息不合规！！");
                        }
                    }
                }
            }
        }else {
            //扫了桌码下单
            if(uid==null){
                uid = userMapper.findMyInfo(TokenUtil.getSopenIdByToken(makeOrder.geteToken())).getUserId();
            }
            QrCode qrCode = qrCodeMapper.findQrById(makeOrder.getShopId());
            //先删除此人在其他店铺未完成的订单
            billInfoMapper.delOtherShopBills(qrCode.getShopId());
            for(FoodInfo b:makeOrder.getBillInfos()){
                FoodInfo foodInfo = foodMapper.findFoodById(b.getFoodId());
                if(foodInfo.getShopId().equals(qrCode.getShopId())&&foodInfo.getFoodName().equals(b.getFoodName())){
                    //菜单校验完毕，入库
                    BillInfo billInfo = new BillInfo(uid,qrCode.getShopId(),qrCode.getDeskCode(),foodInfo.getFoodId(),foodInfo.getFoodName(),b.getCount(),b.getFoodPrice()*b.getCount());
                    billInfoMapper.insertOne(billInfo);
                }else {
                    resp.respErr(MsgConstant.OPE_ERR);
                    throw new RuntimeException("菜品信息不合规！！");
                }
            }
        }
    }

    @Override
    public void rate(Integer userId, ApiResp<UserRate> resp) {

        List<BillInfo> billInfos = billInfoMapper.findMyWillEatBills(userId);
        if(billInfos.isEmpty()){
            resp.respErr(MsgConstant.NO_BILL);
        }else {
            ShopInfo shopInfo = shopMapper.findShopById(billInfos.get(0).getShopId());
            Integer billId = billInfoMapper.notOut(billInfos.get(0).getShopId(),userId);
            Integer rate;
            if(billId==null){
                rate =0;
            }else {
                rate = billInfoMapper.findRateByBillid(billInfos.get(0).getShopId(),billId);
            }

            int total = 0;
            for(BillInfo b:billInfos){
                if(b.getShopId().equals(shopInfo.getShopId())){
                    total = b.getTotalPrice() + total;
                }
            }
            UserRate userRate = new UserRate(shopInfo.getShopName(),rate,total,billInfos);
            resp.setRespData(userRate);
        }
    }

    @Override
    public void getBills(Integer tabNum,Integer pageNum,String eToken, ApiResp<List<BillInfo>> resp) {
        Integer shopId = TokenUtil.getSidByToken(eToken);
        if(shopId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            List<BillInfo> billInfos;
            if(tabNum.equals(1)){
                //待出餐
                billInfos = billInfoMapper.findOutBills(shopId,0);
            }else if(tabNum.equals(2)){
                //本月全部
                billInfos = billInfoMapper.findAllBills(shopId,(pageNum-1)*10);
            }else {
                //本月全部
                billInfos = billInfoMapper.findAllBills(shopId,(pageNum-1)*10);
            }
            if(billInfos.isEmpty()){
                resp.respErr(MsgConstant.DATA_NULL);
            }else {
                resp.setRespData(billInfos);
            }
        }
    }

    @Override
    public void ctmBill(Integer billStatus, String eToken, ApiResp<List<CtmBill>> resp) {
        Integer shopId = TokenUtil.getSidByToken(eToken);
        if(shopId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            //待处理客单
            List<Integer> noPayUsers = billInfoMapper.findUsersNoPay(shopId);
            if(noPayUsers.isEmpty()){
                resp.respErr(MsgConstant.DATA_NULL);
            }else {
                List<CtmBill> ctmBills = new ArrayList();
                for(Integer uid:noPayUsers){
                    CtmBill cb = new CtmBill();
                    List<BillInfo> bs = billInfoMapper.findNoPayUserBills(shopId,uid);
                    Date makeTime=new Date();
                    Integer deskCode=0;
                    Integer userId=0;
                    Integer totalPay = 0;
                    for(BillInfo b:bs){
                        makeTime = b.getcTime();
                        deskCode = b.getDeskCode();
                        userId=b.getUserId();
                        totalPay=totalPay+b.getTotalPrice();
                    }
                    cb.setBills(bs);
                    cb.setDeskCode(deskCode);
                    cb.setMakeTime(makeTime);
                    cb.setTotalPay(totalPay);
                    cb.setUserId(userId);
                    cb.setShopId(shopId);
                    ctmBills.add(cb);
                }
                resp.setRespData(ctmBills);
            }

        }
    }

    @Override
    public void delUserBill(Integer userId, String eToken, ApiResp resp) {
        Integer shopId = TokenUtil.getSidByToken(eToken);
        if(shopId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo shopInfo = shopMapper.findShopById(shopId);
            if(!shopInfo.getUserRole().equals(1)){
                //员工
                shopId = shopInfo.getMySid();
            }
            if(userId==0){
                resp.respErr("代客下单不可删除！");
            }else {
                int i = billInfoMapper.delUserBills(shopId,userId);
                if(i==0){
                    resp.respErr(MsgConstant.OPE_ERR);
                }
            }
        }
    }

    @Override
    public void delOneBill(Integer billId, String eToken, ApiResp resp) {
        Integer shopId = TokenUtil.getSidByToken(eToken);
        if(shopId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo shopInfo = shopMapper.findShopById(shopId);
            if(!shopInfo.getUserRole().equals(1)){
                //员工
                shopId = shopInfo.getMySid();
            }
            int i = billInfoMapper.delById(billId,shopId);
            if(i==0){
                resp.respErr(MsgConstant.OPE_ERR);
            }
        }
    }

    @Override
    public void sendDishe(Integer billId, String eToken, ApiResp resp) {
        Integer shopId = TokenUtil.getSidByToken(eToken);
        if(shopId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo shopInfo = shopMapper.findShopById(shopId);
            if(!shopInfo.getUserRole().equals(1)){
                //员工
                shopId = shopInfo.getMySid();
            }
            int i = billInfoMapper.updateStatus(billId,1,shopId);
            if(i==0){
                resp.respErr(MsgConstant.OPE_ERR);
            }
        }
    }

    @Override
    public void completeUserBill(Integer userId, String eToken, ApiResp resp) {
        Integer shopId = TokenUtil.getSidByToken(eToken);
        if(shopId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo shopInfo = shopMapper.findShopById(shopId);
            if(!shopInfo.getUserRole().equals(1)){
                //员工
                shopId = shopInfo.getMySid();
            }
            int i = billInfoMapper.completeBills(shopId,userId);
            if(i==0){
                resp.respErr(MsgConstant.OPE_ERR);
            }
        }
    }

//    @Override
//    public void deal(Integer billId,Integer billStatus,String eToken, ApiResp resp) {
//        TokenUtil.getSopenIdByToken(eToken);
//        int i = billInfoMapper.updateStatus(billId,billStatus);
//        if(i!=1){
//            resp.respErr(MsgConstant.OPE_ERR);
//        }
//    }


}
