package com.chunlei.eat.controller;

import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.QrCodeService;
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
 * @Created by lcl on 2019/9/17 0017
 * 店铺二维码
 */
@RestController
@RequestMapping("/qr")
@Api(value = "店铺二维码")
public class QrController {
    private static final Logger log = LoggerFactory.getLogger(QrController.class);
    @Autowired
    private QrCodeService qrCodeService;

    @RequestMapping(value = "/make",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="申领桌码", notes="申领桌码")
    public ApiResp make(@RequestParam String eToken,@RequestParam Integer qrTotal){
        ApiResp resp = new ApiResp();
        log.info("\n-----申领桌码---->"+eToken+"-->"+qrTotal);
        qrCodeService.addShopQr(eToken,qrTotal,resp);
        log.info("\n-----申领桌码resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/mine",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="我的所有桌码", notes="我的所有桌码")
    public ApiResp myQrs(@RequestParam String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----我的所有桌码---->"+eToken);
        qrCodeService.findMyQrs(eToken,resp);
        log.info("\n-----我的所有桌码resp---->"+resp);
        return resp;
    }


}
