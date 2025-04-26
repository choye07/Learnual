package com.learn.insttn.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.common.vo.AjaxResponse;
import com.learn.insttn.service.InsttnService;
import com.learn.insttn.vo.InsttnRegistRequestVO;
import com.learn.insttn.vo.InsttnSearchRequestVO;
import com.learn.insttn.vo.InsttnVO;

import jakarta.validation.Valid;

@Controller
public class InsttnController {
	private static final Logger LOGGER = LoggerFactory.getLogger(InsttnController.class);
	@Autowired
	private InsttnService insttnService;

	@PostMapping("/insttn/create")
	public String doInsttnRegist(@Valid @ModelAttribute InsttnRegistRequestVO insttnRegistRequestVO,
			BindingResult bindingResult, Model model) {

		// TO-DO 회원 등록을 하기 전 Super 관리자인지 체크

		// TO-DO 회원 유효성 검사에서 error 발견 시 어떻게 할건지.
		boolean isCreated = this.insttnService.createNewInsttn(insttnRegistRequestVO);

		if (isCreated) {
			return "redirect:/2";
		}

		return "/";

	}
}
