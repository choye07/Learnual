package com.learn.main.ntc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.main.ntc.dao.MainNtcDao;
import com.learn.main.ntc.service.MainNtcService;
import com.learn.main.ntc.vo.NtcListVO;
import com.learn.main.ntc.vo.NtcUpdateRequestVO;
import com.learn.main.ntc.vo.NtcVO;
import com.learn.main.ntc.vo.NtcWriteRequestVO;


/**
 * @TableName NTC
 * @TableComment null
 * 러뉴얼 공지사항 
 */
@Service
public class MainNtcServiceImpl implements MainNtcService {

    @Autowired
    private MainNtcDao mainNtcDao;
    
	@Override
	public boolean createNewMainNotice(NtcWriteRequestVO ntcWriteRequestVO) {
		int insertedCount = this.mainNtcDao.insertNewMainNotice(ntcWriteRequestVO);
		
		return insertedCount > 0;
	}

	@Override
	public NtcListVO getAllMainNotice() {
		NtcListVO ntcListVO = new NtcListVO();
		List<NtcVO> mainNtcListVO =this.mainNtcDao.selectMainNoticeAll();
		
		ntcListVO.setNtcCnt(this.mainNtcDao.selectMainNoticeAllCount());
		ntcListVO.setNtcList(mainNtcListVO);
		
		return ntcListVO;
	}

	@Override
	public NtcVO getOneMainNotcie(String id) {
		NtcVO ntcVO = this.mainNtcDao.selecOneMainNotice(id);
		return ntcVO;
	}

	@Override
	public boolean deleteOneMainNoticeBy(String id) {
		int deleteCount = this.mainNtcDao.deleteOneMainNotice(id);
		return deleteCount > 0;
	}

	@Override
	public boolean updateOneMainNoticeBy(NtcUpdateRequestVO ntcUpdateRequestVO) {
		int updateCount = this.mainNtcDao.updateOneMainNoticeBy(ntcUpdateRequestVO);
		return updateCount > 0;
	}
	

}