package com.learn.bbs.tst.vo;

public class CreateTstRequestVO extends TstCommonVO {

	private String tstTtl;
	private String tstCtt;
	private String tstExamDt;
	/**
	 * @ColumnName TST_RSPNS_PTH
	 * @ColumnType VARCHAR2(2083)
	 * @ColumnComment 응답 구글 폼 경로 (URL)
	 */
	private String tstRspnsPth;

	/**
	 * @ColumnName TST_EDT_PTH
	 * @ColumnType VARCHAR2(2083)
	 * @ColumnComment 편집 구글 폼 경로 (URL)
	 */
	private String tstEdtPth;

	public String getTstTtl() {
		return tstTtl;
	}

	public void setTstTtl(String tstTtl) {
		this.tstTtl = tstTtl;
	}

	public String getTstCtt() {
		return tstCtt;
	}

	public void setTstCtt(String tstCtt) {
		this.tstCtt = tstCtt;
	}

	public String getTstExamDt() {
		return tstExamDt;
	}

	public void setTstExamDt(String tstExamDt) {
		this.tstExamDt = tstExamDt;
	}

	public String getTstRspnsPth() {
		return tstRspnsPth;
	}

	public void setTstRspnsPth(String tstRspnsPth) {
		this.tstRspnsPth = tstRspnsPth;
	}

	public String getTstEdtPth() {
		return tstEdtPth;
	}

	public void setTstEdtPth(String tstEdtPth) {
		this.tstEdtPth = tstEdtPth;
	}

}
