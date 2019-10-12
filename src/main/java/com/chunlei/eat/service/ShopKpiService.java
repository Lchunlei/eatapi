package com.chunlei.eat.service;

import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.resp.ShopKpi;

/**
 * @Created by lcl on 2019/10/12 0012
 */
public interface ShopKpiService {

    public void todayKpi(String eToken, ApiResp<ShopKpi> resp);

}
