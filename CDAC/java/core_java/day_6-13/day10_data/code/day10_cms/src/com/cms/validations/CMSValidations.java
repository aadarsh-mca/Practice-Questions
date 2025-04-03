package com.cms.validations;

import com.cms.core.ServicePlan;
import com.cms.custom_exceptions.CMSException;

public class CMSValidations {
//add public static method to parse and validate plan it's reg amount
	public static ServicePlan parseAndValidatePlan
	(String plan,double amount) throws IllegalArgumentException,
	CMSException
	{
		//1. parsing (string -> enum, valueOf)
		ServicePlan myPlan=ServicePlan.valueOf(plan.toUpperCase());
		//2 . continue to checking plan n reg amount
		if(myPlan.getPlanCost() != amount)
			throw new CMSException("Reg amount doesn't match "
					+ "with the chosen plan !!!!");
		return myPlan;
	}
}
