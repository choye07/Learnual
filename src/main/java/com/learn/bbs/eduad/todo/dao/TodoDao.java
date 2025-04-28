package com.learn.bbs.eduad.todo.dao;

import java.util.List;

import com.learn.bbs.eduad.todo.vo.TodoDeleteRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoUpdateRequestVO;
import com.learn.bbs.eduad.todo.vo.TodoVO;
import com.learn.bbs.eduad.todo.vo.TodoWriteRequestVO;

public interface TodoDao {
	
	// 오늘의 할일 개수
	public int selectAllCountTodo(String lgnId);
	
	// 강사 대시보드: 오늘의 모든 투두 조회 
	// 강의 계획서 + 강사 직접 추가한 투두
	public List<TodoVO> selectMyAllTodo(String lgnId);
	
	// 한 강좌의 학습 목표 투두
	public List<TodoVO> selectAllTodo(String lgnId);
	
	// 투두 추가
	public int insertNewTodo(TodoWriteRequestVO todoWriteRequestVO);
	
	// 투두 삭제
	public int deleteOneTodo(TodoDeleteRequestVO todoDeleteRequestVO);
	
	// 투두 수정
	public int updateOneTodo(TodoUpdateRequestVO todoUpdateRequestVO);
	
}