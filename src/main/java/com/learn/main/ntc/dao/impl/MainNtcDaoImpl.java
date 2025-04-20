package com.learn.main.ntc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.main.ntc.dao.MainNtcDao;
import com.learn.main.ntc.vo.NtcListVO;
import com.learn.main.ntc.vo.NtcVO;
import com.learn.main.ntc.vo.NtcWriteRequestVO;


/**
 * @author 최예진
 * 러뉴얼 공지사항 
 */
@Repository
public class MainNtcDaoImpl extends SqlSessionDaoSupport implements MainNtcDao {

    private final String NAME_SPACE = "com.learn.main.ntc.dao.impl.MainNtcDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    // 1. 메인 공지사항 작성
	@Override
	public int insertNewMainNotice(NtcWriteRequestVO ntcWriteRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewMainNotice", ntcWriteRequestVO);
	}

	// 2. 메인 공지사항 개수 가져오기
	@Override
	public int selectMainNoticeAllCount() {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectMainNoticeAllCount");
	}

	// 2. 메인 공지사항 리스트 가져오기
	@Override
	public List<NtcVO> selectMainNoticeAll() {
		return this.getSqlSession().selectList(NAME_SPACE + "selectMainNoticeAll");
	}

	// 3. 메인 러뉴얼 공지사항 하나 가져오기
	@Override
	public NtcVO selecOneMainNotice(String id) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selecOneMainNotice", id);
	}

	// 4. 메인 러뉴얼 공지사항 하나 삭제하기
	@Override
	public int deleteOneMainNotice(String id) {
		return this.getSqlSession().update(NAME_SPACE + "deleteOneMainNotice", id);
	}

	// 5. 메인 러뉴얼 공지사항 하나 수정하기
	@Override
	public int updateOneMainNoticeBy(String id) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneMainNoticeBy", id);
	}
	
}