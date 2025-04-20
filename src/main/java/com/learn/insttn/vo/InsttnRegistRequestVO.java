package com.learn.insttn.vo;

public class InsttnRegistRequestVO {
	
	
    /**
     * @ColumnName INSTTN_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 기관(학원) 정보의 고유한 아이디(INSTTN-YYYYMMDD-NNNNNN)
     */
    private String insttnId;
	/**
     * @ColumnName INSTTN_NM
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 기관(학원)의 이름
     */
    private String insttnNm;

    /**
     * @ColumnName INSTTN_BSNS_NB
     * @ColumnType VARCHAR2(20)
     * @ColumnComment 기관(학원)의 사업자 번호
     */
    private String insttnBsnsNb;

    /**
     * @ColumnName INSTTN_CEO_NM
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 기관(학원)의 대표
     */
    private String insttnCeoNm;

    /**
     * @ColumnName INSTTN_ADRS
     * @ColumnType VARCHAR2(200)
     * @ColumnComment 기관(학원)의 주소
     */
    private String insttnAdrs;

    /**
     * @ColumnName INSTTN_PN
     * @ColumnType VARCHAR2(20)
     * @ColumnComment 기관(학원)의 전화번호
     */
    private String insttnPn;

    
	public String getInsttnId() {
		return insttnId;
	}

	public void setInsttnId(String insttnId) {
		this.insttnId = insttnId;
	}

	public String getInsttnNm() {
		return insttnNm;
	}

	public void setInsttnNm(String insttnNm) {
		this.insttnNm = insttnNm;
	}

	public String getInsttnBsnsNb() {
		return insttnBsnsNb;
	}

	public void setInsttnBsnsNb(String insttnBsnsNb) {
		this.insttnBsnsNb = insttnBsnsNb;
	}

	public String getInsttnCeoNm() {
		return insttnCeoNm;
	}

	public void setInsttnCeoNm(String insttnCeoNm) {
		this.insttnCeoNm = insttnCeoNm;
	}

	public String getInsttnAdrs() {
		return insttnAdrs;
	}

	public void setInsttnAdrs(String insttnAdrs) {
		this.insttnAdrs = insttnAdrs;
	}

	public String getInsttnPn() {
		return insttnPn;
	}

	public void setInsttnPn(String insttnPn) {
		this.insttnPn = insttnPn;
	}
    
    
    

}
