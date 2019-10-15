package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.entity.VipPay;
import com.chunlei.eat.mapper.QrCodeMapper;
import com.chunlei.eat.mapper.ShopMapper;
import com.chunlei.eat.mapper.VipPayMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.ShopService;
import com.chunlei.eat.utils.StringTool;
import com.chunlei.eat.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Created by lcl on 2019/8/22 0022
 */
@Service
public class ShopServiceImpl implements ShopService {
    private static final Logger log = LoggerFactory.getLogger(ShopServiceImpl.class);

    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private VipPayMapper vipPayMapper;
    @Autowired
    private QrCodeMapper qrCodeMapper;

    //用户主动登录
    @Override
    @Transactional
    public void userLogin(ShopInfo shopInfo, ApiResp<ShopInfo> apiResp) {
        Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher emojiMatcher = emoji.matcher(shopInfo.getNickName());
        if (emojiMatcher.find()) {
            String replace = emojiMatcher.replaceAll("*");
            shopInfo.setNickName(replace);
        }
        //拼接当前信息保存到店铺表
        String openid = TokenUtil.getUopenIdByToken(shopInfo.getWxOpenId());
        shopInfo.setWxOpenId(openid);
        ShopInfo shop = shopMapper.findMyShop(openid);
        int i;
        String eToken;
        if(shop==null){
            try {
                i = shopMapper.insertOne(shopInfo);
            }catch (Exception e){
                String regEx="[a-zA-Z0-9\\u4e00-\\u9fa5]";
                Pattern p  = Pattern.compile(regEx);
                Matcher m = p.matcher(shopInfo.getNickName());
                StringBuffer sb = new StringBuffer();
                while(m.find()){
                    sb.append(m.group());
                }
                shopInfo.setNickName(sb.toString());
                try {
                    i = shopMapper.insertOne(shopInfo);
                }catch (Exception ex){
                    shopInfo.setNickName("****");
                    i = shopMapper.insertOne(shopInfo);
                }
            }
            eToken = TokenUtil.getStoken(shopMapper.selectMaxSeq(),openid);
            shop.setMySid(null);
            shop.setUserRole(1);
            shop.setWxOpenId("");
        }else {
            shopInfo.setBossName(null);
            shopInfo.setBossTel(null);
            shopInfo.setExpireTime(null);
            try {
                i = shopMapper.updateBathInfo(shopInfo);
            }catch (Exception e){
                String regEx="[a-zA-Z0-9\\u4e00-\\u9fa5]";
                Pattern p  = Pattern.compile(regEx);
                Matcher m = p.matcher(shopInfo.getNickName());
                StringBuffer sb = new StringBuffer();
                while(m.find()){
                    sb.append(m.group());
                }
                shopInfo.setNickName(sb.toString());
                try {
                    i = shopMapper.updateBathInfo(shopInfo);
                }catch (Exception ex){
                    shopInfo.setNickName("****");
                    i = shopMapper.updateBathInfo(shopInfo);
                }
            }
            eToken = TokenUtil.getStoken(shop.getShopId(),openid);
            if(shop.getUserRole().equals(1)){
                shop.setWxOpenId("");
            }else {
                //员工登陆
                ShopInfo myShop = shopMapper.findShopById(shop.getMySid());
                String sToken = TokenUtil.getStoken(shop.getMySid(),myShop.getWxOpenId());
                shop.setWxOpenId(sToken);
            }
        }
        if(i==1){
            //刷新客户端token
            apiResp.setRespMsg(eToken);
            apiResp.setRespData(shop);
        }else {
            apiResp.respErr(MsgConstant.SYS_ERR);
        }
    }

    //用户正式入驻商家
    @Override
    public void join(ShopInfo shopInfo, ApiResp apiResp) {
        Integer sId = TokenUtil.getSidByToken(shopInfo.getWxOpenId());
        if(sId==null){
            apiResp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo shop = shopMapper.findShopById(sId);
            shopInfo.setShopId(shop.getShopId());
            shopInfo.setExpireTime(null);
            try {
                shopMapper.updateBathInfo(shopInfo);
            }catch (Exception e){
                apiResp.respErr("不支持特殊字符");
            }

        }
    }

    @Override
    public void upInfo(ShopInfo shopInfo, ApiResp apiResp) {
        Integer sId = TokenUtil.getSidByToken(shopInfo.getWxOpenId());
        if(sId==null){
            apiResp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo shop = shopMapper.findShopById(sId);
            shopInfo.setShopId(shop.getShopId());
            shopInfo.setExpireTime(null);
            shopInfo.setInviteCode(null);
            shopMapper.updateBathInfo(shopInfo);
        }
    }

    //升级为VIP/续费缴费记录提交
    @Override
    public void renewVip(VipPay vipPay, ApiResp apiResp){
        Integer sId = TokenUtil.getSidByToken(vipPay.geteToken());
        if(sId==null){
            apiResp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo shop = shopMapper.findShopById(sId);
            //直接先开通VIP功能，其他修改等后台审核
            vipPay.setShopId(shop.getShopId());
            vipPay.setShopName(shop.getShopName());
            if(StringTool.isBlank(shop.getDistrict())){
                vipPay.setCity(shop.getProvince());
            }else {
                vipPay.setCity(shop.getCity());
            }
            vipPayMapper.insertOne(vipPay);
//            shopMapper.updateVip(1,shop.getShopId());
        }
    }

    @Override
    public void getInfo(String eToken, ApiResp<ShopInfo> apiResp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            apiResp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo shop = shopMapper.findShopById(sId);
            shop.setWxOpenId(null);
            Integer qrTotal = qrCodeMapper.findShopQrTotal(sId);
            if(qrTotal!=null){
                shop.setQrTotal(qrTotal);
            }
            apiResp.setRespData(shop);
        }
    }


}
