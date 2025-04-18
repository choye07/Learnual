package com.learn.bbs.crs.crsinf.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.crs.crsinf.dao.CrsInfDao;
import com.learn.bbs.crs.crsinf.vo.CrsInfAvailableReadResponseVO;
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
	public List<CrsInfAvailableReadResponseVO> selectAvailableCourses() {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAvailableCourses");
	}


}