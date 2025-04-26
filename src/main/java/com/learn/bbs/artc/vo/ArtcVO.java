package com.learn.bbs.artc.vo;

import java.util.List;

/**
 * @TableName ARTC
 * @TableComment null
 */
public class ArtcVO {

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
     * @ColumnName ARTC_UPDT_DT
     * @ColumnType DATE
     * @ColumnComment 게시판 수정 날짜
     */
    private String artcUpdtDt;

    /**
     * @ColumnName ARTC_DEL_DT
     * @ColumnType DATE
     * @ColumnComment 게시판 삭제 날짜
     */
    private String artcDelDt;

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
    
    
    private ArtcAccVO artcAccVO;
    
    private List<ArtcAccVO> artcAccList;
    
    

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

	public String getArtcId() {
        return this.artcId;
    }
    
    public void setArtcId(String artcId) {
        this.artcId = artcId;
    }
    
    public String getArtcNm() {
        return this.artcNm;
    }
    
    public void setArtcNm(String artcNm) {
        this.artcNm = artcNm;
    }
    
    public String getArtcUsYn() {
        return this.artcUsYn;
    }
    
    public void setArtcUsYn(String artcUsYn) {
        this.artcUsYn = artcUsYn;
    }
    
    public String getArtcFlYn() {
        return this.artcFlYn;
    }
    
    public void setArtcFlYn(String artcFlYn) {
        this.artcFlYn = artcFlYn;
    }
    
    public String getArtcUrlYn() {
        return this.artcUrlYn;
    }
    
    public void setArtcUrlYn(String artcUrlYn) {
        this.artcUrlYn = artcUrlYn;
    }
    
    public String getArtcRgstDt() {
        return this.artcRgstDt;
    }
    
    public void setArtcRgstDt(String artcRgstDt) {
        this.artcRgstDt = artcRgstDt;
    }
    
    public String getArtcUpdtDt() {
        return this.artcUpdtDt;
    }
    
    public void setArtcUpdtDt(String artcUpdtDt) {
        this.artcUpdtDt = artcUpdtDt;
    }
    
    public String getArtcDelDt() {
        return this.artcDelDt;
    }
    
    public void setArtcDelDt(String artcDelDt) {
        this.artcDelDt = artcDelDt;
    }
    
    public String getArtcDelYn() {
        return this.artcDelYn;
    }
    
    public void setArtcDelYn(String artcDelYn) {
        this.artcDelYn = artcDelYn;
    }
    
    public String getInsttnId() {
        return this.insttnId;
    }
    
    public void setInsttnId(String insttnId) {
        this.insttnId = insttnId;
    }
    
    public String getCrsInfId() {
        return this.crsInfId;
    }
    
    public void setCrsInfId(String crsInfId) {
        this.crsInfId = crsInfId;
    }
    
    @Override
    public String toString() {
        return "ArtcVO(artcId: " + artcId + ", artcNm: " + artcNm + ", artcUsYn: " + artcUsYn + ", artcFlYn: " + artcFlYn + ", artcUrlYn: " + artcUrlYn + ", artcRgstDt: " + artcRgstDt + ", artcUpdtDt: " + artcUpdtDt + ", artcDelDt: " + artcDelDt + ", artcDelYn: " + artcDelYn + ", insttnId: " + insttnId + ", crsInfId: " + crsInfId + ", )";
    }
}