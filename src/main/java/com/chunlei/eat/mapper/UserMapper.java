package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.UserInfo;
import com.chunlei.eat.model.resp.ShopStaff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by lcl on 2019/8/22 0022
 */
@Repository
public interface UserMapper {

    @Insert("INSERT INTO user_info(`wxOpenId`,`uTime`) VALUES (#{wxOpenId}, NOW())")
    int insertOne(@Param("wxOpenId") String wxOpenId);

    @Update("UPDATE user_info SET myShopId=#{myShopId},shopRole=#{shopRole} WHERE wxOpenId=#{wxOpenId}")
    int addUserRole(@Param("myShopId")Integer myShopId,@Param("shopRole")Integer shopRole,@Param("wxOpenId")String wxOpenId);

    @Update("UPDATE user_info SET myShopId=NULL,shopRole=NULL WHERE wxOpenId=#{wxOpenId}")
    int delUserRole(@Param("wxOpenId")String wxOpenId);

    @Select("SELECT u.userId,u.wxOpenId,u.shopRole,s.nickName,s.headUrl FROM user_info u LEFT JOIN shop_info s ON u.wxOpenId=s.wxOpenId WHERE u.myShopId=#{shopId}")
    List<ShopStaff> findShopStaff(@Param("shopId")Integer shopId);

    @Select("SELECT u.userId,u.wxOpenId,u.shopRole,s.nickName,s.headUrl FROM user_info u LEFT JOIN shop_info s ON u.wxOpenId=s.wxOpenId WHERE u.userId=#{uId}")
    ShopStaff findPreStaff(@Param("uId")Integer uId);

    @Select("SELECT last_insert_id()")
    int selectMaxSeq();

    @Select("SELECT * FROM user_info WHERE wxOpenId=#{wxOpenId}")
    UserInfo findMyInfo(@Param("wxOpenId") String wxOpenId);

    @Select("SELECT * FROM user_info WHERE userId=#{userId}")
    UserInfo findById(@Param("userId")Integer userId);

}
