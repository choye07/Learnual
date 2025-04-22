package com.learn.bbs.pltad.vo;

import jakarta.validation.constraints.NotEmpty;

/**
 * @TableName PLTADM
 * @TableComment null
 */
public class PltadmLoginRequestVO {

    /**
     * @ColumnName PLTADM_LGN_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 관리자 계정의 아이디
     */
	@NotEmpty(message="이메일을 입력하세요")
    private String pltadmLgnId;

    /**
     * @ColumnName PLTADM_LGN_PW
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 관리자 계정의 비밀번호
     */
	@NotEmpty(message="비밀번호를 입력하세요")
    private String pltadmLgnPw;

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

	@Override
	public String toString() {
		return "PltadmLoginRequestVO [pltadmLgnId=" + pltadmLgnId + ", pltadmLgnPw=" + pltadmLgnPw
				+ ", getPltadmLgnId()=" + getPltadmLgnId() + ", getPltadmLgnPw()=" + getPltadmLgnPw() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}