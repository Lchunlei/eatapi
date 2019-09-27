package com.chunlei.eat;

import com.chunlei.eat.utils.TokenUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Created by lcl on 2019/8/28 0028
 */
public class ToolsTest {


    @Test
    public void test1(){
        System.out.println(TokenUtil.getStoken(1,"oLIW-4pZeF1Dc-KHWQgVsd5U0kL0"));
        System.out.println(TokenUtil.getSopenIdByToken("OjYT8MaoNz6fadHctMkrcludhqqrQ9LNzSSC7KYlogl3I2jn3W9Wv5tcWZ7Icr15"));
        System.out.println(TokenUtil.getSidByToken("OjYT8MaoNz6fadHctMkrcludhqqrQ9LNzSSC7KYlogl3I2jn3W9Wv5tcWZ7Icr15"));
    }

    @Test
    public void test2() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date testDate = format.parse("2019-08-01 10:10:10");
        System.out.println(testDate.after(new Date()));
    }


}
