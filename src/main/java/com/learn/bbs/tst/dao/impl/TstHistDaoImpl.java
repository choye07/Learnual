package com.learn.bbs.tst.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.tst.dao.TstHistDao;
import com.learn.bbs.tst.vo.CreateTstHstrRequestVO;
import com.learn.bbs.tst.vo.TstHistVO;

@Repository
public class TstHistDaoImpl extends SqlSessionDaoSupport implements TstHistDao {

	private final String NAME_SPACE = "com.learn.bbs.tst.dao.impl.TstHistDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public List<TstHistVO> selectTstHistList(String tstId) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectTstHistList", tstId);
	}

	@Override
	public TstHistVO selectTstHist(String tstHstrId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectTstHist", tstHstrId);
	}

	@Override
	public int insertNewTstHist(CreateTstHstrRequestVO createTstHstrRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewTstHist", createTstHstrRequestVO);
	}

	@Override
	public int updateTstRspnsHist(String tstHstrId) {
		return this.getSqlSession().update(NAME_SPACE + "updateTstRspnsHist", tstHstrId);
	}
	
}
