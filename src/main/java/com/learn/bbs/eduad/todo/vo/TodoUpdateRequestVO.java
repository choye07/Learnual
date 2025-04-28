package com.learn.bbs.eduad.todo.vo;

import jakarta.validation.constraints.NotEmpty;

public class TodoUpdateRequestVO {

	// 투두 고유한 아이디
	private String todoId;
	
	// 투두 내용
	@NotEmpty(message = "내용은 필수 입력값입니다.")
	private String todoCtt;
	
	// 투두 수행 완료 여부 (Y/N)
	private String todoFinishYn;

	public String getTodoId() {
		return todoId;
	}
	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}
	public String getTodoCtt() {
		return todoCtt;
	}
	public void setTodoCtt(String todoCtt) {
		this.todoCtt = todoCtt;
	}
	public String getTodoFinishYn() {
		return todoFinishYn;
	}
	public void setTodoFinishYn(String todoFinishYn) {
		this.todoFinishYn = todoFinishYn;
	}
}
