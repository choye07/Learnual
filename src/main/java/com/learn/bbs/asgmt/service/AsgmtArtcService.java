package com.learn.bbs.asgmt.service;

import java.util.List;

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
public interface AsgmtArtcService {

	public List<AsgmtArtcVO> readAllAsgmtArtc(SearchAsgmtArtcRequestVO searchAsgmtArtcRequestVO);
	
	public AsgmtArtcVO readOneAsgmtArtc(AsgmtArtcCommonVO asgmtArtcCommonVO);
	
	public boolean createNewAsgmtArtc(CreateAsgmtArtcRequestVO createAsgmtArtcRequestVO);
	
	public boolean updateOneAsmgtArtc(UpdateAsgmtArtcRequestVO updateAsgmtArtcRequestVO);
	
	public boolean deleteOneAsgmtArtc(DeleteAsgmtArtcRequestVO deleteAsgmtArtcRequestVO);
	
}