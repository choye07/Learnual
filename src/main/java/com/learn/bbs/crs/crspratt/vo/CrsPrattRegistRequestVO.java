package com.learn.bbs.crs.crspratt.vo;

import java.util.List;

public class CrsPrattRegistRequestVO extends CrsPrattVO {
	private String logId;
	private List<String> selectedUserIds;
	private List<String> notConfirmedUsrIds;

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public List<String> getSelectedUserIds() {
		return selectedUserIds;
	}

	public void setSelectedUserIds(List<String> selectedUserIds) {
		this.selectedUserIds = selectedUserIds;
	}

	public List<String> getNotConfirmedUsrIds() {
		return notConfirmedUsrIds;
	}

	public void setNotConfirmedUsrIds(List<String> notConfirmedUsrIds) {
		this.notConfirmedUsrIds = notConfirmedUsrIds;
	}
}
