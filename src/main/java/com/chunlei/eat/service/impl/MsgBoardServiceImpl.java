package com.chunlei.eat.service.impl;

import com.chunlei.eat.common.MsgConstant;
import com.chunlei.eat.entity.MsgBoard;
import com.chunlei.eat.entity.QrCode;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.entity.UserInfo;
import com.chunlei.eat.mapper.MsgBoardMapper;
import com.chunlei.eat.mapper.QrCodeMapper;
import com.chunlei.eat.mapper.ShopMapper;
import com.chunlei.eat.mapper.UserMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.MsgBoardService;
import com.chunlei.eat.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Created by lcl on 2019/11/1 0001
 * 旺铺留言板服务
 */
@Service
public class MsgBoardServiceImpl implements MsgBoardService {

    @Autowired
    private MsgBoardMapper msgBoardMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private QrCodeMapper qrCodeMapper;

    @Override
    public void fingShopMsgs(String eToken,Integer pageNum,ApiResp<List<MsgBoard>> resp) {
        Integer shopId = TokenUtil.getSidByToken(eToken);
        if(shopId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            List<MsgBoard>  msgs = msgBoardMapper.selectShopMsg(shopId,(pageNum-1)*20);
            if(msgs.isEmpty()){
                resp.respErr(MsgConstant.DATA_NULL);
            }else {
                resp.setRespData(msgs);
            }
        }
    }

    @Override
    public void findByQr(Integer qrId, Integer pageNum, ApiResp<List<MsgBoard>> resp) {
        QrCode qrCode = qrCodeMapper.findQrById(qrId);
        if(qrCode.getShopId()==null||qrCode.getShopId().equals(0)){
            resp.respErr(MsgConstant.OPE_ERR);
        }else {
            List<MsgBoard>  msgs = msgBoardMapper.selectShopMsg(qrCode.getShopId(),(pageNum-1)*20);
            if(msgs.isEmpty()){
                resp.respErr(MsgConstant.DATA_NULL);
            }else {
                resp.setRespData(msgs);
            }
        }
    }

    @Override
    public void delOne(String eToken, Integer mbId, ApiResp resp) {
        Integer shopId = TokenUtil.getSidByToken(eToken);
        if(shopId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            int i = msgBoardMapper.delMsg(mbId,shopId);
            if(i==0){
                resp.respErr(MsgConstant.OPE_ERR);
            }
        }
    }

    @Override
    public void addOne(MsgBoard msgBoard, ApiResp resp) {
        Integer sId = TokenUtil.getSidByToken(msgBoard.geteToken());
        Integer uId = TokenUtil.getUidByToken(msgBoard.geteToken());
        if(sId==null && uId==null){
            resp.respErr(MsgConstant.NOT_LOGIN);
        }else {
            QrCode qrCode = qrCodeMapper.findQrById(msgBoard.getShopId());
            if(qrCode.getShopId()==null){
                //传递的桌码没有绑定到店铺
                resp.respErr(MsgConstant.OPE_ERR);
                return;
            }else {
                msgBoard.setShopId(qrCode.getShopId());
            }
            if(uId==null){
                ShopInfo shopInfo = shopMapper.findShopById(sId);
                UserInfo u = userMapper.findMyInfo(shopInfo.getWxOpenId());
                if(u.getUserId().equals(msgBoard.getUserId())){
                    addMsg(msgBoard,resp);
                }else {
                    resp.respErr(MsgConstant.OPE_ERR);
                }
            }else {
                if(uId.equals(msgBoard.getUserId())){
                    addMsg(msgBoard,resp);
                }else {
                    resp.respErr(MsgConstant.OPE_ERR);
                }
            }
        }
    }

    /**
     * 本类私有方法
     * */
    private int addMsg(MsgBoard msgBoard,ApiResp resp){
        UserInfo u = userMapper.findById(msgBoard.getUserId());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = format.format(new Date());
        int i =0;
        if(nowDate.equals(u.getSayDate())){
            if(u.getSayMsg()>3){
                resp.respErr("今日留言已达上限");
            }else {
                msgBoardMapper.insertOne(msgBoard);
                i = userMapper.sayMsg(msgBoard.getUserId(),u.getSayMsg()+1,nowDate);
            }
        }else {
            msgBoardMapper.insertOne(msgBoard);
            i = userMapper.sayMsg(msgBoard.getUserId(),1,nowDate);
        }
        return i;
    }


}
