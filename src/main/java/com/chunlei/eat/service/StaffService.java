package com.chunlei.eat.service;

import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.resp.ShopStaff;

import java.util.List;

/**
 * @Created by lcl on 2019/9/19 0019
 */
public interface StaffService {

    public void findAllShopStaff(String eToken, ApiResp<List<ShopStaff>> resp);

    public void preInfo(String eToken,Integer uId, ApiResp<ShopStaff> resp);

}
