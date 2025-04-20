package com.learn.bbs.pltad.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.pltad.service.PltAdService;
import com.learn.bbs.pltad.vo.PltadRegistRequestVO;

import jakarta.validation.Valid;

@Controller
public class PltAdController {

    @Autowired
    private PltAdService pltAdService;
    
    @PostMapping("/spr/pltadmanage/regist")
    public String doPltadRegist(@Valid 
								@ModelAttribute 
								PltadRegistRequestVO pltadRegistRequestVO,
								BindingResult bindingResult,
								Model model) {
    	
    	pltadRegistRequestVO.setLgnId("sadmin");
    	
		boolean isCreated = this.pltAdService.createNewPltad(pltadRegistRequestVO);
		if (isCreated) {
			return "/pltadmanage/list";
		}

    	
		return "/pltadmanage/regist";
    	
    }
}