package com.learn.main.sprad.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.main.sprad.dao.SpradDao;
import com.learn.main.sprad.vo.SpradRegistRequestVO;

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
	public int selectSpradCount(String SpradId) {
		return this.getSqlSession().selectOne(NAME_SPACE+"selectSpradCount",SpradId);
	}
    
	
    


}