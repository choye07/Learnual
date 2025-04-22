package com.learn.bbs.asgmt.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learn.bbs.asgmt.dao.AsgmtArtcDao;
import com.learn.bbs.asgmt.vo.AsgmtArtcCommonVO;
import com.learn.bbs.asgmt.vo.AsgmtArtcVO;
import com.learn.bbs.asgmt.vo.CreateAsgmtArtcRequestVO;
import com.learn.bbs.asgmt.vo.DeleteAsgmtArtcRequestVO;
import com.learn.bbs.asgmt.vo.SearchAsgmtArtcRequestVO;
import com.learn.bbs.asgmt.vo.UpdateAsgmtArtcRequestVO;


/**
 * @author 최예진
 * 과제 게시판
 */
@Repository
public class AsgmtArtcDaoImpl extends SqlSessionDaoSupport implements AsgmtArtcDao {

    private final String NAME_SPACE = "com.learn.bbs.eduad.asgmt.dao.impl.AsgmtArtcDaoImpl.";

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

	@Override
	public List<AsgmtArtcVO> selectAllAsgmtArtc(SearchAsgmtArtcRequestVO searchAsgmtArtcRequestVO) {
		return this.getSqlSession().selectList(NAME_SPACE + "selectAllAsgmtArtc", searchAsgmtArtcRequestVO);
	}

	@Override
	public AsgmtArtcVO selectOneAsgmtArtc(AsgmtArtcCommonVO asgmtArtcCommonVO) {
		return this.getSqlSession().selectOne(NAME_SPACE + "selectOneAsgmtArtc", asgmtArtcCommonVO);
	}

	@Override
	public int insertNewAsgmtArtc(CreateAsgmtArtcRequestVO createAsgmtArtcRequestVO) {
		return this.getSqlSession().insert(NAME_SPACE + "insertNewAsgmtArtc", createAsgmtArtcRequestVO);
	}

	@Override
	public int updateOneAsmgtArtc(UpdateAsgmtArtcRequestVO updateAsgmtArtcRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "updateOneAsmgtArtc", updateAsgmtArtcRequestVO);
	}

	@Override
	public int deleteOneAsgmtArtc(DeleteAsgmtArtcRequestVO deleteAsgmtArtcRequestVO) {
		return this.getSqlSession().update(NAME_SPACE + "deleteOneAsgmtArtc", deleteAsgmtArtcRequestVO);
	}


}