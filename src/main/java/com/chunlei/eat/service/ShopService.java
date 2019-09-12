package com.chunlei.eat.service;

import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.entity.VipPay;
import com.chunlei.eat.model.ApiResp;

/**
 * @Created by lcl on 2019/8/26 0026
 */
public interface ShopService {

    public void userLogin(ShopInfo shopInfo, ApiResp apiResp);

    public void join(ShopInfo shopInfo, ApiResp apiResp);

    public void upInfo(ShopInfo shopInfo, ApiResp apiResp);

    public void renewVip(VipPay vipPay, ApiResp apiResp);

    public void getInfo(String eToken, ApiResp<ShopInfo> apiResp);

}
