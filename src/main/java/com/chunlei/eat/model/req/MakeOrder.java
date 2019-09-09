package com.chunlei.eat.model.req;

import com.chunlei.eat.entity.BillInfo;

import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public class MakeOrder {
    private Integer userId;
    private Integer shopId;
    private List<BillInfo> billInfos;

    @Override
    public String toString() {
        return "MakeOrder{" +
                "userId=" + userId +
                ", shopId=" + shopId +
                ", billInfos=" + billInfos +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public List<BillInfo> getBillInfos() {
        return billInfos;
    }

    public void setBillInfos(List<BillInfo> billInfos) {
        this.billInfos = billInfos;
    }
}
