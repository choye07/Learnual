package com.learn.bbs.crs.crspratt.vo;

import java.util.List;

public class CrsPrattRegistRequestVO extends CrsPrattVO {
//	private String logId;
	private List<String> selectedUserEmails;
//	private List<String> notConfirmedUsrEmails;
	private String usrMl;

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
	
//	public List<String> getNotConfirmedUsrEmails() {
//		return notConfirmedUsrEmails;
//	}
//	public void setNotConfirmedUsrEmails(List<String> notConfirmedUsrEmails) {
//		this.notConfirmedUsrEmails = notConfirmedUsrEmails;
//	}

//	public String getLogId() {
//		return logId;
//	}
//
//	public void setLogId(String logId) {
//		this.logId = logId;
//	}

}
