package p2;

import static com.shop.utils.ShopUtils.populateProductList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.shop.core.Product;

public class Test6 {

	public static void main(String[] args) {

		System.out.println("orig list");
		// get product list from utils n display it using FP
		List<Product> productList = populateProductList();
		productList.forEach(p -> System.out.println(p));
		// display the product details sorted as per price : asc
		/*
		 * Solve it first in the imperative(traditional) manner n then we will replace
		 * it by FP using lambda expression
		 */
//		Collections.sort(productList, new Comparator<Product>() {
//
//			@Override
//			public int compare(Product o1, Product o2) {
//				// TODO Auto-generated method stub
//				return ((Double)o1.getPrice()).compareTo(o2.getPrice());
//			}
//			
//		});
		//Comparator : Func i/f , SAM - public abstract int compare(T o1,T o2)
		System.out.println("sorted list");
		
		Comparator<Product> productComp=(p1,p2) 
				-> ((Double)p1.getPrice()).compareTo(p2.getPrice());
		Collections.sort(productList,productComp);
		
		productList.forEach(p -> System.out.println(p));
		
//		productList.forEach(Collections.sort(productList,productComp));
		
		productList
			.stream()
			.sorted((o1, o2) -> ((Double)o1.getPrice()).compareTo(o2.getPrice()))
			.forEach(p -> System.out.println(p));
	}

}
