package com.learn.exceptions;

public class AccessDeniedException extends RuntimeException {

	private static final long serialVersionUID = 1013627839346503486L;

	public AccessDeniedException() {
		super("해당 페이지에 접근할 권한이 없습니다.");
	}
}
