package com.chunlei.eat.service;

import com.chunlei.eat.entity.FoodInfo;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.req.MuchFood;

import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public interface FoodService {

    public void addFood(FoodInfo foodInfo, ApiResp resp);

    public void addFoods(MuchFood muchFood, ApiResp resp);

    public void updateFood(FoodInfo foodInfo, ApiResp resp);

    public void findAll(Integer shopId, ApiResp<List<FoodInfo>> resp);

}
