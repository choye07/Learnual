package com.learn.bbs.eduad.todo.vo;

import com.learn.bbs.file.vo.FlVO;

public class TodoDeleteRequestVO {

	private String todoId;

	private String lgnId;

	// 삭제할 이력서 첨부파일
	private FlVO file;

	public String getTodoId() {
		return todoId;
	}

	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}

	public String getLgnId() {
		return lgnId;
	}

	public void setLgnId(String lgnId) {
		this.lgnId = lgnId;
	}

	public FlVO getFile() {
		return file;
	}

	public void setFile(FlVO file) {
		this.file = file;
	}
	
}
