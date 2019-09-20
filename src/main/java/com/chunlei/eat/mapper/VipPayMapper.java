package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.VipPay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @Created by lcl on 2019/9/9 0009
 */
@Repository
public interface VipPayMapper {

    @Insert("INSERT INTO vip_pay(`shopId`, `shopName`, `payType`, `payNum`, `payValue`,`useRemark`, `cTime`) VALUES (#{shopId},#{shopName},#{payType},#{payNum},#{payValue},#{useRemark},NOW())")
    int insertOne(VipPay vipPay);

    @Select("SELECT * FROM vip_pay WHERE payNum=#{payNum}")
    VipPay findByPayNum(@Param("payNum")String payNum);

    @Update("UPDATE vip_pay SET getStatus=#{getStatus} WHERE inId=#{inId}")
    int updateGetStatus(@Param("getStatus")Integer getStatus,@Param("inId")Integer inId);


}
