package com.chunlei.eat.controller;

import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.DanMuService;
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
 * @Created by lcl on 2019/11/29 0029
 */
@RestController
@RequestMapping("/dm")
@Api(value = "danmu",tags = "视频弹幕")
public class DanMuController {
    private static final Logger log = LoggerFactory.getLogger(DanMuController.class);
    @Autowired
    private DanMuService danMuService;

    @RequestMapping(value = "/find",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="弹幕加载", notes="弹幕加载")
    public ApiResp findDanMus(@RequestParam String useType,@RequestParam String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----弹幕加载---->"+useType+"--"+eToken);
        danMuService.findDanMus(useType,resp);
        log.info("\n-----弹幕加载resp---->"+resp);
        return resp;
    }


}
