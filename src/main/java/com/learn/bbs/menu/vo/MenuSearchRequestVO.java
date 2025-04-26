package com.learn.bbs.menu.vo;

public class MenuSearchRequestVO extends MenuVO {

	/**
	 * 학원 아이디
	 */
	private String insttnId;

	/**
	 * 로그인 계정 아이디 : usr, eduacc, pltacc, spracc
	 */
	private String lgnId;

	private String cmcdId;

	private String crsInfId;


	public String getInsttnId() {
		return this.insttnId;
	}

	public void setInsttnId(String insttnId) {
		this.insttnId = insttnId;
	}

	public String getLgnId() {
		return this.lgnId;
	}

	public void setLgnId(String lgnId) {
		this.lgnId = lgnId;
	}

	public String getCmcdId() {
		return this.cmcdId;
	}

	public void setCmcdId(String cmcdId) {
		this.cmcdId = cmcdId;
	}

	public String getCrsInfId() {
		return this.crsInfId;
	}

	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}
	
	

}
