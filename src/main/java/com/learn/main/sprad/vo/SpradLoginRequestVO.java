package com.learn.main.sprad.vo;

import jakarta.validation.constraints.NotEmpty;

/**
 * @TableName SPRADM
 * @TableComment null
 */
public class SpradLoginRequestVO {

	/**
     * @ColumnName SPRADM_LGN_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 슈퍼 관리자 계정의 아이디
     */
	@NotEmpty(message="이메일을 입력하세요")
    private String spradmLgnId;

    /**
     * @ColumnName SPRADM_LGN_PW
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 슈퍼 관리자 계정의 비밀번호
     */
	@NotEmpty(message="비밀번호를 입력하세요")
    private String spradmLgnPw;

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

	@Override
	public String toString() {
		return "SpradLoginRequestVO [spradmLgnId=" + spradmLgnId + ", spradmLgnPw=" + spradmLgnPw + "]";
	}
}