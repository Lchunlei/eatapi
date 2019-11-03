package com.chunlei.eat.model.resp;

import com.chunlei.eat.entity.FoodCate;

import java.util.List;

/**
 * @Created by lcl on 2019/11/2 0002
 */
public class ShopMenu {
    private List<FoodCate> cates;
    private List<MenuCate> foods;

    public List<FoodCate> getCates() {
        return cates;
    }

    public void setCates(List<FoodCate> cates) {
        this.cates = cates;
    }

    public List<MenuCate> getFoods() {
        return foods;
    }

    public void setFoods(List<MenuCate> foods) {
        this.foods = foods;
    }
}
