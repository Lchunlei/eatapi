package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/6 0006
 */
public class FoodInfo {
    private Integer foodId;
    private String foodName;
    private Integer foodPrice;
    private Integer shopId;
    private Integer foodStatus;
    private Integer paixu;
    private Date uTime;

    private String eToken;

    @Override
    public String toString() {
        return "FoodInfo{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                ", shopId=" + shopId +
                ", foodStatus=" + foodStatus +
                ", paixu=" + paixu +
                ", uTime=" + uTime +
                ", eToken='" + eToken + '\'' +
                '}';
    }

    public String geteToken() {
        return eToken;
    }

    public void seteToken(String eToken) {
        this.eToken = eToken;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Integer foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(Integer foodStatus) {
        this.foodStatus = foodStatus;
    }

    public Integer getPaixu() {
        return paixu;
    }

    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }
}
