package com.learn.bbs.crs.sbj.dao;

import java.util.List;

import com.learn.bbs.crs.sbj.vo.SbjVO;

/**
 * @author 최예진
 * 과목 
 */
public interface SbjDao {
	public List<SbjVO> selectAllSubjects();
}