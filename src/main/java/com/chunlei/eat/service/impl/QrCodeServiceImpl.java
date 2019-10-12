package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.QrCode;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.mapper.QrCodeMapper;
import com.chunlei.eat.mapper.ShopMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.QrCodeService;
import com.chunlei.eat.utils.Reqclient;
import com.chunlei.eat.utils.StringTool;
import com.chunlei.eat.utils.TokenUtil;
import com.chunlei.eat.utils.WxQrcodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by lcl on 2019/9/17 0017
 */
@Service
public class QrCodeServiceImpl implements QrCodeService {
    @Autowired
    private QrCodeMapper qrCodeMapper;
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public void binding(String eToken, Integer deskCode,Integer qrId, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            Integer qrTotal = qrCodeMapper.findShopQrTotal(sId);
            if(qrTotal!=null && qrTotal>19){
                resp.respErr("您店铺专属桌码已达20上限，请联系客服修改！");
            }else {
                //开始绑定桌码
                QrCode nQr = qrCodeMapper.findQrById(qrId);
                if(nQr.getShopId()==null){
                    int i = qrCodeMapper.binding(qrId,sId,deskCode);
                    if(i==1){
                        resp.setRespMsg("绑码成功！贴到桌角侯客吧");
                    }else {
                        resp.respErr(MsgConstant.OPE_ERR);
                    }
                }else {
                    resp.respErr("二维码被占用，绑定失败");
                }
            }
        }
    }

    @Override
    public void delBinding(String eToken,Integer qrId, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            QrCode myQr = qrCodeMapper.findQrById(qrId);
            if(myQr!=null){
                if(myQr.getShopId()==null||myQr.getShopId().equals(0)){
                    resp.respErr("桌码没有绑定信息！！");
                }else if(myQr.getShopId().equals(sId)){
                    int i = qrCodeMapper.delBinding(qrId);
                    if(i!=1){
                        resp.respErr(MsgConstant.OPE_ERR);
                    }
                }
            }else {
                resp.respErr(MsgConstant.OPE_ERR);
            }
        }
    }

    @Override
    public void findMyQrs(String eToken, ApiResp<List<QrCode>> resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            List<QrCode> qrCodes = qrCodeMapper.findShopAllQr(sId);
            if(qrCodes.isEmpty()){
                resp.respErr("您还没有申请专属桌牌呢");
            }else {
                resp.setRespData(qrCodes);
            }
        }
    }

    @Override
    public void qrContent(Integer qrId, ApiResp<QrCode> resp) {
        QrCode qrCode = qrCodeMapper.findQrById(qrId);
        if(qrCode==null||qrCode.getShopId()==null){
            resp.respErr(MsgConstant.DATA_NULL);
        }else {
            resp.setRespData(qrCode);
        }
    }

    @Override
    public void preMake(String pwd, ApiResp resp) {
        if("zyilcl".equals(pwd)){
            Integer maxId = qrCodeMapper.findMaxId();
            if(maxId==null){
                maxId=0;
            }
            String accessToken = Reqclient.getWxAuth();
            for(int i=1;i<1002;i++){
                int j = maxId+i;
                try {
                    Boolean re = WxQrcodeUtil.getQr(""+j,accessToken);
                    if(re){
                        QrCode q = new QrCode(j);
                        qrCodeMapper.insertOne(q);
                    }else {
                        System.out.println("生成第"+j+"个失败！");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("生成第"+j+"个出现异常！！！！！！");
                    try {
                        Thread.sleep(3000);
                    }catch (Exception ex){

                    }
                }
            }
        }

    }

    @Override
    public void getShopInfo(Integer qrId, ApiResp<ShopInfo> resp) {
        QrCode qrCode = qrCodeMapper.findQrById(qrId);
        if(qrCode==null||qrCode.getShopId()==null){
            resp.respErr(MsgConstant.GET_DATA_NULL);
        }else {
            ShopInfo shopInfo = shopMapper.findShopById(qrCode.getShopId());
            resp.setRespData(shopInfo);
        }
    }


}
