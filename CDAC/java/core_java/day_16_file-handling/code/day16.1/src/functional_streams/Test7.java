package functional_streams;
import static com.shop.utils.ShopUtils.*;

import java.util.Comparator;
import java.util.Map;

import com.shop.core.Category;
import com.shop.core.Product;

public class Test7 {

	public static void main(String[] args) {
		/*
		 * sort  all the products in a map
		 *  as per desc price of the product

		 */
		Map<Integer, Product> productMap = 
				populateProductMap(populateProductList());
		System.out.println("All products ");
	productMap.forEach((k,v) -> System.out.println(v));
		/*
		 * map -> values -> Collection<Product>  -> stream
		 * 
		 */
	System.out.println("sorted stream");
	Comparator<Product> productPriceComp=
			(p1,p2)->((Double)p2.getPrice()).compareTo(p1.getPrice());
		productMap.values() //Collection<Product>
		.stream()//Stream
		.sorted(productPriceComp) //sorted stream - as per comp
		.forEach(p -> System.out.println(p));
		
		

	}

}
