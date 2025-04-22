package com.learn.bbs.asgmt.vo;

public class AsgmtHstrCommonVO extends AsgmtArtcCommonVO {
	private String asgmtHstrId;
	/**
	 * usr, eduad, pltad, super
	 */
	private String requesterType;

	public String getAsgmtHstrId() {
		return asgmtHstrId;
	}

	public void setAsgmtHstrId(String asgmtHstrId) {
		this.asgmtHstrId = asgmtHstrId;
	}

	public String getRequesterType() {
		return requesterType;
	}

	public void setRequesterType(String requesterType) {
		this.requesterType = requesterType;
	}

}
