package com.learn.exceptions;

public class CrsSbjRegistException extends RuntimeException {
	private static final long serialVersionUID = -7403195042342234625L;

	public CrsSbjRegistException() {
		super("DB 저장에 실패하였습니다.");
	}
	
}
