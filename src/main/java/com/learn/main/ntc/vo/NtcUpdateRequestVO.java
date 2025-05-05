package com.learn.main.ntc.vo;

import jakarta.validation.constraints.NotEmpty;

public class NtcUpdateRequestVO {
	private String ntcId; // NTC_ID

	@NotEmpty(message = "수정할 제목은 필수 입력값입니다.")
	private String ntcTtl; // NTC_TTL

	@NotEmpty(message = "수정할 내용은 필수 입력값입니다.")
	private String ntcCtt; // NTC_CTT

	private String ntcUpdtDt; //NTC_UPDT_DT

	public String getNtcId() {
		return ntcId;
	}

	public void setNtcId(String ntcId) {
		this.ntcId = ntcId;
	}

	public String getNtcTtl() {
		return ntcTtl;
	}

	public void setNtcTtl(String ntcTtl) {
		this.ntcTtl = ntcTtl;
	}

	public String getNtcCtt() {
		return ntcCtt;
	}

	public void setNtcCtt(String ntcCtt) {
		this.ntcCtt = ntcCtt;
	}

	public String getNtcUpdtDt() {
		return ntcUpdtDt;
	}

	public void setNtcUpdtDt(String ntcUpdtDt) {
		this.ntcUpdtDt = ntcUpdtDt;
	}

}
