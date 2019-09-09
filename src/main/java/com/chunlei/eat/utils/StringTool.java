package com.chunlei.eat.utils;

/**
 * @Created by lcl on 2019/8/26 0026
 */
public class StringTool {

    //判断字符串是否为空
    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

}
