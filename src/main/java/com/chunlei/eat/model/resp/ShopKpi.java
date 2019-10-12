package com.chunlei.eat.model.resp;

/**
 * @Created by lcl on 2019/10/12 0012
 */
public class ShopKpi {
    private Integer toDayIncome;
    private Integer toDayBills;
    private Integer toDayClient;

    public ShopKpi() {
    }

    public ShopKpi(Integer toDayIncome, Integer toDayBills, Integer toDayClient) {
        this.toDayIncome = toDayIncome;
        this.toDayBills = toDayBills;
        this.toDayClient = toDayClient;
    }

    @Override
    public String toString() {
        return "ShopKpi{" +
                "toDayIncome=" + toDayIncome +
                ", toDayBills=" + toDayBills +
                ", toDayClient=" + toDayClient +
                '}';
    }

    public Integer getToDayIncome() {
        return toDayIncome;
    }

    public void setToDayIncome(Integer toDayIncome) {
        this.toDayIncome = toDayIncome;
    }

    public Integer getToDayBills() {
        return toDayBills;
    }

    public void setToDayBills(Integer toDayBills) {
        this.toDayBills = toDayBills;
    }

    public Integer getToDayClient() {
        return toDayClient;
    }

    public void setToDayClient(Integer toDayClient) {
        this.toDayClient = toDayClient;
    }
}
