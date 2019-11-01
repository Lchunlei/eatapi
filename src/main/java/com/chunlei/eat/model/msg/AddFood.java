package com.chunlei.eat.model.msg;

/**
 * @Created by lcl on 2019/10/25 0025
 */
public class AddFood {
    //菜谱名称
    private KeyWord phrase1;
    //时间
    private KeyWord date3;
    //内容
    private KeyWord thing4;

    public AddFood() {
    }

    public AddFood(KeyWord phrase1, KeyWord date3, KeyWord thing4) {
        this.phrase1 = phrase1;
        this.date3 = date3;
        this.thing4 = thing4;
    }

    public KeyWord getPhrase1() {
        return phrase1;
    }

    public void setPhrase1(KeyWord phrase1) {
        this.phrase1 = phrase1;
    }

    public KeyWord getDate3() {
        return date3;
    }

    public void setDate3(KeyWord date3) {
        this.date3 = date3;
    }

    public KeyWord getThing4() {
        return thing4;
    }

    public void setThing4(KeyWord thing4) {
        this.thing4 = thing4;
    }
}
