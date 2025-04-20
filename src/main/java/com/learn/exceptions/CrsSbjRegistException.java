package com.learn.exceptions;

public class CrsSbjRegistException extends RuntimeException {
	private static final long serialVersionUID = -7403195042342234625L;

	public CrsSbjRegistException(String id) {
		super(id + ": DB 저장에 실패하였습니다.");
	}
}
