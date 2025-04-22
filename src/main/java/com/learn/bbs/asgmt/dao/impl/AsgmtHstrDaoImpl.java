package com.learn.bbs.asgmt.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.asgmt.dao.AsgmtHstrDao;
import com.learn.bbs.asgmt.vo.AsgmtHstrCommonVO;
import com.learn.bbs.asgmt.vo.AsgmtHstrVO;
import com.learn.bbs.asgmt.vo.CreateAsgmtHstrRequestVO;
import com.learn.bbs.asgmt.vo.DeleteAsgmtHstrRequestVO;
import com.learn.bbs.asgmt.vo.SearchAsgmtHstrRequestVO;

@Repository
public class AsgmtHstrDaoImpl extends SqlSessionDaoSupport implements AsgmtHstrDao {

	private final String NAME_SPACE = "com.learn.bbs.eduad.asgmt.dao.impl.AsgmtHstrDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public List<AsgmtHstrVO> selectAsgmtHstrList(SearchAsgmtHstrRequestVO searchAsgmtHstrRequestVO) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAsgmtHstrList", searchAsgmtHstrRequestVO);
	}

	@Override
	public AsgmtHstrVO selectOneAsgmtHstr(AsgmtHstrCommonVO asgmtHstrCommonVO) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectOneAsgmtHstr", asgmtHstrCommonVO);
	}

	@Override
	public int insertNewAsgmtHstr(CreateAsgmtHstrRequestVO createAsgmtHstrRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewAsgmtHstr", createAsgmtHstrRequestVO);
	}

	@Override
	public int deleteOneAsgmtHstr(DeleteAsgmtHstrRequestVO deleteAsgmtHstrRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "deleteOneAsgmtHstr", deleteAsgmtHstrRequestVO);
	}
    
}
