package com.learn.bbs.crs.crsinf.vo;

import java.util.List;

import com.learn.bbs.eduad.crclm.vo.CrclmSbjVO;
import com.learn.bbs.eduad.crclm.vo.CrclmVO;

public class CrsInfDetailReadResponseVO {
    private String crsInfId;
    private String crsInfNm;
    private String crsInfStDt;
    private String crsInfEndDt;
    private String crsInfAppDt;
    private String crsInfDdlnDt;
    private String crsInfDdlnYn;
    private String crsInfAbdnYn;
    private String crsInfCrsRoomNm;

    // 커리큘럼 리스트 -> 한 강좌에 여러 커리큘럼이 있을 수도 있기에 List로 받아와야함
    private List<CrclmSbjVO> curriculumList;

	public String getCrsInfId() {
		return crsInfId;
	}

	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}

	public String getCrsInfNm() {
		return crsInfNm;
	}

	public void setCrsInfNm(String crsInfNm) {
		this.crsInfNm = crsInfNm;
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

	public String getCrsInfAppDt() {
		return crsInfAppDt;
	}

	public void setCrsInfAppDt(String crsInfAppDt) {
		this.crsInfAppDt = crsInfAppDt;
	}

	public String getCrsInfDdlnDt() {
		return crsInfDdlnDt;
	}

	public void setCrsInfDdlnDt(String crsInfDdlnDt) {
		this.crsInfDdlnDt = crsInfDdlnDt;
	}

	public String getCrsInfCrsRoomNm() {
		return crsInfCrsRoomNm;
	}

	public void setCrsInfCrsRoomNm(String crsInfCrsRoomNm) {
		this.crsInfCrsRoomNm = crsInfCrsRoomNm;
	}

	public List<CrclmSbjVO> getCurriculumList() {
		return curriculumList;
	}

	public void setCurriculumList(List<CrclmSbjVO> curriculumList) {
		this.curriculumList = curriculumList;
	}

	public String getCrsInfAbdnYn() {
		return crsInfAbdnYn;
	}

	public void setCrsInfAbdnYn(String crsInfAbdnYn) {
		this.crsInfAbdnYn = crsInfAbdnYn;
	}

	public String getCrsInfDdlnYn() {
		return crsInfDdlnYn;
	}

	public void setCrsInfDdlnYn(String crsInfDdlnYn) {
		this.crsInfDdlnYn = crsInfDdlnYn;
	}
}
