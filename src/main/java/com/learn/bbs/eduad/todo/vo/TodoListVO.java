package com.learn.bbs.eduad.todo.vo;

import java.util.List;

public class TodoListVO {
	
	// 투두 개수 
	private int todoCnt;
	
	// 투두 목록
	private List<TodoVO> todoList;

	public int getTodoCnt() {
		return todoCnt;
	}

	public void setTodoCnt(int todoCnt) {
		this.todoCnt = todoCnt;
	}

	public List<TodoVO> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<TodoVO> todoList) {
		this.todoList = todoList;
	}
	
}
