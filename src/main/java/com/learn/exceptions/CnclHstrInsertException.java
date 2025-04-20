package com.learn.exceptions;

public class CnclHstrInsertException extends RuntimeException {

	private static final long serialVersionUID = -6142777210151916041L;

	public CnclHstrInsertException(String id) {
		super(id + ": DB 저장에 실패하였습니다.");
	}
}
