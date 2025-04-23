package com.learn.bbs.eduad.flarch.dao;

import java.util.List;

import com.learn.bbs.eduad.flarch.vo.FlArchDeleteRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchSearchRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchUpdateRequestVO;
import com.learn.bbs.eduad.flarch.vo.FlArchVO;
import com.learn.bbs.eduad.flarch.vo.FlArchWriteRequestVO;

public interface FlArchDao {

	// 게시글 총 갯수
	public int selectAllFlArchBoardCount(FlArchSearchRequestVO flArchSearchRequestVO);

	// 게시글 목록
	public List<FlArchVO> selectAllFlArchBoard(FlArchSearchRequestVO flArchSearchRequestVO);

	// 게시글 등록
	public int insertNewFlArchBoard(FlArchWriteRequestVO flArchWriteRequestVO);

	// 조회수 증가
	public int updateViewCountBy(String flArchId);

	// 게시글 조회
	public FlArchVO selectOneFlArchBoard(String flArchId);

	// 게시글 삭제
	public int deleteOneFlArchBoard(FlArchDeleteRequestVO flArchDeleteRequestVO);

	// 게시글 수정
	public int updateOneFlArchBoard(FlArchUpdateRequestVO flArchUpdateRequestVO);

}