package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/17 0017
 */
public class QrCode {
    private Integer qrId;
    private Integer shopId;
    private Integer deskCode;
    private String qrUrl;
    private Date cTime;

    @Override
    public String toString() {
        return "QrCode{" +
                "qrId=" + qrId +
                ", shopId=" + shopId +
                ", deskCode=" + deskCode +
                ", qrUrl='" + qrUrl + '\'' +
                ", cTime=" + cTime +
                '}';
    }

    public QrCode() {
    }

    public QrCode(Integer shopId, Integer deskCode, String qrUrl) {
        this.shopId = shopId;
        this.deskCode = deskCode;
        this.qrUrl = qrUrl;
    }

    public Integer getQrId() {
        return qrId;
    }

    public void setQrId(Integer qrId) {
        this.qrId = qrId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getDeskCode() {
        return deskCode;
    }

    public void setDeskCode(Integer deskCode) {
        this.deskCode = deskCode;
    }

    public String getQrUrl() {
        return qrUrl;
    }

    public void setQrUrl(String qrUrl) {
        this.qrUrl = qrUrl;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
