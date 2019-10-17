package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.BannerInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by lcl on 2019/9/10 0010
 */
@Repository
public interface BannerMapper {

    @Select("SELECT * FROM banner_info WHERE banType=#{banType} AND banStatus=1 ORDER BY paixu")
    List<BannerInfo> findAll(@Param("banType")String banType);

    @Select("SELECT * FROM banner_info WHERE bannerId=#{bannerId}")
    BannerInfo findById(@Param("bannerId")Integer bannerId);

}
