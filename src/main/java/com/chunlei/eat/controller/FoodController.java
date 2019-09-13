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

    @RequestMapping(value = "/sell",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="上下架菜品", notes="上下架菜品")
    public ApiResp sell(@RequestParam Integer foodId,@RequestParam String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----上下架菜品---->"+foodId+"--->"+eToken);
        foodService.sellFood(foodId,eToken,resp);
        log.info("\n-----上下架菜品resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查看菜品详情", notes="查看菜品详情")
    public ApiResp info(@RequestParam Integer foodId){
        ApiResp<FoodInfo> resp = new ApiResp();
        log.info("\n-----查看菜品详情---->"+foodId);
        foodService.findFoodInfo(foodId,resp);
        log.info("\n-----查看菜品详情---->"+resp);
        return resp;
    }

//    @RequestMapping(value = "/delOne",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    @ApiOperation(value="删除菜品", notes="删除菜品")
//    public ApiResp delOne(@RequestParam String eToken,@RequestParam Integer foodId){
//        ApiResp resp = new ApiResp();
//        log.info("\n-----删除菜品---->"+eToken+"-->"+foodId);
//        foodService.delOne(eToken,foodId,resp);
//        log.info("\n-----删除菜品resp---->"+resp);
//        return resp;
//    }

    @RequestMapping(value = "/can/eat",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查看可点的菜单", notes="查看可点的菜单")
    public ApiResp canEat(@RequestParam Integer shopId){
        ApiResp resp = new ApiResp();
        log.info("\n-----查看菜单---->"+shopId);
        foodService.canEat(shopId,resp);
        log.info("\n-----查看菜单resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查看本店所有菜单", notes="查看本店所有菜单")
    public ApiResp findAll(@RequestParam String eToken){
        ApiResp resp = new ApiResp();
        log.info("\n-----查看本店所有菜单---->"+eToken);
        foodService.findAll(eToken,resp);
        log.info("\n-----查看菜单resp---->"+resp);
        return resp;
    }


}
