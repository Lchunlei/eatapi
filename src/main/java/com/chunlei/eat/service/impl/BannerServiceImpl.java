package com.chunlei.eat.service.impl;

import com.chunlei.eat.entity.BannerInfo;
import com.chunlei.eat.mapper.BannerMapper;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by lcl on 2019/9/10 0010
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public void findAll(String banType, ApiResp<List<BannerInfo>> resp) {
        List<BannerInfo> banners = bannerMapper.findAll(banType);
        resp.setRespData(banners);
    }

    @Override
    public void findDetail(Integer bannerId, ApiResp<BannerInfo> resp) {
        BannerInfo info = bannerMapper.findById(bannerId);
        resp.setRespData(info);
    }

}
