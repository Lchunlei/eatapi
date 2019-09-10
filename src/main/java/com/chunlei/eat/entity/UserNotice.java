package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/10 0010
 * 用户公告
 */
public class UserNotice {
    private Integer nteId;
    private String nteTitle;
    private String nteContent;
    private Integer nteType;
    private Integer shopId;
    private String wxOpenId;
    private Date cTime;

    public String getNteContent() {
        return nteContent;
    }

    public void setNteContent(String nteContent) {
        this.nteContent = nteContent;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getNteId() {
        return nteId;
    }

    public void setNteId(Integer nteId) {
        this.nteId = nteId;
    }

    public String getNteTitle() {
        return nteTitle;
    }

    public void setNteTitle(String nteTitle) {
        this.nteTitle = nteTitle;
    }

    public Integer getNteType() {
        return nteType;
    }

    public void setNteType(Integer nteType) {
        this.nteType = nteType;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
