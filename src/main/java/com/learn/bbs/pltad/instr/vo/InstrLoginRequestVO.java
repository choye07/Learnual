package com.learn.bbs.pltad.instr.vo;

import jakarta.validation.constraints.NotEmpty;

/**
 * 강사 로그인 VO
 */
public class InstrLoginRequestVO {

    /**
     * @ColumnName INSTR_LGN_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 강사 계정의 아이디
     */
    @NotEmpty(message="이메일을 입력하세요")
    private String instrLgnId;

    /**
     * @ColumnName INSTR_LGN_PW
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 강사 계정의 비밀번호
     */
    @NotEmpty(message="비밀번호를 입력하세요")
    private String instrLgnPw;

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

	@Override
	public String toString() {
		return "InstrLoginRequestVO [instrLgnId=" + instrLgnId + ", instrLgnPw=" + instrLgnPw + ", getInstrLgnId()="
				+ getInstrLgnId() + ", getInstrLgnPw()=" + getInstrLgnPw() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

    
}