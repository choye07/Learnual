package com.learn.bbs.crs.crsinf.vo;

/**
 * 강좌 수업 시작 시간과 종료시간 VO
 */
public class CrsInfStartAndEndTimeRequestVO {

    /**
     * @ColumnName CRS_INF_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 강좌 정보를 구분할 고유한 문자열(CRS_INF-YYYYMMDD-NNNNNN)
     */
    private String crsInfId;

    /**
     * @ColumnName CRS_INF_ST_DT
     * @ColumnType DATE
     * @ColumnComment 강좌 시작 날짜
     */
    private String crsInfStDt;

    /**
     * @ColumnName CRS_INF_END_DT
     * @ColumnType DATE
     * @ColumnComment 강좌 종료 날짜
     */
    private String crsInfEndDt;

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

    
}