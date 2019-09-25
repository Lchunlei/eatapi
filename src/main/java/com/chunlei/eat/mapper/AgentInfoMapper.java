package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.AgentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Created by lcl on 2019/9/20 0020
 */
@Repository
public interface AgentInfoMapper {

    @Select("SELECT * FROM city_agent WHERE agentMobile=#{mobile}")
    AgentInfo findByMobile(@Param("mobile") String mobile);


}
