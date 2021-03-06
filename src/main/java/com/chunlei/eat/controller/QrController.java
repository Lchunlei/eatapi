package com.chunlei.eat.controller;

import com.chunlei.eat.entity.QrGet;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.QrCodeService;
import com.chunlei.eat.service.QrGetService;
import com.chunlei.eat.utils.StringTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private QrGetService qrGetService;

    @RequestMapping(value = "/get",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="申领桌码", notes="申领桌码")
    public ApiResp getQr(@RequestBody QrGet qrGet){
        ApiResp resp = new ApiResp();
        log.info("\n-----申领桌码---->"+qrGet);
        qrGetService.getQr(qrGet,resp);
        log.info("\n-----申领桌码resp---->"+resp);
        return resp;
    }

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

    @RequestMapping(value = "/wifi",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="根据桌码查看本店WIFI", notes="根据桌码查看本店WIFI")
    public ApiResp getWifi(@RequestParam Integer qrId){
        ApiResp<ShopInfo> resp = new ApiResp();
        log.info("\n-----根据桌码查看本店WIFI---->"+qrId);
        qrCodeService.getShopInfo(qrId,resp);
        if(StringTool.isBlank(resp.getRespData().getWifiPwd())){
            resp.respErr("本店未提供免费WIFI哦");
            resp.setRespData(null);
        }
        log.info("\n-----根据桌码查看本店WIFI_resp---->"+resp);
        return resp;
    }

}
