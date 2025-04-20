package com.learn.bbs.asgmt.web;

import org.springframework.stereotype.Controller;

import com.learn.bbs.asgmt.service.AsgmtArtcService;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author 최예진
 * 과제 게시판
 */
@Controller
public class AsgmtArtcController {

    @Autowired
    private AsgmtArtcService asgmtArtcService;

}