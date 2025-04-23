package com.learn.bbs.eduad.flarch.vo;

import java.util.List;

public class FlArchListVO {

	// 게시글 수
	private int flArchCnt;
	// 게시글 목록
	private List<FlArchVO> flArchList;
	
	public int getFlArchCnt() {
		return flArchCnt;
	}
	public void setFlArchCnt(int flArchCnt) {
		this.flArchCnt = flArchCnt;
	}
	public List<FlArchVO> getFlArchList() {
		return flArchList;
	}
	public void setFlArchList(List<FlArchVO> flArchList) {
		this.flArchList = flArchList;
	}
	
}
