package com.learn.bbs.crs.apphstr.dao.impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.crs.apphstr.dao.AppHstrDao;
import com.learn.bbs.crs.apphstr.vo.AppHstrVO;

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
	public int insertOneAppHstr(AppHstrVO appHstr) {
		return this.getSqlSession().insert(NAME_SPACE + "insertOneAppHstr", appHstr);
	}

    @Override
    public boolean existsAppHstr(String crsInfId, String usrId) {
        return this.getSqlSession().selectOne(NAME_SPACE + "existsAppHstr", Map.of(
            "crsInfId", crsInfId,
            "usrId", usrId
        ));
    }

    @Override
    public String findAppHstrId(String crsInfId, String usrId) {
        return this.getSqlSession().selectOne(NAME_SPACE + "findAppHstrId", Map.of(
            "crsInfId", crsInfId,
            "usrId", usrId
        ));
    }
}