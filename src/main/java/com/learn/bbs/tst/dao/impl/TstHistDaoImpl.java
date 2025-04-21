package com.learn.bbs.tst.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.tst.dao.TstHistDao;

@Repository
public class TstHistDaoImpl extends SqlSessionDaoSupport implements TstHistDao {

	private final String NAME_SPACE = "com.learn.bbs.tst.dao.impl.TstHistDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
	
}
