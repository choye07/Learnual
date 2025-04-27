package com.learn.bbs.rsm.vo;

import org.springframework.web.multipart.MultipartFile;

import com.learn.bbs.file.vo.FlVO;

/**
 * @TableName RSM
 * @TableComment null 이력서
 */
public class RsmVO {

	/**
	 * @ColumnName RSM_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 이력서의 고유한 아이디
	 */
	private String rsmId;

	/**
	 * @ColumnName RSM_TTL
	 * @ColumnType VARCHAR2(100)
	 * @ColumnComment 이력서 제목
	 */
	private String rsmTtl;

	/**
	 * @ColumnName RSM_RGST_DT
	 * @ColumnType DATE
	 * @ColumnComment 이력서 등록 날짜
	 */
	private String rsmRgstDt;

	/**
	 * @ColumnName RSM_UPDT_DT
	 * @ColumnType DATE
	 * @ColumnComment 이력서 수정 날짜
	 */
	private String rsmUpdtDt;

	/**
	 * @ColumnName RSM_DEL_DT
	 * @ColumnType DATE
	 * @ColumnComment 이력서 삭제 날짜
	 */
	private String rsmDelDt;

	/**
	 * @ColumnName RSM_DEL_YN
	 * @ColumnType CHAR(1)
	 * @ColumnComment 이력서 삭제 여부
	 */
	private String rsmDelYn;

	// 회원 아이디 = 회원 세션 아이디 usrMl;
	private String usrId;

	
	// 저장된 이력서 파일
	private FlVO file;
	

	/**
	 * @ColumnName ARTC_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 게시판을 구분할 고유한 문자열
	 */
	private String artcId;

	public String getRsmId() {
		return this.rsmId;
	}

	public void setRsmId(String rsmId) {
		this.rsmId = rsmId;
	}

	public String getRsmTtl() {
		return this.rsmTtl;
	}

	public void setRsmTtl(String rsmTtl) {
		this.rsmTtl = rsmTtl;
	}

	public String getRsmRgstDt() {
		return this.rsmRgstDt;
	}

	public void setRsmRgstDt(String rsmRgstDt) {
		this.rsmRgstDt = rsmRgstDt;
	}

	public String getRsmUpdtDt() {
		return this.rsmUpdtDt;
	}

	public void setRsmUpdtDt(String rsmUpdtDt) {
		this.rsmUpdtDt = rsmUpdtDt;
	}

	public String getRsmDelDt() {
		return this.rsmDelDt;
	}

	public void setRsmDelDt(String rsmDelDt) {
		this.rsmDelDt = rsmDelDt;
	}

	public String getRsmDelYn() {
		return this.rsmDelYn;
	}

	public void setRsmDelYn(String rsmDelYn) {
		this.rsmDelYn = rsmDelYn;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getArtcId() {
		return this.artcId;
	}

	public void setArtcId(String artcId) {
		this.artcId = artcId;
	}
	

	public FlVO getFile() {
		return file;
	}

	public void setFile(FlVO file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "RsmVO(rsmId: " + rsmId + ", rsmTtl: " + rsmTtl + " , rsmRgstDt: " + rsmRgstDt
				+ ", rsmUpdtDt: " + rsmUpdtDt + ", rsmDelDt: " + rsmDelDt + ", rsmDelYn: " + rsmDelYn + ", usrId: "
				+ usrId + ", artcId: " + artcId  + ",file: " + file;
	}
}