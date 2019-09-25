package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.controller.PayCotroller;
import com.chunlei.eat.entity.AgentIncome;
import com.chunlei.eat.entity.AgentInfo;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.entity.VipPay;
import com.chunlei.eat.mapper.AgentIncomeMapper;
import com.chunlei.eat.mapper.AgentInfoMapper;
import com.chunlei.eat.mapper.ShopMapper;
import com.chunlei.eat.mapper.VipPayMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.PayService;
import com.chunlei.eat.utils.DateTool;
import com.chunlei.eat.utils.StringTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/20 0020
 */
@Service
public class PayServiceImpl implements PayService {
    private static final Logger log = LoggerFactory.getLogger(PayServiceImpl.class);
    @Autowired
    private VipPayMapper vipPayMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private AgentIncomeMapper agentIncomeMapper;
    @Autowired
    private AgentInfoMapper agentInfoMapper;

    @Override
    @Transactional
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
            //店铺VIP时间延长
            i = shopMapper.updateVipDate(1,expDate,vipPay.getShopId());
            if(i==0){
                resp.respErr(MsgConstant.OPE_ERR);
            }else {
                //本次交易完成
                i = vipPayMapper.updateGetStatus(1,vipPay.getInId());
                if(!StringTool.isBlank(shopInfo.getInviteCode())){
                    //直推立即返现
                    AgentInfo agentInfo = agentInfoMapper.findByMobile(shopInfo.getInviteCode());
                    if(agentInfo==null){
                        log.info("所填邀请码无效");
                    }else {
                        AgentIncome agentIncome = new AgentIncome((payValue*6/10),agentInfo.getAgId(),agentInfo.getZfbCode(),1);
                        agentIncomeMapper.insertOne(agentIncome);
                    }
                }
                if(i==0){
                    throw new RuntimeException("充值审核失败！");
                }
            }
        }
    }


}
