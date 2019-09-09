package com.chunlei.eat;

import com.chunlei.eat.utils.TokenUtil;
import org.junit.Test;

/**
 * @Created by lcl on 2019/8/28 0028
 */
public class ToolsTest {


    @Test
    public void test1(){
        System.out.println(TokenUtil.getToken(55,"oYmsa0VexWjPUPA_k1qy5JiXHWAg"));
        //jdkml7XJBJOKKql7MvQvAw==

        System.out.println(TokenUtil.getIdByToken("n/5PvWh7vamdjGnltpjquJKX4c4Wlo88ElxGpIop8f0vwymJ+xqY1y+iUTBeNBx9"));
        System.out.println(TokenUtil.getOpenIdByToken("n/5PvWh7vamdjGnltpjquJKX4c4Wlo88ElxGpIop8f0vwymJ+xqY1y+iUTBeNBx9"));
    }
}
