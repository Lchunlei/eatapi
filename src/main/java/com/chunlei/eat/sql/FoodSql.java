package com.chunlei.eat.sql;

import com.chunlei.eat.entity.FoodInfo;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public class FoodSql {

    public String updateSql(FoodInfo foodInfo) {
        return new SQL(){{
            UPDATE("food_info");
            if(foodInfo.getFoodName()!=null){
                SET("foodName=#{foodName}");
            }
            if(foodInfo.getFoodPrice()!=null){
                SET("foodPrice=#{foodPrice}");
            }
            if(foodInfo.getPaixu()!=null){
                SET("paixu=#{paixu}");
            }
            if(foodInfo.getCateId()!=null){
                SET("cateId=#{cateId}");
            }
            if(foodInfo.getPicUrl()!=null){
                SET("picUrl=#{picUrl}");
            }
            SET("uTime=NOW()");
            WHERE("foodId=#{foodId}");
        }}.toString();
    }


}
