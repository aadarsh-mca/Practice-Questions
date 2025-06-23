package functional_streams;
import static com.shop.utils.ShopUtils.*;

import java.util.Map;

import com.shop.core.Category;
import com.shop.core.Product;

public class Test6 {

	public static void main(String[] args) {
		/*
		 * Display sum of prices of all the products in a map
		 *  from the specified category

		 */
		Map<Integer, Product> productMap = 
				populateProductMap(populateProductList());
		System.out.println("All products ");
	productMap.forEach((k,v) -> System.out.println(v));
		/*
		 * map -> values -> Collection<Product>  -> stream
		 * -> filter ->  mapToDouble  -> DoubleStream -> sum
		 */
		Category category=Category.BISCUITS;
		double sum = productMap.values() //Collection<Product>
		.stream() //Stream<Product>
		.filter(p -> p.getProductCategory()==category) //Stream<Product> :filtered
		.mapToDouble(p -> p.getPrice()) //DoubleStream : price of products
		.sum();
		System.out.println("sum of selected products "+sum);
		

	}

}
