package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.FoodInfo;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.sql.FoodSql;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
@Repository
public interface FoodMapper {

    @Insert("INSERT INTO food_info(`foodName`,`foodPrice`,`shopId`,`cateId`,`paixu`,`uTime`) VALUES (#{foodName},#{foodPrice},#{shopId},#{cateId},#{paixu},NOW())")
    int insertOne(FoodInfo foodInfo);

    @UpdateProvider(type= FoodSql.class, method="updateSql")
    int updateBath(FoodInfo foodInfo);

    @Delete("DELETE FROM food_info WHERE foodId=#{foodId}")
    int delById(@Param("foodId")Integer foodId);

    @Select("SELECT * FROM food_info WHERE shopId=#{shopId} AND foodStatus='1' ORDER BY paixu DESC")
    List<FoodInfo> findCanEatByShopId(@Param("shopId")Integer shopId);

    @Select("SELECT * FROM food_info WHERE shopId=#{shopId} AND cateId=#{cateId} AND foodStatus='1' ORDER BY paixu DESC")
    List<FoodInfo> findCanEatBycateId(@Param("shopId")Integer shopId,@Param("cateId")Integer cateId);

    @Select("SELECT * FROM food_info WHERE shopId=#{shopId} ORDER BY paixu DESC")
    List<FoodInfo> findAllByShopId(@Param("shopId")Integer shopId);

    @Select("SELECT * FROM food_info WHERE foodId=#{foodId}")
    FoodInfo findFoodById(@Param("foodId")Integer foodId);

    @Update("UPDATE food_info SET foodStatus=#{foodStatus} WHERE foodId=#{foodId}")
    int updateSell(@Param("foodStatus")Integer foodStatus,@Param("foodId")Integer foodId);


}
