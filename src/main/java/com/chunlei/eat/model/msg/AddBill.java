package com.chunlei.eat.model.msg;

/**
 * @Created by lcl on 2019/10/19 0019
 */
public class AddBill {
    //预约时间
    private KeyWord keyword1;
    //桌位
    private KeyWord keyword2;
    //预约人
    private KeyWord keyword3;
    //预约产品
    private KeyWord keyword4;

    public AddBill() {
    }

    public AddBill(KeyWord keyword1, KeyWord keyword2, KeyWord keyword3, KeyWord keyword4) {
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
        this.keyword3 = keyword3;
        this.keyword4 = keyword4;
    }

    public KeyWord getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(KeyWord keyword1) {
        this.keyword1 = keyword1;
    }

    public KeyWord getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(KeyWord keyword2) {
        this.keyword2 = keyword2;
    }

    public KeyWord getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(KeyWord keyword3) {
        this.keyword3 = keyword3;
    }

    public KeyWord getKeyword4() {
        return keyword4;
    }

    public void setKeyword4(KeyWord keyword4) {
        this.keyword4 = keyword4;
    }
}
