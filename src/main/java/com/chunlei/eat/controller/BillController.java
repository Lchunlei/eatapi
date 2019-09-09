package com.chunlei.eat.controller;

import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.req.MakeOrder;
import com.chunlei.eat.service.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Created by lcl on 2019/9/9 0009
 */
@RestController
@RequestMapping("/bill")
@Api(value = "客户下单")
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
    public ApiResp deal(@RequestParam Integer billId,Integer billStatus,String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----处理订单---->"+billId+"-->"+billStatus+"-->"+eToken);
        billService.deal(billId,billStatus,eToken,resp);
        log.info("\n-----处理订单resp---->"+resp);
        return resp;
    }



}
