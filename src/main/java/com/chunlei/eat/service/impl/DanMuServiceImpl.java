package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.DanMu;
import com.chunlei.eat.mapper.DanMuMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.DanMuService;
import com.chunlei.eat.utils.TokenUtil;
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
        resp.setRespMsg("https://yuxian.oss-cn-qingdao.aliyuncs.com/jiaocheng01.mp4");
        resp.setRespData(mus);
    }

    @Override
    public void sendDanMu(DanMu danMu, ApiResp resp) {
        String uOpenId = TokenUtil.getUopenIdByToken(danMu.getWxOpenId());
        DanMu oldDanMu = danMuMapper.findMaxDanMus(danMu.getUseType().toString());
        danMu.setWxOpenId(uOpenId);
        if(oldDanMu.getTime()>150){
            danMu.setTime(2);
        }else {
            danMu.setTime(oldDanMu.getTime()+1);
        }
        int i = danMuMapper.insertOne(danMu);
        if(i!=1){
            resp.respErr(MsgConstant.OPE_ERR);
        }
    }

}
