package com.learn.exceptions;

public class CrsInfRegistException extends RuntimeException {

	private static final long serialVersionUID = -4695480374264704615L;

	public CrsInfRegistException() {
		super("DB 저장에 실패하였습니다.");
	}
	
}
