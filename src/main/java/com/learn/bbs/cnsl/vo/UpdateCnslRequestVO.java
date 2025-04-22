package com.learn.bbs.cnsl.vo;

public class UpdateCnslRequestVO extends CnslCommonVO {

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

	private String cnslCnclDt;
	private String cnslCnclYn;
	private String cnslInstrCnclCtt;
	private String cnslUsrCnclCtt;

	private String cnslAnswer;

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

	public String getCnslCnclDt() {
		return cnslCnclDt;
	}

	public void setCnslCnclDt(String cnslCnclDt) {
		this.cnslCnclDt = cnslCnclDt;
	}

	public String getCnslCnclYn() {
		return cnslCnclYn;
	}

	public void setCnslCnclYn(String cnslCnclYn) {
		this.cnslCnclYn = cnslCnclYn;
	}

	public String getCnslInstrCnclCtt() {
		return cnslInstrCnclCtt;
	}

	public void setCnslInstrCnclCtt(String cnslInstrCnclCtt) {
		this.cnslInstrCnclCtt = cnslInstrCnclCtt;
	}

	public String getCnslUsrCnclCtt() {
		return cnslUsrCnclCtt;
	}

	public void setCnslUsrCnclCtt(String cnslUsrCnclCtt) {
		this.cnslUsrCnclCtt = cnslUsrCnclCtt;
	}

	public String getCnslAnswer() {
		return cnslAnswer;
	}

	public void setCnslAnswer(String cnslAnswer) {
		this.cnslAnswer = cnslAnswer;
	}

	public String getInstrId() {
		return instrId;
	}

	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}

}
