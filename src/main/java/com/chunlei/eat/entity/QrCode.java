package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/17 0017
 */
public class QrCode {
    private Integer qrId;
    private Integer shopId;
    private Integer deskCode;
    private Date cTime;

    @Override
    public String toString() {
        return "QrCode{" +
                "qrId=" + qrId +
                ", shopId=" + shopId +
                ", deskCode=" + deskCode +
                ", cTime=" + cTime +
                '}';
    }

    public QrCode() {
    }

    public QrCode(Integer qrId) {
        this.qrId = qrId;
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

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
