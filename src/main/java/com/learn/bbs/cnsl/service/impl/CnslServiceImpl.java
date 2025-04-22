package com.learn.bbs.cnsl.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.cnsl.dao.CnslDao;
import com.learn.bbs.cnsl.service.CnslService;
import com.learn.bbs.cnsl.vo.CnslCommonVO;
import com.learn.bbs.cnsl.vo.CnslVO;
import com.learn.bbs.cnsl.vo.CreateCnslRequestVO;
import com.learn.bbs.cnsl.vo.SearchCnslRequestVO;
import com.learn.bbs.cnsl.vo.UpdateCnslRequestVO;
import com.learn.exceptions.CnslException;
/**
 * @author 최예진
 * 상담
 */
@Service
public class CnslServiceImpl implements CnslService {

    @Autowired
    private CnslDao cnslDao;

	@Override
	public List<CnslVO> readAllCnslList(SearchCnslRequestVO searchCnslRequestVO) {
		return this.cnslDao.selectAllCnslList(searchCnslRequestVO);
	}

	@Override
	public CnslVO readOneCnsl(CnslCommonVO cnslCommonVO) {
		CnslVO cnsl = this.cnslDao.selectOneCnsl(cnslCommonVO);
		if (cnsl == null) {
			throw new CnslException("존재하지 않는 상담입니다.");
		}
		return cnsl;
	}

	@Override
	public boolean createNewCnsl(CreateCnslRequestVO createCnslRequestVO) {
		return this.cnslDao.insertNewCnsl(createCnslRequestVO) > 0;
	}

	@Override
	public boolean updateOneCnsl(UpdateCnslRequestVO updateCnslRequestVO) {
		this.readOneCnsl(updateCnslRequestVO);
		return this.cnslDao.updateOneCnsl(updateCnslRequestVO) > 0;
	}

}