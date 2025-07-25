package functional_streams;

import java.util.Map;
import java.util.Scanner;

import com.shop.core.Category;
import com.shop.core.Product;
import static com.shop.utils.ShopUtils.*;
public class Test3 {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in)) {
		/*
		 * Display all the products from the map with specified category
		 *  & price > min price
		 */
		//get product map
			Map<Integer, Product> productMap = 
					populateProductMap(populateProductList());
			System.out.println("All Products - ");
			productMap.forEach((k,v) -> System.out.println(v));
			System.out.println("Enter category & min price");
			Category cat=Category.valueOf(sc.next().toUpperCase());
			double minPrice=sc.nextDouble();
			/*
			 * map --> values() -> Collection -> stream() -> Stream -> filters ->forEach
			 */
			System.out.println("Filtered products - ");
			productMap.values() //Collection<Product>
			.stream() //Stream<Product>
			.filter(p -> p.getProductCategory()==cat) // Stream<Product> - categoried 
			.filter(p -> p.getPrice()>minPrice)//Stream<Product> - priced
			.forEach(p -> System.out.println(p));
		}

	}

}
