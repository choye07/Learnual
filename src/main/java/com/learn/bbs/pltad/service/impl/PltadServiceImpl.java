package com.learn.bbs.pltad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.pltad.dao.PltadDao;
import com.learn.bbs.pltad.service.PltadService;

public class PltadServiceImpl implements PltadService{

	@Autowired
	private PltadDao platDao;
}
