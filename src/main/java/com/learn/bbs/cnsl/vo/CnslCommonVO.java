package com.learn.bbs.cnsl.vo;

public class CnslCommonVO {

	/**
	 * @ColumnName CNSL_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 상담 게시글의 고유한 아이디(CNSL-YYYYMMDD-NNNNNN)
	 */
	private String cnslId;

	/**
	 * @ColumnName INSTR_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 강좌 정보를 구분할 고유한 문자열(CRS_INF-YYYYMMDD-NNNNNN)
	 */
	private String instrId;

	private String usrId;
	private String crsInfId;
	private String artcId;
	private String sbjId;

	/**
	 * usr, eduad, pltad, super
	 */
	private String requesterType;

	public String getCnslId() {
		return cnslId;
	}

	public void setCnslId(String cnslId) {
		this.cnslId = cnslId;
	}

	public String getInstrId() {
		return instrId;
	}

	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
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

	public String getSbjId() {
		return sbjId;
	}

	public void setSbjId(String sbjId) {
		this.sbjId = sbjId;
	}

	public String getRequesterType() {
		return requesterType;
	}

	public void setRequesterType(String requesterType) {
		this.requesterType = requesterType;
	}

}
