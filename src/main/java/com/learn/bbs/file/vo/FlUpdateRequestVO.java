package com.learn.bbs.file.vo;

public class FlUpdateRequestVO {
	
    /**
     * @ColumnName FL_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 파일 아이디(시퀀스 번호)
     */
    private String flId;

    /**
     * @ColumnName FL_NM
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 원본 파일 이름
     */
    private String flNm;

    /**
     * @ColumnName FL_OBFS_NM
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 난독화된 파일 이름
     */
    private String flObfsNm;

    /**
     * @ColumnName FL_OBFS_PTH
     * @ColumnType VARCHAR2(2083)
     * @ColumnComment 난독화된 파일 경로
     */
    private String flObfsPth;

    /**
     * @ColumnName FL_SZ
     * @ColumnType NUMBER(, )
     * @ColumnComment 파일 크기
     */
    private long flSz;
    
    /**
     * @ColumnName FL_TYPE_NM
     * @ColumnType VARCHAR2(5)
     * @ColumnComment 파일 확장자명(기존 확장자)
     */
    private String flTypeNm;

    /**
     * @ColumnName ARTC_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 게시판을 구분할 고유한 문자열
     */
    private String artcId;

    /**
     * @ColumnName ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 게시글 id, insert 과정 간소화 때문에 미리 발급해야한다.
     */
    private String id;

	public String getFlId() {
		return flId;
	}

	public void setFlId(String flId) {
		this.flId = flId;
	}

	public String getFlNm() {
		return flNm;
	}

	public void setFlNm(String flNm) {
		this.flNm = flNm;
	}

	public String getFlObfsNm() {
		return flObfsNm;
	}

	public void setFlObfsNm(String flObfsNm) {
		this.flObfsNm = flObfsNm;
	}

	public String getFlObfsPth() {
		return flObfsPth;
	}

	public void setFlObfsPth(String flObfsPth) {
		this.flObfsPth = flObfsPth;
	}

	public long getFlSz() {
		return flSz;
	}

	public void setFlSz(long flSz) {
		this.flSz = flSz;
	}

	public String getFlTypeNm() {
		return flTypeNm;
	}

	public void setFlTypeNm(String flTypeNm) {
		this.flTypeNm = flTypeNm;
	}

	public String getArtcId() {
		return artcId;
	}

	public void setArtcId(String artcId) {
		this.artcId = artcId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
