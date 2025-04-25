package com.learn.bbs.crs.apphstr.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.crs.apphstr.dao.AppHstrDao;

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
    public int insertOneAppHstr(String crsInfId, String usrMl) {
        Map<String, Object> param = new HashMap<>();
        param.put("crsInfId", crsInfId);
        param.put("usrMl", usrMl);
        
        // SQL 쿼리 실행
        return this.getSqlSession().insert(NAME_SPACE + "insertOneAppHstr", param);
    }

    @Override
    public boolean existsAppHstr(String crsInfId, String usrMl) {
        return this.getSqlSession().selectOne(NAME_SPACE + "existsAppHstr", Map.of(
            "crsInfId", crsInfId,
            "usrMl", usrMl
        ));
    }

    @Override
    public String findAppHstrId(String crsInfId, String usrMl) {
        return this.getSqlSession().selectOne(NAME_SPACE + "findAppHstrId", Map.of(
            "crsInfId", crsInfId,
            "usrMl", usrMl
        ));
    }

	@Override
	public int countCurrentUserInCourse(String crsInfId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "countCurrentUserInCourse", crsInfId);
	}
}