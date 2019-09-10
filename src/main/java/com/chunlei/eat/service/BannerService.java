package com.chunlei.eat.service;

import com.chunlei.eat.entity.BannerInfo;
import com.chunlei.eat.model.ApiResp;

import java.util.List;

/**
 * @Created by lcl on 2019/9/10 0010
 */
public interface BannerService {

    public void findAll(String banType, ApiResp<List<BannerInfo>> resp);

}
