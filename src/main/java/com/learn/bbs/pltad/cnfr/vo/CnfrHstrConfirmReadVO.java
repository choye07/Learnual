package com.learn.bbs.pltad.cnfr.vo;

/*
 * 플랫폼관리자가 강좌 마감 한 뒤에 그 제목 클릭하면 출력할 정보들
 */

public class CnfrHstrConfirmReadVO {
    private String crsInfId;
    private String crsInfNm;
    private String usrId;
	private String usrNm;
    private String usrMl;
    private String usrPn;
    private String usrAdrs;
    private String appHstrRgstDt;
    
	public String getCrsInfId() {
		return crsInfId;
	}
	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}
    public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getCrsInfNm() {
		return crsInfNm;
	}
	public void setCrsInfNm(String crsInfNm) {
		this.crsInfNm = crsInfNm;
	}
	public String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	public String getUsrMl() {
		return usrMl;
	}
	public void setUsrMl(String usrMl) {
		this.usrMl = usrMl;
	}
	public String getUsrPn() {
		return usrPn;
	}
	public void setUsrPn(String usrPn) {
		this.usrPn = usrPn;
	}
	public String getUsrAdrs() {
		return usrAdrs;
	}
	public void setUsrAdrs(String usrAdrs) {
		this.usrAdrs = usrAdrs;
	}
	public String getAppHstrRgstDt() {
		return appHstrRgstDt;
	}
	public void setAppHstrRgstDt(String appHstrRgstDt) {
		this.appHstrRgstDt = appHstrRgstDt;
	}
}
