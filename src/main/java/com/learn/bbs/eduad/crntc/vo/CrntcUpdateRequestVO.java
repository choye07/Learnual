package com.learn.bbs.eduad.crntc.vo;

import jakarta.validation.constraints.NotEmpty;

public class CrntcUpdateRequestVO {
	private String crntcId; // CRNTC_ID, 강좌 공지사항 게시글의 고유한 아이디

	@NotEmpty(message = "제목은 필수 입력값입니다.")
	private String crntcTtl; // CRNTC_TTL, 강좌 공지사항 게시글의 제목

	@NotEmpty(message = "내용은 필수 입력값입니다.")
	private String crntcCtt; // CRNTC_CTT, 강좌 공지사항 게시글의 내용

	private String crntcPinnedYn; // CRNTC_PINNED_YN, 강좌 공지사항 게시글 상단 고정 여부

    private String crntcUpdtDt; // CRNTC_UPDT_DT, 강좌 공지사항 게시글 수정 날짜

	private String artcId; // ARTC_ID, 게시판의 고유한 아이디

	private String crsInfId; // CRS_INF_ID, 강좌 정보의 고유한 아이디

	private String sbjId2; // SBJ_ID2, 과목을 구별하는 고유한 번호

	private String instrId; // INSTR_ID, 강사의 고유한 아이디

	public String getCrntcId() {
		return crntcId;
	}

	public void setCrntcId(String crntcId) {
		this.crntcId = crntcId;
	}

	public String getCrntcTtl() {
		return crntcTtl;
	}

	public void setCrntcTtl(String crntcTtl) {
		this.crntcTtl = crntcTtl;
	}

	public String getCrntcCtt() {
		return crntcCtt;
	}

	public void setCrntcCtt(String crntcCtt) {
		this.crntcCtt = crntcCtt;
	}

	public String getCrntcPinnedYn() {
		return crntcPinnedYn;
	}

	public void setCrntcPinnedYn(String crntcPinnedYn) {
		this.crntcPinnedYn = crntcPinnedYn;
	}

	public String getCrntcUpdtDt() {
		return crntcUpdtDt;
	}

	public void setCrntcUpdtDt(String crntcUpdtDt) {
		this.crntcUpdtDt = crntcUpdtDt;
	}

	public String getArtcId() {
		return artcId;
	}

	public void setArtcId(String artcId) {
		this.artcId = artcId;
	}

	public String getCrsInfId() {
		return crsInfId;
	}

	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}

	public String getSbjId2() {
		return sbjId2;
	}

	public void setSbjId2(String sbjId2) {
		this.sbjId2 = sbjId2;
	}

	public String getInstrId() {
		return instrId;
	}

	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}
	
}
