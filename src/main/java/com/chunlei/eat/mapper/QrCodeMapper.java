package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.QrCode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by lcl on 2019/9/17 0017
 */
@Repository
public interface QrCodeMapper {

    @Insert("INSERT INTO shop_qr(`shopId`,`deskCode`,`qrUrl`,`cTime`)VALUES(#{shopId},#{deskCode},#{qrUrl},NOW())")
    int insertOne(QrCode qrCode);

    @Select("SELECT * FROM shop_qr WHERE shopId=#{shopId} ORDER BY deskCode")
    List<QrCode> findShopAllQr(@Param("shopId") Integer shopId);



}
