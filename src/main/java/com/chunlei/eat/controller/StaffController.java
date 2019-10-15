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

    @RequestMapping(value = "/del",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="删除本店员工", notes="删除本店员工")
    public ApiResp delMyStaff(@RequestParam String eToken,@RequestParam Integer shopId){
        ApiResp resp = new ApiResp();
        log.info("\n-----删除本店员工---->"+shopId+"-->"+eToken);
        staffService.delMyStaff(eToken,shopId,resp);
        log.info("\n-----删除本店员工resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/preAdd",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="预添加员工", notes="预添加员工")
    public ApiResp preAdd(@RequestParam String eToken,@RequestParam Integer uId,@RequestParam Integer userRole){
        ApiResp resp = new ApiResp();
        log.info("\n-----预添加员工---->"+uId+"-->"+userRole+"-->"+eToken);
        staffService.preAdd(eToken,uId,userRole,resp);
        log.info("\n-----预添加员工resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/cofInvite",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="确认成为员工", notes="确认成为员工")
    public ApiResp cofInvite(@RequestParam String eToken,@RequestParam Integer cof){
        ApiResp resp = new ApiResp();
        log.info("\n-----确认成为员工---->"+eToken+"-->"+cof);
        staffService.cofInvite(eToken,cof,resp);
        log.info("\n-----确认成为员工resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/lookup",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查看是否有员工邀请", notes="查看是否有员工邀请")
    public ApiResp lookupStaff(@RequestParam String eToken){
        ApiResp<Integer> resp = new ApiResp();
        log.info("\n-----查看是否有员工邀请---->"+eToken);
        staffService.lookupStaff(eToken,resp);
        log.info("\n-----查看是否有员工邀请resp---->"+resp);
        return resp;
    }

}
