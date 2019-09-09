package com.chunlei.eat.service;

import com.chunlei.eat.entity.UserInfo;
import com.chunlei.eat.model.ApiResp;

/**
 * @Created by lcl on 2019/9/6 0006
 */
public interface UserService {

    public void loginApp(String wxOpenId, ApiResp<String> apiResp);


}
