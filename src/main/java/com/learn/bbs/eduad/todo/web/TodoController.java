package com.learn.bbs.eduad.todo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.learn.bbs.eduad.todo.service.TodoService;
import com.learn.bbs.eduad.todo.vo.TodoDeleteRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoFileVO;
import com.learn.bbs.eduad.todo.vo.TodoListVO;
import com.learn.bbs.eduad.todo.vo.TodoUpdateRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoVO;
import com.learn.bbs.eduad.todo.vo.TodoWriteRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.common.vo.AjaxResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;


	// 강사 마이페이지 대시보드 - AJAX로 투두 영역만 변경되어 보이기
	// 오늘의 모든 투두 조회, 수정, 삭제
	@ResponseBody
	@GetMapping("/eduad/todo/ajax/list/{lgnId}")
	public AjaxResponse viewInstrTodoList(@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO, TodoVO todoVO) {
		// 강사 대시보드 = 강의 계획서 + 강사 직접 추가한 투두를 읽어온다.
		// 강좌 마다 가진 학습 계획서의 오늘 학습 목표를 읽어온다.
		
// TODO 세션에서 강사 아이디를 가져온다.
//		InstrVO instrVO = (InStrVO) session.getAttribute("__LOGIN_USER__");
//		TodoListVO todoListVO = this.todoService.getAllMyTodo(instrVO.getInstrMl());
		
		String instrId = instrVO.getInstrLgnId();
		todoVO.setLgnId(instrId);

		// 투두 정보를 불러온다.
		TodoListVO todoListVO = this.todoService.getAllMyTodo(todoVO.getLgnId());
		// 투두 리스트와 정보를 Ajax로 반환한다.
		return new AjaxResponse(todoListVO);
	}

	// 투두 등록
	@ResponseBody
	@PostMapping("/eduad/todo/write")
	public AjaxResponse doTodoWrite(@Valid @ModelAttribute TodoFileVO todoFileVO,
			BindingResult bindingResult, HttpSession session,
			@RequestParam(value = "file", required = false) MultipartFile file, 
			@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO) {
		
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			Map<String, String> errorMap = new HashMap<>();
			for (ObjectError error : allErrors) {
				String message = error.getDefaultMessage();
				String fieldName = "";

				if (error instanceof FieldError fieldError) {
					fieldName = fieldError.getField();
				}

				errorMap.put(fieldName, message);
			}
			return new AjaxResponse(HttpStatus.BAD_REQUEST.value(), errorMap);
		}

		todoFileVO.setLgnId(instrVO.getInstrLgnId());
		todoFileVO.setArtcId("ARTC_ID");
		todoFileVO.setCrsInfId("CRS_INF-20250425-000008");
		todoFileVO.setFile(file);
		boolean isCreate = this.todoService.createNewTodoByFile(todoFileVO);
		return new AjaxResponse(HttpStatus.OK.value(), isCreate);
	}

	// 투두 하나 삭제
	@ResponseBody
	@GetMapping("/eduad/todo/delete/{todoId}")
	public AjaxResponse deleteOneTodo(@PathVariable String todoId) {

		// 삭제할 투두 생성
		TodoDeleteRequestVO todoDeleteRequestVO = new TodoDeleteRequestVO();
		// TODO 세션에서 사용자 정보 설정 (임시로 하드코딩)
		todoDeleteRequestVO.setLgnId("장유진@learnual.com");
		// 삭제될 투두 아이디 지정
		todoDeleteRequestVO.setTodoId(todoId);
		// TODO 삭제될 강의 계획서 지정
		todoDeleteRequestVO.setFile(null);

		boolean isDelete = this.todoService.deleteOneTodo(todoDeleteRequestVO);
		return new AjaxResponse(HttpStatus.OK.value(), isDelete);
	}

	// 투두 수정 => 강의 계획서 수정은 안됨(파일은 삭제해야된다.)
	@ResponseBody
	@PostMapping("/eduad/todo/update/{todoId}")
	public AjaxResponse updateOneTodo(@PathVariable String todoId, TodoUpdateRequestVO todoUpdateRequestVO) {

		todoUpdateRequestVO.setTodoId(todoId);
		boolean isUpdate = this.todoService.updateOneTodo(todoUpdateRequestVO);
		return new AjaxResponse(HttpStatus.OK.value(), isUpdate);
	}

}