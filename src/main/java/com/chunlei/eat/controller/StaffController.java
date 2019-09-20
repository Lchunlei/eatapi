package com.chunlei.eat.controller;

import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.StaffService;
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
 * @Created by lcl on 2019/9/19 0017
 * 员工管理
 */
@RestController
@RequestMapping("/staff")
@Api(value = "staff",tags = "员工操作")
public class StaffController {
    private static final Logger log = LoggerFactory.getLogger(StaffController.class);
    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查询本店所有员工", notes="查询本店所有员工")
    public ApiResp allStaff(@RequestParam String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----查询本店所有员工---->"+eToken);
        staffService.findAllShopStaff(eToken,resp);
        log.info("\n-----查询本店所有员工resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/preInfo",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查询可添加员工信息", notes="查询可添加员工信息")
    public ApiResp preInfo(@RequestParam String eToken,@RequestParam Integer uId){
        ApiResp resp = new ApiResp();
        log.info("\n-----查询可添加员工信息---->"+eToken);
        staffService.preInfo(eToken,uId,resp);
        log.info("\n-----查询可添加员工信息resp---->"+resp);
        return resp;
    }

}
