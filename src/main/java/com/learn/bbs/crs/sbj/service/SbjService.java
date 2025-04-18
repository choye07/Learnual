package com.learn.bbs.crs.sbj.service;

import java.util.List;

import com.learn.bbs.crs.sbj.vo.SbjVO;

/**
 * @author 최예진
 * 과목 
 */
public interface SbjService {
	public List<SbjVO> selectAllSubjects();
}