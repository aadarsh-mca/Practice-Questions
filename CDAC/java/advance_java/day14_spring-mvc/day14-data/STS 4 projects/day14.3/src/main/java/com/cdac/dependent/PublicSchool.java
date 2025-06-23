package com.cdac.dependent;

import java.util.Arrays;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher[] subjectTeachers;// =new EnglishTeacher();
	private Coach[] sportsCoaches;

	public PublicSchool() {
		System.out.println("In constructor - " + getClass() + " " + subjectTeachers + " " + sportsCoaches);// dependencies

	}

	// setter based D.I
	public void setSubjectTeachers(Teacher[] subjectTeachers) {
		System.out.println("in set teachers");
		this.subjectTeachers = subjectTeachers;
	}

	public void setSportsCoaches(Coach[] sportsCoaches) {
		System.out.println("in set coaches");
		this.sportsCoaches = sportsCoaches;
	}
	
	@Override
	// B.L method - to use academic staff
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		Arrays.stream(subjectTeachers).forEach(Teacher :: teach); //s -> s.teach()
	}

	

	// add B.L method - to organize sports event
	@Override
	public void organizeSportsEvent() {
		System.out.println("organzing sports day !");
		Arrays.stream(sportsCoaches)
		.forEach(coach -> System.out.println(coach.getDailyWorkout()));
	}

	// init method
	public void anyInit() {
		System.out.println("in init of " + getClass());
		System.out.println("In init " + sportsCoaches + " " + subjectTeachers);
	}

	// destroy method
	public void anyDestroy() {
		System.out.println("in destroy of " + getClass());
	}
}
