package com.cms.custom_ordering;

import java.util.Comparator;

import com.cms.core.Customer;

public class CustomerDobRegAmountComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		System.out.println("in compare - dob n amount");
		int retVal = c1.getDob().compareTo(c2.getDob());
		if (retVal == 0) {
			// dates are same - sort as per amount (desc)
			if (c1.getRegAmount() < c2.getRegAmount())
				return 1;
			if (c1.getRegAmount() == c2.getRegAmount())
				return 0;
			return -1;

		}
		return retVal;
	}

}
