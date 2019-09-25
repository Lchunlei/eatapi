package com.chunlei.eat.service;

import com.chunlei.eat.entity.FoodInfo;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.req.MuchFood;
import com.chunlei.eat.model.resp.MenuCate;

import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public interface FoodService {

    public void addFood(FoodInfo foodInfo, ApiResp resp);

    public void addFoods(MuchFood muchFood, ApiResp resp);

    public void sellFood(Integer foodId,String eToken, ApiResp resp);

    public void updateFood(FoodInfo foodInfo, ApiResp resp);

    public void findFoodInfo(Integer foodId, ApiResp<FoodInfo> resp);

    public void delOne(String eToken,Integer foodId, ApiResp resp);

    public void canEat(Integer shopId,String eToken,ApiResp<List<MenuCate>> resp);

    public void deskCodeInfo(Integer qrId,String eToken,ApiResp<List<MenuCate>> resp);

    public void findAll(String eToken, ApiResp<List<FoodInfo>> resp);

}
