package com.learn.insttn.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.insttn.dao.InsttnDao;
import com.learn.insttn.vo.InsttnRegistRequestVO;
import com.learn.insttn.vo.InsttnSearchRequestVO;
import com.learn.insttn.vo.InsttnVO;

/**
 * @author 최예진 기관(학원)
 */
@Repository
public class InsttnDaoImpl extends SqlSessionDaoSupport implements InsttnDao {

	private final String NAME_SPACE = "com.learn.insttn.dao.impl.InsttnDaoImpl.";

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	/**
	 * 기관(학원) 등록
	 */
	@Override
	public int insertNewInsttn(InsttnRegistRequestVO insttnRegistRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewInsttn", insttnRegistRequestVO);
	}

	/**
	 * 등록 된 기관(학원)인지 체크
	 */
	@Override
	public int selectCheckDuplicateInsttn(InsttnRegistRequestVO insttnRegistRequestVO) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectCheckDuplicateInsttn");
	}

	/**
	 * 등록 된 학원 리스트 뽑아오기ㅣ
	 */
	@Override
	public List<InsttnVO> selectAllInsttn (InsttnSearchRequestVO insttnSearchRequestVO) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllInsttn", insttnSearchRequestVO);
	}

	@Override
	public List<InsttnVO> selectAllInsttnBy(String insttnId) {
		return this.getSqlSession().selectList(NAME_SPACE+"selectAllInsttnBy" ,insttnId);
	}


}