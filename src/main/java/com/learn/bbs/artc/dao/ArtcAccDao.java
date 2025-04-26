package com.learn.bbs.artc.dao;

import java.util.List;

import com.learn.bbs.artc.vo.ArtcAccVO;
import com.learn.bbs.artc.vo.ArtcRegistRequestVO;

public interface ArtcAccDao {

	public List<ArtcAccVO> selectAllArtcAcc(String artcId);

	public int insertNewArtcAcc(ArtcRegistRequestVO artcRegistRequestVO );
}