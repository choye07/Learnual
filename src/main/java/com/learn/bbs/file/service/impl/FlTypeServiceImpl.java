package com.learn.bbs.file.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.file.dao.FlTypeDao;
import com.learn.bbs.file.service.FlTypeService;
import com.learn.bbs.file.vo.FlTypeVO;


@Service
public class FlTypeServiceImpl implements FlTypeService {

    @Autowired
    private FlTypeDao flTypeDao;

	@Override
	public List<FlTypeVO> getFlMdfyTypes(String flTypeNm) {
		// 변환 가능한 확장자 모두 List로 반환
		return this.flTypeDao.selectFlMdfyTypes(flTypeNm);
	}

	@Override
	public boolean insertNewFlMdfyTypes(FlTypeVO flTypeVO) {
		 int insertCount = this.flTypeDao.insertFlMdfyTypes(flTypeVO);
		 // 0보다 크면 새로운 insert 성공
		 return insertCount > 0;
	}

	@Override
	public boolean deleteOneFlMdfyTypes(FlTypeVO flTypeVO) {
		int deleteCount = this.flTypeDao.deleteFlMdfyTypes(flTypeVO);
		// 0보다 크면 delete 성공
		return deleteCount > 0;
	}

}