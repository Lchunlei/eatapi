package com.chunlei.eat.service;

import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.resp.ShopStaff;

import java.util.List;

/**
 * @Created by lcl on 2019/9/19 0019
 */
public interface StaffService {

    public void findAllShopStaff(String eToken, ApiResp<List<ShopInfo>> resp);

    public void delMyStaff(String eToken,Integer shopId, ApiResp resp);

    public void preAdd(String eToken,Integer uId,Integer userRole, ApiResp resp);

    public void cofInvite(String eToken,Integer cof,ApiResp resp);

    public void lookupStaff(String eToken,ApiResp<Integer> resp);

}
