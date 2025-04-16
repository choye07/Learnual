package com.learn.bbs.usr.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.usr.dao.UsrDao;


/**
 * @author 최예진
 * 사용자
 */
@Repository
public class UsrDaoImpl extends SqlSessionDaoSupport implements UsrDao {

    private final String NAME_SPACE = "com.learn.bbs.usr.dao.impl.UsrDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }


}