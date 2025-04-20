package com.learn.bbs.pltad.instr.vo;

public class InstrRegistRequestVO extends InstrVO {

	public static final String INSTR_MACC_NM = "강사";
	/**
	 * 현재 로그인한 관리자 아이디
	 */
	private String lgnId;
	

    /**
     * @ColumnName INSTR_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 강사의 고유한 아이디
     */
    private String instrId;
	
	  /**
     * @ColumnName INSTR_LGN_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 강사 계정의 아이디
     */
    private String instrLgnId;

    /**
     * @ColumnName INSTR_LGN_PW
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 강사 계정의 비밀번호
     */
    private String instrLgnPw;

    /**
     * @ColumnName INSTR_LGN_SLT_PW
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 난독화된 비밀번호
     */
    private String instrLgnSltPw;

    /**
     * @ColumnName INSTR_NM
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 강사의 성명
     */
    private String instrNm;

    /**
     * @ColumnName INSTR_PN
     * @ColumnType VARCHAR2(20)
     * @ColumnComment 강사의 전화번호
     */
    private String instrPn;

    /**
     * @ColumnName INSTR_ML
     * @ColumnType VARCHAR2(320)
     * @ColumnComment 강사의 이메일
     */
    private String instrMl;

    /**
     * @ColumnName INSTR_BRT_DT
     * @ColumnType DATE
     * @ColumnComment 강사의 생년월일
     */
    private String instrBrtDt;

    /**
     * @ColumnName INSTR_ADRS
     * @ColumnType VARCHAR2(200)
     * @ColumnComment 강사의 주거지 주소
     */
    private String instrAdrs;

    /**
     * @ColumnName INSTR_RGST_DT
     * @ColumnType DATE
     * @ColumnComment 등록 날짜
     */
    private String instrRgstDt;
    
    /**
     * @ColumnName INSTR_DEL_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 삭제 여부 (Y/N)
     */
    private String instrDelYn;

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
    
    

	public String getInstrId() {
		return instrId;
	}

	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}

	public String getLgnId() {
		return lgnId;
	}

	public void setLgnId(String lgnId) {
		this.lgnId = lgnId;
	}

	public String getInstrLgnId() {
		return instrLgnId;
	}

	public void setInstrLgnId(String instrLgnId) {
		this.instrLgnId = instrLgnId;
	}

	public String getInstrLgnPw() {
		return instrLgnPw;
	}

	public void setInstrLgnPw(String instrLgnPw) {
		this.instrLgnPw = instrLgnPw;
	}

	public String getInstrLgnSltPw() {
		return instrLgnSltPw;
	}

	public void setInstrLgnSltPw(String instrLgnSltPw) {
		this.instrLgnSltPw = instrLgnSltPw;
	}

	public String getInstrNm() {
		return instrNm;
	}

	public void setInstrNm(String instrNm) {
		this.instrNm = instrNm;
	}

	public String getInstrPn() {
		return instrPn;
	}

	public void setInstrPn(String instrPn) {
		this.instrPn = instrPn;
	}

	public String getInstrMl() {
		return instrMl;
	}

	public void setInstrMl(String instrMl) {
		this.instrMl = instrMl;
	}

	public String getInstrBrtDt() {
		return instrBrtDt;
	}

	public void setInstrBrtDt(String instrBrtDt) {
		this.instrBrtDt = instrBrtDt;
	}

	public String getInstrAdrs() {
		return instrAdrs;
	}

	public void setInstrAdrs(String instrAdrs) {
		this.instrAdrs = instrAdrs;
	}

	public String getInstrRgstDt() {
		return instrRgstDt;
	}

	public void setInstrRgstDt(String instrRgstDt) {
		this.instrRgstDt = instrRgstDt;
	}

	public String getInstrDelYn() {
		return instrDelYn;
	}

	public void setInstrDelYn(String instrDelYn) {
		this.instrDelYn = instrDelYn;
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
    
    
    
}
