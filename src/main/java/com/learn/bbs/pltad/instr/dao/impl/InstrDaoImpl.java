package com.learn.bbs.pltad.instr.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.pltad.instr.dao.InstrDao;
import com.learn.bbs.pltad.instr.vo.InstrRegistRequestVO;
import com.learn.bbs.pltad.instr.vo.InstrVO;
import com.learn.common.vo.MyInformationRequestVO;


/**
 * @TableName INSTR
 * @TableComment null
 * 강사
 */
@Repository
public class InstrDaoImpl extends SqlSessionDaoSupport implements InstrDao {

    private final String NAME_SPACE = "com.learn.bbs.pltad.instr.dao.impl.InstrDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int insertNewInstr(InstrRegistRequestVO instrRegistRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE+"insertNewInstr",instrRegistRequestVO);
	}
	
	@Override
	public int selectUsrCountBy(String instrLgnId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectUsrCountBy", instrLgnId);
	}
	@Override
	public InstrVO selectOneUsrBy(String instrLgnId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectOneUsrBy", instrLgnId);
	}
	@Override
	public int updateLoginFailCount(String instrLgnId) {
		return this.getSqlSession().update(NAME_SPACE + "updateLoginFailCount",instrLgnId);
	}
	@Override
	public int updateBlock(String instrLgnId) {
		return this.getSqlSession().update(NAME_SPACE + "updateBlock",instrLgnId);
	}
	@Override
	public int updateLoginSuccess(String instrLgnId) {
		return this.getSqlSession().update(NAME_SPACE + "updateLoginSuccess",instrLgnId);
	}
	@Override
	public int updateLogoutStatus(String instrLgnId) {
		return this.getSqlSession().update(NAME_SPACE + "updateLogoutStatus",instrLgnId);
	}
	@Override
	public int deleteOneUsrBy(String instrLgnId) {
		return this.getSqlSession().update(NAME_SPACE + "deleteOneUsrBy",instrLgnId);
	}
	
	@Override
	public int updateOneUsrEditMyinformation(MyInformationRequestVO myInfromationRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneUsrEditMyinformation",myInfromationRequestVO);		
	}
	
	@Override
	public List<InstrVO> selectAllInstrs() {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllInstrs");
	}

	@Override
	public String selectOneInstrName(String crsInfId) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectOneInstrName", crsInfId);
	}

}