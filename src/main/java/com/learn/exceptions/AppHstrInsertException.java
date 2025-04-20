package com.learn.exceptions;

public class AppHstrInsertException extends RuntimeException {

	private static final long serialVersionUID = -7745413325055425294L;

	public AppHstrInsertException(String id) {
		super(id + ": DB 저장에 실패하였습니다.");
	}
}
