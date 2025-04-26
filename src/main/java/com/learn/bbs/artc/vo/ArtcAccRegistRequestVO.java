package com.learn.bbs.artc.vo;

public class ArtcAccRegistRequestVO {

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

	/**
	 * @ColumnName ARTC_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 게시판을 구분할 고유한 문자열 (ARTC-YYYYMMDD-NNNNNN)
	 */
	private String artcId;

	public ArtcAccRegistRequestVO(ArtcAccVO artcAccVO) {
		this.artcAccWr = artcAccVO.getArtcAccWr();
		this.artcAccRd = artcAccVO.getArtcAccRd();
		this.artcAccUpdt = artcAccVO.getArtcAccUpdt();
		this.artcAccDel =artcAccVO.getArtcAccDel();
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

	public String getArtcId() {
		return artcId;
	}

	public void setArtcId(String artcId) {
		this.artcId = artcId;
	}

}
