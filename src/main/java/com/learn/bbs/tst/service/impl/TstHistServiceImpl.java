package com.learn.bbs.tst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.tst.dao.TstDao;
import com.learn.bbs.tst.dao.TstHistDao;
import com.learn.bbs.tst.service.TstHistService;
import com.learn.bbs.tst.vo.CreateTstHstrRequestVO;
import com.learn.bbs.tst.vo.TstHistVO;
import com.learn.bbs.tst.vo.TstVO;
import com.learn.bbs.tst.vo.UpdateTstHstrRequestVO;
import com.learn.exceptions.TstException;

@Service
public class TstHistServiceImpl implements TstHistService {

	@Autowired
	private TstDao tstDao;
	
	@Autowired
	private TstHistDao tstHistDao;

	@Transactional(readOnly = true)
	@Override
	public List<TstHistVO> readTstHistList(String tstId) {
		return this.tstHistDao.selectTstHistList(tstId);
	}

	@Transactional(readOnly = true)
	@Override
	public TstHistVO readTstHist(String tstHstrId) {
		return this.tstHistDao.selectTstHist(tstHstrId);
	}

	@Transactional
	@Override
	public boolean createNewTstHist(CreateTstHstrRequestVO createTstHstrRequestVO) {
		TstVO tstVO = this.tstDao.selectOneTest(createTstHstrRequestVO);
		if (tstVO == null) {
			throw new TstException("존재하지 않는 시험입니다.");
		}
		
		if (tstVO.getTstStat().equals("마감")) {
			throw new TstException("마감된 시험입니다.");
		}
		else if (tstVO.getTstStat().equals("확정")) {
			return this.tstHistDao.insertNewTstHist(createTstHstrRequestVO) > 0;
		}
		else {
			throw new TstException("준비되지 않은 시험입니다.");
		}
	}

	@Transactional
	@Override
	public boolean updateTstRspnsHist(UpdateTstHstrRequestVO updateTstHstrRequestVO) {
		TstVO tstVO = this.tstDao.selectOneTest(updateTstHstrRequestVO);
		if (tstVO == null) {
			throw new TstException("존재하지 않는 시험입니다.");
		}
		
		if (tstVO.getTstStat().equals("마감")) {
			throw new TstException("마감된 시험입니다.");
		}
		else if (tstVO.getTstStat().equals("확정")) {
			return this.tstHistDao.updateTstRspnsHist(updateTstHstrRequestVO.getTstHstrId()) > 0;
		}
		else {
			throw new TstException("준비되지 않은 시험입니다.");
		}
	}
	
}
