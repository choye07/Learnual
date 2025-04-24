package com.learn.bbs.pltad.dao;

import com.learn.bbs.pltad.vo.PltadRegistRequestVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.common.vo.MyInformationRequestVO;

public interface PltAdDao {

	
	//플랫폼 관리자 등록
	public int insertNewPltad(PltadRegistRequestVO pltadRegistRequestVO);
	
	//플랫폼 관린자 등록되어 있는지 체크
	public int selectPltadCount(String lgnId);
	
    /**
     * 플랫폼 관리자 로그인 로직을 위한 dao start
     */

    // 이메일 중복 체크
    public int selectUsrCountBy (String pltadmLgnId);

    // 이메일로 조회시 모든 정보를 가져옴.
    public PltadmVO selectOneUsrBy(String pltadmLgnId);

    // 사용자의 로그인 시도시 실패 횟수
    public int updateLoginFailCount(String pltadmLgnId);

    // 5회 이상 로그인 실패시 잠금
    public int updateBlock(String pltadmLgnId);

    // 로그인 성공 상태.
    public int updateLoginSuccess(String pltadmLgnId);

    // 로그아웃 상태로 변경.
    public int updateLogoutStatus(String pltadmLgnId);

    // 이메일 계정 삭제.
    // -> 물리적 삭제가 아닌 삭제 여부를 'Y'로 변경 후 변경된 당일 날짜 등록.
    public int deleteOneUsrBy(String pltadmLgnId);

    // 이메일 계정으로 관리자 정보 수정.
    //	-> 비밀번호, 이름, 전화번호, 주소를 입력하지 않을 시 변경 X.
    public int updateOneUsrEditMyinformation(MyInformationRequestVO myInfromationRequestVO);
    /**
     * 로그인 로직을 위한 dao end
     */
}