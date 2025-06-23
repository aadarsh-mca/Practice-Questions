package com.sms.core;

import java.util.Objects;

public class UniqueStudentKey {
	
	private String prnId;
	private String email;
	
	public UniqueStudentKey(String prnId, String email) {
		this.prnId = prnId;
		this.email = email;
	}
	
	@Override
	public boolean equals(Object aObj) {
		if(aObj instanceof UniqueStudentKey) {
			UniqueStudentKey anotherKey = (UniqueStudentKey)aObj;
			if(this.prnId.equals(anotherKey.prnId) && this.email.equals(anotherKey.email)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.prnId, this.email);
	}

	public String getPrnId() {
		return prnId;
	}

	public String getEmail() {
		return email;
	}
}
