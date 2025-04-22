package com.learn.bbs.eduad.flarch.vo;

import java.util.List;

import com.learn.bbs.file.vo.FlVO;

public class FlArchDeleteRequestVO {

	// 게시글 아이디
	private String flArchId;
	// 강사 아이디
	private String instrId;
	
    // 삭제할 파일
    private List<FlVO> flList;
	
	public String getFlArchId() {
		return flArchId;
	}
	public void setFlArchId(String flArchId) {
		this.flArchId = flArchId;
	}
	public String getInstrId() {
		return instrId;
	}
	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}
	public List<FlVO> getFlList() {
		return flList;
	}
	public void setFlList(List<FlVO> flList) {
		this.flList = flList;
	}
	
}
