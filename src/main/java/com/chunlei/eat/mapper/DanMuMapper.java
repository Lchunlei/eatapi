package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.DanMu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by lcl on 2019/11/29 0029
 */
@Repository
public interface DanMuMapper {

    //查看指定视频弹幕
    @Select("SELECT * FROM video_dm WHERE useType=#{useType}")
    List<DanMu> findDanMus(@Param("useType")String useType);


}
