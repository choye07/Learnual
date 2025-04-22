package com.learn.bbs.asgmt.vo;

public class UpdateAsgmtArtcRequestVO extends AsgmtArtcCommonVO {

	/**
	 * @ColumnName ASGMT_ARTC_TTL
	 * @ColumnType VARCHAR2(100)
	 * @ColumnComment 과제 게시판 게시글 제목
	 */
	private String asgmtArtcTtl;

	/**
	 * @ColumnName ASGMT_ARTC_CTT
	 * @ColumnType VARCHAR2(4000)
	 * @ColumnComment 과제 게시판 게시글의 내용
	 */
	private String asgmtArtcCtt;

	private String asgmtArtcStat;

	private String asgmtArtcSrtDt;

	/**
	 * @ColumnName ASGMT_ARTC_DDLN_DT
	 * @ColumnType DATE
	 * @ColumnComment 과제를 제출해야하는 마감 날짜
	 */
	private String asgmtArtcDdlnDt;

	public String getAsgmtArtcTtl() {
		return asgmtArtcTtl;
	}

	public void setAsgmtArtcTtl(String asgmtArtcTtl) {
		this.asgmtArtcTtl = asgmtArtcTtl;
	}

	public String getAsgmtArtcCtt() {
		return asgmtArtcCtt;
	}

	public void setAsgmtArtcCtt(String asgmtArtcCtt) {
		this.asgmtArtcCtt = asgmtArtcCtt;
	}

	public String getAsgmtArtcStat() {
		return asgmtArtcStat;
	}

	public void setAsgmtArtcStat(String asgmtArtcStat) {
		this.asgmtArtcStat = asgmtArtcStat;
	}

	public String getAsgmtArtcSrtDt() {
		return asgmtArtcSrtDt;
	}

	public void setAsgmtArtcSrtDt(String asgmtArtcSrtDt) {
		this.asgmtArtcSrtDt = asgmtArtcSrtDt;
	}

	public String getAsgmtArtcDdlnDt() {
		return asgmtArtcDdlnDt;
	}

	public void setAsgmtArtcDdlnDt(String asgmtArtcDdlnDt) {
		this.asgmtArtcDdlnDt = asgmtArtcDdlnDt;
	}

}
