package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;// =new EnglishTeacher();
	private Coach sportsCoach;

	public PublicSchool() {
		System.out.println("In constructor - " + getClass() + " " + subjectTeacher + " " + sportsCoach);// dependencies
																										// available //
																										// - no null -
	}

	// setter based D.I
	public void setSubjectTeacher(Teacher subjectTeacher) {
		System.out.println("in setter - teacher");
		this.subjectTeacher = subjectTeacher;
	}

	public void setSportsCoach(Coach sportsCoach) {
		System.out.println("in setter - coach");
		this.sportsCoach = sportsCoach;
	}

	@Override
	// B.L method - to use academic staff
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}

	// add B.L method - to organize sports event
	@Override
	public void organizeSportsEvent() {
		System.out.println("organzing sports day !");
		System.out.println(sportsCoach.getDailyWorkout());

	}

	// init method
	public void anyInit() {
		System.out.println("in init of " + getClass());
		System.out.println("In init " + sportsCoach + " " + subjectTeacher);
	}

	// destroy method
	public void anyDestroy() {
		System.out.println("in destroy of " + getClass());
	}
}
