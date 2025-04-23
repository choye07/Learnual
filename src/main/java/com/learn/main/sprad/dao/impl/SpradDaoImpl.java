package com.learn.main.sprad.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.main.sprad.dao.SpradDao;
import com.learn.main.sprad.vo.SpradRegistRequestVO;
import com.learn.main.sprad.vo.SpradmVO;

@Repository
public class SpradDaoImpl extends SqlSessionDaoSupport implements SpradDao {

    private final String NAME_SPACE = "com.learn.main.sprad.dao.impl.SpradDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int createNewSprad(SpradRegistRequestVO spradRegistRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE+"createNewSprad",spradRegistRequestVO);
	}
	
	@Override
	public int selectUsrCountBy(String spradId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectUsrCountBy", spradId);
	}
	@Override
	public SpradmVO selectOneUsrBy(String spradId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectOneUsrBy", spradId);
	}
	@Override
	public int updateLoginFailCount(String spradId) {
		return this.getSqlSession().update(NAME_SPACE + "updateLoginFailCount",spradId);
	}
	@Override
	public int updateBlock(String spradId) {
		return this.getSqlSession().update(NAME_SPACE + "updateBlock",spradId);
	}
	@Override
	public int updateLoginSuccess(String spradId) {
		return this.getSqlSession().update(NAME_SPACE + "updateLoginSuccess",spradId);
	}
	@Override
	public int updateLogoutStatus(String spradId) {
		return this.getSqlSession().update(NAME_SPACE + "updateLogoutStatus",spradId);
	}
	@Override
	public int deleteOneUsrBy(String spradId) {
		return this.getSqlSession().update(NAME_SPACE + "deleteOneUsrBy",spradId);
	}
    
	
    


}