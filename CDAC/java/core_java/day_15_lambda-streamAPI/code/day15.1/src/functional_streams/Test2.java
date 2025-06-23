package functional_streams;

import java.util.List;

import com.shop.core.Product;
import com.shop.utils.ShopUtils;

public class Test2 {
	
	public static void main(String[] args) {
		/**
		 * 	Get  product list ,  attach stream , display its contents 
		 * 	Sequential access
 		 * 	Parallel access
		 */
		List<Product> productList = ShopUtils.populateProductList();
		
		System.out.println("\n\n===== [ All Products (Sequential) ] =====\n");
		productList
			.stream() // Stream<Product>
			.forEach(prod -> System.out.println(prod));

		
		System.out.println("\n\n===== [ All Products (Parallel) ] =====\n");
		productList
			.parallelStream()
			.forEach(prod -> System.out.println(prod));
		
		
		
	}

}
