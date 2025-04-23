package com.learn.bbs.crs.sbj.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.learn.bbs.crs.sbj.service.SbjService;
import com.learn.bbs.crs.sbj.vo.SbjVO;


/**
 * @author 최예진
 * 과목 
 */
@Controller
public class SbjController {

    @Autowired
    private SbjService sbjService;

}