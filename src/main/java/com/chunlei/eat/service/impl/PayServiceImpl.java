package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.entity.VipPay;
import com.chunlei.eat.mapper.ShopMapper;
import com.chunlei.eat.mapper.VipPayMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.PayService;
import com.chunlei.eat.utils.DateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/20 0020
 */
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private VipPayMapper vipPayMapper;
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public void checkPay(String payNum, Integer payValue, ApiResp resp) {
        VipPay vipPay = vipPayMapper.findByPayNum(payNum);
        if(vipPay==null){
            resp.respErr("交易单号未录入");
        }else if(vipPay.getGetStatus().equals(1)){
            resp.respErr("交易单号重复使用");
        }else if(!vipPay.getPayValue().equals(payValue)){
            resp.respErr("交易单号申请金额于实际支付金额不匹配");
        }else {
            //校验成功
            int i =0;
            Date nowDate = new Date();
            Date expDate;
            ShopInfo shopInfo = shopMapper.findShopById(vipPay.getShopId());
            if(shopInfo.getExpireTime()==null||shopInfo.getExpireTime().before(nowDate)){
                //首次开通VIP---中断续费
                expDate = DateTool.addDay(nowDate,vipPay.getVipday()+1);
            }else{
                //续费VIP
                expDate = DateTool.addDay(shopInfo.getExpireTime(),vipPay.getVipday());
            }
            i = shopMapper.updateVipDate(1,expDate,vipPay.getShopId());
            if(i==0){
                resp.respErr(MsgConstant.OPE_ERR);
            }else {
                i = vipPayMapper.updateGetStatus(1,vipPay.getInId());
                if(i==0){
                    throw new RuntimeException("充值审核失败！");
                }
            }
        }
    }


}
