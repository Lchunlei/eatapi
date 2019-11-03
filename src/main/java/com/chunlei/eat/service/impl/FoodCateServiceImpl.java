package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.FoodCate;
import com.chunlei.eat.entity.FoodInfo;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.mapper.FoodCateMapper;
import com.chunlei.eat.mapper.FoodMapper;
import com.chunlei.eat.mapper.ShopMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.FoodCateService;
import com.chunlei.eat.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by lcl on 2019/11/1 0001
 */
@Service
public class FoodCateServiceImpl implements FoodCateService {

    @Autowired
    private FoodCateMapper foodCateMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public void updateCate(FoodCate foodCate, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(foodCate.geteToken());
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo s = shopMapper.findShopById(sId);
            if(s.getVipStatus().equals(0)){
                resp.respErr(MsgConstant.VIP_OPE_ERR);
            }else {
                FoodCate oldCate = foodCateMapper.findById(foodCate.getCateId());
                if(oldCate.getShopId().equals(sId)){
                    foodCate.setShopId(sId);
                    foodCateMapper.updateCate(foodCate);
                }else {
                    resp.respErr(MsgConstant.OPE_ERR);
                }
            }
        }
    }

    @Override
    public void findMyCates(String eToken, ApiResp<List<FoodCate>> resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            List<FoodCate> cates = foodCateMapper.findMyCates(sId);
            resp.setRespData(cates);
        }
    }

    @Override
    public void addCate(FoodCate foodCate, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(foodCate.geteToken());
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo s = shopMapper.findShopById(sId);
            if(s.getVipStatus().equals(0)){
                resp.respErr(MsgConstant.VIP_OPE_ERR);
            }else {
                List<FoodCate> cates = foodCateMapper.findMyCates(sId);
                if(cates.size()>9){
                    resp.respErr("菜谱类目数量已达上限");
                }else {
                    foodCate.setShopId(sId);
                    foodCateMapper.insertOne(foodCate);
                }
            }
        }
    }

    @Override
    public void delCate(String eToken, Integer cateId, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo s = shopMapper.findShopById(sId);
            if(s.getVipStatus().equals(0)){
                resp.respErr(MsgConstant.VIP_OPE_ERR);
            }else {
                //先查看这个类目下是否有菜品
                List<FoodInfo> foods = foodMapper.findAllByCateId(cateId);
                if(foods.isEmpty()){
                    int i = foodCateMapper.delOneById(cateId,sId);
                    if(i==0){
                        resp.respErr(MsgConstant.OPE_ERR);
                    }
                }else {
                    resp.respErr(foods.get(0).getFoodName()+"...属于类目不可删除");
                }
            }
        }
    }


}
