package com.learn.bbs.crs.apphstr.service;

import java.util.List;

import com.learn.bbs.crs.apphstr.vo.AppHstrReadResponseVO;
import com.learn.bbs.crs.apphstr.vo.AppHstrRegistRequestVO;

/**
 * @author 최예진
 * 신청 내역
 */
public interface AppHstrService {
    public boolean insertOneAppHstr(AppHstrRegistRequestVO appHstrRegistRequestVO);
    
    public List<AppHstrReadResponseVO> selectCurrentUserInCourse(String crsInfId, String insttnId);
    
    public String selectCourseName(String crsInfId, String insttnId);
}