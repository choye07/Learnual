package com.learn.main.sprad.service;

import com.learn.main.sprad.vo.SpradRegistRequestVO;

public interface SpradService {
	//슈퍼관리자 등록
	public boolean createNewSprad(SpradRegistRequestVO spradRegistRequestVO);
}