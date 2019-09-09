package com.chunlei.eat.model.req;

import com.chunlei.eat.entity.FoodInfo;

import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public class MuchFood {
    private String eToken;
    private List<FoodInfo> foods;

    public String geteToken() {
        return eToken;
    }

    public void seteToken(String eToken) {
        this.eToken = eToken;
    }

    public List<FoodInfo> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodInfo> foods) {
        this.foods = foods;
    }
}
