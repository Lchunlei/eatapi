package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.FoodInfo;
import com.chunlei.eat.mapper.FoodMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.req.MuchFood;
import com.chunlei.eat.service.FoodService;
import com.chunlei.eat.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
@Service
public class FoodServiceImpl implements FoodService {
    private static final Logger log = LoggerFactory.getLogger(FoodServiceImpl.class);

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public void addFood(FoodInfo foodInfo, ApiResp resp) {
        Integer shopId = TokenUtil.getIdByToken(foodInfo.geteToken());
        foodInfo.setShopId(shopId);
        foodMapper.insertOne(foodInfo);
    }

    @Override
    public void addFoods(MuchFood muchFood, ApiResp resp) {
        Integer shopId = TokenUtil.getIdByToken(muchFood.geteToken());
        int i = 0;
        for(FoodInfo f:muchFood.getFoods()){
            f.setShopId(shopId);
            int j = foodMapper.insertOne(f);
            if(j==1){
                j++;
            }
        }
        resp.setRespMsg("成功添加"+i+"份新品！");
    }

    @Override
    public void updateFood(FoodInfo foodInfo, ApiResp resp) {
        Integer shopId = TokenUtil.getIdByToken(foodInfo.geteToken());
        foodInfo.setShopId(shopId);
        int i = foodMapper.updateBath(foodInfo);
        if(i!=1){
            resp.setRespMsg(MsgConstant.OPE_ERR);
        }
    }

    @Override
    public void findAll(Integer shopId, ApiResp<List<FoodInfo>> resp) {
        List<FoodInfo> foodInfos = foodMapper.findByShopId(shopId);
        if(foodInfos.isEmpty()){
            resp.respErr(MsgConstant.FOOD_NULL);
        }else {
            resp.setRespData(foodInfos);
        }
    }


}
