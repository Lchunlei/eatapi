package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.QrCode;
import com.chunlei.eat.mapper.QrCodeMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.QrCodeService;
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

    @Override
    public void addShopQr(String eToken, Integer qrTotal, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(eToken);
        if(sId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            String errMsg = "您店铺专属桌码已达20上限，请联系客服修改！";
            List<QrCode> qrCodes = qrCodeMapper.findShopAllQr(sId);
            if(qrCodes.size()>20){
                resp.respErr(errMsg);
            }else if((qrCodes.size()+qrTotal)>20){
                resp.respErr(errMsg);
            }else {
                //生成指定店铺二维码
                int sdeskCode = 1;
                if(!qrCodes.isEmpty()){
                    sdeskCode = qrCodes.get(qrCodes.size()-1).getDeskCode()+1;
                }
                for(int i=0;i<qrTotal;i++){
                    String imgUrl = WxQrcodeUtil.getQr(sId+"-"+(sdeskCode+i));
                    if(!StringTool.isBlank(imgUrl)){
                        QrCode q = new QrCode(sId,sdeskCode+i,imgUrl);
                        qrCodeMapper.insertOne(q);
                    }
                }
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


}
