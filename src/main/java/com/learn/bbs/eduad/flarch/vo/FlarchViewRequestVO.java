package com.learn.bbs.eduad.flarch.vo;

public class FlarchViewRequestVO {

	// 게시글 아이디
	private String flArchId;
	// 게시판 아이디
	private String artcId;
	// 학원 아이디
	private String insttnId;
	// 강좌 아이디
	private String crsInfId;
	
	
	public String getFlArchId() {
		return flArchId;
	}
	public void setFlArchId(String flArchId) {
		this.flArchId = flArchId;
	}
	public String getArtcId() {
		return artcId;
	}
	public void setArtcId(String artcId) {
		this.artcId = artcId;
	}
	public String getInsttnId() {
		return insttnId;
	}
	public void setInsttnId(String insttnId) {
		this.insttnId = insttnId;
	}
	public String getCrsInfId() {
		return crsInfId;
	}
	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}
}
