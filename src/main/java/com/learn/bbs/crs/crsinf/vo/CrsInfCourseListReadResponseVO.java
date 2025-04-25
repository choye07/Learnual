package com.learn.bbs.crs.crsinf.vo;

import java.util.List;

public class CrsInfCourseListReadResponseVO {
    private boolean isRegistered;
    private List<CrsInfAvailableReadResponseVO> courseList;
    
	public boolean getIsRegistered() {
		return isRegistered;
	}
	public void setIsRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	public List<CrsInfAvailableReadResponseVO> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<CrsInfAvailableReadResponseVO> courseList) {
		this.courseList = courseList;
	}
}
