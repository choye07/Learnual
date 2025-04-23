package com.learn.bbs.eduad.crntc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.eduad.crntc.dao.CrNtcDao;
import com.learn.bbs.eduad.crntc.vo.CrntcUpdateRequestVO;
import com.learn.bbs.eduad.crntc.vo.CrntcVO;
import com.learn.bbs.eduad.crntc.vo.CrntcWriteRequestVO;



/**
 * @author 최예진
 *  강좌 공지사항
 */
@Repository
public class CrNtcDaoImpl extends SqlSessionDaoSupport implements CrNtcDao {

    private final String NAME_SPACE = "com.learn.bbs.eduad.crntc.dao.impl.CrNtcDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public List<CrntcVO> selectCourseNoticeAll() {
		return this.getSqlSession().selectList(NAME_SPACE + "selectCourseNoticeAll");
	}

	@Override
	public int selectCourseNoticeAllCount() {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectCourseNoticeAllCount");
	}

	@Override
	public int insertNewCourseNotice(CrntcWriteRequestVO crntcWriteRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewCourseNotice", crntcWriteRequestVO);
	}

	@Override
	public CrntcVO selectOneCourseNoticeBy(String id) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectOneCourseNoticeBy", id);
	}

	@Override
	public int deleteOneCourseNoticeBy(String id) {
		return this.getSqlSession().update(NAME_SPACE + "deleteOneCourseNoticeBy", id);
	}

	@Override
	public int updateOneCourseNoticeBy(CrntcUpdateRequestVO crntcUpdateRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneCourseNoticeBy", crntcUpdateRequestVO);
	}


}