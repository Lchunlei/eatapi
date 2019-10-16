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

    @Delete("DELETE FROM bill_today_info WHERE billId=#{billId} AND shopId=#{shopId} AND billStatus='0'")
    int delById(@Param("billId")Integer billId,@Param("shopId")Integer shopId);

    @Delete("DELETE FROM bill_today_info WHERE shopId!=#{shopId} AND billStatus!='2'")
    int delOtherShopBills(@Param("shopId")Integer shopId);

    //查看当前点餐排名
    @Select("SELECT COUNT(DISTINCT(userId)) AS rate FROM bill_today_info WHERE shopId=#{shopId} AND billId<#{billId} AND billStatus ='0'")
    Integer findRateByBillid(@Param("shopId")Integer shopId,@Param("billId")Integer billId);

    //查看没有上的菜ID
    @Select("SELECT billId FROM bill_today_info WHERE shopId=#{shopId} AND userId=#{userId} AND billStatus='0' ORDER BY billId DESC LIMIT 1")
    Integer notOut(@Param("shopId")Integer shopId,@Param("userId")Integer userId);

    //查看出菜顺序列表
    @Select("SELECT * FROM bill_today_info WHERE shopId=#{shopId} AND billStatus=#{billStatus} ORDER BY billId")
    List<BillInfo> findOutBills(@Param("shopId")Integer shopId,@Param("billStatus")Integer billStatus);

    //查看用户点菜顺序列表
    @Select("SELECT DISTINCT(userId) FROM bill_today_info WHERE shopId=#{shopId} AND billStatus='1'")
    List<Integer> findUserIdBills(@Param("shopId")Integer shopId,@Param("billStatus")Integer billStatus);
    @Select("SELECT * FROM bill_today_info WHERE shopId=#{shopId} AND userId=#{userId} AND billStatus IN('0','1')")
    List<BillInfo> findNoPayUserBills(@Param("shopId")Integer shopId,@Param("userId")Integer userId);

    //查看所有菜单
    @Select("SELECT * FROM bill_today_info WHERE shopId=#{shopId} ORDER BY billId DESC LIMIT ${startNum},10")
    List<BillInfo> findAllBills(@Param("shopId")Integer shopId,@Param("startNum")Integer startNum);

    @Select("SELECT * FROM bill_today_info WHERE userId=#{userId} AND billStatus=#{billStatus}")
    List<BillInfo> findMyBills(@Param("userId")Integer userId,@Param("billStatus")Integer billStatus);

    @Select("SELECT * FROM bill_today_info WHERE userId=#{userId} AND billStatus IN('0','1') ORDER BY billId DESC")
    List<BillInfo> findMyWillEatBills(@Param("userId")Integer userId);

    @Update("UPDATE bill_today_info SET billStatus=#{billStatus} WHERE billId=#{billId} AND shopId=#{shopId}")
    int updateStatus(@Param("billId")Integer billId,@Param("billStatus")Integer billStatus,@Param("shopId")Integer shopId);

    //查看当前店铺未完成订单的客人ID
    @Select("SELECT DISTINCT(userId) FROM bill_today_info WHERE shopId=#{shopId} AND billStatus=#{billStatus} ORDER BY cTime")
    List<Integer> findUsersEating(@Param("shopId")Integer shopId,@Param("billStatus")Integer billStatus);

    //查看当前店铺未支付的客人ID
    @Select("SELECT DISTINCT(userId) FROM bill_today_info WHERE shopId=#{shopId} AND billStatus IN('0','1') ORDER BY cTime")
    List<Integer> findUsersNoPay(@Param("shopId")Integer shopId);

    @Delete("DELETE FROM bill_today_info WHERE shopId=#{shopId} AND billStatus='0' AND userId=#{userId}")
    int delUserBills(@Param("shopId")Integer shopId,@Param("userId")Integer userId);

    //本店某顾客付款结账
    @Update("UPDATE bill_today_info SET billStatus='2' WHERE shopId=#{shopId} AND billStatus='1' AND userId=#{userId}")
    int completeBills(@Param("shopId")Integer shopId,@Param("userId")Integer userId);

    //查看本店收益
    @Select("SELECT SUM(totalPrice) FROM bill_today_info WHERE shopId=#{shopId} AND billStatus='2' AND cTime>#{sTime} AND cTime<#{eTime}")
    Integer findIncome(@Param("shopId")Integer shopId,@Param("sTime")String sTime,@Param("eTime")String eTime);

    //查看本店单量
    @Select("SELECT COUNT(billId) FROM bill_today_info WHERE shopId=#{shopId} AND billStatus='2' AND cTime>#{sTime} AND cTime<#{eTime}")
    Integer findBillNum(@Param("shopId")Integer shopId,@Param("sTime")String sTime,@Param("eTime")String eTime);

    //查看本店客流量
    @Select("SELECT COUNT(DISTINCT(userId)) FROM bill_today_info WHERE shopId=#{shopId} AND billStatus='2' AND cTime>#{sTime} AND cTime<#{eTime}")
    Integer findClientNum(@Param("shopId")Integer shopId,@Param("sTime")String sTime,@Param("eTime")String eTime);

}
