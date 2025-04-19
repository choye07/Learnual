package com.learn.bbs.crs.crsinf.vo;

public class CrsInfAvailableReadResponseVO extends CrsInfPltadReadResponseVO {
	private boolean availableToday;

	public boolean isAvailableToday() {
		return availableToday;
	}

	public void setAvailableToday(boolean availableToday) {
		this.availableToday = availableToday;
	}
}
