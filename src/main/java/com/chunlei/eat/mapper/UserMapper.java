package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Created by lcl on 2019/8/22 0022
 */
@Repository
public interface UserMapper {

    @Insert("INSERT INTO user_info(`wxOpenId`,`uTime`) VALUES (#{wxOpenId}, NOW())")
    int insertOne(@Param("wxOpenId") String wxOpenId);

    @Select("SELECT last_insert_id()")
    int selectMaxSeq();

    @Select("SELECT * FROM user_info WHERE wxOpenId=#{wxOpenId}")
    UserInfo findMyInfo(@Param("wxOpenId") String wxOpenId);

    @Select("SELECT * FROM user_info WHERE userId=#{userId}")
    UserInfo findById(@Param("userId")Integer userId);

}
