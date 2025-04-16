package com.learn.bbs.tst.web;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.tst.service.TstService;


/**
 * @author 최예진
 * 시험
 */
@Controller
public class TstController {

    @Autowired
    private TstService tstService;

}