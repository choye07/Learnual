package com.learn.bbs.pltad.cnfr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.pltad.cnfr.dao.CnfrHstrDao;
import com.learn.bbs.pltad.cnfr.service.CnfrHstrService;
import com.learn.exceptions.CnfrHstrInsertException;


/**
 * @author 최예진
 * 확정 내역
 */
@Service
public class CnfrHstrServiceImpl implements CnfrHstrService {

    @Autowired
    private CnfrHstrDao cnfrHstrDao;
}