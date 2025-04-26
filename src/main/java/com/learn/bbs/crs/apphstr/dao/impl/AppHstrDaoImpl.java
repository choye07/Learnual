package com.learn.bbs.crs.apphstr.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.crs.apphstr.dao.AppHstrDao;
import com.learn.bbs.crs.apphstr.vo.AppHstrReadResponseVO;
import com.learn.bbs.crs.apphstr.vo.AppHstrRegistRequestVO;

/**
 * @author 최예진
 * 신청 내역
 */
@Repository
public class AppHstrDaoImpl extends SqlSessionDaoSupport implements AppHstrDao {

    private final String NAME_SPACE = "com.learn.bbs.crs.apphstr.dao.impl.AppHstrDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public int insertOneAppHstr(AppHstrRegistRequestVO appHstrRegistRequestVO) {
        return this.getSqlSession().insert(NAME_SPACE + "insertOneAppHstr", appHstrRegistRequestVO);
    }

    @Override
    public boolean existsAppHstr(String crsInfId, String usrMl, String insttnId) {
        Map<String, Object> param = new HashMap<>();
        param.put("crsInfId", crsInfId);
        param.put("usrMl", usrMl);
        param.put("insttnId", insttnId);
        
        return this.getSqlSession().selectOne(NAME_SPACE + "existsAppHstr", param);
    }

    @Override
    public String findAppHstrId(String crsInfId, String usrMl, String insttnId) {
        Map<String, Object> param = new HashMap<>();
        param.put("crsInfId", crsInfId);
        param.put("usrMl", usrMl);
        param.put("insttnId", insttnId);
        
        return this.getSqlSession().selectOne(NAME_SPACE + "findAppHstrId", param);
    }

    @Override
    public int countCurrentUserInCourse(String crsInfId, String insttnId) {
        Map<String, Object> param = new HashMap<>();
        param.put("crsInfId", crsInfId);
        param.put("insttnId", insttnId);
        
        return this.getSqlSession().selectOne(NAME_SPACE + "countCurrentUserInCourse", param);
    }

	@Override
	public List<AppHstrReadResponseVO> selectCurrentUserInCourse(String crsInfId, String insttnId) {
        Map<String, Object> param = new HashMap<>();
        param.put("crsInfId", crsInfId);
        param.put("insttnId", insttnId);
        
        return this.getSqlSession().selectList(NAME_SPACE + "selectCurrentUserInCourse", param);
	}
}