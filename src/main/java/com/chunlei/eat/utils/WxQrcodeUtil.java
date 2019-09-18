package com.chunlei.eat.utils;

import com.chunlei.eat.model.resp.QrMsg;

/**
 * @Created by lcl on 2019/9/17 0017
 * 申请微信二维码
 */
public class WxQrcodeUtil {
    private static final String WX_QR_URL="https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";
    private static String ACCESS_TOKEN = "123";

    public static String getQr(String scene){
        //获取有效的 ACCESS_TOKEN
//        String wxQrUrl = WX_QR_URL.replace("ACCESS_TOKEN",ACCESS_TOKEN);
//        QrMsg qrMsg = new QrMsg(scene,"",300);
//        String qrImgUrl = Reqclient.getQrCode(wxQrUrl,scene+".png", qrMsg);
//        if (StringTool.isBlank(qrImgUrl)){
//            System.out.println("ACCESS_TOKEN过期！！重试获取....");
//            ACCESS_TOKEN = Reqclient.getWxAuth();
//            wxQrUrl = WX_QR_URL.replace("ACCESS_TOKEN",ACCESS_TOKEN);
//            qrImgUrl = Reqclient.getQrCode(wxQrUrl,scene+"desk.png", qrMsg);
//        }
        String qrImgUrl = "http://file.51yuxian.com/DD48E4A2F75144E89FCABA679FFD8A6F.jpg";
        return qrImgUrl;
    }

}
