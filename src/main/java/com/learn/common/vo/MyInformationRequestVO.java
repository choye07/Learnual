package com.learn.common.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

/**
 * 공통 개인정보 수정 VO
 */
public class MyInformationRequestVO {
	
	/**
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 공통 개인정보 아이디
     */
    private String myiLgnId;
    
    @NotEmpty(message = "비밀번호를 입력해주세요.")
	@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*\\W).{10,}$",
				message="비밀번호는 영소문자, 대문자, 숫자, 특수문자를 포함해 10자리 이상으로 입력해야 합니다.")
	// 관리자 비밀번호
	private String myiLgnPw;
	
    @NotEmpty(message = "비밀번호 재입력을 입력해주세요.")
	@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z])(?=.*\\W).{10,}$",
	message="비밀번호는 영소문자, 대문자, 숫자, 특수문자를 포함해 10자리 이상으로 입력해야 합니다.")
	// 관리자 비밀번호 확인
	private String myiConfirlgnPw;

    /**
     * @ColumnType VARCHAR2¬(32)
     * @ColumnComment 공통 개인정보 비밀번호 암호화를 위한 문자열
     */
    private String myiLgnSlt;
	
    /**
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 공통 개인정보 이름
     */
    @NotBlank(message = "이름을 입력해주세요.")
    private String myiNm;

    /**
     * @ColumnType VARCHAR2(20)
     * @ColumnComment 공통 개인정보 전화번호
     */
    @NotBlank(message = "휴대폰 번호를 입력하세요.")
    @Pattern(
        regexp = "^(010|011|016|017|018|019)-\\d{3,4}-\\d{4}$",
        message = "올바른 휴대폰 번호 형식이 아닙니다. 예: 010-1234-5678"
    )
    private String myiPn;

    /**
     * @ColumnType VARCHAR2(200)
     * @ColumnComment 공통 개인정보 주소
     */
    @NotEmpty(message = "주소를 입력해주세요.")
    private String myiAdrs;

    /**
     * @ColumnType VARCHAR2(320)
     * @ColumnComment 공통 개인정보 이메일
     */
    private String myiEmail;


    /**
     * @ColumnType DATE
     * @ColumnComment 공통 개인정보 아이디 수정 날짜
     */
    private String myiUpdtDt;

    /**
     * @ColumnType DATE
     * @ColumnComment 공통 개인정보 최근 비밀번호 변경 날짜
     */
    private String myiLstPwMdfyDt;

	public String getMyiLgnId() {
		return myiLgnId;
	}

	public void setMyiLgnId(String myiLgnId) {
		this.myiLgnId = myiLgnId;
	}

	public String getMyiLgnPw() {
		return myiLgnPw;
	}

	public void setMyiLgnPw(String myiLgnPw) {
		this.myiLgnPw = myiLgnPw;
	}

	public String getMyiConfirlgnPw() {
		return myiConfirlgnPw;
	}

	public void setMyiConfirlgnPw(String myiConfirlgnPw) {
		this.myiConfirlgnPw = myiConfirlgnPw;
	}

	public String getMyiLgnSlt() {
		return myiLgnSlt;
	}

	public void setMyiLgnSlt(String myiLgnSlt) {
		this.myiLgnSlt = myiLgnSlt;
	}

	public String getMyiNm() {
		return myiNm;
	}

	public void setMyiNm(String myiNm) {
		this.myiNm = myiNm;
	}

	public String getMyiPn() {
		return myiPn;
	}

	public void setMyiPn(String myiPn) {
		this.myiPn = myiPn;
	}

	public String getMyiAdrs() {
		return myiAdrs;
	}

	public void setMyiAdrs(String myiAdrs) {
		this.myiAdrs = myiAdrs;
	}

	public String getMyiEmail() {
		return myiEmail;
	}

	public void setMyiEmail(String myiEmail) {
		this.myiEmail = myiEmail;
	}

	public String getMyiUpdtDt() {
		return myiUpdtDt;
	}

	public void setMyiUpdtDt(String myiUpdtDt) {
		this.myiUpdtDt = myiUpdtDt;
	}

	public String getMyiLstPwMdfyDt() {
		return myiLstPwMdfyDt;
	}

	public void setMyiLstPwMdfyDt(String myiLstPwMdfyDt) {
		this.myiLstPwMdfyDt = myiLstPwMdfyDt;
	}

	@Override
	public String toString() {
		return "MyInfromationRequestVO [myiLgnId=" + myiLgnId + ", myiLgnPw=" + myiLgnPw + ", myiConfirlgnPw="
				+ myiConfirlgnPw + ", myiLgnSlt=" + myiLgnSlt + ", myiNm=" + myiNm + ", myiPn=" + myiPn + ", myiAdrs="
				+ myiAdrs + ", myiEmail=" + myiEmail + ", myiUpdtDt=" + myiUpdtDt + ", myiLstPwMdfyDt=" + myiLstPwMdfyDt
				+ "]";
	}

}
