package com.learn.bbs.pltad.instr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.pltad.instr.dao.InstrPrattDao;
import com.learn.bbs.pltad.instr.service.InstrPrattService;


/**
 * @TableName PRATT
 * @TableComment null
 * 강사 이력
 */
@Service
public class InstrPrattServiceImpl implements InstrPrattService {

    @Autowired
    private InstrPrattDao instrPrattDao;

}