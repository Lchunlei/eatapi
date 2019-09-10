package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/10 0010
 */
public class BannerInfo {
    private Integer bannerId;
    private Integer businessId;
    private Integer userId;
    private String banTitle;
    private String linkUrl;
    private String paixu;
    private String picUrl;
    private String banRemark;
    private String banType;
    private Integer banStatus;
    private String statusStr;
    private Date cTime;
    private Date uTime;

    @Override
    public String toString() {
        return "BannerInfo{" +
                "bannerId=" + bannerId +
                ", businessId=" + businessId +
                ", userId=" + userId +
                ", banTitle='" + banTitle + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", paixu='" + paixu + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", banRemark='" + banRemark + '\'' +
                ", banType='" + banType + '\'' +
                ", banStatus=" + banStatus +
                ", statusStr='" + statusStr + '\'' +
                ", cTime=" + cTime +
                ", uTime=" + uTime +
                '}';
    }

    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBanTitle() {
        return banTitle;
    }

    public void setBanTitle(String banTitle) {
        this.banTitle = banTitle;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getPaixu() {
        return paixu;
    }

    public void setPaixu(String paixu) {
        this.paixu = paixu;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getBanRemark() {
        return banRemark;
    }

    public void setBanRemark(String banRemark) {
        this.banRemark = banRemark;
    }

    public String getBanType() {
        return banType;
    }

    public void setBanType(String banType) {
        this.banType = banType;
    }

    public Integer getBanStatus() {
        return banStatus;
    }

    public void setBanStatus(Integer banStatus) {
        this.banStatus = banStatus;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }
}
