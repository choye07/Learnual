package com.learn.bbs.eduad.todo.vo;

public class TodoUpdateRequestVO {

	// 투두 고유한 아이디
	private String todoId;
	
	// 투두 수행 완료 여부 (Y/N)
	private String todoFinishYn;

	public String getTodoId() {
		return todoId;
	}
	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}

	public String getTodoFinishYn() {
		return todoFinishYn;
	}
	public void setTodoFinishYn(String todoFinishYn) {
		this.todoFinishYn = todoFinishYn;
	}
}
