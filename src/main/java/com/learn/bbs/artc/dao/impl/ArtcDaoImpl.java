package com.learn.bbs.artc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.artc.dao.ArtcDao;
import com.learn.bbs.artc.vo.ArtcReadRequestVO;
import com.learn.bbs.artc.vo.ArtcRegistRequestVO;
import com.learn.bbs.artc.vo.ArtcVO;

@Repository

public class ArtcDaoImpl extends SqlSessionDaoSupport implements ArtcDao {

	private final String NAME_SPACE = "com.learn.bbs.artc.dao.impl.ArtcDaoImpl.";

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int insertNewArtc(ArtcRegistRequestVO artcRegistRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewArtc", artcRegistRequestVO);
	}

	@Override
	public List<ArtcVO> selectAllArtc(ArtcReadRequestVO artcReadRequestVO) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllArtc", artcReadRequestVO);
	}

}