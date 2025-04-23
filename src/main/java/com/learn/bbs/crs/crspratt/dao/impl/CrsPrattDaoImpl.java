package com.learn.bbs.crs.crspratt.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.crs.crspratt.dao.CrsPrattDao;
import com.learn.bbs.crs.crspratt.vo.CrsPrattRegistRequestVO;


/**
 * @author 최예진
 * 수강이력
 */
@Repository
public class CrsPrattDaoImpl extends SqlSessionDaoSupport implements CrsPrattDao {

    private final String NAME_SPACE = "com.learn.bbs.crs.crspratt.dao.impl.CrsPrattDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int checkUserHasCrsPratt(String usrId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "checkUserHasCrsPratt", usrId);
	}

	@Override
	public int insertCrsPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertCrsPratt", crsPrattRegistRequestVO);
	}
}