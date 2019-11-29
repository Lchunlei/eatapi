package com.chunlei.eat.model.req;

import com.chunlei.eat.entity.FoodInfo;

import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public class MakeOrder {
    private String eToken;
    private Integer shopId;
    private Integer deskCode;
    private String foodRemark;
    private List<FoodInfo> billInfos;

    @Override
    public String toString() {
        return "MakeOrder{" +
                "eToken='" + eToken + '\'' +
                ", shopId=" + shopId +
                ", foodRemark=" + foodRemark +
                ", deskCode=" + deskCode +
                ", billInfos=" + billInfos +
                '}';
    }

    public String getFoodRemark() {
        return foodRemark;
    }

    public void setFoodRemark(String foodRemark) {
        this.foodRemark = foodRemark;
    }

    public String geteToken() {
        return eToken;
    }

    public void seteToken(String eToken) {
        this.eToken = eToken;
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

    public List<FoodInfo> getBillInfos() {
        return billInfos;
    }

    public void setBillInfos(List<FoodInfo> billInfos) {
        this.billInfos = billInfos;
    }
}
