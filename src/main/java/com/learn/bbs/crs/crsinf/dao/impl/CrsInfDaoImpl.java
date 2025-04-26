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
import com.learn.bbs.crs.crsinf.vo.CrsInfEndUpdateRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfModifyRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadFinishedReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfPltadReadResponseVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfRegistRequestVO;
import com.learn.bbs.crs.crsinf.vo.CrsInfStartAndEndTimeRequestVO;


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
	public int countCourseName(String crsInfNm, String insttnId) {
	    Map<String, Object> param = new HashMap<>();
	    param.put("crsInfNm", crsInfNm);
	    param.put("insttnId", insttnId);
	    
	    return this.getSqlSession().selectOne(NAME_SPACE + "countCourseName", param);
	}
	
	@Override
	public String selectCourseName(String crsInfId, String insttnId) {
	    Map<String, Object> param = new HashMap<>();
	    param.put("crsInfId", crsInfId);
	    param.put("insttnId", insttnId);
	    
	    return this.getSqlSession().selectOne(NAME_SPACE + "selectCourseName", param);
	}

	@Override
	public List<CrsInfPltadReadResponseVO> selectAllCourseForPltad(String insttnId) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllCourseForPltad", insttnId);
	}

	@Override
	public List<CrsInfPltadFinishedReadResponseVO> selectAllFinishedCourseForPltad(String insttnId) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllFinishedCourseForPltad", insttnId);
	}

	@Override
	public int updateOneCourse(CrsInfModifyRequestVO crsInfUpdateRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneCourse", crsInfUpdateRequestVO);
	}

	@Override
	public CrsInfModifyRequestVO selectAllInfoFromOneCourse(String crsInfId, String insttnId) {
	    Map<String, Object> param = new HashMap<>();
	    param.put("crsInfId", crsInfId);
	    param.put("insttnId", insttnId);
	    
		return this.getSqlSession().selectOne(NAME_SPACE + "selectAllInfoFromOneCourse", param);
	}

	@Override
	public int deleteOneCourse(String crsInfId, String insttnId) {
	    Map<String, Object> param = new HashMap<>();
	    param.put("crsInfId", crsInfId);
	    param.put("insttnId", insttnId);
	    
		return this.getSqlSession().update(NAME_SPACE + "deleteOneCourse", param);
	}

	@Override
	public List<CrsInfAvailableReadResponseVO> selectAvailableCoursesForUser(String insttnId) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAvailableCoursesForUser", insttnId);
	}
	

	@Override
	public List<CrsInfAvailableReadResponseVO> selectAvailableFourCoursesForUser(String insttnId) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAvailableFourCoursesForUser", insttnId);
	}
	
	@Override
	public List<CrsInfAvailableReadResponseVO> selectMyCourseForUser(String usrMl, String insttnId) {
	    Map<String, Object> param = new HashMap<>();
	    param.put("usrMl", usrMl);
	    param.put("insttnId", insttnId);
	    
		return this.getSqlSession().selectList(NAME_SPACE + "selectMyCourseForUser", param);
	}

	@Override
	public CrsInfDetailReadResponseVO selectCourseDetail(String crsInfId, String insttnId) {
	    Map<String, Object> param = new HashMap<>();
	    param.put("crsInfId", crsInfId);
	    param.put("insttnId", insttnId);
	    
		return this.getSqlSession().selectOne(NAME_SPACE + "selectCourseDetail", param);
	}

	@Override
	public int endOneCourse(CrsInfEndUpdateRequestVO crsInfEndUpdateRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "endOneCourse", crsInfEndUpdateRequestVO);
	}

	@Override
	public int abandonOneCourse(CrsInfAbandonUpdateRequestVO crsInfAbandonUpdateRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "abandonOneCourse", crsInfAbandonUpdateRequestVO);
	}

	@Override
	public List<CrsInfAbandonReadResponseVO> selectAbandonCourse(String insttnId) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAbandonCourse", insttnId);
	}

	@Override
	public int selectLimitedCount(String crsInfId, String insttnId) {
	    Map<String, Object> param = new HashMap<>();
	    param.put("crsInfId", crsInfId);
	    param.put("insttnId", insttnId);
	    
		return this.getSqlSession().selectOne(NAME_SPACE + "selectLimitedCount", param);
	}
	
	@Override
	public CrsInfStartAndEndTimeRequestVO selectCourseTimeStartAndEnd(String crsInfId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectCourseTimeStartAndEnd", crsInfId);
	}
}