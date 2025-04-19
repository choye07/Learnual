package com.learn.main.cmcd.service.impl;

import org.springframework.stereotype.Service;

import com.learn.main.cmcd.dao.CmcdDao;
import com.learn.main.cmcd.service.CmcdService;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * @TableName CM_CODE
 * @TableComment null
 * 공통 코드
 */
@Service
public class CmcdServiceImpl implements CmcdService {

    @Autowired
    private CmcdDao cmcdDao;

}