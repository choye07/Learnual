package com.learn.bbs.artc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.learn.bbs.artc.service.ArtcAccService;


/**
 * @TableName ARTC_ACC
 * @TableComment null
 * 게시판 권한
 */
@Controller
public class ArtcAccController {

    @Autowired
    private ArtcAccService artcAccService;

}