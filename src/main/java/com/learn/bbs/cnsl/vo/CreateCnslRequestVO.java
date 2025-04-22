package com.learn.bbs.cnsl.vo;

public class CreateCnslRequestVO extends CnslCommonVO {

	/**
	 * @ColumnName CNSL_TTL
	 * @ColumnType VARCHAR2(100)
	 * @ColumnComment 상담 게시글의 제목
	 */
	private String cnslTtl;

	/**
	 * @ColumnName CNSL_CTT
	 * @ColumnType VARCHAR2(4000)
	 * @ColumnComment 상담 게시글의 내용
	 */
	private String cnslCtt;

	/**
	 * @ColumnName INSTR_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 강좌 정보를 구분할 고유한 문자열(CRS_INF-YYYYMMDD-NNNNNN)
	 */
	private String instrId;

	public String getCnslTtl() {
		return cnslTtl;
	}

	public void setCnslTtl(String cnslTtl) {
		this.cnslTtl = cnslTtl;
	}

	public String getCnslCtt() {
		return cnslCtt;
	}

	public void setCnslCtt(String cnslCtt) {
		this.cnslCtt = cnslCtt;
	}

	public String getInstrId() {
		return instrId;
	}

	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}

}
