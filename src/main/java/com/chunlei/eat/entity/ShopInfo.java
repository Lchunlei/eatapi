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
    private Integer vipStatus;//0不是VIP，1是VIP
    private String inviteCode;//邀请注册码（邀请者手机号）
    private String province;
    private String city;
    private String district;
    private String address;
    private String wifiName;
    private String wifiPwd;
    private Date loginTime;
    private Date expireTime;
    private Date cTime;

    private Integer staffTotal;
    private Integer qrTotal;

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
                ", vipStatus=" + vipStatus +
                ", inviteCode='" + inviteCode + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", loginTime=" + loginTime +
                ", expireTime=" + expireTime +
                ", cTime=" + cTime +
                '}';
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getWifiPwd() {
        return wifiPwd;
    }

    public void setWifiPwd(String wifiPwd) {
        this.wifiPwd = wifiPwd;
    }

    public Integer getStaffTotal() {
        return staffTotal;
    }

    public void setStaffTotal(Integer staffTotal) {
        this.staffTotal = staffTotal;
    }

    public Integer getQrTotal() {
        return qrTotal;
    }

    public void setQrTotal(Integer qrTotal) {
        this.qrTotal = qrTotal;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Integer getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(Integer vipStatus) {
        this.vipStatus = vipStatus;
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
