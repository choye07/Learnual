package com.learn.bbs.menu.vo;

import java.util.List;

import com.learn.main.cmcd.vo.CmCodeVO;

import jakarta.validation.constraints.NotEmpty;

/**
 * @TableName MENU
 * @TableComment null
 */
public class MenuRegistRequestVO {

    /**
     * @ColumnName MENU_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 메뉴를 구별하는 고유한 번호(MENU-YYYYMMDD-NNNNNN)
     */
    private String menuId;

    /**
     * @ColumnName MENU_NM
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 메뉴 이름
     */
    @NotEmpty(message = "메뉴 명을 입력해주세요.")
    private String menuNm;

    /**
     * @ColumnName MENU_URL
     * @ColumnType VARCHAR2(100)
     * @ColumnComment 메뉴 URL
     */
    @NotEmpty(message = "메뉴 url을 입력해주세요.")
    private String menuUrl;

    /**
     * @ColumnName MENU_RGST_DT
     * @ColumnType DATE
     * @ColumnComment 메뉴 등록 날짜
     */
    private String menuRgstDt;
    /**
     * @ColumnName MENU_DEL_YN
     * @ColumnType CHAR(1)
     * @ColumnComment 메뉴 삭제 여부
     */
    private String menuDelYn;

    /**
     * @ColumnName INSTTN_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 기관(학원) 정보의 고유한 아이디(INSTTN-YYYYMMDD-NNNNNN)
     */
    private String insttnId;

    /**
     * @ColumnName MENU_HGH_RNK_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 상위 메뉴 아이디
     */
    private String menuHghRnkId;

    /**
     * @ColumnName MENU_ACC
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 메뉴 접근 권한
     */
    @NotEmpty(message = "접근 권한을 체크해주세요.")
    private String menuAcc;

    /**
     * @ColumnName MENU_US_YN
     * @ColumnType VARCHAR2(1)
     * @ColumnComment 메뉴 사용 여부
     */
    @NotEmpty(message = "사용 여부를 체크해주세요.")
    private String menuUsYn;

    /**
     * @ColumnName CRS_INF_ID
     * @ColumnType VARCHAR2(50)
     * @ColumnComment 강좌 정보를 구분할 고유한 문자열(CRS_INF-YYYYMMDD-NNNNNN)
     */
    private String crsInfId;
    
    private List<CmCodeVO> cmCdList;
    
    
    

    public List<CmCodeVO> getCmCdList() {
		return cmCdList;
	}

	public void setCmCdList(List<CmCodeVO> cmCdList) {
		this.cmCdList = cmCdList;
	}

	public String getMenuId() {
        return this.menuId;
    }
    
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
    
    public String getMenuNm() {
        return this.menuNm;
    }
    
    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }
    
    public String getMenuUrl() {
        return this.menuUrl;
    }
    
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
    
    public String getMenuRgstDt() {
        return this.menuRgstDt;
    }
    
    public void setMenuRgstDt(String menuRgstDt) {
        this.menuRgstDt = menuRgstDt;
    }
    

    public String getMenuDelYn() {
        return this.menuDelYn;
    }
    
    public void setMenuDelYn(String menuDelYn) {
        this.menuDelYn = menuDelYn;
    }
    
    public String getInsttnId() {
        return this.insttnId;
    }
    
    public void setInsttnId(String insttnId) {
        this.insttnId = insttnId;
    }
    
    public String getMenuHghRnkId() {
        return this.menuHghRnkId;
    }
    
    public void setMenuHghRnkId(String menuHghRnkId) {
        this.menuHghRnkId = menuHghRnkId;
    }
    
    public String getMenuAcc() {
        return this.menuAcc;
    }
    
    public void setMenuAcc(String menuAcc) {
        this.menuAcc = menuAcc;
    }
    
    public String getMenuUsYn() {
        return this.menuUsYn;
    }
    
    public void setMenuUsYn(String menuUsYn) {
        this.menuUsYn = menuUsYn;
    }
    
    public String getCrsInfId() {
        return this.crsInfId;
    }
    
    public void setCrsInfId(String crsInfId) {
        this.crsInfId = crsInfId;
    }
    
    @Override
    public String toString() {
        return "MenuVO(menuId: " + menuId + ", menuNm: " + menuNm + ", menuUrl: " + menuUrl + ", menuRgstDt: " + menuRgstDt+ ", menuDelYn: " + menuDelYn + ", insttnId: " + insttnId + ", menuHghRnkId: " + menuHghRnkId + ", menuAcc: " + menuAcc + ", menuUsYn: " + menuUsYn + ", crsInfId: " + crsInfId + ", )";
    }
}