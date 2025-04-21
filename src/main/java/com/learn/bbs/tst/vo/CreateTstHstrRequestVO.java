package com.learn.bbs.tst.vo;

public class CreateTstHstrRequestVO extends TstCommonVO {

	private String tstHstrId;
	private String tstId;
	private String usrId;

	public String getTstHstrId() {
		return tstHstrId;
	}

	public void setTstHstrId(String tstHstrId) {
		this.tstHstrId = tstHstrId;
	}

	public String getTstId() {
		return tstId;
	}

	public void setTstId(String tstId) {
		this.tstId = tstId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

}
