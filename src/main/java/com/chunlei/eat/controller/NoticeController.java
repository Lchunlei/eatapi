package com.chunlei.eat.controller;

import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.BannerService;
import com.chunlei.eat.service.UserNoticeService;
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
 * @Created by lcl on 2019/9/10 0010
 */
@RestController
@RequestMapping("/notice")
@Api(value = "notice",tags = "系统公告")
public class NoticeController {
    private static final Logger log = LoggerFactory.getLogger(NoticeController.class);
    @Autowired
    private UserNoticeService userNoticeService;

    @RequestMapping(value = "/show",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查看公告", notes="查看公告")
    public ApiResp show(@RequestParam String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----查看公告---->"+eToken);
        userNoticeService.findNotice(eToken,resp);
        log.info("\n-----查看公告resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/details",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="公告详情", notes="公告详情")
    public ApiResp details(@RequestParam Integer nteId){
        ApiResp resp = new ApiResp();
        log.info("\n-----公告详情---->"+nteId);
        userNoticeService.findNoticeDetails(nteId,resp);
        log.info("\n-----公告详情resp---->"+resp);
        return resp;
    }


}
