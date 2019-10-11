package com.chunlei.eat.service;

import com.chunlei.eat.entity.QrGet;
import com.chunlei.eat.model.ApiResp;

/**
 * @Created by lcl on 2019/10/10 0010
 */
public interface QrGetService {

    public void getQr(QrGet qrGet, ApiResp resp);

}
