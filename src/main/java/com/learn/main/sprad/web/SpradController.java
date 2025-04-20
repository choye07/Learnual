package com.learn.main.sprad.web;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.main.sprad.service.SpradService;

@Controller
public class SpradController {

    @Autowired
    private SpradService spradService;

}