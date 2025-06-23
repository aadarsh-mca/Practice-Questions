package functional_streams;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import com.shop.core.Category;
import com.shop.core.Product;
import com.shop.utils.ShopUtils;

public class Test3 {
	
	public static void main(String[] args) {
		
		/**
		 * 4.	Display all the products with 
		 * 		specified category & price > min price
		 */
		Map<Integer, Product> productMap = ShopUtils.populateProductMap(ShopUtils.populateProductList());
		
//		Scanner scan = new Scanner(Sys)
		
		productMap.values()
			.forEach(prod -> System.out.println(prod));
		
		System.out.println("\n===============================\n");
		
		int minPrice = 70;
		
		productMap.values()  // Collection<Product>
			.stream()  // Stream<Product>
			// filtering product with FRUITS category and price > more than 70
			.filter(prod -> prod.getProductCategory() == Category.FRUITS && prod.getPrice() > minPrice)
			.forEach(System.out::println);  // Functional Reference
		
//		Function<Integer, Product> function = ShopUtils::populateProductMap;
		
		
	}

}
