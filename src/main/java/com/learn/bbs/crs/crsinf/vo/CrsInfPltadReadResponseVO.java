package com.learn.bbs.crs.crsinf.vo;

public class CrsInfPltadReadResponseVO extends CrsInfVO {
	// 현재 강좌 신청 이력의 인원
    private int crsCurAppCnt;
    // 현재 강좌 취소 이력의 인원
    private int crsCurCnclCnt;
    // 현재 강좌 신청 인원
    private int crsCurPrsCnt;
    // 현재 강좌의 상태(수강신청 전, 수강신청 중, 마감가능, 폐강가능, 마감중, 수강완료)
    private String status;

	public int getCrsCurAppCnt() {
		return crsCurAppCnt;
	}

	public void setCrsCurAppCnt(int crsCurAppCnt) {
		this.crsCurAppCnt = crsCurAppCnt;
	}

	public int getCrsCurCnclCnt() {
		return crsCurCnclCnt;
	}

	public void setCrsCurCnclCnt(int crsCurCnclCnt) {
		this.crsCurCnclCnt = crsCurCnclCnt;
	}

	public int getCrsCurPrsCnt() {
		return crsCurPrsCnt;
	}

	public void setCrsCurPrsCnt(int crsCurPrsCnt) {
		this.crsCurPrsCnt = crsCurPrsCnt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}
