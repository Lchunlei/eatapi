package com.chunlei.eat.service;

import com.chunlei.eat.entity.ShopBlack;
import com.chunlei.eat.model.ApiResp;

import java.util.List;

/**
 * @Created by lcl on 2019/11/5 0005
 */
public interface ShopBlackService {

    public void addBlack(ShopBlack shopBlack, ApiResp resp);

    public void shopBlacks(String eToken, ApiResp<List<ShopBlack>> resp);

    public void delBlack(String eToken,Integer userId, ApiResp resp);

}
