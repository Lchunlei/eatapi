package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public class BillInfo {
    private Integer billId;
    private Integer userId;
    private Integer shopId;
    private Integer deskCode;
    private Integer foodId;
    private String foodName;
    private Integer eatNum;
    private Integer totalPrice;
    private Integer billStatus;//0未支付1已支付2完成交易
    private String billRemark;
    private Date cTime;

    private String eToken;

    public BillInfo() {
    }

    public BillInfo(Integer userId, Integer shopId,Integer deskCode, Integer foodId, String foodName, Integer eatNum, Integer totalPrice,String billRemark) {
        this.userId = userId;
        this.shopId = shopId;
        this.deskCode = deskCode;
        this.foodId = foodId;
        this.foodName = foodName;
        this.eatNum = eatNum;
        this.totalPrice = totalPrice;
        this.billRemark = billRemark;
    }

    @Override
    public String toString() {
        return "BillInfo{" +
                "billId=" + billId +
                ", userId=" + userId +
                ", shopId=" + shopId +
                ", deskCode=" + deskCode +
                ", foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", eatNum=" + eatNum +
                ", totalPrice=" + totalPrice +
                ", billStatus=" + billStatus +
                ", cTime=" + cTime +
                ", eToken='" + eToken + '\'' +
                '}';
    }

    public String getBillRemark() {
        return billRemark;
    }

    public void setBillRemark(String billRemark) {
        this.billRemark = billRemark;
    }

    public Integer getDeskCode() {
        return deskCode;
    }

    public void setDeskCode(Integer deskCode) {
        this.deskCode = deskCode;
    }

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
