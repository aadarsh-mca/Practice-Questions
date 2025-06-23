package com.sms.core;

import com.sms.validator.Constant;
import com.sms.validator.exception.NoCourseAvailableException;

public enum Course {
	DAC(95000.0),
	DBDA(90000.0),
	DITISS(85000.0);
	
	private double fees;
	private static final Course[] allCourse = Course.values(); 
	
	static {
		// System.out.println("Inside Course Enum Static init block ---");
	}
	
	private Course(double fees) {
		this.fees = fees;
		// System.out.println("Inside Course Enum Constructor ---");
	}
	
	public static Course of(int idx) throws NoCourseAvailableException {
		if(idx < 1 || idx > getSize()) {
			throw new NoCourseAvailableException(Constant.NO_COURSE_AVAILABLE);
		}
		return allCourse[idx-1];
	}
	
	public static int getSize() {
		return allCourse.length;
	}
	
	public double getFees() {
		return this.fees;
	}
}