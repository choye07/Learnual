package com.learn.main.sprad.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class SpradEditMyinformationVO {
	
    
	@NotEmpty(message = "비밀번호를 입력해주세요.")
	@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*\\W).{10,}$",
				message="비밀번호는 영소문자, 대문자, 숫자, 특수문자를 포함해 10자리 이상으로 입력해야 합니다.")
	// 슈퍼 관리자 비밀번호
	private String spradmLgnPw;
	
	@NotEmpty(message = "비밀번호 재입력을 입력해주세요.")
	@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*\\W).{10,}$",
	message="비밀번호는 영소문자, 대문자, 숫자, 특수문자를 포함해 10자리 이상으로 입력해야 합니다.")
	// 슈퍼 관리자 비밀번호 확인
	private String confiSpradmLgnPw;

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
     * @ColumnName SPRADM_ADRS
     * @ColumnType VARCHAR2(200)
     * @ColumnComment 슈퍼 관리자 주소
     */
    private String spradmAdrs;

    /**
     * @ColumnName SPRADM_EMAIL
     * @ColumnType VARCHAR2(320)
     * @ColumnComment 슈퍼 관리자 이메일
     */
    private String spradmEmail;

    /**
     * @ColumnName SPRADM_UPDT_DT
     * @ColumnType DATE
     * @ColumnComment 슈퍼 관리자 아이디 수정 날짜
     */
    private String spradmUpdtDt;
    
    /**
     * @ColumnName SPRADM_LST_PW_MDFY_DT
     * @ColumnType DATE
     * @ColumnComment 슈퍼 관리자의 최근 비밀번호 변경 날짜
     */
    private String spradmLstPwMdfyDt;

	public String getSpradmLgnPw() {
		return spradmLgnPw;
	}

	public void setSpradmLgnPw(String spradmLgnPw) {
		this.spradmLgnPw = spradmLgnPw;
	}

	public String getConfiSpradmLgnPw() {
		return confiSpradmLgnPw;
	}

	public void setConfiSpradmLgnPw(String confiSpradmLgnPw) {
		this.confiSpradmLgnPw = confiSpradmLgnPw;
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

	public String getSpradmAdrs() {
		return spradmAdrs;
	}

	public void setSpradmAdrs(String spradmAdrs) {
		this.spradmAdrs = spradmAdrs;
	}

	public String getSpradmEmail() {
		return spradmEmail;
	}

	public void setSpradmEmail(String spradmEmail) {
		this.spradmEmail = spradmEmail;
	}

	public String getSpradmUpdtDt() {
		return spradmUpdtDt;
	}

	public void setSpradmUpdtDt(String spradmUpdtDt) {
		this.spradmUpdtDt = spradmUpdtDt;
	}

	public String getSpradmLstPwMdfyDt() {
		return spradmLstPwMdfyDt;
	}

	public void setSpradmLstPwMdfyDt(String spradmLstPwMdfyDt) {
		this.spradmLstPwMdfyDt = spradmLstPwMdfyDt;
	}

	@Override
	public String toString() {
		return "SpradEditMyinformationVO [spradmLgnPw=" + spradmLgnPw + ", confiSpradmLgnPw=" + confiSpradmLgnPw
				+ ", spradmLgnSlt=" + spradmLgnSlt + ", spradmNm=" + spradmNm + ", spradmPn=" + spradmPn
				+ ", spradmAdrs=" + spradmAdrs + ", spradmEmail=" + spradmEmail + ", spradmUpdtDt=" + spradmUpdtDt
				+ ", spradmLstPwMdfyDt=" + spradmLstPwMdfyDt + "]";
	}

}
