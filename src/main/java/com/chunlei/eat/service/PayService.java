package com.chunlei.eat.service;

import com.chunlei.eat.model.ApiResp;

/**
 * @Created by lcl on 2019/9/20 0020
 */
public interface PayService {

    public void checkPay(String payNum, Integer payValue, ApiResp resp);

}
