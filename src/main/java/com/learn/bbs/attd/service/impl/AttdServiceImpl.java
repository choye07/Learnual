package com.learn.bbs.attd.service.impl;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.attd.dao.AttdDao;
import com.learn.bbs.attd.service.AttdService;
import com.learn.bbs.attd.vo.AttdRegistRequestVO;
import com.learn.bbs.crs.crsinf.dao.CrsInfDao;
import com.learn.bbs.crs.crsinf.vo.CrsInfStartAndEndTimeRequestVO;
import com.learn.util.DateTimeFormatterUtil;


/**
 * @author 최예진
 * 신청 내역
 */
@Service
public class AttdServiceImpl implements AttdService {

    @Autowired
    private AttdDao attdDao;
    
    @Autowired
    private CrsInfDao crsInfDao;

	@Override
	public boolean createNewUsrAttd(AttdRegistRequestVO attdRegistRequestVO) {
		
		// 1. 유저 id 세션으로 보낸거 확인.
		return this.attdDao.insertNewUsrAttd(attdRegistRequestVO) > 0;
	}

	@Override
	public AttdRegistRequestVO doUsrAttd(AttdRegistRequestVO attdRegistRequestVO) {
		
		boolean isAttdSuccess = this.createNewUsrAttd(attdRegistRequestVO);
		
		if(isAttdSuccess) {
			
			AttdRegistRequestVO registRequestVO  =  this.attdDao.selectOneUsrAttdBy(attdRegistRequestVO.getUsrMl());
			
			// 강좌정보를 조회해서 해당 강좌의 시작 시간과 마지막 시간을 알아낸다.
			 CrsInfStartAndEndTimeRequestVO crsInfStartAndEndTimeRequestVO = this.crsInfDao.selectCourseTimeStartAndEnd(registRequestVO.getCrsInfId());
			 
			// 사용자 출석 시간 (yyyyMMdd HH:mm) 형식 
			 LocalDateTime startUsrTime =  DateTimeFormatterUtil.parseDateTime(registRequestVO.getAttdRgstDt());
			// 강좌 수업시작 시간 HH:mm 형식 
			 //LocalTime startCourseTime = DateTimeFormatterUtil.parseTime("01:22");
			 LocalTime startCourseTime = DateTimeFormatterUtil.parseTime(crsInfStartAndEndTimeRequestVO.getCrsInfStDt());
			 
			 // 강좌 시작 전이나 정각에 출석 할 경우를 고려 
			 if (startUsrTime.toLocalTime().isBefore(startCourseTime) || startUsrTime.toLocalTime().equals(startCourseTime)) {
		            attdRegistRequestVO.setAttdUsrCurrent("출석");
		            attdRegistRequestVO.setAttdDlyYn("Y");
		        } 
			 	else {
			 		attdRegistRequestVO.setAttdUsrCurrent("지각");
			 		attdRegistRequestVO.setAttdTdYn("Y");
			 		attdRegistRequestVO.setAttdDlyYn("N");
			 	
		        }
		}
		
		return attdRegistRequestVO;
	}

	@Override
	public boolean updateUsrAttdCurrent(AttdRegistRequestVO attdRegistRequestVO) {
		
		// 가장 최신 출석 날짜를 가져온다. 
		AttdRegistRequestVO registRequestVO  =  this.attdDao.selectOneUsrAttdBy(attdRegistRequestVO.getUsrMl());
		return this.attdDao.updateOneUsrAttdCurrent(attdRegistRequestVO) > 0;
	}
    
	
    

}