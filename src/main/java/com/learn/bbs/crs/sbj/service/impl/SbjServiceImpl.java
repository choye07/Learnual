package com.learn.bbs.crs.sbj.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.crs.sbj.dao.SbjDao;
import com.learn.bbs.crs.sbj.service.SbjService;
import com.learn.bbs.crs.sbj.vo.SbjVO;


/**
 * @author 최예진
 * 과목 
 */
@Service
public class SbjServiceImpl implements SbjService {

    @Autowired
    private SbjDao sbjDao;

	@Override
	public List<SbjVO> selectAllSubjects() {
		return this.sbjDao.selectAllSubjects();
	}

}