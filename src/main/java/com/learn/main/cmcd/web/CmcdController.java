package com.learn.main.cmcd.web;

import org.springframework.stereotype.Controller;

import com.learn.main.cmcd.service.CmcdService;

import org.springframework.beans.factory.annotation.Autowired;



/**
 * @TableName CM_CODE
 * @TableComment null
 * 공통 코드
 */
@Controller
public class CmcdController {

    @Autowired
    private CmcdService cmcdService;

}