package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/8/22 0022
 */
public class UserInfo {
    private Integer userId;
    private String wxOpenId;
    private Integer useStatus;//0禁用1正常
    private Integer sayMsg;
    private String sayDate;
    private Date uTime;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", wxOpenId='" + wxOpenId + '\'' +
                '}';
    }

    public Integer getSayMsg() {
        return sayMsg;
    }

    public void setSayMsg(Integer sayMsg) {
        this.sayMsg = sayMsg;
    }

    public String getSayDate() {
        return sayDate;
    }

    public void setSayDate(String sayDate) {
        this.sayDate = sayDate;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
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

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }
}
