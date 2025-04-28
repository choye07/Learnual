package com.learn.bbs.eduad.todo.vo;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public class TodoWriteRequestVO {

    private String todoId;

    private String todoCtt;

    private String lgnId;

    private String crsInfId;
    
    private String artcId;
    
    // 업로드한 강의 계획서 파일
    private MultipartFile file;
    

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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}


}
