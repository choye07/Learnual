package com.learn.bbs.tst.vo;

/**
 * 
 */
public class TstCommonVO {

	private String tstId;
	private String usrId;
	private String crsInfId;
	private String artcId;
	private String sbjId;

	/**
	 * usr, eduad, pltad, super
	 */
	private String requesterType;

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

	public String getCrsInfId() {
		return crsInfId;
	}

	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}

	public String getArtcId() {
		return artcId;
	}

	public void setArtcId(String artcId) {
		this.artcId = artcId;
	}

	public String getSbjId() {
		return sbjId;
	}

	public void setSbjId(String sbjId) {
		this.sbjId = sbjId;
	}

	public String getRequesterType() {
		return requesterType;
	}

	public void setRequesterType(String requesterType) {
		this.requesterType = requesterType;
	}

}
