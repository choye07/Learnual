package com.learn.bbs.pltad.ntc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.pltad.ntc.dao.InsttnNtcDao;
import com.learn.bbs.pltad.ntc.service.InsttnNtcService;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcListVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcUpdateRequestVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcVO;
import com.learn.bbs.pltad.ntc.vo.InsttnNtcWriteRequestVO;

/**
 * @TableName NTC
 * @TableComment null 러뉴얼 공지사항
 */
@Service
public class InsttnNtcServiceImpl implements InsttnNtcService {

	@Autowired
	private InsttnNtcDao insttnNtcDao;

	@Override
	public boolean createNewInsttnNotice(InsttnNtcWriteRequestVO insttnNtcWriteRequestVO) {
		int insertedCount = this.insttnNtcDao.insertNewInsttnNotice(insttnNtcWriteRequestVO);

		return insertedCount > 0;
	}

	@Override
	public InsttnNtcListVO getAllInsttnNotice() {
		// DB에서 학원공지사항 List 불러와 저장
		List<InsttnNtcVO> insttnNtcList = this.insttnNtcDao.selectInsttnNoticeAll();

		// Controller 에 보낼 학원공지사항목록(List) 데이터 세팅
		InsttnNtcListVO insttnNtcListVO = new InsttnNtcListVO();
		insttnNtcListVO.setNtcCnt(this.insttnNtcDao.selectInsttnNoticeAllCount());
		insttnNtcListVO.setNtcList(insttnNtcList);

		// Controller 에 반환
		return insttnNtcListVO;
	}

	@Override
	public InsttnNtcVO getOneInsttnNoticeBy(String id) {
		InsttnNtcVO insttnNtcVO = this.insttnNtcDao.selectOneInsttnNoticeBy(id);
		return insttnNtcVO;
	}
//
//	@Override
	public boolean deleteOneInsttnNoticeBy(String id) {
		int deleteCount = this.insttnNtcDao.deleteOneInsttnNoticeBy(id);
		return deleteCount > 0;
	}
//
	@Override
	public boolean updateOneInsttnNoticeBy(InsttnNtcUpdateRequestVO insttnNtcUpdateRequestVO) {
		int updateCount = this.insttnNtcDao.updateOneInsttnNoticeBy(insttnNtcUpdateRequestVO);
		return updateCount > 0;
	}

}