package com.learn.bbs.artc.dao;

import java.util.List;

import com.learn.bbs.artc.vo.ArtcReadRequestVO;
import com.learn.bbs.artc.vo.ArtcRegistRequestVO;
import com.learn.bbs.artc.vo.ArtcVO;

public interface ArtcDao {

	public int insertNewArtc(ArtcRegistRequestVO artcRegistRequestVO);

	public List<ArtcVO> selectAllArtc(ArtcReadRequestVO artcReadRequestVO);

}