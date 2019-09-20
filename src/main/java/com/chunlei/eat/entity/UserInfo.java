package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/8/22 0022
 */
public class UserInfo {
    private Integer userId;
    private String wxOpenId;
    private Integer billId;
    private Integer shopId;
    private Integer myShopId;
    private Integer shopRole;//1服务员2厨师
    private Date uTime;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", wxOpenId='" + wxOpenId + '\'' +
                ", billId=" + billId +
                ", shopId=" + shopId +
                ", uTime=" + uTime +
                '}';
    }

    public Integer getMyShopId() {
        return myShopId;
    }

    public void setMyShopId(Integer myShopId) {
        this.myShopId = myShopId;
    }

    public Integer getShopRole() {
        return shopRole;
    }

    public void setShopRole(Integer shopRole) {
        this.shopRole = shopRole;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }
}
