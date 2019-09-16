package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.BillInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
@Repository
public interface BillInfoMapper {

    @Insert("INSERT INTO bill_today_info(`userId`, `shopId`,`deskCode`, `foodId`, `foodName`, `eatNum`, `totalPrice`, `cTime`) VALUES (#{userId},#{shopId},#{deskCode},#{foodId},#{foodName},#{eatNum},#{totalPrice},NOW())")
    int insertOne(BillInfo billInfo);

    @Delete("DELETE FROM bill_today_info WHERE billId=#{billId}")
    int delById(Integer billId);

    //查看当前点餐排名
    @Select("SELECT COUNT(billId) FROM bill_today_info WHERE shopId=#{shopId} AND billId<#{billId} AND billStatus='1'")
    int findRate(@Param("shopId")Integer shopId,@Param("billId")Integer billId);

    //查看出菜顺序列表
    @Select("SELECT * FROM bill_today_info WHERE shopId=#{shopId} AND billStatus=#{billStatus} ORDER BY billId")
    List<BillInfo> findOutBills(@Param("shopId")Integer shopId,@Param("billStatus")Integer billStatus);

    //查看用户点菜顺序列表
    @Select("SELECT DISTINCT(userId) FROM bill_today_info WHERE shopId=#{shopId} AND billStatus='1'")
    List<Integer> findUserIdBills(@Param("shopId")Integer shopId,@Param("billStatus")Integer billStatus);
    @Select("SELECT * FROM bill_today_info WHERE shopId=#{shopId} AND userId=#{userId} AND billStatus=#{billStatus}")
    List<BillInfo> findUserBills(@Param("shopId")Integer shopId,@Param("userId")Integer userId,@Param("billStatus")Integer billStatus);

    //查看所有菜单
    @Select("SELECT * FROM bill_today_info WHERE shopId=#{shopId}")
    List<BillInfo> findAllBills(@Param("shopId")Integer shopId);

    @Select("SELECT * FROM bill_today_info WHERE userId=#{userId} AND billStatus=#{billStatus}")
    List<BillInfo> findMyBills(@Param("userId")Integer userId,@Param("billStatus")Integer billStatus);

    @Update("UPDATE bill_today_info SET billStatus=#{billStatus} WHERE billId=#{billId}")
    int updateStatus(@Param("billId")Integer billId,@Param("billStatus")Integer billStatus);

    //查看当前店铺未完成订单的客人ID
    @Select("SELECT DISTINCT(userId) FROM bill_today_info WHERE shopId=#{shopId} AND billStatus=#{billStatus} ORDER BY cTime")
    List<Integer> findUsersEating(@Param("shopId")Integer shopId,@Param("billStatus")Integer billStatus);


}
