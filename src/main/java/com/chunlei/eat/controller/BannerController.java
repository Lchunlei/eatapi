package com.chunlei.eat.controller;

import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.req.MakeOrder;
import com.chunlei.eat.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Created by lcl on 2019/9/10 0010
 */
@RestController
@RequestMapping("/banner")
@Api(value = "banner",tags = "轮播图")
public class BannerController {
    private static final Logger log = LoggerFactory.getLogger(BannerController.class);
    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/show",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查看轮播图", notes="查看轮播图")
    public ApiResp show(@RequestParam String banType){
        ApiResp resp = new ApiResp();
        log.info("\n-----查看轮播图---->"+banType);
        bannerService.findAll(banType,resp);
        log.info("\n-----查看轮播图resp---->"+resp);
        return resp;
    }


}
