package functional_streams;
import static com.shop.utils.ShopUtils.populateProductList;

import java.util.List;

import com.shop.core.Product;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * get product list from utils n display the products using Stream API
		 * List<Product> ---> stream() --> Stream<Product> --> forEach
		 */
		List<Product> productList = populateProductList();
		/*
		 * API of Collection i/f
		 * public default Stream<T> stream() - for seq accessed stream
		 */
		System.out.println("All products accessed in seq manner ");
		productList.stream() //Stream<Product>
		.forEach(p -> System.out.println(p));
		System.out.println("All products accessed in parallel manner ");
		/*
		 * API of Collection i/f
		 * public default Stream<T> parallelstream() - for parallel accessed stream
		 */
		productList.parallelStream() //Stream<Product>
		.forEach(p -> System.out.println(p));
		

	}

}
