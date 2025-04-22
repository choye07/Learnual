package com.learn.bbs.asgmt.dao;

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
public interface AsgmtArtcDao {

	public List<AsgmtArtcVO> selectAllAsgmtArtc(SearchAsgmtArtcRequestVO searchAsgmtArtcRequestVO);
	
	public AsgmtArtcVO selectOneAsgmtArtc(AsgmtArtcCommonVO asgmtArtcCommonVO);
	
	public int insertNewAsgmtArtc(CreateAsgmtArtcRequestVO createAsgmtArtcRequestVO);
	
	public int updateOneAsmgtArtc(UpdateAsgmtArtcRequestVO updateAsgmtArtcRequestVO);
	
	public int deleteOneAsgmtArtc(DeleteAsgmtArtcRequestVO deleteAsgmtArtcRequestVO);
	
}