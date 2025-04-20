package com.learn.exceptions;

public class CrsSbjDeleteException extends RuntimeException {
	private static final long serialVersionUID = 1374706471419448937L;

	public CrsSbjDeleteException() {
		super("DB 삭제에 실패하였습니다.");
	}
}
