package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public class BillInfo {
    private Integer billId;
    private Integer userId;
    private Integer shopId;
    private Integer foodId;
    private String foodName;
    private Integer eatNum;
    private Integer totalPrice;
    private Integer billStatus;//0未支付1已支付2完成交易
    private Date cTime;

    private String eToken;

    public String geteToken() {
        return eToken;
    }

    public void seteToken(String eToken) {
        this.eToken = eToken;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
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

    public Integer getEatNum() {
        return eatNum;
    }

    public void setEatNum(Integer eatNum) {
        this.eatNum = eatNum;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}