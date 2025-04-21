package com.learn.bbs.tst.dao;

import java.util.List;

import com.learn.bbs.tst.vo.CreateTstHstrRequestVO;
import com.learn.bbs.tst.vo.TstHistVO;

public interface TstHistDao {

	public List<TstHistVO> selectTstHistList(String tstId);
	
	public TstHistVO selectTstHist(String tstHstrId);
	
	public int insertNewTstHist(CreateTstHstrRequestVO createTstHstrRequestVO);
	
	public int updateTstRspnsHist(String tstHstrId);
	
}
