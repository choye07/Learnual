package com.learn.bbs.cnsl.vo;

import com.learn.bbs.crs.crsinf.vo.CrsInfVO;
import com.learn.bbs.crs.sbj.vo.SbjVO;
import com.learn.bbs.pltad.artc.vo.ArtcVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.bbs.usr.vo.UsrVO;


/**
 * @TableName CNSL
 * @TableComment null
 * 상담
 */
public class CnslVO {

	/**
	 * @ColumnName CNSL_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 상담 게시글의 고유한 아이디(CNSL-YYYYMMDD-NNNNNN)
	 */
	private String cnslId;

	/**
	 * @ColumnName CNSL_TTL
	 * @ColumnType VARCHAR2(100)
	 * @ColumnComment 상담 게시글의 제목
	 */
	private String cnslTtl;

	/**
	 * @ColumnName CNSL_CTT
	 * @ColumnType VARCHAR2(4000)
	 * @ColumnComment 상담 게시글의 내용
	 */
	private String cnslCtt;

	/**
	 * @ColumnName CNSL_APPLY_DT
	 * @ColumnType DATE
	 * @ColumnComment 상담 요청일
	 */
	private String cnslApplyDt;

	/**
	 * @ColumnName CNSL_FINISH_DT
	 * @ColumnType DATE
	 * @ColumnComment 상담 완료일
	 */
	private String cnslFinishDt;

	/**
	 * @ColumnName CNSL_RGST_DT
	 * @ColumnType DATE
	 * @ColumnComment 상담 정보 게시글 게시 날짜
	 */
	private String cnslRgstDt;

	/**
	 * @ColumnName CNSL_UPDT_DT
	 * @ColumnType DATE
	 * @ColumnComment 상담 정보 게시글 수정 날짜
	 */
	private String cnslUpdtDt;

	private String cnslCnclDt;
	private String cnslCnclYn;
	private String cnslInstrCncl_ctt;
	private String cnslUsrCncl_ctt;

	/**
	 * @ColumnName CNSL_COM_YN
	 * @ColumnType CHAR(1)
	 * @ColumnComment 상담 완료 여부
	 */
	private String cnslComYn;

	/**
	 * @ColumnName ARTC_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 게시판의 고유한 아이디(ARTC-YYYYMMDD-NNNNNN)
	 */
	private String artcId;

	/**
	 * @ColumnName INSTR_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 강좌 정보를 구분할 고유한 문자열(CRS_INF-YYYYMMDD-NNNNNN)
	 */
	private String instrId;

	/**
	 * @ColumnName USR_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 사용자의 고유한 아이디(USER-YYYYMMDD-NNNNNN)
	 */
	private String usrId;

	/**
	 * @ColumnName CRS_INF_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 강좌 정보를 구분할 고유한 문자열(CRS_INF-YYYYMMDD-NNNNNN)
	 */
	private String crsInfId;

	/**
	 * @ColumnName SBJ_ID
	 * @ColumnType VARCHAR2(50)
	 * @ColumnComment 과목을 구별하는 고유한 번호
	 */
	private String sbjId;

	private String cnslAnswer;

	private CrsInfVO crsInf;
	private InstrVO instr;
	private SbjVO sbj;
	private ArtcVO artc;
	private UsrVO usr;

	public String getCnslId() {
		return cnslId;
	}

	public void setCnslId(String cnslId) {
		this.cnslId = cnslId;
	}

	public String getCnslTtl() {
		return cnslTtl;
	}

	public void setCnslTtl(String cnslTtl) {
		this.cnslTtl = cnslTtl;
	}

	public String getCnslCtt() {
		return cnslCtt;
	}

	public void setCnslCtt(String cnslCtt) {
		this.cnslCtt = cnslCtt;
	}

	public String getCnslApplyDt() {
		return cnslApplyDt;
	}

	public void setCnslApplyDt(String cnslApplyDt) {
		this.cnslApplyDt = cnslApplyDt;
	}

	public String getCnslFinishDt() {
		return cnslFinishDt;
	}

	public void setCnslFinishDt(String cnslFinishDt) {
		this.cnslFinishDt = cnslFinishDt;
	}

	public String getCnslRgstDt() {
		return cnslRgstDt;
	}

	public void setCnslRgstDt(String cnslRgstDt) {
		this.cnslRgstDt = cnslRgstDt;
	}

	public String getCnslUpdtDt() {
		return cnslUpdtDt;
	}

	public void setCnslUpdtDt(String cnslUpdtDt) {
		this.cnslUpdtDt = cnslUpdtDt;
	}

	public String getCnslCnclDt() {
		return cnslCnclDt;
	}

	public void setCnslCnclDt(String cnslCnclDt) {
		this.cnslCnclDt = cnslCnclDt;
	}

	public String getCnslCnclYn() {
		return cnslCnclYn;
	}

	public void setCnslCnclYn(String cnslCnclYn) {
		this.cnslCnclYn = cnslCnclYn;
	}

	public String getCnslInstrCncl_ctt() {
		return cnslInstrCncl_ctt;
	}

	public void setCnslInstrCncl_ctt(String cnslInstrCncl_ctt) {
		this.cnslInstrCncl_ctt = cnslInstrCncl_ctt;
	}

	public String getCnslUsrCncl_ctt() {
		return cnslUsrCncl_ctt;
	}

	public void setCnslUsrCncl_ctt(String cnslUsrCncl_ctt) {
		this.cnslUsrCncl_ctt = cnslUsrCncl_ctt;
	}

	public String getCnslComYn() {
		return cnslComYn;
	}

	public void setCnslComYn(String cnslComYn) {
		this.cnslComYn = cnslComYn;
	}

	public String getArtcId() {
		return artcId;
	}

	public void setArtcId(String artcId) {
		this.artcId = artcId;
	}

	public String getInstrId() {
		return instrId;
	}

	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getCrsInfId() {
		return crsInfId;
	}

	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}

	public String getSbjId() {
		return sbjId;
	}

	public void setSbjId(String sbjId) {
		this.sbjId = sbjId;
	}

	public SbjVO getSbj() {
		return sbj;
	}

	public void setSbj(SbjVO sbj) {
		this.sbj = sbj;
	}

	public ArtcVO getArtc() {
		return artc;
	}

	public void setArtc(ArtcVO artc) {
		this.artc = artc;
	}

	public InstrVO getInstr() {
		return instr;
	}

	public void setInstr(InstrVO instr) {
		this.instr = instr;
	}

	public UsrVO getUsr() {
		return usr;
	}

	public void setUsr(UsrVO usr) {
		this.usr = usr;
	}

	public CrsInfVO getCrsInf() {
		return crsInf;
	}

	public void setCrsInf(CrsInfVO crsInf) {
		this.crsInf = crsInf;
	}

	public String getCnslAnswer() {
		return cnslAnswer;
	}

	public void setCnslAnswer(String cnslAnswer) {
		this.cnslAnswer = cnslAnswer;
	}

	@Override
	public String toString() {
		return "CnslVO(cnslId: " + cnslId + ", cnslTtl: " + cnslTtl + ", cnslCtt: " + cnslCtt + ", cnslApplyDt: "
				+ cnslApplyDt + ", cnslFinishDt: " + cnslFinishDt + ", cnslRgstDt: " + cnslRgstDt + ", cnslUpdtDt: "
				+ cnslUpdtDt + ", cnslComYn: " + cnslComYn + ", artcId: " + artcId + ", instrId: " + instrId
				+ ", usrId: " + usrId + ", crsInfId: " + crsInfId + ", sbjId: " + sbjId + ", )";
	}
}