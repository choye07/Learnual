package com.learn.bbs.usr.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class UsrEditMyinformationVO {
	
    
	@NotEmpty(message = "비밀번호를 입력해주세요.")
	@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*\\W).{10,}$",
				message="비밀번호는 영소문자, 대문자, 숫자, 특수문자를 포함해 10자리 이상으로 입력해야 합니다.")
	// 회원 비밀번호
	private String usrPw;
	
	@NotEmpty(message = "비밀번호 재입력을 입력해주세요.")
	@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*\\W).{10,}$",
	message="비밀번호는 영소문자, 대문자, 숫자, 특수문자를 포함해 10자리 이상으로 입력해야 합니다.")
	// 회원 비밀번호 확인
	private String confirmUsrPw;

    /**
     * @ColumnName USR_SLT
     * @ColumnType VARCHAR2(32)
     * @ColumnComment 회원의 비밀번호 암호화를 위한 문자열
     */
    private String usrSlt;
    /**
     * @ColumnName USR_NM
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 회원 이름
     */
    private String usrNm;

    /**
     * @ColumnName USR_PN
     * @ColumnType VARCHAR2(20)
     * @ColumnComment 회원 전화번호
     */
    private String usrPn;

    /**
     * @ColumnName USR_ADRS
     * @ColumnType VARCHAR2(200)
     * @ColumnComment 회원 주소
     */
    private String usrAdrs;

    /**
     * @ColumnName USR_ML
     * @ColumnType VARCHAR2(320)
     * @ColumnComment 회원 이메일
     */
    private String usrMl;


    /**
     * @ColumnName USR_UPDT_DT
     * @ColumnType DATE
     * @ColumnComment 회원 아이디 수정 날짜
     */
    private String usrUpdtDt;

    /**
     * @ColumnName USR_LST_PW_MDFY_DT
     * @ColumnType DATE
     * @ColumnComment 회원의 최근 비밀번호 변경 날짜
     */
    private String usrLstPwMdfyDt;

	public String getUsrPw() {
		return usrPw;
	}

	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}

	public String getConfirmUsrPw() {
		return confirmUsrPw;
	}

	public void setConfirmUsrPw(String confirmUsrPw) {
		this.confirmUsrPw = confirmUsrPw;
	}

	public String getUsrSlt() {
		return usrSlt;
	}

	public void setUsrSlt(String usrSlt) {
		this.usrSlt = usrSlt;
	}

	public String getUsrNm() {
		return usrNm;
	}

	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	public String getUsrPn() {
		return usrPn;
	}

	public void setUsrPn(String usrPn) {
		this.usrPn = usrPn;
	}

	public String getUsrAdrs() {
		return usrAdrs;
	}

	public void setUsrAdrs(String usrAdrs) {
		this.usrAdrs = usrAdrs;
	}

	public String getUsrMl() {
		return usrMl;
	}

	public void setUsrMl(String usrMl) {
		this.usrMl = usrMl;
	}

	public String getUsrUpdtDt() {
		return usrUpdtDt;
	}

	public void setUsrUpdtDt(String usrUpdtDt) {
		this.usrUpdtDt = usrUpdtDt;
	}

	public String getUsrLstPwMdfyDt() {
		return usrLstPwMdfyDt;
	}

	public void setUsrLstPwMdfyDt(String usrLstPwMdfyDt) {
		this.usrLstPwMdfyDt = usrLstPwMdfyDt;
	}

	@Override
	public String toString() {
		return "UsrEditMyinformationVO [usrPw=" + usrPw + ", confirmUsrPw=" + confirmUsrPw + ", usrSlt=" + usrSlt
				+ ", usrNm=" + usrNm + ", usrPn=" + usrPn + ", usrAdrs=" + usrAdrs + ", usrMl=" + usrMl + ", usrUpdtDt="
				+ usrUpdtDt + ", usrLstPwMdfyDt=" + usrLstPwMdfyDt + ", getUsrPw()=" + getUsrPw()
				+ ", getConfirmUsrPw()=" + getConfirmUsrPw() + ", getUsrSlt()=" + getUsrSlt() + ", getUsrNm()="
				+ getUsrNm() + ", getUsrPn()=" + getUsrPn() + ", getUsrAdrs()=" + getUsrAdrs() + ", getUsrMl()="
				+ getUsrMl() + ", getUsrUpdtDt()=" + getUsrUpdtDt() + ", getUsrLstPwMdfyDt()=" + getUsrLstPwMdfyDt()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


    
}
