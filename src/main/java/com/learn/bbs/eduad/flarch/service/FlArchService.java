package com.learn.bbs.eduad.flarch.service;

import com.learn.bbs.eduad.flarch.vo.FlArchDeleteRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchListVO;
import com.learn.bbs.eduad.flarch.vo.FlArchSearchRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchUpdateRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchVO;
import com.learn.bbs.eduad.flarch.vo.FlArchWriteRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlarchViewRequestVO;

public interface FlArchService {

		// 게시글 목록
		public FlArchListVO getFlArchBoardList(FlArchSearchRequestVO flArchSearchRequestVO);

		// 게시글 등록
		public boolean createNewFlArchBoard(FlArchWriteRequestVO flArchWriteRequestVO);	
		
		// 게시글 조회
		public FlArchVO getOneFlArchBoard(FlarchViewRequestVO flarchViewRequestVO, boolean isIncrease);

		// 게시글 삭제
		public boolean deleteOneFlArchBoard(FlArchDeleteRequestVO flArchDeleteRequestVO);

		// 게시글 수정
		public boolean updateOneFlArchBoard(FlArchUpdateRequestVO flArchUpdateRequestVO);
		
}