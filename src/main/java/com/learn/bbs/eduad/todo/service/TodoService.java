package com.learn.bbs.eduad.todo.service;



import com.learn.bbs.eduad.todo.vo.TodoDeleteRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoFileVO;
import com.learn.bbs.eduad.todo.vo.TodoListVO;
import com.learn.bbs.eduad.todo.vo.TodoUpdateRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoWriteRequestVO;

public interface TodoService {
	
		// 오늘의 모든 투두 조회 
		// 강사 대시보드 = 강의 계획서 + 강사 직접 추가한 투두
		public TodoListVO getAllMyTodo(String lgnId);
		
		// 강좌에 올라갈 학습목표이자 강사의 모든 강좌 투두를 추가
		public boolean createNewTodoByFile(TodoFileVO todoFileVO);
		
		// 투두 추가
		public boolean createNewTodo(TodoWriteRequestVO todoWriteRequestVO);
		
		// 투두 삭제
		public boolean deleteOneTodo(TodoDeleteRequestVO todoDeleteRequestVO);
		
		// 투두 수정
		public boolean updateOneTodo(TodoUpdateRequestVO todoUpdateRequestVO);

}