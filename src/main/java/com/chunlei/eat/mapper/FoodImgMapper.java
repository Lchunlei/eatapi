package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.FoodImg;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Created by lcl on 2019/11/29 0029
 */
@Repository
public interface FoodImgMapper {

    @Select("SELECT * FROM food_img WHERE imgName LIKE concat('%',#{foodName},'%') LIMIT 1")
    FoodImg getOneImg(String foodName);

}
