package com.learn.bbs.pltad.web;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.pltad.service.PltAdService;

@Controller
public class PltAdController {

    @Autowired
    private PltAdService pltAdService;

}