package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public class VipPay {
    private Integer inId;
    private Integer shopId;
    private String shopName;
    private Integer payType;//1微信2支付宝3系统赠送
    private String payNum;
    private Integer payValue;
    private String useRemark;
    private Date cTime;

    private String eToken;

    @Override
    public String toString() {
        return "VipPay{" +
                "inId=" + inId +
                ", shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", payType=" + payType +
                ", payNum='" + payNum + '\'' +
                ", payValue=" + payValue +
                ", useRemark='" + useRemark + '\'' +
                ", cTime=" + cTime +
                ", eToken='" + eToken + '\'' +
                '}';
    }

    public String geteToken() {
        return eToken;
    }

    public void seteToken(String eToken) {
        this.eToken = eToken;
    }

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
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

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayNum() {
        return payNum;
    }

    public void setPayNum(String payNum) {
        this.payNum = payNum;
    }

    public Integer getPayValue() {
        return payValue;
    }

    public void setPayValue(Integer payValue) {
        this.payValue = payValue;
    }

    public String getUseRemark() {
        return useRemark;
    }

    public void setUseRemark(String useRemark) {
        this.useRemark = useRemark;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
