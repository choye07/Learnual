package com.learn.bbs.artc.service;

import java.util.List;

import com.learn.bbs.artc.vo.ArtcReadRequestVO;
import com.learn.bbs.artc.vo.ArtcRegistRequestVO;
import com.learn.bbs.artc.vo.ArtcVO;

public interface ArtcService {
	
	public List<ArtcVO> selectAllArtc(ArtcReadRequestVO ArtcReadRequestVO);
	
	public boolean createNewArtc(ArtcRegistRequestVO artcRegistRequestVO);

}