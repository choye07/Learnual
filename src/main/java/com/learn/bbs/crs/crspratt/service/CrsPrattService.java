package com.learn.bbs.crs.crspratt.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.crs.crspratt.dao.CrsPrattDao;
import com.learn.bbs.crs.crspratt.vo.CrsPrattRegistRequestVO;

/**
 * @author 최예진
 * 수강이력
 */
public interface CrsPrattService {
	public boolean insertCrsPratt(CrsPrattRegistRequestVO crsPrattRegistRequestVO);
}