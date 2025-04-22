package com.learn.bbs.asgmt.vo;

import org.springframework.web.multipart.MultipartFile;

public class CreateAsgmtHstrRequestVO extends AsgmtHstrCommonVO {

	private MultipartFile asgmtFile;

	public MultipartFile getAsgmtFile() {
		return asgmtFile;
	}

	public void setAsgmtFile(MultipartFile asgmtFile) {
		this.asgmtFile = asgmtFile;
	}

}
