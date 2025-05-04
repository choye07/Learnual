package com.learn.bbs.rsm.vo;

import com.learn.common.vo.Search;

public class RsmSearchRequestVO extends Search {

	// 이력서 제목으로 검색
	private String rsmTtl;

	// 등록 날짜로 검색
	private String rsmRgstDt;

	// 회원 아이디 = 회원 세션 아이디 usrMl;
	private String usrId;

	// 학원 아이디
	private String InsttnId;

	public String getInsttnId() {
		return InsttnId;
	}

	public void setInsttnId(String insttnId) {
		InsttnId = insttnId;
	}

	public String getRsmTtl() {
		return rsmTtl;
	}

	public void setRsmTtl(String rsmTtl) {
		this.rsmTtl = rsmTtl;
	}

	public String getRsmRgstDt() {
		return rsmRgstDt;
	}

	public void setRsmRgstDt(String rsmRgstDt) {
		this.rsmRgstDt = rsmRgstDt;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}
