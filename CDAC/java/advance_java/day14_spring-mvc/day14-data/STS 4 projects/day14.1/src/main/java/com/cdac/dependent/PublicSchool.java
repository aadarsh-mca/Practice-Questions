package com.cdac.dependent;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;// =new EnglishTeacher();
	private Coach sportsCoach;

	
	private PublicSchool(Teacher myTeacher,Coach myCoach) {
		this.subjectTeacher = myTeacher;
		this.sportsCoach=myCoach;
		System.out.println("In constructor - " + getClass() 
		+ " " + subjectTeacher + " " + sportsCoach);// dependencies available																// - no null -
	}

	@Override
	// B.L method - to use academic staff
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
	}
	//add B.L method - to organize sports event
	@Override
	public void organizeSportsEvent() {
		System.out.println("organzing sports day !");
		 System.out.println(sportsCoach.getDailyWorkout());
		
	}
	

	// init method
	public void anyInit() {
		System.out.println("in init of " + getClass());
		System.out.println("In init "+ sportsCoach+" "+subjectTeacher);
	}
	// destroy method
	public void anyDestroy() {
		System.out.println("in destroy of " + getClass());
	}
	//Factory method D.I
	public static PublicSchool myFactoryMethod(Teacher teacher123,Coach coach123)
	{
		System.out.println("in factory method");
		return new PublicSchool(teacher123, coach123);//partial IoC
	}
	
	

}
