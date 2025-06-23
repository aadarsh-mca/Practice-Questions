package com.cdac.dependency;

import org.springframework.stereotype.Component;

//singleton n eager n derived bean id
@Component //id=englishTeacher
public class EnglishTeacher implements Teacher {
	public EnglishTeacher() {
		System.out.println("In constructor - " + getClass());
	}

	@Override
	public void teach() {
		System.out.println("Practice English Grammar");
	}

}
