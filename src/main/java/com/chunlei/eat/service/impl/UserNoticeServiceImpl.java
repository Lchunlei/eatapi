package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.UserNotice;
import com.chunlei.eat.mapper.UserNoticeMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.UserNoticeService;
import com.chunlei.eat.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by lcl on 2019/9/10 0010
 */
@Service
public class UserNoticeServiceImpl implements UserNoticeService {
    @Autowired
    private UserNoticeMapper userNoticeMapper;

    @Override
    public void findNotice(String eToken, ApiResp resp) {
        try {
            String openid = TokenUtil.getOpenIdByToken(eToken);
            List<UserNotice> notices = userNoticeMapper.findByOpenID(openid);
            List<UserNotice> alls = userNoticeMapper.findAll();
            notices.addAll(alls);
            resp.setRespData(notices);
        }catch (Exception e){
            List<UserNotice> alls = userNoticeMapper.findAll();
            resp.setRespData(alls);
        }
    }

    @Override
    public void findNoticeDetails(Integer nteId, ApiResp<UserNotice> resp) {
        UserNotice userNotice = userNoticeMapper.findById(nteId);
        if(userNotice==null){
            resp.respErr(MsgConstant.DATA_NULL);
        }else {
            resp.setRespData(userNotice);
        }
    }


}
