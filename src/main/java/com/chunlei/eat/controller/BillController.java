package com.chunlei.eat.controller;

import com.chunlei.eat.entity.BillInfo;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.req.MakeOrder;
import com.chunlei.eat.model.resp.CtmBill;
import com.chunlei.eat.service.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
@RestController
@RequestMapping("/bill")
@Api(value = "bill",tags = "客户下单")
public class BillController {
    private static final Logger log = LoggerFactory.getLogger(BillController.class);
    @Autowired
    private BillService billService;


    @RequestMapping(value = "/make",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="下单", notes="下单")
    public ApiResp makeOrder(@RequestBody MakeOrder makeOrder){
        ApiResp resp = new ApiResp();
        log.info("\n-----下单---->"+makeOrder);
        billService.makeBill(makeOrder,resp);
        log.info("\n-----下单resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/rate",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="当前等餐排名", notes="当前等餐排名")
    public ApiResp rate(@RequestParam Integer userId){
        ApiResp resp = new ApiResp();
        log.info("\n-----当前等餐排名---->"+userId);
        billService.rate(userId,resp);
        log.info("\n-----当前等餐排名resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/deal",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="处理订单", notes="处理订单")
    public ApiResp deal(@RequestParam Integer billId,@RequestParam Integer billStatus,@RequestParam String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----处理订单---->"+billId+"-->"+billStatus+"-->"+eToken);
        billService.deal(billId,billStatus,eToken,resp);
        log.info("\n-----处理订单resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/ctmBill",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查看本店客单", notes="查看本店客单")
    public ApiResp<List<CtmBill>> ctmBill(@RequestParam(required = false) Integer billStatus, @RequestParam String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----查看本店客单---->"+billStatus+"-->"+eToken);
        billService.ctmBill(billStatus,eToken,resp);
        log.info("\n-----查看本店客单resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查看本店订单列表", notes="查看本店订单列表")
    public ApiResp<List<BillInfo>> list(@RequestParam(required = false) Integer tabNum, @RequestParam String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----查看本店订单列表---->"+tabNum+"-->"+eToken);
        billService.getBills(tabNum,eToken,resp);
        log.info("\n-----查看本店订单列表resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/statistics",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="本店订单统计", notes="本店订单统计")
    public ApiResp statistics( @RequestParam String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----本店订单统计---->"+eToken);


//        billService.getBills(billStatus,eToken,resp);
        log.info("\n-----本店订单统计resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="本店用户订单删除", notes="本店用户订单删除")
    public ApiResp delUserBill(@RequestParam String eToken,@RequestParam Integer userId){
        ApiResp resp = new ApiResp();
        log.info("\n-----本店用户订单删除---->"+eToken+"-->"+userId);
        billService.delUserBill(userId,eToken,resp);
        log.info("\n-----本店用户订单删除resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/delOne",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="订单删除", notes="订单删除")
    public ApiResp delOneBill(@RequestParam String eToken,@RequestParam Integer billId){
        ApiResp resp = new ApiResp();
        log.info("\n-----订单删除---->"+eToken+"-->"+billId);
        billService.delOneBill(billId,eToken,resp);
        log.info("\n-----订单删除resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/sendDishe",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="上菜完成", notes="上菜完成")
    public ApiResp sendDishe(@RequestParam String eToken,@RequestParam Integer billId){
        ApiResp resp = new ApiResp();
        log.info("\n-----上菜完成---->"+eToken+"-->"+billId);
        billService.sendDishe(billId,eToken,resp);
        log.info("\n-----上菜完成resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/complete",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="本店用户订单交易完成", notes="本店用户订单交易完成")
    public ApiResp completeUserBill(@RequestParam String eToken,@RequestParam Integer userId){
        ApiResp resp = new ApiResp();
        log.info("\n-----交易完成---->"+eToken+"-->"+userId);
        billService.completeUserBill(userId,eToken,resp);
        log.info("\n-----交易完成resp---->"+resp);
        return resp;
    }



}
