package com.chunlei.eat.service;

import com.chunlei.eat.entity.UserNotice;
import com.chunlei.eat.model.ApiResp;

import java.util.List;

/**
 * @Created by lcl on 2019/9/10 0010
 */
public interface UserNoticeService {

    public void findNotice(String eToken, ApiResp<List<UserNotice>> resp);

    public void findNoticeDetails(Integer nteId, ApiResp<UserNotice> resp);

}
