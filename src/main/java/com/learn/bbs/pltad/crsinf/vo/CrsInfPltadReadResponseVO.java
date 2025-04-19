package com.learn.bbs.pltad.crsinf.vo;

public class CrsInfPltadReadResponseVO {
    private String crsInfId;
    private String crsInfNm;
    private String crsInfStDt;
    private String crsInfEndDt;
    private String crsInfDdlnDt;
    private int crsInfPrsCnt;
    // 현재 강좌 신청 인원
    private int crsCurPrsCnt;
    // 오늘이 마감일인가?; 강좌 관리 페이지에서 마감 버튼 보여줄지 말지 판단하기 위해 넣음
    private boolean deadlineToday;
    
	public boolean getDeadlineToday() {
		return deadlineToday;
	}
	public void setDeadlineToday(boolean deadlineToday) {
		this.deadlineToday = deadlineToday;
	}
	public String getCrsInfId() {
		return crsInfId;
	}
	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}
	public String getCrsInfStDt() {
		return crsInfStDt;
	}
	public void setCrsInfStDt(String crsInfStDt) {
		this.crsInfStDt = crsInfStDt;
	}
	public String getCrsInfEndDt() {
		return crsInfEndDt;
	}
	public void setCrsInfEndDt(String crsInfEndDt) {
		this.crsInfEndDt = crsInfEndDt;
	}
	public String getCrsInfNm() {
		return crsInfNm;
	}
	public void setCrsInfNm(String crsInfNm) {
		this.crsInfNm = crsInfNm;
	}
	
	public String getCrsInfDdlnDt() {
		return crsInfDdlnDt;
	}
	public void setCrsInfDdlnDt(String crsInfDdlnDt) {
		this.crsInfDdlnDt = crsInfDdlnDt;
	}
	public int getCrsInfPrsCnt() {
		return crsInfPrsCnt;
	}
	public void setCrsInfPrsCnt(int crsInfPrsCnt) {
		this.crsInfPrsCnt = crsInfPrsCnt;
	}
	public int getCrsCurPrsCnt() {
		return crsCurPrsCnt;
	}
	public void setCrsCurPrsCnt(int crsCurPrsCnt) {
		this.crsCurPrsCnt = crsCurPrsCnt;
	}
}
