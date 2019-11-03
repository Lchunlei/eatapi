package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/11/1 0001
 */
public class FoodCate {
    private Integer cateId;
    private Integer shopId;
    private String cateName;
    private Date cTime;

    private String eToken;

    @Override
    public String toString() {
        return "FoodCate{" +
                "cateId=" + cateId +
                ", shopId=" + shopId +
                ", cateName='" + cateName + '\'' +
                '}';
    }

    public String geteToken() {
        return eToken;
    }

    public void seteToken(String eToken) {
        this.eToken = eToken;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
