package com.learn.common.vo;



/**
 * @author 최예진
 * 사용자들 등록 시 필요한 권한 select를 위한 CM_CODE 테이블의 VO
 */
public class SesCmcdRequestVO {

    /**
     * @ColumnName CMCD_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 코드를 구별하는 고유한 번호(CM-YYYYMMDD-NNNNNN)
     */
    private String cmcdId;

    /**
     * @ColumnName HGH_RNK_CMCD_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 코드를 구별하는 상위 코드 번호
     */
    private String hghRnkCmcdId;

    /**
     * @ColumnName CMCD_NM
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 코드 이름
     */
    private String cmcdNm;
    

	public String getCmcdId() {
		return cmcdId;
	}

	public void setCmcdId(String cmcdId) {
		this.cmcdId = cmcdId;
	}

	public String getHghRnkCmcdId() {
		return hghRnkCmcdId;
	}

	public void setHghRnkCmcdId(String hghRnkCmcdId) {
		this.hghRnkCmcdId = hghRnkCmcdId;
	}

	public String getCmcdNm() {
		return cmcdNm;
	}

	public void setCmcdNm(String cmcdNm) {
		this.cmcdNm = cmcdNm;
	}

    
}
