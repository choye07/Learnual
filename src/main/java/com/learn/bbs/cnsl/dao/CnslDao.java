package com.learn.bbs.cnsl.dao;

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
public interface CnslDao {

	public List<CnslVO> selectAllCnslList(SearchCnslRequestVO searchCnslRequestVO);
	
	public CnslVO selectOneCnsl(CnslCommonVO cnslCommonVO);
	
	public int insertNewCnsl(CreateCnslRequestVO createCnslRequestVO);
	
	public int updateOneCnsl(UpdateCnslRequestVO updateCnslRequestVO);
	
}