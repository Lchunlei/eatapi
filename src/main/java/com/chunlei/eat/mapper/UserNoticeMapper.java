package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.UserNotice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @Created by lcl on 2019/9/10 0010
 */
@Repository
public interface UserNoticeMapper {

    @Select("SELECT * FROM user_notice")
    List<UserNotice> findAll();

    @Select("SELECT * FROM user_notice WHERE nteType='2' AND shopId=#{shopId}")
    List<UserNotice> findByUid(@Param("shopId") Integer shopId);

    @Select("SELECT * FROM user_notice WHERE nteType='2' AND wxOpenId=#{wxOpenId}")
    List<UserNotice> findByOpenID(@Param("wxOpenId") String wxOpenId);

    @Select("SELECT * FROM user_notice WHERE nteId=#{nteId}")
    UserNotice findById(@Param("nteId")Integer nteId);


}
