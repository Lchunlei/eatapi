package com.chunlei.eat.service.impl;

import com.chunlei.eat.entity.DanMu;
import com.chunlei.eat.mapper.DanMuMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.DanMuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by lcl on 2019/11/29 0029
 */
@Service
public class DanMuServiceImpl implements DanMuService {

    @Autowired
    private DanMuMapper danMuMapper;

    @Override
    public void findDanMus(String useType, ApiResp<List<DanMu>> resp) {
        List<DanMu> mus = danMuMapper.findDanMus(useType);
        resp.setRespData(mus);
    }

}
