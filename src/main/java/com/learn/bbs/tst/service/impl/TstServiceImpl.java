package com.learn.bbs.tst.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.tst.dao.TstDao;
import com.learn.bbs.tst.service.TstService;
import com.learn.bbs.tst.vo.CreateTstRequestVO;
import com.learn.bbs.tst.vo.DeleteTstRequestVO;
import com.learn.bbs.tst.vo.SearchTstRequestVO;
import com.learn.bbs.tst.vo.TstCommonVO;
import com.learn.bbs.tst.vo.TstListVO;
import com.learn.bbs.tst.vo.TstVO;
import com.learn.bbs.tst.vo.UpdateTstRequestVO;
import com.learn.exceptions.TstException;

/**
 * @author 최예진 시험
 */
@Service
public class TstServiceImpl implements TstService {

	@Autowired
	private TstDao tstDao;

	@Transactional(readOnly = true)
	@Override
	public TstListVO readAllTest(SearchTstRequestVO searchTstRequestVO) {
		int count = this.tstDao.selectAllTestCount(searchTstRequestVO);

		TstListVO tstListVO = new TstListVO();
		tstListVO.setTstListCount(count);
		searchTstRequestVO.setPageCount(count);
		if (count > 0) {
			tstListVO.setTstList(this.tstDao.selectAllTest(searchTstRequestVO));
		}

		return tstListVO;
	}

	@Transactional(readOnly = true)
	@Override
	public TstVO readOneTest(TstCommonVO tstCommonVO) {
		TstVO tst = this.tstDao.selectOneTest(tstCommonVO);
		if (tst == null) {
			throw new TstException("존재하지 않는 시험입니다.");
		}
		return tst;
	}

	@Transactional
	@Override
	public boolean createNewTest(CreateTstRequestVO createTstRequestVO) {
		return this.tstDao.insertNewTest(createTstRequestVO) > 0;
	}

	@Transactional
	@Override
	public boolean updateOneTest(UpdateTstRequestVO updateTstRequestVO) {
		this.readOneTest(updateTstRequestVO);
		
		return this.tstDao.updateOneTest(updateTstRequestVO) > 0;
	}

	@Transactional
	@Override
	public boolean changeTestStat(UpdateTstRequestVO updateTstRequestVO) {
		this.readOneTest(updateTstRequestVO);
		return this.tstDao.updateOneTest(updateTstRequestVO) > 0;
	}

	@Transactional
	@Override
	public boolean deleteOneTest(DeleteTstRequestVO deleteTstRequestVO) {
		this.readOneTest(deleteTstRequestVO);
		return this.tstDao.deleteOneTest(deleteTstRequestVO) > 0;
	}

}