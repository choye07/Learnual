package com.learn.bbs.crs.crspratt.vo;

import java.util.List;

public class CrsPrattRegistRequestVO extends CrsPrattVO {
	private List<String> selectedUserEmails;
	private String usrMl;
	private String insttnId;

	public String getUsrMl() {
	    return usrMl;
	}

	public void setUsrMl(String usrMl) {
	    this.usrMl = usrMl;
	}
	
	public List<String> getSelectedUserEmails() {
	    return selectedUserEmails;
	}

	public void setSelectedUserEmails(List<String> selectedUserEmails) {
	    this.selectedUserEmails = selectedUserEmails;
	}

	public String getInsttnId() {
		return insttnId;
	}

	public void setInsttnId(String insttnId) {
		this.insttnId = insttnId;
	}
}
