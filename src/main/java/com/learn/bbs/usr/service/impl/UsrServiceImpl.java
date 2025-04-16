package com.learn.bbs.usr.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.usr.dao.UsrDao;
import com.learn.bbs.usr.service.UsrService;



/**
 * @author 최예진
 * 사용자
 */
@Service
public class UsrServiceImpl implements UsrService {

    @Autowired
    private UsrDao usrDao;

}