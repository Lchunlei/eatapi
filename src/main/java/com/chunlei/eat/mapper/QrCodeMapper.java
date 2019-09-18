package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.QrCode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by lcl on 2019/9/17 0017
 */
@Repository
public interface QrCodeMapper {

    @Insert("INSERT INTO shop_qr(`qrId`,`cTime`)VALUES(#{qrId},NOW())")
    int insertOne(QrCode qrCode);

    @Select("SELECT * FROM shop_qr WHERE shopId=#{shopId} ORDER BY deskCode")
    List<QrCode> findShopAllQr(@Param("shopId") Integer shopId);

    @Select("SELECT * FROM shop_qr WHERE qrId=#{qrId}")
    QrCode findQrById(@Param("qrId") Integer qrId);

    @Select("SELECT MAX(qrId) FROM shop_qr")
    Integer findMaxId();

    @Update("UPDATE shop_qr SET shopId=#{shopId},deskCode=#{deskCode} WHERE qrId=#{qrId}")
    int binding(@Param("qrId") Integer qrId,@Param("shopId") Integer shopId,@Param("deskCode") Integer deskCode);

}
