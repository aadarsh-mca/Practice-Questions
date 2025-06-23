package functional_streams;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.shop.core.Category;
import com.shop.core.Product;
import com.shop.utils.ShopUtils;

public class Test4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/**
		 * 5.	Display sum of all odd numbers within some range
		 */
		System.out.println("\n==============================");
		
		Map<Integer, Product> productMap = ShopUtils.populateProductMap(ShopUtils.populateProductList());
		
		productMap.forEach((id, prod) -> System.out.println(prod));
		
		System.out.println();
		
		int sumOfOdd = IntStream.range(1, 101)
			.filter(num -> num % 2 != 0)
			.sum();
		
		System.out.println(sumOfOdd);
		
		/**
		 * 7.	Display sum of prices 
		 * 		of all the products in a map 
		 * 		from the specified category
		 */
		
		System.out.println("Enter the name of category :: ");
//		Category category = Category.valueOf(scan.next().toUpperCase());
		Category category = Category.FRUITS;
		
		System.out.println("\n======= [ Avg Price of all products ] ======");

		double sumOfPrice = productMap.entrySet()
			.stream()
			.filter(entry -> entry.getValue().getProductCategory() == category)
			.mapToDouble(entry -> {
				return entry.getValue().getPrice();
			})
			.sum();
		
		System.out.println(sumOfPrice);
		
		
		/**
		 * 8.	Display average of prices 
		 * 		of all the products in a map 
		 * 		from the specified category
		 */
		System.out.println("\n======= [ Avg Price of all products ] ======");
		
		double avgOfPrice = productMap.values()
			.stream()
			.filter(prod -> prod.getProductCategory() == category)
			.mapToDouble(prod -> prod.getPrice())
			.average().getAsDouble();
		
		System.out.println(avgOfPrice);
		
		
		/**
		 * 		Extra Ques ::
		 * 
		 */
		System.out.println("\n======= [ Sorted Map as per Price (desc) ] ======");
		
		productMap.values()
			.stream()
			.sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
			.forEach(prod -> System.out.println(prod));
		
		
		/**
		 * 9.	Display name of 
		 * 		most expensive product in the shop
		 */
		System.out.println("\n======= [ Price of most expensive product ] ======");
		
		productMap.values()
			.stream()
			.sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
			.limit(1)
			.forEach(prod -> System.out.println(prod));
		
		
		/**
		 * 10.	Collect products ids 
		 * 		in another list from 
		 * 		products in the Map
		 */
		System.out.println("\n======= [ Product ID into new list ] ======");
		
		List<Integer> newList = 
				productMap.values()
			.stream()
			.map(prod -> prod.getProductId())
			.collect(Collectors.toList());			
		
//			.mapToInt(prod -> prod.getProductId())
//			.mapToObj(num -> num)
//			.collect(Collectors.toList());
		
		System.out.println(newList);
		
		
		scan.close();
	}
	
}
