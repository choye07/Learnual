package com.learn.bbs.eduad.flarch.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.learn.bbs.file.vo.FlVO;

import jakarta.validation.constraints.NotEmpty;

public class FlArchUpdateRequestVO {

	@NotEmpty(message = "제목은 필수 입력값입니다.")
	private String flArchTtl;

	@NotEmpty(message = "내용은 필수 입력값입니다.")
	private String flArchCtt;

	private String flArchId;

	// 새로 첨부된 파일 등록을 위해 MultipartFile 타입을 사용한다.
	private List<MultipartFile> flList;

	// 삭제할 기존 파일 ID - 유지할 파일을 서버에게 알려주기 위해 필요함
	private List<String> deleteFileIds;

	// 게시판 아이디
	private String artcId;
	// 학원 아이디
	private String insttnId;
	// 강좌 아이디
	private String crsInfId;
	// 로그인 아이디 (학생, 강사 로그인 아이디)
	private String lgnId;

	
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

	public List<String> getDeleteFileIds() {
		return deleteFileIds;
	}

	public void setDeleteFileIds(List<String> deleteFileIds) {
		this.deleteFileIds = deleteFileIds;
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