package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.QrGet;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @Created by lcl on 2019/10/10 0010
 */
@Repository
public interface QrGetMapper {

    @Insert("INSERT INTO qr_get(`receiveName`, `receiveTel`, `receiveAddr`, `getNum`, `payCode`, `cTime`) VALUES (#{receiveName},#{receiveTel},#{receiveAddr},#{getNum},#{payCode},NOW())")
    int insertOne(QrGet qrGet);

}
