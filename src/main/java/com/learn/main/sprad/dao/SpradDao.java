package com.learn.main.sprad.dao;

import com.learn.main.sprad.vo.SpradRegistRequestVO;
import com.learn.main.sprad.vo.SpradmVO;

public interface SpradDao {
	
	/**
	 * 슈퍼 관리자 등록
	 * @param spradRegistRequestVO
	 * @return
	 */
	public int createNewSprad(SpradRegistRequestVO spradRegistRequestVO);
	
	/**
     * 강사 로그인 로직을 위한 dao start
	 * @param SpradId
	 * @return
	 */
	// 이메일 중복 체크
	public int selectUsrCountBy(String spradId);

    // 이메일로 조회시 모든 정보를 가져옴.
    public SpradmVO selectOneUsrBy(String spradId);

    // 슈퍼관리자의 로그인 시도시 실패 횟수
    public int updateLoginFailCount(String spradId);

    // 5회 이상 로그인 실패시 잠금
    public int updateBlock(String spradId);

    // 로그인 성공 상태.
    public int updateLoginSuccess(String spradId);

    // 로그아웃 상태로 변경.
    public int updateLogoutStatus(String spradId);

    // 이메일 계정 삭제.
    // -> 물리적 삭제가 아닌 삭제 여부를 'Y'로 변경 후 변경된 당일 날짜 등록.
    public int deleteOneUsrBy(String spradId);

    // 이메일 계정으로 나의 정보 수정.
    //	-> 비밀번호, 이름, 전화번호, 주소를 입력하지 않을 시 변경 X.
    //public int updateOneUsrEditMyinformation(UsrEditMyinformationVO usrEditMyinformationVO);
    /**
     * 강사 로직을 위한 dao end
     */

}