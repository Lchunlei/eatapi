package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.mapper.BillInfoMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.resp.ShopKpi;
import com.chunlei.eat.service.ShopKpiService;
import com.chunlei.eat.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Created by lcl on 2019/10/12 0012
 */
@Service
public class ShopKpiServiceImpl implements ShopKpiService {

    @Autowired
    private BillInfoMapper billInfoMapper;

    @Override
    public void todayKpi(String eToken, ApiResp<ShopKpi> resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowDay = format.format(new Date());
            String sTime = nowDay.substring(0,10)+" 00:00:00";
            Integer billNum = billInfoMapper.findBillNum(sId,sTime,nowDay);
            ShopKpi kpi;
            if(billNum==null||billNum<1){
                kpi = new ShopKpi(0,0,0);
            }else {
                Integer cNum = billInfoMapper.findClientNum(sId,sTime,nowDay);
                Integer income = billInfoMapper.findIncome(sId,sTime,nowDay);
                kpi = new ShopKpi(income,billNum,cNum);
            }
            resp.setRespData(kpi);
        }
    }

}
