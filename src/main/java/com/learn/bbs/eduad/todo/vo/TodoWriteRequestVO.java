package com.learn.bbs.eduad.todo.vo;

import jakarta.validation.constraints.NotEmpty;

public class TodoWriteRequestVO {

    private String todoId;

    @NotEmpty(message = "내용은 필수 입력값입니다.")
    private String todoCtt;

    private String lgnId;

    private String crsInfId;
    
    private String artcId;
    
    
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

	public String getLgnId() {
		return lgnId;
	}

	public void setLgnId(String lgnId) {
		this.lgnId = lgnId;
	}

	public String getCrsInfId() {
		return crsInfId;
	}

	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}

	public String getArtcId() {
		return artcId;
	}

	public void setArtcId(String artcId) {
		this.artcId = artcId;
	}

}