package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/11/29 0029
 */
public class DanMu {
    private Integer dmId;
    private String text;
    private String color;
    private Integer time;
    private Integer useType;
    private String wxOpenId;
    private Date cTime;

    @Override
    public String toString() {
        return "DanMu{" +
                "text='" + text + '\'' +
                ", color='" + color + '\'' +
                ", time=" + time +
                ", useType=" + useType +
                ", wxOpenId='" + wxOpenId + '\'' +
                '}';
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Integer getDmId() {
        return dmId;
    }

    public void setDmId(Integer dmId) {
        this.dmId = dmId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getUseType() {
        return useType;
    }

    public void setUseType(Integer useType) {
        this.useType = useType;
    }
}
