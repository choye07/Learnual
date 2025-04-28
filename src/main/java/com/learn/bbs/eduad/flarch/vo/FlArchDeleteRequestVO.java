package com.learn.bbs.eduad.flarch.vo;

import java.util.List;

import com.learn.bbs.file.vo.FlVO;

public class FlArchDeleteRequestVO {

	// 게시글 아이디
	private String flArchId;
	// 삭제할 파일
	private List<FlVO> flList;

	// 게시판 아이디
	private String artcId;
	// 학원 아이디
	private String insttnId;
	// 강좌 아이디
	private String crsInfId;
	// 로그인 아이디 (학생, 강사 로그인 아이디)
	private String lgnId;

	public String getFlArchId() {
		return flArchId;
	}

	public void setFlArchId(String flArchId) {
		this.flArchId = flArchId;
	}

	public List<FlVO> getFlList() {
		return flList;
	}

	public void setFlList(List<FlVO> flList) {
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
