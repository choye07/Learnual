package com.learn.bbs.eduad.flarch.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public class FlArchWriteRequestVO {

	@NotEmpty(message = "제목은 필수 입력값입니다.")
	private String flArchTtl;

	@NotEmpty(message = "내용은 필수 입력값입니다.")
	private String flArchCtt;

	// 게시글 아이디
	private String flArchId;
	
	// 게시판 아이디
	private String artcId;
	// 학원 아이디
	private String insttnId;
	// 강좌 아이디
	private String crsInfId;
	// 로그인 아이디 (학생, 강사 로그인 아이디)
	private String lgnId;


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

	public String getInsttnId() {
		return insttnId;
	}

	public void setInsttnId(String insttnId) {
		this.insttnId = insttnId;
	}

	public String getCrsInfId() {
		return crsInfId;
	}

	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}

	public String getLgnId() {
		return lgnId;
	}

	public void setLgnId(String lgnId) {
		this.lgnId = lgnId;
	}
	
}
