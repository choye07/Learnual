package com.learn.insttn.web;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.insttn.service.InsttnService;


/**
 * @TableName MENU
 * @TableComment null
 * 학원 메뉴
 */
@Controller
public class InsttnController {

    @Autowired
    private InsttnService insttnService;

}