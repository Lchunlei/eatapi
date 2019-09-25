package com.chunlei.eat.mapper;

import com.chunlei.eat.entity.AgentIncome;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @Created by lcl on 2019/9/20 0020
 */
@Repository
public interface AgentIncomeMapper {

    @Insert("INSERT INTO city_agent_income(`incomeTotal`,`agId`,`moneyAcc`,`inType`,`cTime`) VALUES (#{incomeTotal},#{agId},#{moneyAcc},#{inType},NOW())")
    int insertOne(AgentIncome agentIncome);

}
