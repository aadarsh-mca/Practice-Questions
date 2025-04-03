package com.cms.custom_ordering;

import java.util.Comparator;

import com.cms.core.Customer;

public class CustomerDoBComparator implements Comparator<Customer> {
	@Override
	public int compare(Customer c1, Customer c2) {
		System.out.println("in compare - dob");
//		if(c1.getDob().isBefore(c2.getDob()))
//			return -1;
//		if(c1.getDob().isEqual(c2.getDob()))
//			return 0;
//		return 1;
		return c1.getDob().compareTo(c2.getDob());
	}
}
