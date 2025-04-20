package com.learn.bbs.pltad.vo;

/**
 * @TableName PLTADM
 * @TableComment null
 */
public class PltadmVO {

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
     * @ColumnName PLTADM_UPDT_DT
     * @ColumnType DATE
     * @ColumnComment 관리자 아이디 수정 날짜
     */
    private String pltadmUpdtDt;

    /**
     * @ColumnName PLTADM_DEL_DT
     * @ColumnType DATE
     * @ColumnComment 관리자 아이디 수정 날짜
     */
    private String pltadmDelDt;

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

    /**
     * @ColumnName PLTADM_LGN_IP
     * @ColumnType VARCHAR2(39)
     * @ColumnComment 관리자의 최근 접속 IP
     */
    private String pltadmLgnIp;

    /**
     * @ColumnName PLTADM_LST_PW_MDFY_DT
     * @ColumnType DATE
     * @ColumnComment 관리자의 최근 비밀번호 변경 날짜
     */
    private String pltadmLstPwMdfyDt;

    /**
     * @ColumnName PLTADM_LST_LGN_DT
     * @ColumnType DATE
     * @ColumnComment 관리자의 최근 로그인 날짜
     */
    private String pltadmLstLgnDt;

    /**
     * @ColumnName PLTADM_LST_LGN_FAIL_DT
     * @ColumnType DATE
     * @ColumnComment 관리자의 최근 로그인 실패 날짜
     */
    private String pltadmLstLgnFailDt;

    /**
     * @ColumnName PLTADM_LGN_FAIL_CNT
     * @ColumnType NUMBER(1, 0)
     * @ColumnComment 관리자가 로그인에 실패한 횟수
     */
    private int pltadmLgnFailCnt;

    /**
     * @ColumnName PLTADM_LGN_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 관리자 로그인 여부
     */
    private String pltadmLgnYn;

    /**
     * @ColumnName PLTADM_BLK_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 관리자 계정 잠금 여부
     */
    private String pltadmBlkYn;

    public String getPltadmId() {
        return this.pltadmId;
    }
    
    public void setPltadmId(String pltadmId) {
        this.pltadmId = pltadmId;
    }
    
    public String getPltadmLgnId() {
        return this.pltadmLgnId;
    }
    
    public void setPltadmLgnId(String pltadmLgnId) {
        this.pltadmLgnId = pltadmLgnId;
    }
    
    public String getPltadmLgnPw() {
        return this.pltadmLgnPw;
    }
    
    public void setPltadmLgnPw(String pltadmLgnPw) {
        this.pltadmLgnPw = pltadmLgnPw;
    }
    
    public String getPltadmNm() {
        return this.pltadmNm;
    }
    
    public void setPltadmNm(String pltadmNm) {
        this.pltadmNm = pltadmNm;
    }
    
    public String getPltadmPn() {
        return this.pltadmPn;
    }
    
    public void setPltadmPn(String pltadmPn) {
        this.pltadmPn = pltadmPn;
    }
    
    public String getPltadmEmail() {
        return this.pltadmEmail;
    }
    
    public void setPltadmEmail(String pltadmEmail) {
        this.pltadmEmail = pltadmEmail;
    }
    
    public String getPltadmBrtDt() {
        return this.pltadmBrtDt;
    }
    
    public void setPltadmBrtDt(String pltadmBrtDt) {
        this.pltadmBrtDt = pltadmBrtDt;
    }
    
    public String getPltadmAdrs() {
        return this.pltadmAdrs;
    }
    
    public void setPltadmAdrs(String pltadmAdrs) {
        this.pltadmAdrs = pltadmAdrs;
    }
    
    public String getPltadmRgstDt() {
        return this.pltadmRgstDt;
    }
    
    public void setPltadmRgstDt(String pltadmRgstDt) {
        this.pltadmRgstDt = pltadmRgstDt;
    }
    
    public String getPltadmUpdtDt() {
        return this.pltadmUpdtDt;
    }
    
    public void setPltadmUpdtDt(String pltadmUpdtDt) {
        this.pltadmUpdtDt = pltadmUpdtDt;
    }
    
