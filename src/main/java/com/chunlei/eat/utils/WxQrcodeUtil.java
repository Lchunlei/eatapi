package com.chunlei.eat.utils;

import com.chunlei.eat.model.resp.QrMsg;

/**
 * @Created by lcl on 2019/9/17 0017
 * 申请微信二维码
 */
public class WxQrcodeUtil {
    private static final String WX_QR_URL="https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";

    public static Boolean getQr(String scene,String accessToken){
        //获取有效的 ACCESS_TOKEN
//        String accessToken = Reqclient.getWxAuth();
        String wxQrUrl = WX_QR_URL.replace("ACCESS_TOKEN",accessToken);
        QrMsg qrMsg = new QrMsg(scene,"pages/userbill/userbill",300);
        Boolean result = Reqclient.getQrCode(wxQrUrl,scene+".png", qrMsg);
        return result;
    }

}
