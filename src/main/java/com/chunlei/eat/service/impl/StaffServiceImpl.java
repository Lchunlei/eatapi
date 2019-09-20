package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.mapper.UserMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.resp.ShopStaff;
import com.chunlei.eat.service.StaffService;
import com.chunlei.eat.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by lcl on 2019/9/19 0019
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void findAllShopStaff(String eToken, ApiResp<List<ShopStaff>> resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            List<ShopStaff> staffs = userMapper.findShopStaff(sId);
            if(staffs.isEmpty()){
                resp.respErr(MsgConstant.DATA_NULL);
            }else {
                resp.setRespData(staffs);
            }
        }
    }

    @Override
    public void preInfo(String eToken, Integer uId, ApiResp<ShopStaff> resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopStaff staff = userMapper.findPreStaff(uId);
            if(staff==null){
                resp.respErr("掌柜号不存在，请核查后重试");
            }else {
                resp.setRespData(staff);
            }
        }
    }


}