    public String getPltadmDelDt() {
        return this.pltadmDelDt;
    }
    
    public void setPltadmDelDt(String pltadmDelDt) {
        this.pltadmDelDt = pltadmDelDt;
    }
    
    public String getPltadmDelYn() {
        return this.pltadmDelYn;
    }
    
    public void setPltadmDelYn(String pltadmDelYn) {
        this.pltadmDelYn = pltadmDelYn;
    }
    
    public String getInsttnId() {
        return this.insttnId;
    }
    
    public void setInsttnId(String insttnId) {
        this.insttnId = insttnId;
    }
    
    public String getCmcdId() {
        return this.cmcdId;
    }
    
    public void setCmcdId(String cmcdId) {
        this.cmcdId = cmcdId;
    }
    
    public String getPlatadmLgnSlt() {
        return this.platadmLgnSlt;
    }
    
    public void setPlatadmLgnSlt(String platadmLgnSlt) {
        this.platadmLgnSlt = platadmLgnSlt;
    }
    
    public String getPltadmLgnIp() {
        return this.pltadmLgnIp;
    }
    
    public void setPltadmLgnIp(String pltadmLgnIp) {
        this.pltadmLgnIp = pltadmLgnIp;
    }
    
    public String getPltadmLstPwMdfyDt() {
        return this.pltadmLstPwMdfyDt;
    }
    
    public void setPltadmLstPwMdfyDt(String pltadmLstPwMdfyDt) {
        this.pltadmLstPwMdfyDt = pltadmLstPwMdfyDt;
    }
    
    public String getPltadmLstLgnDt() {
        return this.pltadmLstLgnDt;
    }
    
    public void setPltadmLstLgnDt(String pltadmLstLgnDt) {
        this.pltadmLstLgnDt = pltadmLstLgnDt;
    }
    
    public String getPltadmLstLgnFailDt() {
        return this.pltadmLstLgnFailDt;
    }
    
    public void setPltadmLstLgnFailDt(String pltadmLstLgnFailDt) {
        this.pltadmLstLgnFailDt = pltadmLstLgnFailDt;
    }
    
    public int getPltadmLgnFailCnt() {
        return this.pltadmLgnFailCnt;
    }
    
    public void setPltadmLgnFailCnt(int pltadmLgnFailCnt) {
        this.pltadmLgnFailCnt = pltadmLgnFailCnt;
    }
    
    public String getPltadmLgnYn() {
        return this.pltadmLgnYn;
    }
    
    public void setPltadmLgnYn(String pltadmLgnYn) {
        this.pltadmLgnYn = pltadmLgnYn;
    }
    
    public String getPltadmBlkYn() {
        return this.pltadmBlkYn;
    }
    
    public void setPltadmBlkYn(String pltadmBlkYn) {
        this.pltadmBlkYn = pltadmBlkYn;
    }
    
    @Override
    public String toString() {
        return "PltadmVO(pltadmId: " + pltadmId + ", pltadmLgnId: " + pltadmLgnId + ", pltadmLgnPw: " + pltadmLgnPw + ", pltadmNm: " + pltadmNm + ", pltadmPn: " + pltadmPn + ", pltadmEmail: " + pltadmEmail + ", pltadmBrtDt: " + pltadmBrtDt + ", pltadmAdrs: " + pltadmAdrs + ", pltadmRgstDt: " + pltadmRgstDt + ", pltadmUpdtDt: " + pltadmUpdtDt + ", pltadmDelDt: " + pltadmDelDt + ", pltadmDelYn: " + pltadmDelYn + ", insttnId: " + insttnId + ", cmcdId: " + cmcdId + ", platadmLgnSlt: " + platadmLgnSlt + ", pltadmLgnIp: " + pltadmLgnIp + ", pltadmLstPwMdfyDt: " + pltadmLstPwMdfyDt + ", pltadmLstLgnDt: " + pltadmLstLgnDt + ", pltadmLstLgnFailDt: " + pltadmLstLgnFailDt + ", pltadmLgnFailCnt: " + pltadmLgnFailCnt + ", pltadmLgnYn: " + pltadmLgnYn + ", pltadmBlkYn: " + pltadmBlkYn + ", )";
    }
}