package com.cms.validator;

import com.cms.plans.ServicePlan;
import com.cms.validator.exception.*;

public class Validate {

	public static ServicePlan planAndAmount(String planName, double registerAmt)
			throws IllegalArgumentException, CMSException {

		ServicePlan plan = ServicePlan.valueOf(planName.toUpperCase());

		if (plan.getPlanRate() == registerAmt) {
			return plan;
		}
		throw new CMSException(ErrorConstant.PLAN_RATE_ERROR_MSG);
	}
	
	public static void email(String email) {
		if(email.matches("^[a-z]+[a-z0-9_.]+@(gmail|yahoo)[.](com|org|co.in)$") == false) {
			System.out.println("Not matched !!!");
//			throw new InvalidEmailException();
			return;
		}
		System.out.println(".......email matched.......");
	}
	
//	public static void 
}