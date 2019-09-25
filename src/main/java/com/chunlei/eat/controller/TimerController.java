package com.chunlei.eat.controller;

import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.SalaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by lcl on 2019/9/20 0020
 */
@RestController
@RequestMapping("/timer")
@Api(value = "timer",tags = "核心业务定时计算")
public class TimerController {
    private static final Logger log = LoggerFactory.getLogger(TimerController.class);
    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value = "/fx/income",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="计算上月分销员工资", notes="计算上月分销员工资")
    public ApiResp fxIncome(){
        ApiResp resp = new ApiResp();
        log.info("\n-----计算上月分销员工资S----");

        log.info("\n-----计算上月分销员工资E----");
        return resp;
    }



}
