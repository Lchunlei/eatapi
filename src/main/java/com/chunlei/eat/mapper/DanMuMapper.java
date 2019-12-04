package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.DanMu;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("INSERT INTO video_dm(`text`, `color`, `time`, `useType`, `wxOpenId`, `cTime`) VALUES (#{text},#{color},#{time},#{useType},#{wxOpenId},NOW())")
    int insertOne(DanMu danMu);

    @Select("SELECT * FROM video_dm WHERE useType=#{useType} ORDER BY dmId DESC LIMIT 1")
    DanMu findMaxDanMus(@Param("useType")String useType);

}
