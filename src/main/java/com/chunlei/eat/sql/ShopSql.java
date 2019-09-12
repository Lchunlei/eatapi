package com.chunlei.eat.sql;

import com.chunlei.eat.entity.ShopInfo;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Created by lcl on 2019/9/9 0009
 */
public class ShopSql {

    public String updateSql(ShopInfo shopInfo) {
        return new SQL(){{
            UPDATE("shop_info");
            if(shopInfo.getShopName()!=null){
                SET("shopName=#{shopName}");
            }
            if(shopInfo.getNickName()!=null){
                SET("nickName=#{nickName}");
            }
            if(shopInfo.getHeadUrl()!=null){
                SET("headUrl=#{headUrl}");
            }
            if(shopInfo.getBossTel()!=null){
                SET("bossTel=#{bossTel}");
            }
            if(shopInfo.getBossName()!=null){
                SET("bossName=#{bossName}");
            }
            if(shopInfo.getInviteCode()!=null){
                SET("inviteCode=#{inviteCode}");
            }
            if(shopInfo.getProvince()!=null){
                SET("province=#{province}");
            }
            if(shopInfo.getCity()!=null){
                SET("city=#{city}");
            }
            if(shopInfo.getDistrict()!=null){
                SET("district=#{district}");
            }
            if(shopInfo.getAddress()!=null){
                SET("address=#{address}");
            }
            if(shopInfo.getExpireTime()!=null){
                SET("expireTime=#{expireTime}");
            }
            SET("loginTime=NOW()");
            if(shopInfo.getShopId()!=null){
                WHERE("shopId=#{shopId}");
            }else {
                WHERE("wxOpenId=#{wxOpenId}");
            }
        }}.toString();
    }



}
