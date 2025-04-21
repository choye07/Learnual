package com.learn.bbs.tst.service;

import java.util.List;

import com.learn.bbs.tst.vo.CreateTstHstrRequestVO;
import com.learn.bbs.tst.vo.TstHistVO;
import com.learn.bbs.tst.vo.UpdateTstHstrRequestVO;

public interface TstHistService {

	public List<TstHistVO> readTstHistList(String tstId);
	
	public TstHistVO readTstHist(String tstHstrId);
	
	public boolean createNewTstHist(CreateTstHstrRequestVO createTstHstrRequestVO);
	
	public boolean updateTstRspnsHist(UpdateTstHstrRequestVO updateTstHstrRequestVO);

}

