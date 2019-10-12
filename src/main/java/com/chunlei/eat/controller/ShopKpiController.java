package com.chunlei.eat.controller;

import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.resp.ShopKpi;
import com.chunlei.eat.service.ShopKpiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Created by lcl on 2019/10/12 0012
 */
@RestController
@RequestMapping("/sKpi")
@Api(value = "sKpi",tags = "店铺业绩统计")
public class ShopKpiController {
    private static final Logger log = LoggerFactory.getLogger(ShopKpiController.class);
    @Autowired
    private ShopKpiService shopKpiService;

    @RequestMapping(value = "/today",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="店铺今日业绩", notes="店铺今日业绩")
    public ApiResp todayKpi(@RequestParam String eToken){
        ApiResp<ShopKpi> resp = new ApiResp();
        log.info("\n-----店铺今日业绩---->"+eToken);
        shopKpiService.todayKpi(eToken,resp);
        log.info("\n-----店铺今日业绩resp---->"+resp);
        return resp;
    }

}
