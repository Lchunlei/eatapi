package com.chunlei.eat.model.msg;

/**
 * @Created by lcl on 2019/10/19 0019
 */
public class TakeFood {
    //温馨提示
    private KeyWord thing1;
    //取餐地址
    private KeyWord thing2;

    public KeyWord getThing1() {
        return thing1;
    }

    public void setThing1(KeyWord thing1) {
        this.thing1 = thing1;
    }

    public KeyWord getThing2() {
        return thing2;
    }

    public void setThing2(KeyWord thing2) {
        this.thing2 = thing2;
    }
}
