package com.learn.bbs.pltad.crssbj.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.pltad.crssbj.dao.CrsSbjDao;
import com.learn.bbs.pltad.crssbj.vo.CrsSbjRegistRequestVO;


/**
 * @TableName CRS_SBJ
 * @TableComment null
 * 강좌 과목
 */
@Repository
public class CrsSbjDaoImpl extends SqlSessionDaoSupport implements CrsSbjDao {

    private final String NAME_SPACE = "com.learn.bbs.pltad.crssbj.dao.impl.CrsSbjDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int insertOneCourseSubject(CrsSbjRegistRequestVO crsSbjRegistRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertOneCourseSubject", crsSbjRegistRequestVO);
	}

	@Override
	public int deleteCourseSubject(String crsInfId) {
		return this.getSqlSession().delete(NAME_SPACE + "deleteCourseSubject", crsInfId);
	}

	@Override
	public List<CrsSbjRegistRequestVO> selectSubjectList(String crsInfId) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectSubjectList", crsInfId);
	}
}