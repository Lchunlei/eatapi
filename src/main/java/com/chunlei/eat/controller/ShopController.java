package com.chunlei.eat.controller;

import com.alibaba.fastjson.JSONObject;
import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.entity.UserInfo;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.ShopService;
import com.chunlei.eat.utils.Reqclient;
import com.chunlei.eat.utils.StringTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Created by lcl on 2019/8/22 0022
 */
@RestController
@RequestMapping("/shop")
@Api(value = "店铺操作")
public class ShopController {
    private static final Logger log = LoggerFactory.getLogger(ShopController.class);
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/userLogin",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="用户主动登录", notes="用户主动登录")
    public ApiResp userLogin(@RequestBody ShopInfo shopInfo){
        ApiResp<String> resp = new ApiResp();
        log.info("\n-----用户主动登录---->"+shopInfo);
        shopService.userLogin(shopInfo,resp);
        return resp;
    }

    @RequestMapping(value = "/join",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="商家入驻", notes="商家入驻")
    public ApiResp join(@RequestBody ShopInfo shopInfo){
        ApiResp<String> resp = new ApiResp();
        log.info("\n-----用户主动登录---->"+shopInfo);
        shopService.userLogin(shopInfo,resp);
        return resp;
    }

    @RequestMapping(value = "/vip",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="商家升级", notes="商家升级")
    public ApiResp renewVip(@RequestBody ShopInfo shopInfo){
        ApiResp<String> resp = new ApiResp();
        log.info("\n-----用户主动登录---->"+shopInfo);
        shopService.userLogin(shopInfo,resp);
        return resp;
    }

}
