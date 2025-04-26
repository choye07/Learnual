package com.learn.bbs.artc.vo;

import java.util.List;

public class ArtcRegistRequestVO {
	
	  /**
     * @ColumnName ARTC_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 게시판을 구분할 고유한 문자열 (ARTC-YYYYMMDD-NNNNNN)
     */
    private String artcId;

    /**
     * @ColumnName ARTC_NM
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 게시판의 이름
     */
    private String artcNm;

    /**
     * @ColumnName ARTC_US_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 게시판 사용 여부
     */
    private String artcUsYn;
    /**
     * @ColumnName ARTC_FL_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 게시판 첨부 파일 사용 여부
     */
    private String artcFlYn;

    /**
     * @ColumnName ARTC_URL_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 게시판 URL 첨부 여부
     */
    private String artcUrlYn;

    /**
     * @ColumnName ARTC_RGST_DT
     * @ColumnType DATE
     * @ColumnComment 게시판 등록 날짜
     */
    private String artcRgstDt;
    

    /**
     * @ColumnName ARTC_DEL_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 게시판 삭제 여부
     */
    private String artcDelYn;

    /**
     * @ColumnName INSTTN_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 기관(학원) 정보의 고유한 아이디(INSTTN-YYYYMMDD-NNNNNN)
     */
    private String insttnId;

    /**
     * @ColumnName CRS_INF_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 강좌 정보를 구분할 고유한 문자열(CRS_INF-YYYYMMDD-NNNNNN)
     */
    private String crsInfId;
    
    /**
     * @ColumnName ARTC_ACC_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 게시판 권한을 식별할 고유한 번호(ARTAC-YYYYMMDD-NNNNNN)
     */
    private String artcAccId;

    /**
     * @ColumnName ARTC_ACC_WR
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 현 게시판에 글을 쓸 수 있는 권한
     */
    private String artcAccWr;

    /**
     * @ColumnName ARTC_ACC_RD
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 현 게시판에 글을 읽을 수 있는 권한
     */
    private String artcAccRd;

    /**
     * @ColumnName ARTC_ACC_UPDT
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 현 게시판에 글을 수정할 수 있는 권한
     */
    private String artcAccUpdt;

    /**
     * @ColumnName ARTC_ACC_DEL
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 현 게시판에 글을 삭제할 수 있는 권한
     */
    private String artcAccDel;

    
    private ArtcAccVO artcAccVO;
    
    private List<ArtcAccVO> artcAccList;

	public String getArtcId() {
		return artcId;
	}

	public void setArtcId(String artcId) {
		this.artcId = artcId;
	}

	public String getArtcNm() {
		return artcNm;
	}

	public void setArtcNm(String artcNm) {
		this.artcNm = artcNm;
	}

	public String getArtcUsYn() {
		return artcUsYn;
	}

	public void setArtcUsYn(String artcUsYn) {
		this.artcUsYn = artcUsYn;
	}

	public String getArtcFlYn() {
		return artcFlYn;
	}

	public void setArtcFlYn(String artcFlYn) {
		this.artcFlYn = artcFlYn;
	}

	public String getArtcUrlYn() {
		return artcUrlYn;
	}

	public void setArtcUrlYn(String artcUrlYn) {
		this.artcUrlYn = artcUrlYn;
	}

	public String getArtcRgstDt() {
		return artcRgstDt;
	}

	public void setArtcRgstDt(String artcRgstDt) {
		this.artcRgstDt = artcRgstDt;
	}

	public String getArtcDelYn() {
		return artcDelYn;
	}

	public void setArtcDelYn(String artcDelYn) {
		this.artcDelYn = artcDelYn;
	}

	public String getInsttnId() {
		return insttnId;
	}

	public void setInsttnId(String insttnId) {
		this.insttnId = insttnId;
	}

	public String getCrsInfId() {
		return crsInfId;
	}

	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}

	public ArtcAccVO getArtcAccVO() {
		return artcAccVO;
	}

	public void setArtcAccVO(ArtcAccVO artcAccVO) {
		this.artcAccVO = artcAccVO;
	}

	public List<ArtcAccVO> getArtcAccList() {
		return artcAccList;
	}

	public void setArtcAccList(List<ArtcAccVO> artcAccList) {
		this.artcAccList = artcAccList;
	}

	public String getArtcAccId() {
		return artcAccId;
	}

	public void setArtcAccId(String artcAccId) {
		this.artcAccId = artcAccId;
	}

	public String getArtcAccWr() {
		return artcAccWr;
	}

	public void setArtcAccWr(String artcAccWr) {
		this.artcAccWr = artcAccWr;
	}

	public String getArtcAccRd() {
		return artcAccRd;
	}

	public void setArtcAccRd(String artcAccRd) {
		this.artcAccRd = artcAccRd;
	}

	public String getArtcAccUpdt() {
		return artcAccUpdt;
	}

	public void setArtcAccUpdt(String artcAccUpdt) {
		this.artcAccUpdt = artcAccUpdt;
	}

	public String getArtcAccDel() {
		return artcAccDel;
	}

	public void setArtcAccDel(String artcAccDel) {
		this.artcAccDel = artcAccDel;
	}

	
}
