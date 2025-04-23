package com.learn.bbs.crs.crsinf.vo;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * 강좌 등록할 때 form에서 필수 요소값 받기위해 생성한 VO
 */

public class CrsInfRegistRequestVO {
	private String crsInfId;
	
    @NotBlank(message = "강좌명은 필수 항목입니다.")
    private String crsInfNm;

    @NotBlank(message = "강의실명은 필수 항목입니다.")
    private String crsInfCrsRoomNm;

    @NotNull(message = "수강 인원을 입력해주세요.")
    @Min(value = 1, message = "최소 수강 인원은 1명 이상이어야 합니다.")
    @Max(value = 999, message = "최대 수강 인원은 999명을 초과할 수 없습니다.")
    private int crsInfPrsCnt; // int 변환 -> js에서 빈 값일때 체크

    @NotBlank(message = "강좌 시작일은 필수 항목입니다.")
    private String crsInfStDt; // string 변환 -> 수동으로 체크

    @NotBlank(message = "강좌 종료일은 필수 항목입니다.")
    private String crsInfEndDt;

    @NotBlank(message = "신청 시작일은 필수 항목입니다.")
    private String crsInfAppDt;

    @NotBlank(message = "신청 마감일은 필수 항목입니다.")
    private String crsInfDdlnDt;

    @NotEmpty(message = "과목은 최소 1개이상 선택해야 합니다.") 
    private List<String> subjects;
    
    @NotEmpty(message = "강사는 1명 선택해야 합니다.") 
    private String instrId;
    
    private String loginId;
    
    public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getCrsInfId() {
		return crsInfId;
	}

	public void setCrsInfId(String crsInfId) {
		this.crsInfId = crsInfId;
	}

    public void setCrsInfPrsCnt(int crsInfPrsCnt) {
		this.crsInfPrsCnt = crsInfPrsCnt;
	}

	public String getCrsInfNm() {
        return crsInfNm;
    }

    public void setCrsInfNm(String crsInfNm) {
        this.crsInfNm = crsInfNm;
    }

    public String getCrsInfCrsRoomNm() {
        return crsInfCrsRoomNm;
    }

    public void setCrsInfCrsRoomNm(String crsInfCrsRoomNm) {
        this.crsInfCrsRoomNm = crsInfCrsRoomNm;
    }

    public Integer getCrsInfPrsCnt() {
        return crsInfPrsCnt;
    }

    public void setCrsInfPrsCnt(Integer crsInfPrsCnt) {
        this.crsInfPrsCnt = crsInfPrsCnt;
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

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public String getInstrId() {
		return instrId;
	}

	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}
}
