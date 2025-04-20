package com.learn.main.sprad.vo;

/**
 * @TableName SPRADM
 * @TableComment null
 */
public class SpradmVO {

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

    /**
     * @ColumnName SPRADM_UPDT_DT
     * @ColumnType DATE
     * @ColumnComment 슈퍼 관리자 아이디 수정 날짜
     */
    private String spradmUpdtDt;

    /**
     * @ColumnName SPRADM_DEL_DT
     * @ColumnType DATE
     * @ColumnComment 슈퍼 관리자 아이디 삭제 날짜
     */
    private String spradmDelDt;

    /**
     * @ColumnName SPRADM_DEL_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 슈퍼 관리자 아이디 삭제 여부
     */
    private String spradmDelYn;

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
     * @ColumnName SPRADM_LGN_IP
     * @ColumnType VARCHAR2(39)
     * @ColumnComment 슈퍼관리자의 최근 접속 IP
     */
    private String spradmLgnIp;

    /**
     * @ColumnName SPRADM_LST_PW_MDFY_DT
     * @ColumnType DATE
     * @ColumnComment null
     */
    private String spradmLstPwMdfyDt;

    /**
     * @ColumnName SPRADM_LST_LGN_DT
     * @ColumnType DATE
     * @ColumnComment 슈퍼관리자의  최근 로그인 날짜
     */
    private String spradmLstLgnDt;

    /**
     * @ColumnName SPRADM_LST_LGN_FAIL_DT
     * @ColumnType DATE
     * @ColumnComment 슈퍼관리자의 최근 로그인 실패 날짜
     */
    private String spradmLstLgnFailDt;

    /**
     * @ColumnName SPRADM_LGN_FAIL_CNT
     * @ColumnType NUMBER(1, 0)
     * @ColumnComment 슈퍼관리자가 로그인에 실패한 횟수
     */
    private int spradmLgnFailCnt;

    /**
     * @ColumnName SPRADM_LGN_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 슈퍼관리자 로그인 여부
     */
    private String spradmLgnYn;

    /**
     * @ColumnName SPRADM_BLK_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 슈퍼관리자 계정 잠금 여부
     */
    private String spradmBlkYn;

    public String getSpradmId() {
        return this.spradmId;
    }
    
    public void setSpradmId(String spradmId) {
        this.spradmId = spradmId;
    }
    
    public String getSpradmLgnId() {
        return this.spradmLgnId;
    }
    
    public void setSpradmLgnId(String spradmLgnId) {
        this.spradmLgnId = spradmLgnId;
    }
    
    public String getSpradmLgnPw() {
        return this.spradmLgnPw;
    }
    
    public void setSpradmLgnPw(String spradmLgnPw) {
        this.spradmLgnPw = spradmLgnPw;
    }
    
    public String getSpradmLgnSlt() {
        return this.spradmLgnSlt;
    }
    
    public void setSpradmLgnSlt(String spradmLgnSlt) {
        this.spradmLgnSlt = spradmLgnSlt;
    }
    
    public String getSpradmNm() {
        return this.spradmNm;
    }
    
    public void setSpradmNm(String spradmNm) {
        this.spradmNm = spradmNm;
    }
    
    public String getSpradmPn() {
        return this.spradmPn;
    }
    
    public void setSpradmPn(String spradmPn) {
        this.spradmPn = spradmPn;
    }
    
    public String getSpradmEmail() {
        return this.spradmEmail;
    }
    
    public void setSpradmEmail(String spradmEmail) {
        this.spradmEmail = spradmEmail;
    }
    
    public String getSpradmBrtDt() {
        return this.spradmBrtDt;
    }
    
    public void setSpradmBrtDt(String spradmBrtDt) {
        this.spradmBrtDt = spradmBrtDt;
    }
    
    public String getSpradmAdrs() {
        return this.spradmAdrs;
    }
    
    public void setSpradmAdrs(String spradmAdrs) {
        this.spradmAdrs = spradmAdrs;
    }
    
