package com.chunlei.eat.common;

/**
 * @Created by lcl on 2019/8/26 0026
 */
public class WxConfig {

    public static final String WX_OPENID_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=wx4d9d0dd11e726af3&secret=a1477410f65c673f55f441ab12505744&js_code=CODE&grant_type=authorization_code";

    public static final String WX_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx4d9d0dd11e726af3&secret=a1477410f65c673f55f441ab12505744";

    public static final String WX_PUSH_URL="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";


}
