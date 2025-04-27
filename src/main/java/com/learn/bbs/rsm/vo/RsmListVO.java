package com.learn.bbs.rsm.vo;

import java.util.List;

public class RsmListVO {

	// 게시글 수
	private int RsmCnt;
	
	// 게시글 목록
	private List<RsmVO> rsmList;

	public int getRsmCnt() {
		return RsmCnt;
	}

	public void setRsmCnt(int rsmCnt) {
		RsmCnt = rsmCnt;
	}

	public List<RsmVO> getRsmList() {
		return rsmList;
	}

	public void setRsmList(List<RsmVO> rsmList) {
		this.rsmList = rsmList;
	}
}
