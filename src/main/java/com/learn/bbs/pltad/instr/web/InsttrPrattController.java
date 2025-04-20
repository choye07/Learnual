package com.learn.bbs.pltad.instr.web;

import org.springframework.stereotype.Controller;

import com.learn.bbs.pltad.instr.service.InstrPrattService;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @TableName PRATT
 * @TableComment null
 * 강사 이력
 */
@Controller
public class InsttrPrattController {

    @Autowired
    private InstrPrattService prattService;

}