package com.chunlei.eat.model.resp;

import com.chunlei.eat.entity.BillInfo;

import java.util.Date;
import java.util.List;

/**
 * @Created by lcl on 2019/9/16 0016
 */
public class CtmBill {
    private Integer totalPay;
    private Integer userId;
    private Integer deskCode;
    private Date makeTime;
    private List<BillInfo> bills;

    @Override
    public String toString() {
        return "CtmBill{" +
                "totalPay=" + totalPay +
                ", userId=" + userId +
                ", deskCode=" + deskCode +
                ", makeTime=" + makeTime +
                ", bills=" + bills +
                '}';
    }

    public Integer getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Integer totalPay) {
        this.totalPay = totalPay;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeskCode() {
        return deskCode;
    }

    public void setDeskCode(Integer deskCode) {
        this.deskCode = deskCode;
    }

    public Date getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Date makeTime) {
        this.makeTime = makeTime;
    }

    public List<BillInfo> getBills() {
        return bills;
    }

    public void setBills(List<BillInfo> bills) {
        this.bills = bills;
    }
}
