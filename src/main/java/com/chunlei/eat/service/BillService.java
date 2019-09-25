package com.chunlei.eat.service;

import com.chunlei.eat.entity.BillInfo;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.req.MakeOrder;
import com.chunlei.eat.model.resp.CtmBill;
import com.chunlei.eat.model.resp.UserRate;

import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public interface BillService {

    public void makeBill(MakeOrder makeOrder, ApiResp resp);

    public void rate(Integer userId, ApiResp<UserRate> resp);

    public void deal(Integer billId,Integer billStatus,String eToken, ApiResp<Integer> resp);

    public void getBills(Integer tabNum,String eToken, ApiResp<List<BillInfo>> resp);

    public void ctmBill(Integer billStatus,String eToken, ApiResp<List<CtmBill>> resp);

    public void delUserBill(Integer userId,String eToken,ApiResp resp);

    public void delOneBill(Integer billId,String eToken,ApiResp resp);

    public void sendDishe(Integer billId,String eToken,ApiResp resp);

    public void completeUserBill(Integer userId,String eToken,ApiResp resp);


}
