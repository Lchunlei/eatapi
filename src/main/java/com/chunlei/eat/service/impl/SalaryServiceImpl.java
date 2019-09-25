package com.chunlei.eat.service.impl;

import com.chunlei.eat.mapper.VipPayMapper;
import com.chunlei.eat.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Created by lcl on 2019/9/20 0020
 */
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private VipPayMapper vipPayMapper;

    @Override
    public void autoWorkSalary() {

    }



}
