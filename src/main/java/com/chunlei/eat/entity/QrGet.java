package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/10/10 0010
 */
public class QrGet {
    private Integer getQrId;
    private String receiveName;
    private String receiveTel;
    private String receiveAddr;
    private Integer getNum;
    private Integer sendStatus;
    private String expressCode;
    private String expressName;
    private String payCode;
    private Date cTime;

    @Override
    public String toString() {
        return "QrGet{" +
                "getQrId=" + getQrId +
                ", receiveName='" + receiveName + '\'' +
                ", receiveTel='" + receiveTel + '\'' +
                ", receiveAddr='" + receiveAddr + '\'' +
                ", getNum=" + getNum +
                ", sendStatus=" + sendStatus +
                ", expressCode='" + expressCode + '\'' +
                ", expressName='" + expressName + '\'' +
                ", payCode='" + payCode + '\'' +
                ", cTime=" + cTime +
                '}';
    }

    public Integer getGetQrId() {
        return getQrId;
    }

    public void setGetQrId(Integer getQrId) {
        this.getQrId = getQrId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceiveTel() {
        return receiveTel;
    }

    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel;
    }

    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

    public Integer getGetNum() {
        return getNum;
    }

    public void setGetNum(Integer getNum) {
        this.getNum = getNum;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
