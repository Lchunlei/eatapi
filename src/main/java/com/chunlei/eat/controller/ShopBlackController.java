package com.chunlei.eat.controller;

import com.chunlei.eat.entity.ShopBlack;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.ShopBlackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Created by lcl on 2019/11/5 0005
 */
@RestController
@RequestMapping("/black")
@Api(value = "black",tags = "黑名单")
public class ShopBlackController {
    private static final Logger log = LoggerFactory.getLogger(ShopBlackController.class);
    @Autowired
    private ShopBlackService shopBlackService;

    @RequestMapping(value = "/mine",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="本店黑名单", notes="本店黑名单")
    public ApiResp getMyBlacks(@RequestParam String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----本店黑名单---->"+eToken);
        shopBlackService.shopBlacks(eToken,resp);
        log.info("\n-----本店黑名单resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="拉黑", notes="拉黑")
    public ApiResp addBlack(@RequestBody ShopBlack shopBlack){
        ApiResp resp = new ApiResp();
        log.info("\n-----拉黑---->"+shopBlack);
        shopBlackService.addBlack(shopBlack,resp);
        log.info("\n-----拉黑resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="移除黑名单", notes="移除黑名单")
    public ApiResp delBlack(@RequestParam String eToken,@RequestParam Integer userId){
        ApiResp resp = new ApiResp();
        log.info("\n-----移除黑名单---->"+userId+"-->"+eToken);
        shopBlackService.delBlack(eToken,userId,resp);
        log.info("\n-----移除黑名单resp---->"+resp);
        return resp;
    }

}
