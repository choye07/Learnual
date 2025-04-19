package com.learn.bbs.pltad.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.pltad.dao.PltAdDao;

@Repository
public class PltAdDaoImpl extends SqlSessionDaoSupport implements PltAdDao {

    private final String NAME_SPACE = "com.learn.bbs.pltad.dao.impl.PltAdDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }


}