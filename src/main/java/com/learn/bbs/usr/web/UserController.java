package com.learn.bbs.usr.web;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.usr.service.UsrService;



/**
 * @author 최예진
 * 사용자
 */
@Controller
public class UserController {

    @Autowired
    private UsrService usrService;

}