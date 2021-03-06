package com.chunlei.eat.service;

import com.chunlei.eat.entity.QrCode;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.model.ApiResp;

import java.util.List;

/**
 * @Created by lcl on 2019/9/17 0017
 */
public interface QrCodeService {

    public void binding(String eToken,Integer deskCode,Integer qrId,ApiResp resp);

    public void delBinding(String eToken,Integer qrId,ApiResp resp);

    public void findMyQrs(String eToken, ApiResp<List<QrCode>> resp);

    public void qrContent(Integer qrId, ApiResp<QrCode> resp);

    public void preMake(String pwd, ApiResp resp);

    public void getShopInfo(Integer qrId, ApiResp<ShopInfo> resp);

}
