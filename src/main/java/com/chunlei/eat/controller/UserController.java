package com.chunlei.eat.controller;

import com.alibaba.fastjson.JSONObject;
import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.UserInfo;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.UserService;
import com.chunlei.eat.utils.Reqclient;
import com.chunlei.eat.utils.StringTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by lcl on 2019/9/6 0006
 */
@RestController
@RequestMapping("/user")
@Api(value = "user",tags = "用户操作")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/wxLogin",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="微信快捷登录", notes="微信快捷登录")
    public ApiResp wxLogin(@RequestParam String code){
        ApiResp<String> resp = new ApiResp();
        log.info("\n-----微信快捷登录---->"+code);
        if(StringTool.isBlank(code)){
            resp.respErr(MsgConstant.PARAMS_NULL_ERR);
        }else {
            //获取微信的openid
            String respJson = Reqclient.getWxOpenId(code);
            if(StringTool.isBlank(respJson)){
                resp.respErr(MsgConstant.SYS_ERR);
            }else {
                // 解析相应内容（转换成json对象）
                JSONObject json = JSONObject.parseObject(respJson);
                // 用户的唯一标识（openid）
                //{"openid":"oYmsa0VexWjPUPA_k1qy5JiXHWAg","session_key":"t5EjTGmnmfJfR0YNMsjV5w==","expires_in":7200}
                String openId = json.getString("openid");
//                String openId = "oYmsa0VexWjPUPA_k1qy5JiXHWAg";
                if(StringTool.isBlank(openId)){
                    log.error("\n获取openid失败-->"+json.toJSONString());
                    resp.respErr(MsgConstant.SYS_ERR);
                }else {
                    userService.loginApp(openId,resp);
                }
            }
        }
        log.info("\n-----微信快捷登录resp---->"+resp);
        return resp;
    }




}
