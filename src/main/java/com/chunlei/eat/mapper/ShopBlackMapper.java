package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.ShopBlack;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by lcl on 2019/11/5 0005
 */
@Repository
public interface ShopBlackMapper {

    @Insert("INSERT INTO shop_black(`shopId`, `userId`, `cTime`) VALUES (${shopId},${userId},NOW())")
    int insertOne(ShopBlack shopBlack);

    @Select("SELECT * FROM shop_black WHERE shopId=#{shopId} AND userId=#{userId}")
    ShopBlack findBlack(@Param("shopId")Integer shopId, @Param("userId")Integer userId);

    @Select("SELECT * FROM shop_black WHERE shopId=#{shopId}")
    List<ShopBlack> shopBlacks(@Param("shopId")Integer shopId);

    @Delete("DELETE FROM shop_black WHERE shopId=#{shopId} AND userId=#{userId}")
    int delBlack(@Param("shopId")Integer shopId, @Param("userId")Integer userId);


}
