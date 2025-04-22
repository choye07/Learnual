package com.learn.bbs.asgmt.service;

import java.util.List;

import com.learn.bbs.asgmt.vo.AsgmtHstrCommonVO;
import com.learn.bbs.asgmt.vo.AsgmtHstrVO;
import com.learn.bbs.asgmt.vo.CreateAsgmtHstrRequestVO;
import com.learn.bbs.asgmt.vo.DeleteAsgmtHstrRequestVO;
import com.learn.bbs.asgmt.vo.SearchAsgmtHstrRequestVO;

public interface AsgmtHstrService {

	public List<AsgmtHstrVO> readAsgmtHstrList(SearchAsgmtHstrRequestVO searchAsgmtHstrRequestVO);
	
	public AsgmtHstrVO readOneAsgmtHstr(AsgmtHstrCommonVO asgmtHstrCommonVO);
	
	public boolean createNewAsgmtHstr(CreateAsgmtHstrRequestVO createAsgmtHstrRequestVO);
	
	public boolean deleteOneAsgmtHstr(DeleteAsgmtHstrRequestVO deleteAsgmtHstrRequestVO);
	
}
