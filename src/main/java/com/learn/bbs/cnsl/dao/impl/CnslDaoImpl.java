package com.learn.bbs.cnsl.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.cnsl.dao.CnslDao;
import com.learn.bbs.cnsl.vo.CnslCommonVO;
import com.learn.bbs.cnsl.vo.CnslVO;
import com.learn.bbs.cnsl.vo.CreateCnslRequestVO;
import com.learn.bbs.cnsl.vo.SearchCnslRequestVO;
import com.learn.bbs.cnsl.vo.UpdateCnslRequestVO;

/**
 * @author 최예진
 * 상담
 */
@Repository
public class CnslDaoImpl extends SqlSessionDaoSupport implements CnslDao {

    private final String NAME_SPACE = "com.learn.bbs.cnsl.dao.impl.CnslDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public List<CnslVO> selectAllCnslList(SearchCnslRequestVO searchCnslRequestVO) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllCnslList", searchCnslRequestVO);
	}

	@Override
	public CnslVO selectOneCnsl(CnslCommonVO cnslCommonVO) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectOneCnsl", cnslCommonVO);
	}

	@Override
	public int insertNewCnsl(CreateCnslRequestVO createCnslRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewCnsl", createCnslRequestVO);
	}

	@Override
	public int updateOneCnsl(UpdateCnslRequestVO updateCnslRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneCnsl", updateCnslRequestVO);
	}


}