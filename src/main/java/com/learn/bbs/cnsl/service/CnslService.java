package com.learn.bbs.cnsl.service;

import java.util.List;

import com.learn.bbs.cnsl.vo.CnslCommonVO;
import com.learn.bbs.cnsl.vo.CnslVO;
import com.learn.bbs.cnsl.vo.CreateCnslRequestVO;
import com.learn.bbs.cnsl.vo.SearchCnslRequestVO;
import com.learn.bbs.cnsl.vo.UpdateCnslRequestVO;

/**
 * @author 최예진
 * 상담
 */
public interface CnslService {

	public List<CnslVO> readAllCnslList(SearchCnslRequestVO searchCnslRequestVO);
	
	public CnslVO readOneCnsl(CnslCommonVO cnslCommonVO);
	
	public boolean createNewCnsl(CreateCnslRequestVO createCnslRequestVO);
	
	public boolean updateOneCnsl(UpdateCnslRequestVO updateCnslRequestVO);
	
}