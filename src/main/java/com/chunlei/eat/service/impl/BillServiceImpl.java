package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.BillInfo;
import com.chunlei.eat.entity.FoodInfo;
import com.chunlei.eat.mapper.BillInfoMapper;
import com.chunlei.eat.mapper.FoodMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.req.MakeOrder;
import com.chunlei.eat.service.BillService;
import com.chunlei.eat.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        for(BillInfo b:makeOrder.getBillInfos()){
            FoodInfo foodInfo = foodMapper.findFoodById(b.getFoodId());
            if(foodInfo.getShopId().equals(makeOrder.getShopId())){
                b.setShopId(makeOrder.getShopId());
                b.setFoodName(foodInfo.getFoodName());
                int price = b.getEatNum()*foodInfo.getFoodPrice();
                b.setTotalPrice(price);
                billInfoMapper.insertOne(b);
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
    public void deal(Integer billId,Integer billStatus,String eToken, ApiResp resp) {
        TokenUtil.getIdByToken(eToken);
        int i = billInfoMapper.updateStatus(billId,billStatus);
        if(i!=1){
            resp.respErr(MsgConstant.OPE_ERR);
        }
    }


}
