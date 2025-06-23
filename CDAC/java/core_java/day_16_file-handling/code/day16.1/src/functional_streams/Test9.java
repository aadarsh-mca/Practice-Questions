package functional_streams;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

import com.shop.core.Category;
import com.shop.core.Product;
import com.shop.custom_exceptions.ProductHandlingException;

import static com.shop.utils.ShopUtils.*;
public class Test9 {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in)) {
		/*
		 * 9.	Display average of prices of all the products in a 
		 * map produced after specified date
		 */
		//get product map
			Map<Integer, Product> productMap = 
					populateProductMap(populateProductList());
			System.out.println("All Products - ");
			productMap.forEach((k,v) -> System.out.println(v));
			System.out.println("Enter date (yr-mon-day)");
			LocalDate date=LocalDate.parse(sc.next());
			double avg=productMap.values() //Collection<Product>
			.stream() //Stream<Product>
			.filter(p -> p.getManufactureDate().isAfter(date)) //Filtered Stream<P>
			.mapToDouble(p -> p.getPrice()) //DoubleStream - prices of filtered products
			.average()
			.orElseThrow(() -> new ProductHandlingException("no product found!!!!!!"));
			System.out.println("avg price "+avg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
