package com.learn.bbs.asgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.asgmt.dao.AsgmtArtcDao;
import com.learn.bbs.asgmt.service.AsgmtArtcService;
import com.learn.bbs.asgmt.vo.AsgmtArtcCommonVO;
import com.learn.bbs.asgmt.vo.AsgmtArtcVO;
import com.learn.bbs.asgmt.vo.CreateAsgmtArtcRequestVO;
import com.learn.bbs.asgmt.vo.DeleteAsgmtArtcRequestVO;
import com.learn.bbs.asgmt.vo.SearchAsgmtArtcRequestVO;
import com.learn.bbs.asgmt.vo.UpdateAsgmtArtcRequestVO;
import com.learn.exceptions.AsgmtException;


/**
 * @author 최예진
 * 과제 게시판
 */
@Service
public class AsgmtArtcServiceImpl implements AsgmtArtcService {

    @Autowired
    private AsgmtArtcDao asgmtArtcDao;

	@Override
	public List<AsgmtArtcVO> readAllAsgmtArtc(SearchAsgmtArtcRequestVO searchAsgmtArtcRequestVO) {
		return this.asgmtArtcDao.selectAllAsgmtArtc(searchAsgmtArtcRequestVO);
	}

	@Override
	public AsgmtArtcVO readOneAsgmtArtc(AsgmtArtcCommonVO asgmtArtcCommonVO) {
		AsgmtArtcVO asgmtArtc = this.asgmtArtcDao.selectOneAsgmtArtc(asgmtArtcCommonVO);
		if (asgmtArtc == null) {
			throw new AsgmtException("존재하지않는 과제입니다.");
		}
		return asgmtArtc;
	}

	@Override
	public boolean createNewAsgmtArtc(CreateAsgmtArtcRequestVO createAsgmtArtcRequestVO) {
		return this.asgmtArtcDao.insertNewAsgmtArtc(createAsgmtArtcRequestVO) > 0;
	}

	@Override
	public boolean updateOneAsmgtArtc(UpdateAsgmtArtcRequestVO updateAsgmtArtcRequestVO) {
		this.readOneAsgmtArtc(updateAsgmtArtcRequestVO);
		return this.asgmtArtcDao.updateOneAsmgtArtc(updateAsgmtArtcRequestVO) > 0;
	}

	@Override
	public boolean deleteOneAsgmtArtc(DeleteAsgmtArtcRequestVO deleteAsgmtArtcRequestVO) {
		this.readOneAsgmtArtc(deleteAsgmtArtcRequestVO);
		return this.asgmtArtcDao.deleteOneAsgmtArtc(deleteAsgmtArtcRequestVO) > 0;
	}

}