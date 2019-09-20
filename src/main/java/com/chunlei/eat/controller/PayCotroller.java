package com.chunlei.eat.controller;

import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.PayService;
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
 * @Created by lcl on 2019/9/20 0020
 * 平台收益
 */
@RestController
@RequestMapping("/pay")
@Api(value = "pay",tags = "平台支付交易")
public class PayCotroller {
    private static final Logger log = LoggerFactory.getLogger(PayCotroller.class);
    @Autowired
    private PayService payService;

    @RequestMapping(value = "/check",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="到账校验", notes="到账校验")
    public ApiResp checkPay(@RequestParam String payNum,@RequestParam Integer payValue){
        ApiResp resp = new ApiResp();
        log.info("\n-----到账校验---->"+payNum+"-->"+payValue);
        payService.checkPay(payNum,payValue,resp);
        log.info("\n-----到账校验resp---->"+resp);
        return resp;
    }


}
