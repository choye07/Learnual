package com.learn.bbs.pltad.crssbj.vo;

/**
 * @TableName CRS_SBJ
 * @TableComment null
 * 강좌 과목
 */
public class CrsSbjVO {

    /**
     * @ColumnName CRS_INF_ID2
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 강좌 정보를 구분할 고유한 문자열(CRS_INF-YYYYMMDD-NNNNNN)
     */
    private String crsInfId2;

    /**
     * @ColumnName SBJ_ID2
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 과목을 구별하는 고유한 번호
     */
    private String sbjId2;

    public String getCrsInfId2() {
        return this.crsInfId2;
    }
    
    public void setCrsInfId2(String crsInfId2) {
        this.crsInfId2 = crsInfId2;
    }
    
    public String getSbjId2() {
        return this.sbjId2;
    }
    
    public void setSbjId2(String sbjId2) {
        this.sbjId2 = sbjId2;
    }
    
    @Override
    public String toString() {
        return "CrsSbjVO(crsInfId2: " + crsInfId2 + ", sbjId2: " + sbjId2 + ", )";
    }
}