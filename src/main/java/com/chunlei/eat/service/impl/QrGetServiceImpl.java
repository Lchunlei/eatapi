package com.chunlei.eat.service.impl;

import com.chunlei.eat.entity.QrGet;
import com.chunlei.eat.mapper.QrGetMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.QrGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by lcl on 2019/10/10 0010
 */
@Service
public class QrGetServiceImpl implements QrGetService {
    @Autowired
    private QrGetMapper qrGetMapper;

    @Override
    public void getQr(QrGet qrGet, ApiResp resp) {
        qrGetMapper.insertOne(qrGet);
    }


}
