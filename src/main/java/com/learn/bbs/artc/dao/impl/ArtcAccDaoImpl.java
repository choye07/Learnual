package com.learn.bbs.artc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.artc.dao.ArtcAccDao;
import com.learn.bbs.artc.vo.ArtcAccVO;
import com.learn.bbs.artc.vo.ArtcRegistRequestVO;

@Repository
public class ArtcAccDaoImpl extends SqlSessionDaoSupport implements ArtcAccDao {

	private final String NAME_SPACE = "com.learn.bbs.artc.dao.impl.ArtcAccDaoImpl.";

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<ArtcAccVO> selectAllArtcAcc(String artcId) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllArtcAcc", artcId);
	}

	@Override
	public int insertNewArtcAcc(ArtcRegistRequestVO artcRegistRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewArtcAcc", artcRegistRequestVO);
	}

}