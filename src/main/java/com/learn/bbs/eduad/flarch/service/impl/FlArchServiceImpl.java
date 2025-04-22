package com.learn.bbs.eduad.flarch.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.learn.bbs.eduad.flarch.dao.FlArchDao;
import com.learn.bbs.eduad.flarch.service.FlArchService;
import com.learn.bbs.eduad.flarch.vo.FlArchDeleteRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchListVO;
import com.learn.bbs.eduad.flarch.vo.FlArchSearchRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchUpdateRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchVO;
import com.learn.bbs.eduad.flarch.vo.FlArchWriteRequestVO;
import com.learn.bbs.file.dao.FlDao;
import com.learn.bbs.file.dao.FlTypeDao;
import com.learn.bbs.file.vo.FlDeleteRequestVO;
import com.learn.bbs.file.vo.FlTypeVO;
import com.learn.bbs.file.vo.FlVO;
import com.learn.beans.FileHandler;
import com.learn.beans.FileHandler.StoredFile;
import com.learn.exceptions.PageNotFoundException;

@Service
public class FlArchServiceImpl implements FlArchService {

	// 로그를 쓰기 위한 설정
	private static final Logger LOGGER = LoggerFactory.getLogger(FlArchServiceImpl.class);

	@Autowired
	private FlArchDao flArchDao;
	@Autowired
	private FileHandler fileHandler;
	@Autowired
	private FlDao flDao;
	@Autowired
	private FlTypeDao flTypeDao;

	@Transactional(readOnly = true)
	@Override
	public FlArchListVO getFlArchBoardList(FlArchSearchRequestVO flArchSearchRequestVO) {
		int count = this.flArchDao.selectAllFlArchBoardCount(flArchSearchRequestVO);
		// 총 게시글의 수를 가져와서 넣어준다.
		flArchSearchRequestVO.setPageCount(count);

		List<FlArchVO> flArchList = this.flArchDao.selectAllFlArchBoard(flArchSearchRequestVO);

		FlArchListVO flArchListVO = new FlArchListVO();
		flArchListVO.setFlArchCnt(count);
		flArchListVO.setFlArchList(flArchList);
		return flArchListVO;
	}

	@Transactional
	@Override
	public boolean createNewFlArchBoard(FlArchWriteRequestVO flArchWriteRequestVO) {

		// dao의 insert 실행
		int insertCount = this.flArchDao.insertNewFlArchBoard(flArchWriteRequestVO);

		if (insertCount > 0) {
			
			List<MultipartFile> flList = flArchWriteRequestVO.getFlList();
			
			if (flList != null && !flList.isEmpty()) {
			// // 파일을 여러 개 올릴 수 있으니깐 for문으로 파일 여러 개 만들어야한다.
				for (MultipartFile file : flList) {
					// 사용자가 업로드한 파일을 서버에 저장하는 객체
					StoredFile storedFile = this.fileHandler.store(file);

					if (storedFile != null) {
						FlVO flVO = new FlVO();
						flVO.setId(flArchWriteRequestVO.getFlArchId());  // 이 값이 이제 null이 아님!
						flVO.setFlNm(storedFile.getFileName());
						flVO.setFlObfsNm(storedFile.getRealFileName());
						flVO.setFlObfsPth(storedFile.getRealFilePath());
						flVO.setFlSz(storedFile.getFileSize());
						flVO.setFlTypeNm(storedFile.getFileType());
						// 데이터 베이스에 파일 테이블에 파일 정보를 저장한다
						this.flDao.insertNewFile(flVO);
					}
				}
			} else {
				flArchWriteRequestVO.setFlList(new ArrayList<>()); // 선택 사항
			}
		}

		return insertCount > 0;
	}

