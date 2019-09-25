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
@Api(value = "qr",tags = "店铺二维码")
public class QrController {
    private static final Logger log = LoggerFactory.getLogger(QrController.class);
    @Autowired
    private QrCodeService qrCodeService;

    @RequestMapping(value = "/binding",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="绑定桌码", notes="绑定桌码")
    public ApiResp binding(@RequestParam String eToken,@RequestParam Integer deskCode,@RequestParam Integer qrId){
        ApiResp resp = new ApiResp();
        log.info("\n-----绑定桌码---->"+eToken+"-->"+deskCode+"-->"+qrId);
        qrCodeService.binding(eToken,deskCode,qrId,resp);
        log.info("\n-----绑定桌码resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/delbind",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="解绑桌码", notes="解绑桌码")
    public ApiResp delBinding(@RequestParam String eToken,@RequestParam Integer qrId){
        ApiResp resp = new ApiResp();
        log.info("\n-----解绑桌码---->"+eToken+"-->"+qrId);
        qrCodeService.delBinding(eToken,qrId,resp);
        log.info("\n-----解绑桌码resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/content",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="获取二维码内容", notes="获取二维码内容")
    public ApiResp qrContent(@RequestParam Integer qrId){
        ApiResp resp = new ApiResp();
        log.info("\n-----获取二维码内容---->"+qrId);
        qrCodeService.qrContent(qrId,resp);
        log.info("\n-----获取二维码内容resp---->"+resp);
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

    @RequestMapping(value = "/preMake",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="预生成桌牌", notes="预生成桌牌")
    public ApiResp preMake(@RequestParam String pwd){
        ApiResp resp = new ApiResp();
        log.info("\n-----预生成桌牌---->"+pwd);
        qrCodeService.preMake(pwd,resp);
        log.info("\n-----预生成桌牌resp---->"+resp);
        return resp;
    }


}
