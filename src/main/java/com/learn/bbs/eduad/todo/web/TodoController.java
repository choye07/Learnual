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

	// 다른 페이지와 합쳐질 거 생각해서 임시 리스트 만들기
//	@GetMapping("/eduad/{insttnId}/dashboard")
//	public String viewTodoList(Model model, HttpSession session) {
//		// 아직 모든 세션이 안합쳐졌다. 임시 URL로 일반 Controller를 구성한다.
//		// 대신 Ajax를 사용할 메소드에는 @ResponseBody를 붙여 json응답을 받도록 한다.
//		String lgnId = (String) session.getAttribute("INSTR_ID"); // 세션에서 가져오기
//		if (lgnId == null) {
//			lgnId = "장유진@learnual.com"; // 테스트용 디폴트
//		}
//		// 투두리스트를 읽어온다.
//		TodoListVO todoListVO = this.todoService.getAllMyTodo(lgnId);
//		model.addAttribute("todoList", todoListVO);
//
//		return "dashboard/dashboardeduad";
//	}

	// 강사 마이페이지 대시보드 - AJAX로 투두 영역만 변경되어 보이기
	// 오늘의 모든 투두 조회, 수정, 삭제
	// TODO 강사 마이페이지 대시보드에서 수정하니깐 URL 수정하기
	@ResponseBody
	@GetMapping("/eduad/todo/ajax/list/{lgnId}")
	public AjaxResponse viewInstrTodoList(@SessionAttribute("__LOGIN_INSTR__") InstrVO instrVO, TodoVO todoVO) {
		// 강사 대시보드 = 강의 계획서 + 강사 직접 추가한 투두를 읽어온다.
		// 강좌 마다 가진 학습 계획서의 오늘 학습 목표를 읽어온다.
// TODO 세션에서 강사 아이디를 가져온다.
//		InstrVO instrVO = (InStrVO) session.getAttribute("__LOGIN_USER__");
//		TodoListVO todoListVO = this.todoService.getAllMyTodo(instrVO.getInstrMl());
		// 임시 세션 테스트 아이디(이메일)
		
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
	public AjaxResponse doTodoWrite(@Valid @ModelAttribute TodoWriteRequestVO todoWriteRequestVO,
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

		todoWriteRequestVO.setLgnId(instrVO.getInstrLgnId());
		todoWriteRequestVO.setArtcId("ARTC_ID");
		todoWriteRequestVO.setCrsInfId("CRS_INF-20250425-000008");
		todoWriteRequestVO.setFile(file);
		boolean isCreate = this.todoService.createNewTodoByFile(todoWriteRequestVO);
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

	// TODO 강좌 게시판 - 오늘의 학습 목표가 대시보드로 조회된다.
	// TODO 나중엔 강좌 페이지에서 보일 거니깐 URL, 뷰네임 수정하기
//	@GetMapping("/eduad/todo/list/{lgnId}")
//	public String viewCrsTodoList(@SessionAttribute("__LOGIN_USER__") InstrVO instrVO, Model model, TodoVO todoVO) {
//
//		// 강좌 마다 가진 학습 계획서의 오늘 학습 목표를 읽어온다.
//		TodoListVO todoListVO = this.todoService.getAllMyTodo(instrVO.getInstrMl());
//		model.addAttribute("todoList", todoListVO);
//		return "dashboard/dashboardeduad";
//	}

//	@PostMapping("/eduad/todo/crstodolist/{crsInfId}")
//	public String doCrsTodoWrite(@PathVariable String crsInfId,
//			@Valid @ModelAttribute TodoWriteRequestVO todoWriteRequestVO, Model model) {
//
//		// 강좌 마다 가진 학습 계획서의 오늘 학습 목표를 읽어온다.
//		boolean isCreated = this.todoService.createOneTodoByFile(todoVO.getCrsInfId(), todoVO.getFile());
//
//		// 다시 목록 불러오기 (업로드 성공/실패 관계 없이)
//		List<TodoVO> todoList = this.todoService.createNewTodoByFile(crsInfId);
//		model.addAttribute("todoList", todoList);
//		model.addAttribute("uploadResult", isCreated ? "완료" : "실패");
//
//		return "bbs/eduad/todo/crstodolist";
//	}

}