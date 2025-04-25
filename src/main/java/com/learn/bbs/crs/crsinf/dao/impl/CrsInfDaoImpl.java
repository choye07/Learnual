package com.learn.bbs.crs.crsinf.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.crs.crsinf.dao.CrsInfDao;
import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAbandonUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfDetailReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;


/**
 * @TableName CRS_INF
 * @TableComment null
 * 강좌 정보
 */
@Repository
public class CrsInfDaoImpl extends SqlSessionDaoSupport implements CrsInfDao {

    private final String NAME_SPACE = "com.learn.bbs.crs.crsinf.dao.impl.CrsInfDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int insertOneCourse(CrsInfRegistRequestVO crsInfRegistRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertOneCourse", crsInfRegistRequestVO);
	}

	@Override
	public int countCourseName(String crsInfNm) {
		return this.getSqlSession().selectOne(NAME_SPACE + "countCourseName", crsInfNm);
	}
	
	@Override
	public String selectCourseName(String crsInfId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectCourseName", crsInfId);
	}

	@Override
	public List<CrsInfPltadReadResponseVO> selectAllCourseForPltad() {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllCourseForPltad");
	}

	@Override
	public List<CrsInfPltadFinishedReadResponseVO> selectAllFinishedCourseForPltad() {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllFinishedCourseForPltad");
	}

	@Override
	public int updateOneCourse(CrsInfModifyRequestVO crsInfUpdateRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneCourse", crsInfUpdateRequestVO);
	}

	@Override
	public CrsInfModifyRequestVO selectAllInfoFromOneCourse(String crsInfId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectAllInfoFromOneCourse", crsInfId);
	}

	@Override
	public int deleteOneCourse(String crsInfId) {
		return this.getSqlSession().update(NAME_SPACE + "deleteOneCourse", crsInfId);
	}

	@Override
	public List<CrsInfAvailableReadResponseVO> selectAvailableCoursesForUser() {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAvailableCoursesForUser");
	}
	

	@Override
	public List<CrsInfAvailableReadResponseVO> selectAvailableFourCoursesForUser() {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAvailableFourCoursesForUser");
	}
	
	@Override
	public List<CrsInfAvailableReadResponseVO> selectMyCourseForUser(String usrMl) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectMyCourseForUser", usrMl);
	}

	@Override
	public CrsInfDetailReadResponseVO selectCourseDetail(String crsInfId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectCourseDetail", crsInfId);
	}

	@Override
	public int endOneCourse(String crsInfId) {
		return this.getSqlSession().update(NAME_SPACE + "endOneCourse", crsInfId);
	}

	@Override
	public int abandonOneCourse(CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "abandonOneCourse", crsInfAbandonUpdateRequestVO.getCrsInfId());
	}

	@Override
	public List<CrsInfAbandonReadResponseVO> selectAbandonCourse() {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAbandonCourse");
	}

	@Override
	public int selectLimitedCount(String crsInfId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectLimitedCount", crsInfId);
	}
}