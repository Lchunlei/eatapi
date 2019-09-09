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

/**
 * @Created by lcl on 2019/9/6 0006
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserMapper userMapper;

    @Override
    public void loginApp(String wxOpenId, ApiResp<String> apiResp) {
        UserInfo userInfo = userMapper.findMyInfo(wxOpenId);
        if(userInfo==null){
            int i = userMapper.insertOne(wxOpenId);
            if(i==1){
                userInfo = userMapper.findMyInfo(wxOpenId);
                String tolen = TokenUtil.getToken(userInfo.getUserId(),wxOpenId);
                apiResp.setRespData(tolen);
            }else {
                apiResp.respErr(MsgConstant.SYS_ERR);
            }
        }else {
            String tolen = TokenUtil.getToken(userInfo.getUserId(),wxOpenId);
            apiResp.setRespData(tolen);
        }
    }


}
