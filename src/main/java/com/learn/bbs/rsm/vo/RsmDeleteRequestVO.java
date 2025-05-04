package com.learn.bbs.rsm.vo;

import com.learn.bbs.file.vo.FlVO;

public class RsmDeleteRequestVO {

	// 이력서 아이디
	private String rsmId;

	// 회원 아이디 = 회원 세션 아이디 usrMl;
	private String usrId;

	// 삭제할 이력서 첨부파일
	private FlVO file;

	// 학원 아이디
	private String InsttnId;

	public String getInsttnId() {
		return InsttnId;
	}

	public void setInsttnId(String insttnId) {
		InsttnId = insttnId;
	}

	public String getRsmId() {
		return rsmId;
	}

	public void setRsmId(String rsmId) {
		this.rsmId = rsmId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public FlVO getFile() {
		return file;
	}

	public void setFile(FlVO file) {
		this.file = file;
	}

}
