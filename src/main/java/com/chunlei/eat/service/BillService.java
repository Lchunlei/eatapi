package com.chunlei.eat.service;

import com.chunlei.eat.entity.BillInfo;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.req.MakeOrder;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public interface BillService {

    public void makeBill(MakeOrder makeOrder, ApiResp resp);

    public void rate(Integer userId, ApiResp<Integer> resp);

    public void deal(Integer billId,Integer billStatus,String eToken, ApiResp<Integer> resp);



}
