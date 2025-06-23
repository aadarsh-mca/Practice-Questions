package com.generic.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.app.core.Mgr;
import com.app.core.SalesMgr;
import com.app.core.TempWorker;

/*
 * 1. Consider Emp inheritance hierarchy
write a static method in GenericUtils i/f  -package : com.app.utils
to return sum of salaries of all emps from the specified list.
Test cases -- AL<Mgr> , Vector<TempWorker> ,
 LinkedList<SalesMgr> 

 */
public class Test1 {

	public static void main(String[] args) {
		ArrayList<Mgr> mgrs=new ArrayList<Mgr>(
				List.of(new Mgr(1000), new Mgr(1500), new Mgr(2000)));
		//call the method - computeSum
		/**
		 * 1000 + 1000  = 2000
		 * 1500 + 1000  = 2500
		 * 2000 + 1000  = 3000
		 */
		System.out.println(GenericUtils.computeSum(mgrs));
		
		Vector<TempWorker> tempWorkers=new Vector<>(
				Arrays.asList(new TempWorker(100),
						new TempWorker(200),
						new TempWorker(300)));
		//call the method - computeSum
		/**
		 * 100 + 600  = 700
		 * 200 + 600  = 800
		 * 300 + 600  = 900
		 */
		System.out.println(GenericUtils.computeSum(tempWorkers));
		
		LinkedList<SalesMgr> salesMgrs=new LinkedList<>(
				List.of(new SalesMgr(3000),
						new SalesMgr(4000),
						new SalesMgr(5000)));
		//call the method - computeSum
		/**
		 * 3000 + 2000  = 5000
		 * 4000 + 2000  = 6000
		 * 5000 + 2000  = 7000
		 */
		System.out.println(GenericUtils.computeSum(salesMgrs));
	}

}
