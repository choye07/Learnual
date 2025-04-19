package com.learn.exceptions;

public class CrsInfDeleteException extends RuntimeException {
	private static final long serialVersionUID = 388887191732715123L;

	public CrsInfDeleteException() {
		super("DB 삭제(Soft delete)에 실패하였습니다.");
	}
}
