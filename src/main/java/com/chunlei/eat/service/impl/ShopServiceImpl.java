package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.entity.UserInfo;
import com.chunlei.eat.entity.VipPay;
import com.chunlei.eat.mapper.ShopMapper;
import com.chunlei.eat.mapper.UserMapper;
import com.chunlei.eat.mapper.VipPayMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.ShopService;
import com.chunlei.eat.utils.DateTool;
import com.chunlei.eat.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        ShopInfo shop = shopMapper.findMyShop(openid);
        int i;
        if(shop==null){
            i = shopMapper.insertOne(shopInfo);
        }else {
            i = shopMapper.updateBathInfo(shopInfo);
        }
        if(i!=1){
            apiResp.respErr(MsgConstant.PARAMS_ERR);
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
            shopInfo.setShopId(shop.getShopId());
            shopMapper.updateBathInfo(shopInfo);
        }
    }

    //升级为VIP/续费
    @Override
    public void renewVip(VipPay vipPay, ApiResp apiResp) {
        String openId = TokenUtil.getOpenIdByToken(vipPay.geteToken());
        ShopInfo shop = shopMapper.findMyShop(openId);
        if(shop==null){
            apiResp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            //直接先开通VIP功能，其他修改等后台审核
            vipPay.setShopId(shop.getShopId());
            vipPay.setShopName(shop.getShopName());
            vipPayMapper.insertOne(vipPay);
            shopMapper.updateStatus(1,shop.getShopId());
        }
    }


}
