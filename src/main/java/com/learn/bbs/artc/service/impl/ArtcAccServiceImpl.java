package com.learn.bbs.artc.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learn.bbs.artc.dao.ArtcAccDao;
import com.learn.bbs.artc.service.ArtcAccService;
import com.learn.bbs.artc.vo.ArtcAccVO;

@Service
public class ArtcAccServiceImpl implements ArtcAccService {

    @Autowired
    private ArtcAccDao artcAccDao;

	@Override
	public List<ArtcAccVO> selectAllArtcAcc(String artcId) {
		// TODO 게시판 아이디가 게시판 권한 테이블의 있는지
		
		this.artcAccDao.selectAllArtcAcc(artcId);
		return null;
	}

}
