package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.ShopBlack;
import com.chunlei.eat.mapper.ShopBlackMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.ShopBlackService;
import com.chunlei.eat.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by lcl on 2019/11/5 0005
 */
@Service
public class ShopBlackServiceImpl implements ShopBlackService {

    @Autowired
    private ShopBlackMapper shopBlackMapper;


    @Override
    public void addBlack(ShopBlack shopBlack, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(shopBlack.geteToken());
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopBlack oldBlack = shopBlackMapper.findBlack(sId,shopBlack.getUserId());
            if(oldBlack!=null){
                resp.respErr("重复添加黑名单");
            }else {
                shopBlack.setShopId(sId);
                int i = shopBlackMapper.insertOne(shopBlack);
                if(i!=1){
                    resp.respErr(MsgConstant.OPE_ERR);
                }
            }
        }
    }

    @Override
    public void shopBlacks(String eToken, ApiResp<List<ShopBlack>> resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            List<ShopBlack> oldBlacks = shopBlackMapper.shopBlacks(sId);
            if(oldBlacks.isEmpty()){
                resp.respErr(MsgConstant.DATA_NULL);
            }else {
                resp.setRespData(oldBlacks);
            }
        }
    }

    @Override
    public void delBlack(String eToken, Integer userId, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            int i = shopBlackMapper.delBlack(sId,userId);
            if(i!=1){
                resp.respErr(MsgConstant.OPE_ERR);
            }
        }
    }


}
