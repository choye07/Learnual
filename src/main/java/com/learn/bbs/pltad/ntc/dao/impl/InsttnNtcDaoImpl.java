package com.learn.bbs.pltad.ntc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.pltad.ntc.dao.InsttnNtcDao;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcUpdateRequestVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcWriteRequestVO;


/**
 * @author 최예진
 * 러뉴얼 공지사항 
 */
@Repository
public class InsttnNtcDaoImpl extends SqlSessionDaoSupport implements InsttnNtcDao {

    private final String NAME_SPACE = "com.learn.bbs.pltad.ntc.dao.impl.InsttnNtcDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    // 학원 공지사항 작성
	@Override
	public int insertNewInsttnNotice(InsttnNtcWriteRequestVO insttnNtcWriteRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewInsttnNotice", insttnNtcWriteRequestVO);
	}

	// 학원 공지사항 리스트 불러오기
	@Override
	public List<InsttnNtcVO> selectInsttnNoticeAll() {
		return this.getSqlSession().selectList(NAME_SPACE + "selectInsttnNoticeAll");
	}

	// 학원 공지사항 리스트 개수 불러오기
	@Override
	public int selectInsttnNoticeAllCount() {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectInsttnNoticeAllCount");
	}
	
	// 학원 공지사항 하나 불러오기
	@Override
	public InsttnNtcVO selectOneInsttnNoticeBy(String id) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectOneInsttnNoticeBy", id);
	}

	// 학원 공지사항 하나 삭제하기
	@Override
	public int deleteOneInsttnNoticeBy(String id) {
		return this.getSqlSession().update(NAME_SPACE + "deleteOneInsttnNoticeBy", id);
	}

	// 학원 공지사항 하나 수정하기
	@Override
	public int updateOneInsttnNoticeBy(InsttnNtcUpdateRequestVO insttnNtcUpdateRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneInsttnNoticeBy", insttnNtcUpdateRequestVO);
	}

	
}