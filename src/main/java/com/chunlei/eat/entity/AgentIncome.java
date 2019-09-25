package com.chunlei.eat.entity;

import java.util.Date;

/**
 * @Created by lcl on 2019/9/20 0020
 */
public class AgentIncome {
    private Integer inId;
    private Integer incomeTotal;
    private Integer agId;
    private String moneyAcc;
    private Integer inType;//1直推收益2间推收益
    private Integer inStatus;//0待打款1已打款
    private Date drawTime;
    private Date cTime;

    public AgentIncome() {
    }

    public AgentIncome(Integer incomeTotal, Integer agId, String moneyAcc, Integer inType) {
        this.incomeTotal = incomeTotal;
        this.agId = agId;
        this.moneyAcc = moneyAcc;
        this.inType = inType;
    }

    @Override
    public String toString() {
        return "AgentIncome{" +
                "inId=" + inId +
                ", incomeTotal=" + incomeTotal +
                ", agId=" + agId +
                ", moneyAcc='" + moneyAcc + '\'' +
                ", inType=" + inType +
                ", inStatus=" + inStatus +
                ", drawTime=" + drawTime +
                ", cTime=" + cTime +
                '}';
    }

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public Integer getIncomeTotal() {
        return incomeTotal;
    }

    public void setIncomeTotal(Integer incomeTotal) {
        this.incomeTotal = incomeTotal;
    }

    public Integer getAgId() {
        return agId;
    }

    public void setAgId(Integer agId) {
        this.agId = agId;
    }

    public String getMoneyAcc() {
        return moneyAcc;
    }

    public void setMoneyAcc(String moneyAcc) {
        this.moneyAcc = moneyAcc;
    }

    public Integer getInType() {
        return inType;
    }

    public void setInType(Integer inType) {
        this.inType = inType;
    }

    public Integer getInStatus() {
        return inStatus;
    }

    public void setInStatus(Integer inStatus) {
        this.inStatus = inStatus;
    }

    public Date getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(Date drawTime) {
        this.drawTime = drawTime;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
