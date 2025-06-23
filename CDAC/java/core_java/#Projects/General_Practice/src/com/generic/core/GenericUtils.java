package com.generic.core;

import java.util.List;

import com.app.core.Emp;

public interface GenericUtils {
//	public static double computeSum(List<? extends Emp> empList) {
//		double sum = 0;
//		
//		for(Emp obj : empList) {
//			sum += obj.computeSalary();
//		}
//		
//		return sum;
//	}
	
	public static <T extends Emp> double computeSum(List<T> empList) {
		double sum = 0;
		
		for(Emp obj : empList) {
			sum += obj.computeSalary();
		}
		
		return sum;
	}
	
	static <T extends Comparable<? super T>> T findMax(List<T> list) {
		T max = list.get(0);
		
		for(T obj : list) {
			if(obj.compareTo(max) > 0) {
				max = obj;
			}				
		}
		
		return max;
	}
	
}
