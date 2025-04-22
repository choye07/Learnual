package com.learn.bbs.asgmt.vo;

import com.learn.bbs.crs.crsinf.vo.CrsInfVO;
import com.learn.bbs.crs.sbj.vo.SbjVO;
import com.learn.bbs.file.vo.FlVO;
import com.learn.bbs.usr.vo.UsrVO;

public class AsgmtHstrVO {

	private String asgmtHstrId;
	private String asgmtArtcId;
	private String asgmtHstrTtl;
	private String asgmtHstrCtt;
	private String asgmtArtcSrtDt;
	private String asgmtHstrSbmTm;
	private String asgmtHstrRgstTm;
	private String asgmtHstr_ddlnDt;
	private String asgmtHstrStat;
	private String crsInfSd;
	private String sbjId;
	private String usrId;
	private String asgmtHstrDelYn;
	private String asgmtHstrDelDt;

	private SbjVO sbj;
	private CrsInfVO crsInf;
	private UsrVO usr;

	private FlVO attachedFile;

	public String getAsgmtHstrId() {
		return asgmtHstrId;
	}

	public void setAsgmtHstrId(String asgmtHstrId) {
		this.asgmtHstrId = asgmtHstrId;
	}

	public String getAsgmtArtcId() {
		return asgmtArtcId;
	}

	public void setAsgmtArtcId(String asgmtArtcId) {
		this.asgmtArtcId = asgmtArtcId;
	}

	public String getAsgmtHstrTtl() {
		return asgmtHstrTtl;
	}

	public void setAsgmtHstrTtl(String asgmtHstrTtl) {
		this.asgmtHstrTtl = asgmtHstrTtl;
	}

	public String getAsgmtHstrCtt() {
		return asgmtHstrCtt;
	}

	public void setAsgmtHstrCtt(String asgmtHstrCtt) {
		this.asgmtHstrCtt = asgmtHstrCtt;
	}

	public String getAsgmtArtcSrtDt() {
		return asgmtArtcSrtDt;
	}

	public void setAsgmtArtcSrtDt(String asgmtArtcSrtDt) {
		this.asgmtArtcSrtDt = asgmtArtcSrtDt;
	}

	public String getAsgmtHstrSbmTm() {
		return asgmtHstrSbmTm;
	}

	public void setAsgmtHstrSbmTm(String asgmtHstrSbmTm) {
		this.asgmtHstrSbmTm = asgmtHstrSbmTm;
	}

	public String getAsgmtHstrRgstTm() {
		return asgmtHstrRgstTm;
	}

	public void setAsgmtHstrRgstTm(String asgmtHstrRgstTm) {
		this.asgmtHstrRgstTm = asgmtHstrRgstTm;
	}

	public String getAsgmtHstr_ddlnDt() {
		return asgmtHstr_ddlnDt;
	}

	public void setAsgmtHstr_ddlnDt(String asgmtHstr_ddlnDt) {
		this.asgmtHstr_ddlnDt = asgmtHstr_ddlnDt;
	}

	public String getAsgmtHstrStat() {
		return asgmtHstrStat;
	}

	public void setAsgmtHstrStat(String asgmtHstrStat) {
		this.asgmtHstrStat = asgmtHstrStat;
	}

	public String getCrsInfSd() {
		return crsInfSd;
	}

	public void setCrsInfSd(String crsInfSd) {
		this.crsInfSd = crsInfSd;
	}

	public String getSbjId() {
		return sbjId;
	}

	public void setSbjId(String sbjId) {
		this.sbjId = sbjId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getAsgmtHstrDelYn() {
		return asgmtHstrDelYn;
	}

	public void setAsgmtHstrDelYn(String asgmtHstrDelYn) {
		this.asgmtHstrDelYn = asgmtHstrDelYn;
	}

	public String getAsgmtHstrDelDt() {
		return asgmtHstrDelDt;
	}

	public void setAsgmtHstrDelDt(String asgmtHstrDelDt) {
		this.asgmtHstrDelDt = asgmtHstrDelDt;
	}

	public SbjVO getSbj() {
		return sbj;
	}

	public void setSbj(SbjVO sbj) {
		this.sbj = sbj;
	}

	public CrsInfVO getCrsInf() {
		return crsInf;
	}

	public void setCrsInf(CrsInfVO crsInf) {
		this.crsInf = crsInf;
	}

	public UsrVO getUsr() {
		return usr;
	}

	public void setUsr(UsrVO usr) {
		this.usr = usr;
	}

	public FlVO getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(FlVO attachedFile) {
		this.attachedFile = attachedFile;
	}

}
