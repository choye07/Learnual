package com.learn.bbs.pltad.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.pltad.dao.PltAdDao;
import com.learn.bbs.pltad.vo.PltadRegistRequestVO;
import com.learn.bbs.pltad.vo.PltadmVO;
import com.learn.common.vo.MyInformationRequestVO;

@Repository
public class PltAdDaoImpl extends SqlSessionDaoSupport implements PltAdDao {

    private final String NAME_SPACE = "com.learn.bbs.pltad.dao.impl.PltAdDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int insertNewPltad(PltadRegistRequestVO pltadRegistRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE+"insertNewPltad",pltadRegistRequestVO);
	}

	@Override
	public int selectPltadCount(String lgnId) {
		return this.getSqlSession().selectOne(NAME_SPACE+"selectPltadCount",lgnId);
	}
	
	@Override
	public int selectUsrCountBy(String pltadmLgnId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectUsrCountBy", pltadmLgnId);
	}
	@Override
	public PltadmVO selectOneUsrBy(String pltadmLgnId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectOneUsrBy", pltadmLgnId);
	}
	@Override
	public int updateLoginFailCount(String pltadmLgnId) {
		return this.getSqlSession().update(NAME_SPACE + "updateLoginFailCount",pltadmLgnId);
	}
	@Override
	public int updateBlock(String pltadmLgnId) {
		return this.getSqlSession().update(NAME_SPACE + "updateBlock",pltadmLgnId);
	}
	@Override
	public int updateLoginSuccess(String pltadmLgnId) {
		return this.getSqlSession().update(NAME_SPACE + "updateLoginSuccess",pltadmLgnId);
	}
	@Override
	public int updateLogoutStatus(String pltadmLgnId) {
		return this.getSqlSession().update(NAME_SPACE + "updateLogoutStatus",pltadmLgnId);
	}
	@Override
	public int deleteOneUsrBy(String pltadmLgnId) {
		return this.getSqlSession().update(NAME_SPACE + "deleteOneUsrBy",pltadmLgnId);
	}

	@Override
	public int updateOneUsrEditMyinformation(MyInformationRequestVO myInfromationRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneUsrEditMyinformation",myInfromationRequestVO);
		
	}

}