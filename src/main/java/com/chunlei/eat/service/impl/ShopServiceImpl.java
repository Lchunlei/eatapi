package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.entity.VipPay;
import com.chunlei.eat.mapper.ShopMapper;
import com.chunlei.eat.mapper.VipPayMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.ShopService;
import com.chunlei.eat.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //用户主动登录
    @Override
    public void userLogin(ShopInfo shopInfo, ApiResp apiResp) {
        //拼接当前信息保存到店铺表
        String openid = TokenUtil.getOpenIdByToken(shopInfo.getWxOpenId());
        shopInfo.setWxOpenId(openid);
        ShopInfo shop = shopMapper.findMyShop(openid);
        int i;
        String eToken;
        if(shop==null){
            i = shopMapper.insertOne(shopInfo);
            eToken = TokenUtil.getToken(shopMapper.selectMaxSeq(),openid);
        }else {
            shopInfo.setBossName(null);
            shopInfo.setBossTel(null);
            shopInfo.setExpireTime(null);
            i = shopMapper.updateBathInfo(shopInfo);
            eToken = TokenUtil.getToken(shop.getShopId(),openid);
        }
        if(i==1){
            //刷新客户端token
            apiResp.setRespData(eToken);
        }else {
            apiResp.respErr(MsgConstant.SYS_ERR);
        }
    }

    //用户正式入驻商家
    @Override
    public void join(ShopInfo shopInfo, ApiResp apiResp) {
        String openId = TokenUtil.getOpenIdByToken(shopInfo.getWxOpenId());
        ShopInfo shop = shopMapper.findMyShop(openId);
        if(shop==null){
            apiResp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            if(shop.getShopName()==null){
                //新入驻商户免费赠送3天会员
                shopInfo.setExpireTime(null);
                shopInfo.setWxOpenId(openId);
                shopMapper.updateBathInfo(shopInfo);
            }else {
                apiResp.respErr(MsgConstant.OPE_ERR);
            }
        }
    }

    //升级为VIP/续费
    @Override
    @Transactional
    public void renewVip(VipPay vipPay, ApiResp apiResp){
        String openId = TokenUtil.getOpenIdByToken(vipPay.geteToken());
        ShopInfo shop = shopMapper.findMyShop(openId);
        if(shop==null){
            apiResp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            //直接先开通VIP功能，其他修改等后台审核
            vipPay.setShopId(shop.getShopId());
            vipPay.setShopName(shop.getShopName());
            vipPayMapper.insertOne(vipPay);
            shopMapper.updateVip(1,shop.getShopId());
        }
    }


}
