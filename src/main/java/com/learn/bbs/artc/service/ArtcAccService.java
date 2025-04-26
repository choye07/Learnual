package com.learn.bbs.artc.service;

import java.util.List;

import com.learn.bbs.artc.vo.ArtcAccVO;

public interface ArtcAccService {
	
	public List<ArtcAccVO> selectAllArtcAcc (String artcId);

}