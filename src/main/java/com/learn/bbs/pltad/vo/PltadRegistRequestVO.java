package com.learn.bbs.pltad.vo;

public class PltadRegistRequestVO {
	
	public static final String PLTAD_MACC_NM = "플랫폼 관리자";
	/**
	 * 현재 로그인한 관리자 아이디
	 */
	private String lgnId;
	  /**
     * @ColumnName PLTADM_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 관리자의 고유한 아이디(PL-YYYYMMDD-NNNNNN)
     */
    private String pltadmId;

    /**
     * @ColumnName PLTADM_LGN_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 관리자 계정의 아이디
     */
    private String pltadmLgnId;

    /**
     * @ColumnName PLTADM_LGN_PW
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 관리자 계정의 비밀번호
     */
    private String pltadmLgnPw;

    /**
     * @ColumnName PLTADM_NM
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 관리자의 이름
     */
    private String pltadmNm;

    /**
     * @ColumnName PLTADM_PN
     * @ColumnType VARCHAR2(20)
     * @ColumnComment 관리자 전화번호
     */
    private String pltadmPn;

    /**
     * @ColumnName PLTADM_EMAIL
     * @ColumnType VARCHAR2(320)
     * @ColumnComment 관리자 이메일
     */
    private String pltadmEmail;

    /**
     * @ColumnName PLTADM_BRT_DT
     * @ColumnType DATE
     * @ColumnComment 관리자 생년월일
     */
    private String pltadmBrtDt;

    /**
     * @ColumnName PLTADM_ADRS
     * @ColumnType VARCHAR2(200)
     * @ColumnComment 관리자 주소
     */
    private String pltadmAdrs;

    /**
     * @ColumnName PLTADM_RGST_DT
     * @ColumnType DATE
     * @ColumnComment 관리자 아이디 등록 날짜
     */
    private String pltadmRgstDt;
    /**
     * @ColumnName PLTADM_DEL_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 관리자 아이디 삭제 여부
     */
    private String pltadmDelYn;

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
     * @ColumnName PLATADM_LGN_SLT
     * @ColumnType VARCHAR2(32)
     * @ColumnComment 관리자의 비밀번호 암호화를 위한 문자열
     */
    private String platadmLgnSlt;
    

	public String getLgnId() {
		return lgnId;
	}

	public void setLgnId(String lgnId) {
		this.lgnId = lgnId;
	}

	public String getPltadmId() {
		return pltadmId;
	}

	public void setPltadmId(String pltadmId) {
		this.pltadmId = pltadmId;
	}

	public String getPltadmLgnId() {
		return pltadmLgnId;
	}

	public void setPltadmLgnId(String pltadmLgnId) {
		this.pltadmLgnId = pltadmLgnId;
	}

	public String getPltadmLgnPw() {
		return pltadmLgnPw;
	}

	public void setPltadmLgnPw(String pltadmLgnPw) {
		this.pltadmLgnPw = pltadmLgnPw;
	}

	public String getPltadmNm() {
		return pltadmNm;
	}

	public void setPltadmNm(String pltadmNm) {
		this.pltadmNm = pltadmNm;
	}

	public String getPltadmPn() {
		return pltadmPn;
	}

	public void setPltadmPn(String pltadmPn) {
		this.pltadmPn = pltadmPn;
	}

	public String getPltadmEmail() {
		return pltadmEmail;
	}

	public void setPltadmEmail(String pltadmEmail) {
		this.pltadmEmail = pltadmEmail;
	}

	public String getPltadmBrtDt() {
		return pltadmBrtDt;
	}

	public void setPltadmBrtDt(String pltadmBrtDt) {
		this.pltadmBrtDt = pltadmBrtDt;
	}

	public String getPltadmAdrs() {
		return pltadmAdrs;
	}

	public void setPltadmAdrs(String pltadmAdrs) {
		this.pltadmAdrs = pltadmAdrs;
	}

	public String getPltadmRgstDt() {
		return pltadmRgstDt;
	}

	public void setPltadmRgstDt(String pltadmRgstDt) {
		this.pltadmRgstDt = pltadmRgstDt;
	}

	public String getPltadmDelYn() {
		return pltadmDelYn;
	}

	public void setPltadmDelYn(String pltadmDelYn) {
		this.pltadmDelYn = pltadmDelYn;
	}

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

	public String getPlatadmLgnSlt() {
		return platadmLgnSlt;
	}

	public void setPlatadmLgnSlt(String platadmLgnSlt) {
		this.platadmLgnSlt = platadmLgnSlt;
	}
    
    
}
