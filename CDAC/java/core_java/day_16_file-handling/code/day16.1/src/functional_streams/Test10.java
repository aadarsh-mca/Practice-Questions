package functional_streams;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.shop.core.Category;
import com.shop.core.Product;
import com.shop.custom_exceptions.ProductHandlingException;

import static com.shop.utils.ShopUtils.*;
public class Test10 {

	public static void main(String[] args) {
		/*
		 * Create list of product ids from the products existing in the map | list
		 */
		//get product map
			Map<Integer, Product> productMap = 
					populateProductMap(populateProductList());
			System.out.println("All Products - ");
			productMap.forEach((k,v) -> System.out.println(v));
			List<Integer> productIds = productMap.values()
			.stream() //Stream<Product>
			.map(p -> p.getProductId()) //Stream<Integer>
			.collect(Collectors.toList());
			System.out.println(productIds);
			
		

	}

}
