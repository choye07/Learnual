package com.learn.bbs.pltad.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.pltad.dao.PltAdDao;
import com.learn.bbs.pltad.service.PltAdService;

@Service
public class PltAdServiceImpl implements PltAdService {

    @Autowired
    private PltAdDao pltAdDao;

}