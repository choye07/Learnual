package com.learn.main.sprad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.common.dao.SesCmcdDao;
import com.learn.common.vo.SesCmcdVO;
import com.learn.main.sprad.dao.SpradDao;
import com.learn.main.sprad.service.SpradService;
import com.learn.main.sprad.vo.SpradRegistRequestVO;

@Service
public class SpradServiceImpl implements SpradService {

	@Autowired
	private SpradDao spradDao;
	
	@Autowired
	private SesCmcdDao sesCmcdDao; 

	@Override
	public boolean createNewSprad(SpradRegistRequestVO spradRegistRequestVO) {
		
		//슈퍼관리자 등록 전 권한값 세팅
		String CmcdNm =  this.sesCmcdDao.selectOneSesCmcd("슈퍼 관리자");
		spradRegistRequestVO.setCmcdId(CmcdNm);

		// 슈퍼관리자 등록
		int insertCount = this.spradDao.createNewSprad(spradRegistRequestVO);
		
		return insertCount > 0;
	}

}