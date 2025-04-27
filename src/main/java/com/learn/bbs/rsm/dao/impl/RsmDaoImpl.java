package com.learn.bbs.rsm.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.rsm.dao.RsmDao;
import com.learn.bbs.rsm.vo.RsmDeleteRequestVO;
import com.learn.bbs.rsm.vo.RsmSearchRequestVO;
import com.learn.bbs.rsm.vo.RsmUpdateRequestVO;
import com.learn.bbs.rsm.vo.RsmVO;
import com.learn.bbs.rsm.vo.RsmWriteRequestVO;

@Repository
public class RsmDaoImpl extends SqlSessionDaoSupport implements RsmDao {

    private final String NAME_SPACE = "com.learn.bbs.rsm.dao.impl.RsmDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public int selectAllRsmCount(RsmSearchRequestVO rsmSearchRequestVO) {
		return getSqlSession().selectOne(NAME_SPACE + "selectAllRsmCount", rsmSearchRequestVO);
	}

	@Override
	public List<RsmVO> selectAllRsm(RsmSearchRequestVO rsmSearchRequestVO) {
		return getSqlSession().selectList(NAME_SPACE + "selectAllRsm", rsmSearchRequestVO);
	}

	@Override
	public int insertNewRsm(RsmWriteRequestVO rsmWriteRequestVO) {
		return getSqlSession().insert(NAME_SPACE + "insertNewRsm", rsmWriteRequestVO);
	}

	@Override
	public int deleteOneRsm(RsmDeleteRequestVO rsmDeleteRequestVO) {
		return getSqlSession().update(NAME_SPACE + "deleteOneRsm", rsmDeleteRequestVO);
	}

	@Override
	public int updateOneRsm(RsmUpdateRequestVO rsmUpdateRequestVO) {
		return getSqlSession().update(NAME_SPACE + "updateOneRsm", rsmUpdateRequestVO);
	}


}