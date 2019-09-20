package com.chunlei.eat.model.resp;

/**
 * @Created by lcl on 2019/9/19 0019
 */
public class ShopStaff {
    private Integer userId;
    private String wxOpenId;
    private Integer shopRole;
    private String nickName;
    private String headUrl;

    @Override
    public String toString() {
        return "ShopStaff{" +
                "userId=" + userId +
                ", wxOpenId='" + wxOpenId + '\'' +
                ", shopRole=" + shopRole +
                ", nickName='" + nickName + '\'' +
                ", headUrl='" + headUrl + '\'' +
                '}';
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

    public Integer getShopRole() {
        return shopRole;
    }

    public void setShopRole(Integer shopRole) {
        this.shopRole = shopRole;
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
}
