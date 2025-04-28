package com.learn.bbs.eduad.flarch.vo;

import com.learn.common.vo.Search;

public class FlArchSearchRequestVO extends Search{
	
	private String writerName; // 작성자명
	private String flArchTtl;
	private String flArchCtt;
	
	// 게시판 아이디
	private String artcId;
	// 학원 아이디
	private String insttnId;
	// 강좌 아이디
	private String crsInfId;
	// 로그인 아이디 (학생, 강사 로그인 아이디)
	private String lgnId;
	
	
	public String getLgnId() {
		return lgnId;
	}

	public void setLgnId(String lgnId) {
		this.lgnId = lgnId;
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

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getFlArchTtl() {
		return flArchTtl;
	}
	public void setFlArchTtl(String flArchTtl) {
		this.flArchTtl = flArchTtl;
	}
	public String getFlArchCtt() {
		return flArchCtt;
	}
	public void setFlArchCtt(String flArchCtt) {
		this.flArchCtt = flArchCtt;
	}

}
