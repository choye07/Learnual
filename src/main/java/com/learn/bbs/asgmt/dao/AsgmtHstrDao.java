package com.learn.bbs.asgmt.dao;

import java.util.List;

import com.learn.bbs.asgmt.vo.AsgmtHstrCommonVO;
import com.learn.bbs.asgmt.vo.AsgmtHstrVO;
import com.learn.bbs.asgmt.vo.CreateAsgmtHstrRequestVO;
import com.learn.bbs.asgmt.vo.DeleteAsgmtHstrRequestVO;
import com.learn.bbs.asgmt.vo.SearchAsgmtHstrRequestVO;

public interface AsgmtHstrDao {

	public List<AsgmtHstrVO> selectAsgmtHstrList(SearchAsgmtHstrRequestVO searchAsgmtHstrRequestVO);
	
	public AsgmtHstrVO selectOneAsgmtHstr(AsgmtHstrCommonVO asgmtHstrCommonVO);
	
	public int insertNewAsgmtHstr(CreateAsgmtHstrRequestVO createAsgmtHstrRequestVO);
	
	public int deleteOneAsgmtHstr(DeleteAsgmtHstrRequestVO deleteAsgmtHstrRequestVO);
	
}
