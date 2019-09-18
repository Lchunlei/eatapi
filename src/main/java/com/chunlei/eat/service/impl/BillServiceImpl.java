package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.BillInfo;
import com.chunlei.eat.entity.FoodInfo;
import com.chunlei.eat.mapper.BillInfoMapper;
import com.chunlei.eat.mapper.FoodMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.req.MakeOrder;
import com.chunlei.eat.model.resp.CtmBill;
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

    @Override
    @Transactional
    public void makeBill(MakeOrder makeOrder, ApiResp resp) {
        Integer uid = TokenUtil.getUidByToken(makeOrder.geteToken());
        Integer sid = TokenUtil.getSidByToken(makeOrder.geteToken());
        if(uid==null&&sid!=null){
            //商家代客下单
            uid = 0;
        }
        for(FoodInfo b:makeOrder.getBillInfos()){
            FoodInfo foodInfo = foodMapper.findFoodById(b.getFoodId());
            if(foodInfo.getShopId().equals(makeOrder.getShopId())&&foodInfo.getFoodName().equals(b.getFoodName())){
                //菜单校验完毕，入库
                BillInfo billInfo = new BillInfo(uid,foodInfo.getShopId(),makeOrder.getDeskCode(),foodInfo.getFoodId(),foodInfo.getFoodName(),b.getCount(),b.getFoodPrice()*b.getCount());
                billInfoMapper.insertOne(billInfo);
            }else {
                resp.respErr(MsgConstant.OPE_ERR);
            }
        }

        if(!resp.getRespCode().equals("R000")){
            throw new RuntimeException("菜品信息不合规！！");
        }
    }

    @Override
    public void rate(Integer userId, ApiResp<Integer> resp) {
        List<BillInfo> billInfos = billInfoMapper.findMyBills(userId,1);
        if(billInfos.isEmpty()){
            resp.respErr("您的菜已上齐，如有疑问请咨询店家！");
        }else {
            Integer rate = billInfoMapper.findRate(billInfos.get(0).getShopId(),billInfos.get(0).getBillId());
            resp.setRespData(rate);
        }
    }

    @Override
    public void getBills(Integer billStatus,String eToken, ApiResp<List<BillInfo>> resp) {
        Integer shopId = TokenUtil.getSidByToken(eToken);
        if(shopId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            if(billStatus==null){

            }else if(billStatus.equals(0)){
                //待处理客单
//                List<Integer> eatingUsers = billInfoMapper.findUsersEating(shopId,billStatus);
//                if(eatingUsers.isEmpty()){
//                    resp.respErr(MsgConstant.DATA_NULL);
//                }else {
//                    List<BillInfo> billInfos = new ArrayList();
//                    for(Integer uid:eatingUsers){
//                        List<BillInfo> bs = billInfoMapper.findUserBills(shopId,uid,billStatus);
//                        billInfos.addAll(bs);
//                    }
//                    resp.setRespData(billInfos);
//                }

            }else if(billStatus.equals(1)){
                //待出餐
                List<BillInfo> billInfos = billInfoMapper.findOutBills(shopId,billStatus);
                if(billInfos.isEmpty()){
                    resp.respErr(MsgConstant.DATA_NULL);
                }else {
                    resp.setRespData(billInfos);
                }
            }else if(billStatus.equals(2)){
                //月全部订单
                List<BillInfo> billInfos = billInfoMapper.findAllBills(shopId);
                if(billInfos.isEmpty()){
                    resp.respErr(MsgConstant.DATA_NULL);
                }else {
                    resp.setRespData(billInfos);
                }
            }else if(billStatus.equals(3)){
                //历史全部订单

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
            List<Integer> eatingUsers = billInfoMapper.findUsersEating(shopId,billStatus);
            if(eatingUsers.isEmpty()){
                resp.respErr(MsgConstant.DATA_NULL);
            }else {
                List<CtmBill> ctmBills = new ArrayList();
                for(Integer uid:eatingUsers){
                    CtmBill cb = new CtmBill();
                    List<BillInfo> bs = billInfoMapper.findUserBills(shopId,uid,billStatus);
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
    public void completeUserBill(Integer userId, String eToken, ApiResp resp) {
        Integer shopId = TokenUtil.getSidByToken(eToken);
        if(shopId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            if(userId==0){
                resp.respErr("代客下单不可一键完成！");
            }else {
                int i = billInfoMapper.completeBills(shopId,userId);
                if(i==0){
                    resp.respErr(MsgConstant.OPE_ERR);
                }
            }
        }
    }

    @Override
    public void deal(Integer billId,Integer billStatus,String eToken, ApiResp resp) {
        TokenUtil.getSopenIdByToken(eToken);
        int i = billInfoMapper.updateStatus(billId,billStatus);
        if(i!=1){
            resp.respErr(MsgConstant.OPE_ERR);
        }
    }


}
