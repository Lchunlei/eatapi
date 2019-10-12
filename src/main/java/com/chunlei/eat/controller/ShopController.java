package com.chunlei.eat.controller;

import com.alibaba.fastjson.JSONObject;
import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.entity.UserInfo;
import com.chunlei.eat.entity.VipPay;
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
@Api(value = "shop",tags = "店铺操作")
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
    @ApiOperation(value="商家入驻或信息更新", notes="商家入驻或信息更新")
    public ApiResp join(@RequestBody ShopInfo shopInfo){
        ApiResp<String> resp = new ApiResp();
        log.info("\n-----商家入驻或信息更新---->"+shopInfo);
        shopService.join(shopInfo,resp);
        return resp;
    }

//    @RequestMapping(value = "/upInfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ApiOperation(value="商家信息更新", notes="商家信息更新")
//    public ApiResp upInfo(@RequestBody ShopInfo shopInfo){
//        ApiResp<String> resp = new ApiResp();
//        log.info("\n-----商家信息更新---->"+shopInfo);
//        shopService.join(shopInfo,resp);
//        return resp;
//    }

    @RequestMapping(value = "/vip",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="商家升级", notes="商家升级")
    public ApiResp renewVip(@RequestBody VipPay vipPay){
        ApiResp<String> resp = new ApiResp();
        log.info("\n-----商家升级---->"+vipPay);
        shopService.renewVip(vipPay,resp);
        return resp;
    }

    @RequestMapping(value = "/auth",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="获取微信接口调用凭证", notes="获取微信接口调用凭证")
    public ApiResp getWxAuth(){
        ApiResp<String> resp = new ApiResp();
        log.info("\n-----获取微信接口调用凭证----");
        //获取微信的openid
        String respJson = Reqclient.getWxAuth();
        if(StringTool.isBlank(respJson)){
            resp.respErr(MsgConstant.SYS_ERR);
        }else {
            JSONObject json = JSONObject.parseObject(respJson);
            String accessToken = json.getString("access_token");
            if(StringTool.isBlank(accessToken)){
                log.error("\n获取accessToken失败-->"+json.toJSONString());
                resp.respErr(MsgConstant.SYS_ERR);
            }else {
                resp.setRespData(accessToken);
            }
        }
        return resp;
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="商家信息查看", notes="商家信息查看")
    public ApiResp getInfo(@RequestParam String eToken){
        ApiResp<ShopInfo> resp = new ApiResp();
        log.info("\n-----商家信息查看---->"+eToken);
        shopService.getInfo(eToken,resp);
        return resp;
    }

}
