package com.learn.bbs.pltad.cnfr.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.pltad.cnfr.dao.CnfrHstrDao;
import com.learn.bbs.pltad.cnfr.vo.CnfrHstrConfirmReadVO;

/**
 * @author 최예진
 * 확정 내역
 */
@Repository
public class CnfrHstrDaoImpl extends SqlSessionDaoSupport implements CnfrHstrDao {

    private final String NAME_SPACE = "com.learn.bbs.pltad.cnfr.dao.impl.CnfrHstrDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int insertRegisteredUsers(String insttnId) {
		return this.getSqlSession().insert(NAME_SPACE + "insertRegisteredUsers", insttnId);
	}

	@Override
	public List<CnfrHstrConfirmReadVO> selectAllConfirmedUsers(String crsInfId, String insttnId) {
	    Map<String, Object> param = new HashMap<>();
	    param.put("crsInfId", crsInfId);
	    param.put("insttnId", insttnId);
		
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllConfirmedUsers", param);
	}
}