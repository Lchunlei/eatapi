package com.chunlei.eat.controller;

import com.chunlei.eat.entity.FoodInfo;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.FoodService;
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
@RequestMapping("/food")
@Api(value = "菜谱操作")
public class FoodController {
    private static final Logger log = LoggerFactory.getLogger(FoodController.class);
    @Autowired
    private FoodService foodService;


    @RequestMapping(value = "/addOne",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="添加一个菜品", notes="添加一个菜品")
    public ApiResp addOne(@RequestBody FoodInfo foodInfo){
        ApiResp resp = new ApiResp();
        log.info("\n-----添加一个菜品---->"+foodInfo);
        foodService.addFood(foodInfo,resp);
        return resp;
    }

    @RequestMapping(value = "/updateOne",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="重新编辑菜品", notes="重新编辑菜品")
    public ApiResp updateOne(@RequestBody FoodInfo foodInfo){
        ApiResp resp = new ApiResp();
        log.info("\n-----重新编辑菜品---->"+foodInfo);
        foodService.updateFood(foodInfo,resp);
        return resp;
    }


    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查看菜单", notes="查看菜单")
    public ApiResp findAll(@RequestParam Integer shopId){
        ApiResp resp = new ApiResp();
        log.info("\n-----查看菜单---->"+shopId);
        foodService.findAll(shopId,resp);
        log.info("\n-----查看菜单resp---->"+resp);
        return resp;
    }


}
