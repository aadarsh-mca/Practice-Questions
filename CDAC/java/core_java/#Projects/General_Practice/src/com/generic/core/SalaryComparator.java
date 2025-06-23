package com.generic.core;

import com.app.core.*;
import java.util.Comparator;

public class SalaryComparator implements Comparator<Emp> {
	@Override
	public int compare(Emp e1, Emp e2) {
		return ((Double)e2.computeSalary()).compareTo(e1.computeSalary());
	}
}
