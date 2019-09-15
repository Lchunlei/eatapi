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
    //售卖状态
    private Boolean sellStatus;
    private Integer paixu;
    private Integer cateId;//分类ID
    private String picUrl;
    private Integer sellNum;
    private Date uTime;

    private String eToken;
    private Integer count=0;

    @Override
    public String toString() {
        return "FoodInfo{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                ", shopId=" + shopId +
                ", foodStatus=" + foodStatus +
                ", paixu=" + paixu +
                ", sellStatus='" + sellStatus + '\'' +
                '}';
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getSellNum() {
        return sellNum;
    }

    public void setSellNum(Integer sellNum) {
        this.sellNum = sellNum;
    }

    public Boolean getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Boolean sellStatus) {
        this.sellStatus = sellStatus;
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
        if(foodStatus.equals(0)){
            this.sellStatus = false;
        }else {
            this.sellStatus = true;
        }
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
