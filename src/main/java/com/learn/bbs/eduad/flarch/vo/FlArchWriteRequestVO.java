package com.learn.bbs.eduad.flarch.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public class FlArchWriteRequestVO {
	
	@NotEmpty(message = "제목은 필수 입력값입니다.")
	private String flArchTtl;

	@NotEmpty(message = "내용은 필수 입력값입니다.")
	private String flArchCtt;

	// 강사 아이디
	private String instrId;

	// 게시글 아이디
	private String flArchId;
	
	// 게시판 아이디
    private String artcId;
	
	// 첨부파일이 여러개인 경우 List이다.
	private List<MultipartFile> flList;

	
	public String getFlArchTtl() {
		return flArchTtl;
	}

	public void setFlArchTtl(String flArchTtl) {
		this.flArchTtl = flArchTtl;
	}

	public String getFlArchCtt() {
		return flArchCtt;
	}

	public void setFlArchCtt(String flArchCtt) {
		this.flArchCtt = flArchCtt;
	}
	
	public String getInstrId() {
		return instrId;
	}

	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}


	public String getFlArchId() {
		return flArchId;
	}

	public void setFlArchId(String flArchId) {
		this.flArchId = flArchId;
	}

	public List<MultipartFile> getFlList() {
		return flList;
	}

	public void setFlList(List<MultipartFile> flList) {
		this.flList = flList;
	}

	public String getArtcId() {
		return artcId;
	}

	public void setArtcId(String artcId) {
		this.artcId = artcId;
	}
	

}
