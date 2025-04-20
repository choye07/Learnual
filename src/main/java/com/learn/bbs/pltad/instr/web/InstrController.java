package com.learn.bbs.pltad.instr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.bbs.pltad.instr.service.InstrService;
import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;

import jakarta.validation.Valid;


/**
 * @TableName INSTR
 * @TableComment null
 * 강사
 */
@Controller
public class InstrController {

    @Autowired
    private InstrService instrService;
    
    @PostMapping("pltad/instrmanage/regist")
    public String doInstrRegist(@Valid 
			@ModelAttribute  InstrRegistRequestVO instrRegistRequestVO,
			BindingResult bindingResult,
			Model model) {
    	
    	instrRegistRequestVO.setLgnId("admin");
    	
		boolean isCreated = this.instrService.createInstr(instrRegistRequestVO);
		
		if (isCreated) {
			return "/success";
		}

    	return"/fail";
    }
    

}