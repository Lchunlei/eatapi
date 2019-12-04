package com.chunlei.eat.service;

import com.chunlei.eat.entity.DanMu;
import com.chunlei.eat.model.ApiResp;

import java.util.List;

/**
 * @Created by lcl on 2019/11/29 0029
 */
public interface DanMuService {

    public void findDanMus(String useType, ApiResp<List<DanMu>> resp);

    public void sendDanMu(DanMu danMu,ApiResp resp);

}
