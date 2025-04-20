package com.learn.exceptions;

public class CrsInfUpdateException extends RuntimeException {
	private static final long serialVersionUID = 6722719972034489874L;

	public CrsInfUpdateException(String id) {
		super(id + ": DB 수정에 실패하였습니다.");
	}
}
