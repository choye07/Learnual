package com.learn.bbs.pltad.instr.dao;

import java.util.List;

import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;

/**
 * @TableName INSTR
 * @TableComment null
 * 강사
 */
public interface InstrDao {
	
	public int insertNewInstr(InstrRegistRequestVO instrRegistRequestVO);
	
	/**
     * 강사 로그인 로직을 위한 dao start
     */

    // 이메일 중복 체크
    public int selectUsrCountBy (String instrLgnId);

    // 이메일로 조회시 모든 정보를 가져옴.
    public InstrVO selectOneUsrBy(String instrLgnId);

    // 사용자의 로그인 시도시 실패 횟수
    public int updateLoginFailCount(String instrLgnId);

    // 5회 이상 로그인 실패시 잠금
    public int updateBlock(String instrLgnId);

    // 로그인 성공 상태.
    public int updateLoginSuccess(String instrLgnIdß);

    // 로그아웃 상태로 변경.
    public int updateLogoutStatus(String instrLgnId);

    // 이메일 계정 삭제.
    // -> 물리적 삭제가 아닌 삭제 여부를 'Y'로 변경 후 변경된 당일 날짜 등록.
    public int deleteOneUsrBy(String instrLgnId);

    // 이메일 계정으로 나의 정보 수정.
    //	-> 비밀번호, 이름, 전화번호, 주소를 입력하지 않을 시 변경 X.
    //public int updateOneUsrEditMyinformation(UsrEditMyinformationVO usrEditMyinformationVO);
    /**
     * 강사 로직을 위한 dao end
     */
    
    // 모든 강사를 불러옴; 강좌 개설 & 수정 필요
    public List<InstrVO> selectAllInstrs();
    
    public String selectOneInstrName(String crsInfId);

}