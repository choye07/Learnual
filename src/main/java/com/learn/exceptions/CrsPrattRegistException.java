package com.learn.exceptions;

public class CrsPrattRegistException extends RuntimeException {

	private static final long serialVersionUID = 6717015784118751993L;

	public CrsPrattRegistException(String id) {
		super(id + ": DB 생성에 실패하였습니다.");
	}
}
