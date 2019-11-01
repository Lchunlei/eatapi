package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.MsgBoard;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by lcl on 2019/10/26 0026
 */
@Repository
public interface MsgBoardMapper {

    @Insert("INSERT INTO msg_board(`shopId`, `userId`, `msgContent`, `cTime`) VALUES (#{shopId},#{userId},#{msgContent},NOW())")
    int insertOne(MsgBoard msgBoard);

    @Select("SELECT * FROM msg_board WHERE shopId=${shopId} LIMIT ${startNum},20")
    List<MsgBoard> selectShopMsg(@Param("shopId")Integer shopId,@Param("startNum")Integer startNum);

    @Delete("DELETE FROM msg_board WHERE mbId=${mbId} AND shopId=${shopId}")
    int delMsg(@Param("mbId")Integer mbId,@Param("shopId")Integer shopId);

    @Update("UPDATE msg_board SET supportNum=supportNum+1 WHERE mbId=${mbId}")
    int zanMsg(@Param("mbId")Integer mbId);


}
