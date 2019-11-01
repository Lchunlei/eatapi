package com.chunlei.eat.service;

import com.chunlei.eat.entity.MsgBoard;
import com.chunlei.eat.model.ApiResp;

import java.util.List;

/**
 * @Created by lcl on 2019/10/26 0026
 */
public interface MsgBoardService {

    public void fingShopMsgs(String eToken,Integer pageNum, ApiResp<List<MsgBoard>> resp);

    public void findByQr(Integer qrId,Integer pageNum, ApiResp<List<MsgBoard>> resp);

    public void delOne(String eToken,Integer mbId,ApiResp resp);

    public void addOne(MsgBoard msgBoard,ApiResp resp);

}
