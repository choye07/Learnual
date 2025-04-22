package com.learn.common.vo;

import jakarta.validation.constraints.NotEmpty;

// 공통 로그인 처리 requestVO
public class LoginRequestVO {

	@NotEmpty(message="이메일을 입력하세요")
    private String lgnId;

	@NotEmpty(message="비밀번호를 입력하세요")
    private String lgnPw;

	public String getLgnId() {
		return lgnId;
	}

	public void setLgnId(String lgnId) {
		this.lgnId = lgnId;
	}

	public String getLgnPw() {
		return lgnPw;
	}

	public void setLgnPw(String lgnPw) {
		this.lgnPw = lgnPw;
	}

}
