package com.learn.bbs.artc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bbs.artc.dao.ArtcAccDao;
import com.learn.bbs.artc.dao.ArtcDao;
import com.learn.bbs.artc.service.ArtcService;
import com.learn.bbs.artc.vo.ArtcReadRequestVO;
import com.learn.bbs.artc.vo.ArtcRegistRequestVO;
import com.learn.bbs.artc.vo.ArtcVO;

@Service
public class ArtcServiceImpl implements ArtcService {

    @Autowired
    private ArtcDao artcDao;
    
    @Autowired
    private ArtcAccDao artAccDao;

	@Override
	public List<ArtcVO> selectAllArtc(ArtcReadRequestVO ArtcReadRequestVO) {
		// TO-DO 로그인 유저의 권한- 체크
		
		// TO-DO  
		return null;
	}

	@Override
	public boolean createNewArtc(ArtcRegistRequestVO artcRegistRequestVO) {
		
		int insertCount = this.artcDao.insertNewArtc(artcRegistRequestVO);
		
		
		if(insertCount>0) {
			this.artAccDao.insertNewArtcAcc(artcRegistRequestVO);
		}
		
		return insertCount>0;
	}

}