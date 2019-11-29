package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/11/5 0005
 */
public class ShopBlack {
    private Integer blackId;
    private Integer shopId;
    private Integer userId;
    private Date cTime;

    private String eToken;

    @Override
    public String toString() {
        return "ShopBlack{" +
                "blackId=" + blackId +
                ", shopId=" + shopId +
                ", userId=" + userId +
                ", cTime=" + cTime +
                ", eToken='" + eToken + '\'' +
                '}';
    }

    public ShopBlack() {
    }

    public ShopBlack(Integer shopId, Integer userId) {
        this.shopId = shopId;
        this.userId = userId;
    }

    public String geteToken() {
        return eToken;
    }

    public void seteToken(String eToken) {
        this.eToken = eToken;
    }

    public Integer getBlackId() {
        return blackId;
    }

    public void setBlackId(Integer blackId) {
        this.blackId = blackId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
