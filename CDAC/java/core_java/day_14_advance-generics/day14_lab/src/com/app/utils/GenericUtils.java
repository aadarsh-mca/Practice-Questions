package com.app.utils;

import java.util.List;

import com.app.core.Emp;

public interface GenericUtils {
	/*
	 * write a static method in GenericUtils i/f 
	 *  -package : com.app.utils
to return sum of salaries of all emps from the specified list.
	 */
//	static double computeSum(List<? extends Emp> emps)
//	{
//		double sum=0.0;
//		for(Emp e : emps)
//			sum += e.computeSalary();
//		return sum;
//	}
	static <T extends Emp> double computeSum(List<T> emps)
	{
		double sum=0.0;
		for(Emp e : emps)
			sum += e.computeSalary();
		return sum;
	} 
}
