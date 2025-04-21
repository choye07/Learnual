package com.learn.bbs.tst.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.tst.dao.TstDao;
import com.learn.bbs.tst.dao.TstHistDao;
import com.learn.bbs.tst.service.TstHistService;

@Service
public class TstHistServiceImpl implements TstHistService {

	@Autowired
	private TstDao tstDao;
	
	@Autowired
	private TstHistDao tstHistDao;
	
}
