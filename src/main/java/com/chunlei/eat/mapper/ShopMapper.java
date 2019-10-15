package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.sql.ShopSql;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Created by lcl on 2019/8/22 0022
 */
@Repository
public interface ShopMapper {

    @Insert("INSERT INTO shop_info(`wxOpenId`, `nickName`, `headUrl`, `loginTime`, `cTime`) VALUES (#{wxOpenId},#{nickName},#{headUrl},NOW(),NOW())")
    int insertOne(ShopInfo shopInfo);

    @Select("SELECT last_insert_id()")
    int selectMaxSeq();

    @Select("SELECT * FROM shop_info WHERE wxOpenId=#{wxOpenId}")
    ShopInfo findMyShop(@Param("wxOpenId")String wxOpenId);

    @Select("SELECT * FROM shop_info WHERE shopId=#{shopId}")
    ShopInfo findShopById(@Param("shopId")Integer shopId);

    @Update("UPDATE shop_info SET shopStatus=#{shopStatus} WHERE shopId=#{shopId}")
    int updateStatus(@Param("shopStatus")Integer shopStatus,@Param("shopId")Integer shopId);

    @Update("UPDATE shop_info SET vipStatus=#{vipStatus} WHERE shopId=#{shopId}")
    int updateVip(@Param("vipStatus")Integer vipStatus,@Param("shopId")Integer shopId);

    @Update("UPDATE shop_info SET vipStatus=#{vipStatus},expireTime=#{expireTime} WHERE shopId=#{shopId}")
    int updateVipDate(@Param("vipStatus")Integer vipStatus, @Param("expireTime") Date expireTime, @Param("shopId")Integer shopId);

    @UpdateProvider(type= ShopSql.class, method="updateSql")
    int updateBathInfo(ShopInfo shopInfo);

    @Update("UPDATE shop_info SET inviteSid=NULL,preRole=NULL WHERE shopId=#{shopId}")
    int refuseInvite(@Param("shopId")Integer shopId);

    @Update("UPDATE shop_info SET inviteSid=NULL,preRole=NULL,province=NULL,city=NULL,district=NULL,address=NULL,userRole=#{userRole},mySid=#{mySid} WHERE shopId=#{shopId}")
    int agreeInvite(@Param("shopId")Integer shopId,@Param("userRole")Integer userRole,@Param("mySid")Integer mySid);

    @Select("SELECT * FROM shop_info WHERE mySid=#{shopId} AND userRole!=1")
    List<ShopInfo> findStaffsBysid(@Param("shopId")Integer shopId);

    @Update("UPDATE shop_info SET inviteSid=NULL,preRole=NULL,province=NULL,city=NULL,district=NULL,address=NULL,userRole='1',mySid=NULL,shopName=NULL,bossTel=NULL,bossName=NULL WHERE shopId=#{shopId}")
    int delStaff(@Param("shopId")Integer shopId);

    @Select("SELECT * FROM shop_info WHERE shopId=#{shopId} AND inviteSid IS NOT NULL")
    ShopInfo lookUpInvite(@Param("shopId")Integer shopId);

}
