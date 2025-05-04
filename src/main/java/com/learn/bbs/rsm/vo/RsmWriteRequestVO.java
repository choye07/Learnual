package com.learn.bbs.rsm.vo;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public class RsmWriteRequestVO {

	// 이력서 아이디
	private String rsmId;

	@NotEmpty(message = "제목은 필수 입력값입니다.")
	private String rsmTtl;

	// 회원 세션 아이디 = usrMl;
	private String usrId;

	// 게시판 아이디
	private String artcId;

	// 이력서 첨부파일
	private MultipartFile file;

	// 학원 아이디
	private String InsttnId;

	public String getInsttnId() {
		return InsttnId;
	}

	public void setInsttnId(String insttnId) {
		InsttnId = insttnId;
	}

	public String getRsmId() {
		return rsmId;
	}

	public void setRsmId(String rsmId) {
		this.rsmId = rsmId;
	}

	public String getRsmTtl() {
		return rsmTtl;
	}

	public void setRsmTtl(String rsmTtl) {
		this.rsmTtl = rsmTtl;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
