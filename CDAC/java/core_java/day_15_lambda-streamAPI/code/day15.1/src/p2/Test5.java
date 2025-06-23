package p2;

import static com.shop.utils.ShopUtils.*;

import java.util.Map;
import java.util.Scanner;

import com.shop.core.Category;
import com.shop.core.Product;

public class Test5 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// get product map from utils n display it(product details) using FP
			Map<Integer, Product> productMap = populateProductMap(populateProductList());
			System.out.println("All products ");
			productMap.forEach((pid, product) -> System.out.println(product));
			/*
			 * Accept the category from user , remove all the products
				from the map for specified category 
				Hint - removeIf
			 */
			System.out.println("Enter category");
			Category selectedCategory=Category.valueOf(sc.next().toUpperCase());
			
			System.out.println("All products after remove ");
			
//			productMap.values() //Collection<Product>
//				.removeIf(p -> p.getProductCategory()==selectedCategory);
//			productMap.forEach((pid, product) -> System.out.println(product));
			
			productMap.values()
				.stream()
				.filter(p -> p.getProductCategory() != selectedCategory)
				.forEach(product -> System.out.println(product));
			
		}

	}

}
