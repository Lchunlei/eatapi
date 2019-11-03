package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.FoodCate;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by lcl on 2019/11/1 0001
 */
@Repository
public interface FoodCateMapper {

    @Select("SELECT * FROM food_cate WHERE shopId=${shopId}")
    List<FoodCate> findMyCates(@Param("shopId")Integer shopId);

    @Select("SELECT * FROM food_cate WHERE cateId=${cateId}")
    FoodCate findById(@Param("cateId")Integer cateId);

    @Insert("INSERT INTO food_cate(`shopId`, `cateName`, `cTime`) VALUES (${shopId}, #{cateName}, NOW())")
    int insertOne(FoodCate foodCate);

    @Update("UPDATE food_cate SET cateName=#{cateName} WHERE cateId=#{cateId} AND shopId=#{shopId}")
    int updateCate(FoodCate foodCate);

    @Delete("DELETE FROM food_cate WHERE cateId=#{cateId} AND shopId=${shopId}")
    int delOneById(@Param("cateId")Integer cateId,@Param("shopId")Integer shopId);

}