    public String getSpradmRgstDt() {
        return this.spradmRgstDt;
    }
    
    public void setSpradmRgstDt(String spradmRgstDt) {
        this.spradmRgstDt = spradmRgstDt;
    }
    
    public String getSpradmUpdtDt() {
        return this.spradmUpdtDt;
    }
    
    public void setSpradmUpdtDt(String spradmUpdtDt) {
        this.spradmUpdtDt = spradmUpdtDt;
    }
    
    public String getSpradmDelDt() {
        return this.spradmDelDt;
    }
    
    public void setSpradmDelDt(String spradmDelDt) {
        this.spradmDelDt = spradmDelDt;
    }
    
    public String getSpradmDelYn() {
        return this.spradmDelYn;
    }
    
    public void setSpradmDelYn(String spradmDelYn) {
        this.spradmDelYn = spradmDelYn;
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
    
    public String getSpradmLgnIp() {
        return this.spradmLgnIp;
    }
    
    public void setSpradmLgnIp(String spradmLgnIp) {
        this.spradmLgnIp = spradmLgnIp;
    }
    
    public String getSpradmLstPwMdfyDt() {
        return this.spradmLstPwMdfyDt;
    }
    
    public void setSpradmLstPwMdfyDt(String spradmLstPwMdfyDt) {
        this.spradmLstPwMdfyDt = spradmLstPwMdfyDt;
    }
    
    public String getSpradmLstLgnDt() {
        return this.spradmLstLgnDt;
    }
    
    public void setSpradmLstLgnDt(String spradmLstLgnDt) {
        this.spradmLstLgnDt = spradmLstLgnDt;
    }
    
    public String getSpradmLstLgnFailDt() {
        return this.spradmLstLgnFailDt;
    }
    
    public void setSpradmLstLgnFailDt(String spradmLstLgnFailDt) {
        this.spradmLstLgnFailDt = spradmLstLgnFailDt;
    }
    
    public int getSpradmLgnFailCnt() {
        return this.spradmLgnFailCnt;
    }
    
    public void setSpradmLgnFailCnt(int spradmLgnFailCnt) {
        this.spradmLgnFailCnt = spradmLgnFailCnt;
    }
    
    public String getSpradmLgnYn() {
        return this.spradmLgnYn;
    }
    
    public void setSpradmLgnYn(String spradmLgnYn) {
        this.spradmLgnYn = spradmLgnYn;
    }
    
    public String getSpradmBlkYn() {
        return this.spradmBlkYn;
    }
    
    public void setSpradmBlkYn(String spradmBlkYn) {
        this.spradmBlkYn = spradmBlkYn;
    }
    
    @Override
    public String toString() {
        return "SpradmVO(spradmId: " + spradmId + ", spradmLgnId: " + spradmLgnId + ", spradmLgnPw: " + spradmLgnPw + ", spradmLgnSlt: " + spradmLgnSlt + ", spradmNm: " + spradmNm + ", spradmPn: " + spradmPn + ", spradmEmail: " + spradmEmail + ", spradmBrtDt: " + spradmBrtDt + ", spradmAdrs: " + spradmAdrs + ", spradmRgstDt: " + spradmRgstDt + ", spradmUpdtDt: " + spradmUpdtDt + ", spradmDelDt: " + spradmDelDt + ", spradmDelYn: " + spradmDelYn + ", insttnId: " + insttnId + ", cmcdId: " + cmcdId + ", spradmLgnIp: " + spradmLgnIp + ", spradmLstPwMdfyDt: " + spradmLstPwMdfyDt + ", spradmLstLgnDt: " + spradmLstLgnDt + ", spradmLstLgnFailDt: " + spradmLstLgnFailDt + ", spradmLgnFailCnt: " + spradmLgnFailCnt + ", spradmLgnYn: " + spradmLgnYn + ", spradmBlkYn: " + spradmBlkYn + ", )";
    }
}