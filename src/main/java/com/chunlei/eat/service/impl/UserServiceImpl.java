package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.UserInfo;
import com.chunlei.eat.mapper.UserMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.UserService;
import com.chunlei.eat.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Created by lcl on 2019/9/6 0006
 * 顾客token
 * 商家eToken
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(isolation= Isolation.READ_UNCOMMITTED)
    public void loginApp(String wxOpenId, ApiResp<String> apiResp) {
        UserInfo userInfo = userMapper.findMyInfo(wxOpenId);
        if(userInfo==null){
            int i = userMapper.insertOne(wxOpenId);
            if(i==1){
                userInfo = userMapper.findMyInfo(wxOpenId);
                String tolen = TokenUtil.getUtoken(userInfo.getUserId(),wxOpenId);
                apiResp.setRespMsg(userInfo.getUserId().toString());
                apiResp.setRespData(tolen);
            }else {
                apiResp.respErr(MsgConstant.SYS_ERR);
            }
        }else {
            String tolen = TokenUtil.getUtoken(userInfo.getUserId(),wxOpenId);
            apiResp.setRespMsg(userInfo.getUserId().toString());
            apiResp.setRespData(tolen);
        }
    }


}
