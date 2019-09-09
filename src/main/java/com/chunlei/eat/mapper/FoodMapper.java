package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.FoodInfo;
import com.chunlei.eat.entity.ShopInfo;
import com.chunlei.eat.sql.FoodSql;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by lcl on 2019/9/9 0009
 */
@Repository
public interface FoodMapper {

    @Insert("INSERT INTO food_info(`foodName`,`foodPrice`,`shopId`,`paixu`,`uTime`) VALUES (#{foodName},#{foodPrice},#{shopId},#{paixu},NOW())")
    int insertOne(FoodInfo foodInfo);

    @UpdateProvider(type= FoodSql.class, method="updateSql")
    int updateBath(FoodInfo foodInfo);

    @Insert("SELECT * FROM food_info WHERE shopId=#{shopId} AND foodStatus='1' ORDER BY paixu DESC")
    List<FoodInfo> findByShopId(Integer shopId);

    @Select("SELECT * FROM food_info WHERE foodId=#{foodId}")
    FoodInfo findFoodById(@Param("foodId")Integer foodId);

}
