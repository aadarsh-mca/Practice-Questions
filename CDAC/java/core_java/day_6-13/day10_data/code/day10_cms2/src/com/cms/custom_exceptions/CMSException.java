package com.cms.custom_exceptions;

@SuppressWarnings("serial")
public class CMSException extends Exception {
	public CMSException(String errorMesg) {
		super(errorMesg);
	}

}
