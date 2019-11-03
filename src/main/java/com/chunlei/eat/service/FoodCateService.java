package com.chunlei.eat.service;

import com.chunlei.eat.entity.FoodCate;
import com.chunlei.eat.model.ApiResp;

import java.util.List;

/**
 * @Created by lcl on 2019/11/1 0001
 */
public interface FoodCateService {

    public void updateCate(FoodCate foodCate, ApiResp resp);

    public void findMyCates(String eToken,ApiResp<List<FoodCate>> resp);

    public void addCate(FoodCate foodCate, ApiResp resp);

    public void delCate(String eToken,Integer cateId, ApiResp resp);


}
