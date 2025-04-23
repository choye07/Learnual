package com.learn.exceptions;

public class CnfrHstrInsertException extends RuntimeException {

	private static final long serialVersionUID = -3637701853942487556L;

	public CnfrHstrInsertException() {
		super("DB 저장에 실패하였습니다.");
	}
}
