package com.learn.bbs.asgmt.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.bbs.asgmt.dao.AsgmtHstrDao;
import com.learn.bbs.asgmt.service.AsgmtHstrService;
import com.learn.bbs.asgmt.vo.AsgmtHstrCommonVO;
import com.learn.bbs.asgmt.vo.AsgmtHstrVO;
import com.learn.bbs.asgmt.vo.CreateAsgmtHstrRequestVO;
import com.learn.bbs.asgmt.vo.DeleteAsgmtHstrRequestVO;
import com.learn.bbs.asgmt.vo.SearchAsgmtHstrRequestVO;
import com.learn.bbs.file.dao.FlDao;
import com.learn.bbs.file.vo.FlVO;
import com.learn.beans.FileHandler;
import com.learn.beans.FileHandler.StoredFile;
import com.learn.exceptions.AsgmtException;

@Service
public class AsgmtHstrServiceImpl implements AsgmtHstrService {

	@Autowired
	private AsgmtHstrDao asgmtHstrDao;
	
	@Autowired
	private FlDao flDao;

	@Autowired
	private FileHandler fileHandler;
	
	@Transactional(readOnly = true)
	@Override
	public List<AsgmtHstrVO> readAsgmtHstrList(SearchAsgmtHstrRequestVO searchAsgmtHstrRequestVO) {
		return this.asgmtHstrDao.selectAsgmtHstrList(searchAsgmtHstrRequestVO);
	}

	@Transactional(readOnly = true)
	@Override
	public AsgmtHstrVO readOneAsgmtHstr(AsgmtHstrCommonVO asgmtHstrCommonVO) {
		AsgmtHstrVO asgmtHstr = this.asgmtHstrDao.selectOneAsgmtHstr(asgmtHstrCommonVO);
		if (asgmtHstr == null) {
			throw new AsgmtException("존재하지않는 과제입니다.");
		}
		return asgmtHstr;
	}

	@Transactional
	@Override
	public boolean createNewAsgmtHstr(CreateAsgmtHstrRequestVO createAsgmtHstrRequestVO) {
		int insertCount = this.asgmtHstrDao.insertNewAsgmtHstr(createAsgmtHstrRequestVO);
		
		if (insertCount > 0) {
			StoredFile uploadResult = this.fileHandler.store(createAsgmtHstrRequestVO.getAsgmtFile());
			String originalFileName = uploadResult.getFileName();
			FlVO flVO = new FlVO();
			flVO.setFlNm(originalFileName);
			flVO.setFlObfsNm(uploadResult.getRealFileName());
			flVO.setFlPth(uploadResult.getRealFilePath());
			flVO.setFlObfsPth(uploadResult.getRealFilePath());
			flVO.setFlSz(uploadResult.getFileSize());
			flVO.setFlId(originalFileName.substring(originalFileName.lastIndexOf(".") + 1));
			flVO.setArtcId(createAsgmtHstrRequestVO.getArtcId());
			flVO.setId(createAsgmtHstrRequestVO.getAsgmtHstrId());
			//TODO flDao insert 호출
		}
		
		return insertCount > 0;
	}

	@Transactional
	@Override
	public boolean deleteOneAsgmtHstr(DeleteAsgmtHstrRequestVO deleteAsgmtHstrRequestVO) {
		AsgmtHstrVO asgmtHstrVO = this.readOneAsgmtHstr(deleteAsgmtHstrRequestVO);
		int deleteCount = this.asgmtHstrDao.deleteOneAsgmtHstr(deleteAsgmtHstrRequestVO);
		if (deleteCount > 0) {
			//TODO flDao delete 호출
			
			FlVO fl = asgmtHstrVO.getAttachedFile();
			String filePath = fl.getFlObfsPth();
			new File(filePath).delete();
		}
		return deleteCount > 0;
	}
	
}
