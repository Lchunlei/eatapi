package com.chunlei.eat.service;

import com.chunlei.eat.entity.QrCode;
import com.chunlei.eat.model.ApiResp;

import java.util.List;

/**
 * @Created by lcl on 2019/9/17 0017
 */
public interface QrCodeService {

    public void addShopQr(String eToken,Integer qrTotal,ApiResp resp);

    public void findMyQrs(String eToken, ApiResp<List<QrCode>> resp);


}
