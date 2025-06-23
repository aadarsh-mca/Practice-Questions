package com.cdac.dependent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cdac.dependency.Coach;
import com.cdac.dependency.Teacher;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//singleton n eager , id=public_school
//dependencies - sc teacher , swimming coach
@Component("public_school")
public class PublicSchool implements School {

	// Field Level D.I - matching byName
	@Autowired//(required = false)
	@Qualifier("sc")
	private Teacher subjectTeacher;
	@Autowired // Field Level D.I - matching byName(name of field tries to mathc it with the
				// bean id)
	@Qualifier("swimming")
	private Coach sportsCoach;

	public PublicSchool() {
		System.out.println("in ctor " + getClass() + " " + subjectTeacher + " " + sportsCoach);

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
	@PostConstruct
	public void anyInit() {
		System.out.println("in init of " + getClass());
		System.out.println("In init " + sportsCoach + " " + subjectTeacher);
	}

	// destroy method
	@PreDestroy
	public void anyDestroy() {
		System.out.println("in destroy of " + getClass());
	}
}
