package com.learn.bbs.eduad.flarch.vo;

import com.learn.common.vo.Search;

public class FlArchSearchRequestVO extends Search{
	
	private String writerName; // 작성자명
	private String flArchTtl;
	private String flArchCtt;
	
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