	@Transactional
	@Override
	public FlArchVO getOneFlArchBoard(String flArchId, boolean isIncrease) {

		if (isIncrease) {
			// 조회하려는 게시글의 조회수를 증가시킨다.
			int updatedCount = this.flArchDao.updateViewCountBy(flArchId);

			// 게시글 조회수 증가 방지
			if (updatedCount == 0) {
				throw new PageNotFoundException(flArchId);
			}
		}

		FlArchVO flArchVO = this.flArchDao.selectOneFlArchBoard(flArchId);

		if (flArchVO == null) {
			throw new PageNotFoundException(flArchId);
		}
		
		// 첨부파일이 없는 게시글인 경우 
		// flList가 null이 아니라 빈 리스트라도 들어가도록 유효성 처리
		// 파일 정보가 아예 조회되지 않음 = null 상태로 남음 = 예외 처리 구간에서 문제가 됨.
		List<FlVO> fileList = this.flDao.selectFilesById(flArchId);
		flArchVO.setFlList(fileList != null ? fileList : new ArrayList<>());

		// 파일 확장자 변환 기능 - 추후에 추가하는 기능
//		if (flArchVO != null && flArchVO.getFlList() != null) {
//			for (FlVO file : flArchVO.getFlList()) {
//				// 예: ".hwp", ".docx" 등에서 확장자만 뽑거나 가공
//				String fileExt = file.getFlTypeNm();
//
//				// FL_TYPE 테이블에 존재하는 변환 가능한 확장자를 조회한다.
//				List<String> convertibleTypeNm = new ArrayList<>();
//				List<FlTypeVO> convertibleTypes = this.flTypeDao.selectFlMdfyTypes(fileExt);
//				for (FlTypeVO fltypeVO : convertibleTypes) {
//					convertibleTypeNm.add(fltypeVO.getFlMdfyType());
//				}
//
//				// 뷰로 드롭박스에서 확장자 선택을 받아온다 -> Controller에서 model 받아야함
//				
//			}
//		}
		// 게시글 반환.
		return flArchVO;
	}

	@Transactional
	@Override
	public boolean deleteOneFlArchBoard(FlArchDeleteRequestVO flArchDeleteRequestVO) {

		// 1. 파일 먼저 삭제
		// 유효한 게시글 번호라면 파일도 같이 삭제되도록 한다.
		if (flArchDeleteRequestVO.getFlArchId() != null) {
			FlDeleteRequestVO flDeleteRequestVO = new FlDeleteRequestVO();
			flDeleteRequestVO.setId(flArchDeleteRequestVO.getFlArchId()); // 게시글 ID만으로 삭제

			// 해당 게시글의 모든 파일이 삭제된다.
			this.flDao.deleteAllFiles(flDeleteRequestVO);
		}

		// 2. 게시글 삭제
		int deleteCount = this.flArchDao.deleteOneFlArchBoard(flArchDeleteRequestVO);

		// 삭제된 게시글의 수가 0이라면 에러 발생
		if (deleteCount == 0) {
			throw new PageNotFoundException(flArchDeleteRequestVO.getFlArchId());
		}
		return deleteCount > 0;
	}

	@Transactional
	@Override
	public boolean updateOneFlArchBoard(FlArchUpdateRequestVO flArchUpdateRequestVO) {

		String flArchId = flArchUpdateRequestVO.getFlArchId();

	    // 1. 게시글 수정
	    int updateCount = this.flArchDao.updateOneFlArchBoard(flArchUpdateRequestVO);
	    if (updateCount == 0) {
	        throw new PageNotFoundException(flArchId);
	    }

	    // 2. 삭제 요청된 파일만 삭제
	    List<String> deleteFileIds = flArchUpdateRequestVO.getDeleteFileIds();
	    if (deleteFileIds != null && !deleteFileIds.isEmpty()) {
	        for (String flId : deleteFileIds) {
	        	FlDeleteRequestVO deleteRequestVO = new FlDeleteRequestVO();
	    		deleteRequestVO.setId(flArchId);
	    		deleteRequestVO.setFlId(flId);
	    		this.flDao.deleteOneFile(deleteRequestVO);
	        }
	    }

	    // 3. 새 파일 등록
	    List<MultipartFile> newFiles = flArchUpdateRequestVO.getFlList();
	    if (newFiles != null && !newFiles.isEmpty()) {
	        for (MultipartFile file : newFiles) {
	            if (file.isEmpty()) continue;

	            StoredFile storedFile = this.fileHandler.store(file);

	            if (storedFile != null) {
	                FlVO flVO = new FlVO();
	                flVO.setId(flArchId);
	                flVO.setFlNm(storedFile.getFileName());
	                flVO.setFlObfsNm(storedFile.getRealFileName());
	                flVO.setFlObfsPth(storedFile.getRealFilePath());
	                flVO.setFlSz(storedFile.getFileSize());
	                flVO.setFlTypeNm(storedFile.getFileType());

	                this.flDao.insertNewFile(flVO);
	            }
	        }
	    }

	    return true;
	}
}