package com.learn.bbs.rsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.learn.bbs.file.dao.FlDao;
import com.learn.bbs.file.vo.FlDeleteRequestVO;
import com.learn.bbs.file.vo.FlDownloadRequestVO;
import com.learn.bbs.file.vo.FlVO;
import com.learn.bbs.rsm.dao.RsmDao;
import com.learn.bbs.rsm.service.RsmService;
import com.learn.bbs.rsm.vo.RsmDeleteRequestVO;
import com.learn.bbs.rsm.vo.RsmListVO;
import com.learn.bbs.rsm.vo.RsmSearchRequestVO;
import com.learn.bbs.rsm.vo.RsmUpdateRequestVO;
import com.learn.bbs.rsm.vo.RsmVO;
import com.learn.bbs.rsm.vo.RsmWriteRequestVO;
import com.learn.beans.FileHandler;
import com.learn.beans.FileHandler.StoredFile;
import com.learn.exceptions.NotExistsException;
import com.learn.exceptions.PageNotFoundException;

@Service
public class RsmServiceImpl implements RsmService {

	@Autowired
	private RsmDao rsmDao;
	@Autowired
	private FileHandler fileHandler;
	@Autowired
	private FlDao flDao;

	@Transactional(readOnly = true)
	@Override
	public RsmListVO getAllRsm(RsmSearchRequestVO rsmSearchRequestVO) {
		int count = this.rsmDao.selectAllRsmCount(rsmSearchRequestVO);
		// 총 게시글의 수를 가져와 넣어준다.
		rsmSearchRequestVO.setPageCount(count);

		List<RsmVO> rsmList = this.rsmDao.selectAllRsm(rsmSearchRequestVO);

		RsmListVO rsmListVO = new RsmListVO();
		rsmListVO.setRsmCnt(count);
		rsmListVO.setRsmList(rsmList);
		return rsmListVO;
	}

	@Transactional
	@Override
	public boolean createNewRsm(RsmWriteRequestVO rsmWriteRequestVO) {
		// dao의 insert 실행
		int insertCount = this.rsmDao.insertNewRsm(rsmWriteRequestVO);

		if (insertCount > 0) {

			MultipartFile rsm = rsmWriteRequestVO.getFile();

			if (rsm != null && !rsm.isEmpty()) {

				// 사용자가 업로드한 파일을 서버에 저장하는 객체
				StoredFile storedFile = this.fileHandler.store(rsm);

				if (storedFile != null) {
					FlVO flVO = new FlVO();
					flVO.setId(rsmWriteRequestVO.getRsmId());
					flVO.setFlNm(storedFile.getFileName());
					flVO.setFlObfsNm(storedFile.getRealFileName());
					flVO.setFlObfsPth(storedFile.getRealFilePath());
					flVO.setFlSz(storedFile.getFileSize());
					flVO.setFlTypeNm(storedFile.getFileType());
					// 데이터 베이스에 파일 테이블에 파일 정보를 저장한다
					this.flDao.insertNewFile(flVO);
				}
			} else {
				// 이력서 파일을 안올린 경우 에러를 보낸다.
				throw new NotExistsException();
			}
		}
		return insertCount > 0;
	}

	@Transactional
	@Override
	public boolean deleteOneRsm(RsmDeleteRequestVO rsmDeleteRequestVO) {

		// 유효한 게시글 번호라면, 이력서 파일 삭제 여부 Y로 변경
		if (rsmDeleteRequestVO.getRsmId() != null && rsmDeleteRequestVO.getFile() != null) {
			FlDeleteRequestVO flDeleteRequestVO = new FlDeleteRequestVO();
			flDeleteRequestVO.setId(rsmDeleteRequestVO.getRsmId());
			flDeleteRequestVO.setFlId(rsmDeleteRequestVO.getFile().getFlId());

			// 한 이력서 게시글의 파일 한개가 삭제여부가 Y로 바뀐다.
			this.flDao.deleteFileData(flDeleteRequestVO);
		}
		// 이력서 게시글 삭제
		int deleteCount = this.rsmDao.deleteOneRsm(rsmDeleteRequestVO);
		System.out.println("Delete Count: " + deleteCount);

		// 삭제된 게시글의 수가 0이라면 에러 발생
		if (deleteCount == 0) {
			throw new PageNotFoundException(rsmDeleteRequestVO.getRsmId());
		}
		return deleteCount > 0;
	}

	@Transactional
	@Override
	public boolean updateOneRsm(RsmUpdateRequestVO rsmUpdateRequestVO) {
		String rsmId = rsmUpdateRequestVO.getRsmId();

		// 1. 게시글 수정
		int updateCount = this.rsmDao.updateOneRsm(rsmUpdateRequestVO);
		if (updateCount == 0) {
			throw new PageNotFoundException(rsmId);
		}

		// 2. 새 파일 등록
		if (updateCount > 0) {

			MultipartFile newRsm = rsmUpdateRequestVO.getFile();

			if (newRsm != null && !newRsm.isEmpty()) {

				// 사용자가 업로드한 파일을 서버에 저장하는 객체
				StoredFile storedFile = this.fileHandler.store(newRsm);

				if (storedFile != null) {
					FlVO flVO = new FlVO();
					flVO.setId(rsmUpdateRequestVO.getRsmId());
					flVO.setFlNm(storedFile.getFileName());
					flVO.setFlObfsNm(storedFile.getRealFileName());
					flVO.setFlObfsPth(storedFile.getRealFilePath());
					flVO.setFlSz(storedFile.getFileSize());
					flVO.setFlTypeNm(storedFile.getFileType());
					// 데이터 베이스에 파일 테이블에 파일 정보를 저장한다
					this.flDao.insertNewFile(flVO);
				}
			} else {
				// 이력서 파일을 안올린 경우 에러를 보낸다.
				throw new NotExistsException();
			}
		}
		// 게시글 수정 성공
		return true;
	}

}