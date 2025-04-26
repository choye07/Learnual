package com.learn.main.cmcd.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.main.cmcd.dao.CmcdDao;
import com.learn.main.cmcd.vo.CmCodeVO;



/**
 * @TableName CM_CODE
 * @TableComment null
 * 공통 코드
 */
@Repository
public class CmcdDaoImpl extends SqlSessionDaoSupport implements CmcdDao {

    private final String NAME_SPACE = "com.learn.main.cmcd.dao.impl.CmcdDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public List<CmCodeVO> selectAllCmcd(int level) {
		return this.getSqlSession().selectList(NAME_SPACE+"selectAllCmcd",level);
	}


}