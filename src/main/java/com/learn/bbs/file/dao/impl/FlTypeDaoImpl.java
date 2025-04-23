package com.learn.bbs.file.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.file.dao.FlTypeDao;
import com.learn.bbs.file.vo.FlTypeVO;

@Repository
public class FlTypeDaoImpl extends SqlSessionDaoSupport implements FlTypeDao {

	private final String NAME_SPACE = "com.learn.bbs.file.dao.impl.FlTypeDaoImpl.";

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public List<FlTypeVO> selectFlMdfyTypes(String flTypeNm) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectFlMdfyTypes", flTypeNm);
	}

	@Override
	public int insertFlMdfyTypes(FlTypeVO flTypeVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertFlMdfyTypes", flTypeVO);
	}

	@Override
	public int deleteFlMdfyTypes(FlTypeVO flTypeVO) {
		return this.getSqlSession().delete(NAME_SPACE + "deleteFlMdfyTypes", flTypeVO);
	}
	
}