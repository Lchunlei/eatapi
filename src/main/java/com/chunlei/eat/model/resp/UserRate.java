package com.chunlei.eat.model.resp;

import com.chunlei.eat.entity.BillInfo;

import java.util.List;

/**
 * @Created by lcl on 2019/9/25 0025
 */
public class UserRate {
    private String shopName;
    private Integer rate;
    private Integer totalMoney;
    private List<BillInfo> bills;

    public UserRate() {
    }

    public UserRate(String shopName, Integer rate, Integer totalMoney, List<BillInfo> bills) {
        this.shopName = shopName;
        this.rate = rate;
        this.totalMoney = totalMoney;
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "UserRate{" +
                "shopName='" + shopName + '\'' +
                ", rate=" + rate +
                ", totalMoney=" + totalMoney +
                ", bills=" + bills +
                '}';
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public List<BillInfo> getBills() {
        return bills;
    }

    public void setBills(List<BillInfo> bills) {
        this.bills = bills;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }
}
