package com.learn.main.sprad.vo;

public class SpradRegistRequestVO extends SpradmVO{
	/**
     * @ColumnName INSTTN_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 기관(학원) 정보의 고유한 아이디(INSTTN-YYYYMMDD-NNNNNN)
     */
    private String insttnId;

    /**
     * @ColumnName CMCD_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 코드를 구별하는 고유한 번호(CM-YYYYMMDD-NNNNNN)
     */
    private String cmcdId;
	
    /**
     * @ColumnName SPRADM_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 슈퍼 관리자의 고유한 아이디(SPR-YYYYMMDD-NNNNNN)
     */
    private String spradmId;

    /**
     * @ColumnName SPRADM_LGN_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 슈퍼 관리자 계정의 아이디
     */
    private String spradmLgnId;

    /**
     * @ColumnName SPRADM_LGN_PW
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 슈퍼 관리자 계정의 비밀번호
     */
    private String spradmLgnPw;

    /**
     * @ColumnName SPRADM_LGN_SLT
     * @ColumnType VARCHAR2(32)
     * @ColumnComment 슈퍼 관리자의 비밀번호 암호화를 위한 문자열
     */
    private String spradmLgnSlt;

    /**
     * @ColumnName SPRADM_NM
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 슈퍼 관리자의 이름
     */
    private String spradmNm;

    /**
     * @ColumnName SPRADM_PN
     * @ColumnType VARCHAR2(20)
     * @ColumnComment 슈퍼 관리자 전화번호
     */
    private String spradmPn;

    /**
     * @ColumnName SPRADM_EMAIL
     * @ColumnType VARCHAR2(320)
     * @ColumnComment 슈퍼 관리자 이메일
     */
    private String spradmEmail;

    /**
     * @ColumnName SPRADM_BRT_DT
     * @ColumnType DATE
     * @ColumnComment 슈퍼 관리자 생년월일
     */
    private String spradmBrtDt;

    /**
     * @ColumnName SPRADM_ADRS
     * @ColumnType VARCHAR2(200)
     * @ColumnComment 슈퍼 관리자 주소
     */
    private String spradmAdrs;

    /**
     * @ColumnName SPRADM_RGST_DT
     * @ColumnType DATE
     * @ColumnComment 슈퍼 관리자 아이디 등록 날짜
     */
    private String spradmRgstDt;

	public String getInsttnId() {
		return insttnId;
	}

	public void setInsttnId(String insttnId) {
		this.insttnId = insttnId;
	}

	public String getCmcdId() {
		return cmcdId;
	}

	public void setCmcdId(String cmcdId) {
		this.cmcdId = cmcdId;
	}

	public String getSpradmId() {
		return spradmId;
	}

	public void setSpradmId(String spradmId) {
		this.spradmId = spradmId;
	}

	public String getSpradmLgnId() {
		return spradmLgnId;
	}

	public void setSpradmLgnId(String spradmLgnId) {
		this.spradmLgnId = spradmLgnId;
	}

	public String getSpradmLgnPw() {
		return spradmLgnPw;
	}

	public void setSpradmLgnPw(String spradmLgnPw) {
		this.spradmLgnPw = spradmLgnPw;
	}

	public String getSpradmLgnSlt() {
		return spradmLgnSlt;
	}

	public void setSpradmLgnSlt(String spradmLgnSlt) {
		this.spradmLgnSlt = spradmLgnSlt;
	}

	public String getSpradmNm() {
		return spradmNm;
	}

	public void setSpradmNm(String spradmNm) {
		this.spradmNm = spradmNm;
	}

	public String getSpradmPn() {
		return spradmPn;
	}

	public void setSpradmPn(String spradmPn) {
		this.spradmPn = spradmPn;
	}

	public String getSpradmEmail() {
		return spradmEmail;
	}

	public void setSpradmEmail(String spradmEmail) {
		this.spradmEmail = spradmEmail;
	}

	public String getSpradmBrtDt() {
		return spradmBrtDt;
	}

	public void setSpradmBrtDt(String spradmBrtDt) {
		this.spradmBrtDt = spradmBrtDt;
	}

	public String getSpradmAdrs() {
		return spradmAdrs;
	}

	public void setSpradmAdrs(String spradmAdrs) {
		this.spradmAdrs = spradmAdrs;
	}

	public String getSpradmRgstDt() {
		return spradmRgstDt;
	}

	public void setSpradmRgstDt(String spradmRgstDt) {
		this.spradmRgstDt = spradmRgstDt;
	}
    
    
    
}
