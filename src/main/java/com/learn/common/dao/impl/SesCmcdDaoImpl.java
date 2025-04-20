package com.learn.common.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.common.dao.SesCmcdDao;
import com.learn.common.vo.SesCmcdVO;


@Repository
public class SesCmcdDaoImpl extends SqlSessionDaoSupport implements SesCmcdDao{

    private final String NAME_SPACE = "com.learn.common.dao.impl.SesCmcdDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public SesCmcdVO selectOneCmcd(String cmcdNm) {
		return this.getSqlSession().selectOne(NAME_SPACE+"selectOneCmcd" ,cmcdNm);
	}

}
