package com.chunlei.eat.controller;

import com.chunlei.eat.entity.FoodCate;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.FoodCateService;
import com.chunlei.eat.service.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created by lcl on 2019/11/2 0002
 */
@RestController
@RequestMapping("/cate")
@Api(value = "cate",tags = "菜谱类别")
public class FoodCateController {
    private static final Logger log = LoggerFactory.getLogger(BillController.class);
    @Autowired
    private FoodCateService foodCateService;

    @RequestMapping(value = "/mine",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="我的菜谱分类", notes="我的菜谱分类")
    public ApiResp myCate(@RequestParam String eToken){
        ApiResp<List<FoodCate>> resp = new ApiResp();
        log.info("\n-----我的菜谱分类---->"+eToken);
        foodCateService.findMyCates(eToken,resp);
        log.info("\n-----我的菜谱分类resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="新增菜谱分类", notes="新增菜谱分类")
    public ApiResp addCate(@RequestBody FoodCate foodCate){
        ApiResp resp = new ApiResp();
        log.info("\n-----新增菜谱分类---->"+foodCate);
        foodCateService.addCate(foodCate,resp);
        log.info("\n-----新增菜谱分类resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="修改菜谱分类", notes="修改菜谱分类")
    public ApiResp updateCate(@RequestBody FoodCate foodCate){
        ApiResp resp = new ApiResp();
        log.info("\n-----修改菜谱分类---->"+foodCate);
        foodCateService.updateCate(foodCate,resp);
        log.info("\n-----修改菜谱分类resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="删除菜谱分类", notes="删除菜谱分类")
    public ApiResp delCate(@RequestParam String eToken,@RequestParam Integer cateId){
        ApiResp resp = new ApiResp();
        log.info("\n-----删除菜谱分类---->"+cateId+"-->"+eToken);
        foodCateService.delCate(eToken,cateId,resp);
        log.info("\n-----删除菜谱分类resp---->"+resp);
        return resp;
    }



}
