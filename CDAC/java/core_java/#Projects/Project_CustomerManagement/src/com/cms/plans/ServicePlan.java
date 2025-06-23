package com.cms.plans;

/**
 * Available plans and rate
 * 
 * SILVER : 1000 
 * GOLD : 2000
 * DIAMOND : 5000
 * PLATINUM : 10000
 * 
 * @author Aadarsh
 */

public enum ServicePlan {
	SILVER(1000),
	GOLD(2000),
	DIAMOND(5000),
	PLATINUM(10000);
	
	private double planRate;
	
	private ServicePlan(int planRate) {
		this.planRate = planRate;
	}
	
	public double getPlanRate() {
		return this.planRate;
	}
}