package com.learn.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.learn.bbs.usr.vo.UsrRegistRequestVO;


@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(UsrLoginException.class)
	public String viewMemberLogingExceptionPage(UsrLoginException ule, Model model) {

		LOGGER.debug(ule.getMessage());
		model.addAttribute("userInput", ule.getUsrLoginRequestVO());
		model.addAttribute("errorMessage", ule.getMessage());
		return "main/mainlogin";
	}

	@ExceptionHandler(UsrRegistException.class)
	public String viewMemberRegistExceptionPage(UsrRegistRequestVO usrRegistRequestVO, UsrRegistException ure,
			Model model) {
		LOGGER.debug(ure.getMessage());
		model.addAttribute("emailErrorMessage", ure.getMessage());
		model.addAttribute("userInputRegist", ure.getUsrRegistRequestVO());
		return "main/mainregist";

	}

	@ExceptionHandler(PageNotFoundException.class)
	public String viewPageNotFoundExceptionPage(PageNotFoundException pnfe, Model model) {
		LOGGER.debug(pnfe.getMessage());
		model.addAttribute("cause", pnfe.getMessage());

		return "error/404";
	}

	@ExceptionHandler(NotExistsException.class)
	public String viewNotExistsExceptionpage(NotExistsException nee, Model model) {
		LOGGER.debug(nee.getMessage());
		model.addAttribute("cause", nee.getMessage());

		return "error/404";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String viewNoHandlerFoundExceptionPage(NoHandlerFoundException ngfe) {
		return "error/404";
	}
	
	@ExceptionHandler(CrsInfRegistException.class)
	public String viewCrsInfRegistExcpetionPage(CrsInfRegistException cire) {
		return "error/404";
	}
	
	@ExceptionHandler(CrsSbjRegistException.class)
	public String viewCrsSbjRegistExceptionPage(CrsSbjRegistException csre) {
		return "error/404";
	}
	
	@ExceptionHandler(CrsInfUpdateException.class)
	public String viewCrsInfUpdateExceptionPage(CrsInfUpdateException ciue) {
		return "error/404";
	}
	
	@ExceptionHandler(CrsSbjDeleteException.class)
	public String viewCrsSbjDeleteExceptionPage(CrsSbjDeleteException csde) {
		return "error/404";
	}
	
	@ExceptionHandler(CrsInfDeleteException.class)
	public String viewCrsInfDeleteExceptionPage(CrsInfDeleteException cide) {
		return "error/404";
	}
	
	//항상 끝에 있어야한다.
	//제일 위에 있어버리면 모든 exception을 다 먹어버리기 때문에 항상 무조건 맨 끝에 적어줘야한다.
	@ExceptionHandler(RuntimeException.class)
	public String viewOtherExceptionPage(RuntimeException re) {
		LOGGER.debug(re.getMessage());
		
		return "error/500";
	}
	

}
