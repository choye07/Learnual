package com.learn.bbs.eduad.flarch.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.eduad.flarch.dao.FlArchDao;
import com.learn.bbs.eduad.flarch.vo.FlArchDeleteRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchSearchRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchUpdateRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchVO;
import com.learn.bbs.eduad.flarch.vo.FlArchWriteRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlarchViewRequestVO;

@Repository
public class FlArchDaoImpl extends SqlSessionDaoSupport implements FlArchDao {

    private final String NAME_SPACE = "com.learn.bbs.eduad.flarch.dao.impl.FlArchDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int selectAllFlArchBoardCount(FlArchSearchRequestVO flArchSearchRequestVO) {
		return getSqlSession().selectOne(NAME_SPACE + "selectAllFlArchBoardCount", flArchSearchRequestVO);
	}

	@Override
	public List<FlArchVO> selectAllFlArchBoard(FlArchSearchRequestVO flArchSearchRequestVO) {
		return getSqlSession().selectList(NAME_SPACE + "selectAllFlArchBoard", flArchSearchRequestVO);
	}

	@Override
	public int insertNewFlArchBoard(FlArchWriteRequestVO flArchWriteRequestVO) {
		return getSqlSession().insert(NAME_SPACE + "insertNewFlArchBoard", flArchWriteRequestVO);
	}

	@Override
	public int updateViewCountBy(String flArchId) {
		return getSqlSession().update(NAME_SPACE + "updateViewCountBy", flArchId);
	}

	@Override
	public FlArchVO selectOneFlArchBoard(FlarchViewRequestVO flarchViewRequestVO) {
		return getSqlSession().selectOne(NAME_SPACE + "selectOneFlArchBoard", flarchViewRequestVO);
	}

	@Override
	public int deleteOneFlArchBoard(FlArchDeleteRequestVO flArchDeleteRequestVO) {
		return getSqlSession().delete(NAME_SPACE + "deleteOneFlArchBoard", flArchDeleteRequestVO);
	}

	@Override
	public int updateOneFlArchBoard(FlArchUpdateRequestVO flArchUpdateRequestVO) {
		return getSqlSession().update(NAME_SPACE + "updateOneFlArchBoard", flArchUpdateRequestVO);
	}

}