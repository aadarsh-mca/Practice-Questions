package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;


public class PublicSchool implements School {	
	private Teacher subjectTeacher;//=new EnglishTeacher();
	private Coach sportsCoach;
	
	//constr based D.I
	public PublicSchool(Teacher myTeacher) {
		this.subjectTeacher = myTeacher;
		System.out.println("=== [ In constructor ] === - " + getClass() + " " + "\n\tsubTeacher :: " + subjectTeacher + "\n\tsportsTeacher :: " + sportsCoach);
	}
	
	// Optional dependencies are injected - setter based Dependency Injection
	public void setSportsCoach(Coach myCoach) {
		this.sportsCoach = myCoach;
		System.out.println("=== [ In setter ] === - " + getClass() + " " + "\n\tsubTeacher :: " + subjectTeacher + "\n\tsportsTeacher :: " + sportsCoach);
	}

	
	//init method
	public void anyInit() {
		System.out.println("in init of " + getClass());
		System.out.println("=== [ In Init ] === - " + getClass() + " " + "\n\tsubTeacher :: " + subjectTeacher + "\n\tsportsTeacher :: " + sportsCoach);
	}
	
	//destroy method
	public void anyDestroy() {
		System.out.println("in destroy of "+getClass());
	}


	/**
	 * Business Logic
	 */
	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -- ");
		subjectTeacher.teach();
	}
	
	@Override
	public void organizeSportsEvent() {
		System.out.println("Organizing sports here -- ");
		System.out.println(sportsCoach.getDailyWorkout());
	}

}
