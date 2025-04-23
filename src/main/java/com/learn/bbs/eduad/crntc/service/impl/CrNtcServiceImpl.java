package com.learn.bbs.eduad.crntc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.eduad.crntc.dao.CrNtcDao;
import com.learn.bbs.eduad.crntc.service.CrNtcService;
import com.learn.bbs.eduad.crntc.vo.CrntcListVO;
import com.learn.bbs.eduad.crntc.vo.CrntcUpdateRequestVO;
import com.learn.bbs.eduad.crntc.vo.CrntcVO;
import com.learn.bbs.eduad.crntc.vo.CrntcWriteRequestVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcVO;



/**
 * @author 최예진
 *  강좌 공지사항
 */
@Service
public class CrNtcServiceImpl implements CrNtcService {

    @Autowired
    private CrNtcDao crNtcDao;

	@Override
	public CrntcListVO getAllCourseNotice() {
		// DB에서 강좌공지사항 List 불러와 저장
		List<CrntcVO> insttnNtcList = this.crNtcDao.selectCourseNoticeAll();

		// Controller 에 보낼 학원공지사항목록(List) 데이터 세팅
		CrntcListVO crNtcListVO = new CrntcListVO();
		crNtcListVO.setNtcCnt(this.crNtcDao.selectCourseNoticeAllCount());
		crNtcListVO.setNtcList(insttnNtcList);

		// Controller 에 반환
		return crNtcListVO;
	}
	
	@Override
	public boolean createNewCourseNotice(CrntcWriteRequestVO crntcWriteRequestVO) {
		int insertedCount = this.crNtcDao.insertNewCourseNotice(crntcWriteRequestVO);

		return insertedCount > 0;
	}

	@Override
	public CrntcVO getOneCourseNoticeBy(String id) {
		CrntcVO crntcVO = this.crNtcDao.selectOneCourseNoticeBy(id);
		return crntcVO;
	}

	@Override
	public boolean deleteOneCourseNoticeBy(String id) {
		int deleteCount = this.crNtcDao.deleteOneCourseNoticeBy(id);
		return deleteCount > 0;
	}

	@Override
	public boolean updateOneCourseNoticeBy(CrntcUpdateRequestVO crntcUpdateRequestVO) {
		int updateCount = this.crNtcDao.updateOneCourseNoticeBy(crntcUpdateRequestVO);
		return updateCount > 0;
	}
	

}