package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.QrCode;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.entity.UserInfo;
import com.chunlei.eat.mapper.QrCodeMapper;
import com.chunlei.eat.mapper.ShopMapper;
import com.chunlei.eat.mapper.UserMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.model.resp.ShopStaff;
import com.chunlei.eat.service.StaffService;
import com.chunlei.eat.utils.StringTool;
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
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private QrCodeMapper qrCodeMapper;

    @Override
    public void findAllShopStaff(String eToken, ApiResp<List<ShopInfo>> resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            List<ShopInfo> staffs = shopMapper.findStaffsBysid(sId);
            if(staffs.isEmpty()){
                resp.respErr(MsgConstant.DATA_NULL);
            }else {
                resp.setRespData(staffs);
            }
        }
    }

    @Override
    public void delMyStaff(String eToken, Integer shopId, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            int i = shopMapper.delStaff(shopId);
            if(i==0){
                resp.respErr(MsgConstant.OPE_ERR);
            }
        }
    }

    @Override
    public void preAdd(String eToken, Integer uId, Integer userRole, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            ShopInfo shopInfo = shopMapper.findShopById(sId);
            if(StringTool.isBlank(shopInfo.getShopName())||StringTool.isBlank(shopInfo.getBossTel())){
                resp.respErr(MsgConstant.SHOP_NULL_MAKE);
            }else {
                List<QrCode> qrCodes = qrCodeMapper.findShopAllQr(sId);
                if(qrCodes.isEmpty()){
                    resp.respErr("请先绑定本店餐桌二维码");
                }else {
                    ShopInfo inviteUser = new ShopInfo();
                    UserInfo userInfo = userMapper.findById(uId);
                    if(userInfo==null){
                        resp.respErr("顾客号不存在");
                    }else {
                        ShopInfo nowShop = shopMapper.findMyShop(userInfo.getWxOpenId());
                        if(nowShop==null){
                            resp.respErr("顾客号不存在");
                        }else {
                            inviteUser.setShopId(nowShop.getShopId());
                            inviteUser.setPreRole(userRole);
                            inviteUser.setInviteSid(sId);
                            shopMapper.updateBathInfo(inviteUser);
                            resp.setRespMsg(nowShop.getNickName()+"邀请已发出");
                        }
                    }
                }
            }
        }
    }

    @Override
    public void cofInvite(String eToken, Integer cof, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            if(cof==0){
                //拒绝成为店员
                shopMapper.refuseInvite(sId);
            }else {
                ShopInfo shopInfo = shopMapper.findShopById(sId);
                ShopInfo supShop = shopMapper.findShopById(shopInfo.getInviteSid());
                //接受邀请
                shopMapper.agreeInvite(sId,shopInfo.getPreRole(),shopInfo.getInviteSid());
                //复制所属店铺基础信息
                ShopInfo upShop = new ShopInfo();
                upShop.setShopId(sId);
                upShop.setShopName(supShop.getShopName());
                upShop.setBossName(supShop.getBossName());
                upShop.setBossTel(supShop.getBossTel());
                shopMapper.updateBathInfo(upShop);
                resp.setRespData(TokenUtil.getStoken(supShop.getShopId(),supShop.getWxOpenId()));
            }
        }
    }

    @Override
    public void lookupStaff(String eToken, ApiResp<Integer> resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.loginErr();
        }else {
            ShopInfo mine = shopMapper.lookUpInvite(sId);
            if(mine==null){
                resp.respErr(MsgConstant.DATA_NULL);
            }else {
                ShopInfo inviteShop = shopMapper.findShopById(mine.getInviteSid());
                resp.setRespData(1);
                resp.setRespMsg(inviteShop.getShopName());
            }
        }
    }

}
