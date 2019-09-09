package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/6 0006
 */
public class ShopInfo {
    private Integer shopId;
    private String shopName;
    private String wxOpenId;
    private String nickName;
    private String headUrl;
    private String bossTel;
    private String bossName;
    private Integer shopStatus;//0歇业1营业
    private Date loginTime;
    private Date expireTime;
    private Date cTime;

    @Override
    public String toString() {
        return "ShopInfo{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", wxOpenId='" + wxOpenId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", bossTel='" + bossTel + '\'' +
                ", bossName='" + bossName + '\'' +
                ", shopStatus=" + shopStatus +
                ", expireTime=" + expireTime +
                ", cTime=" + cTime +
                '}';
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getBossTel() {
        return bossTel;
    }

    public void setBossTel(String bossTel) {
        this.bossTel = bossTel;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
