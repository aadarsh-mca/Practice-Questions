package functional_streams;

import static com.shop.utils.ShopUtils.populateProductList;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.shop.core.Category;
import com.shop.core.Product;
import com.shop.custom_exceptions.ProductHandlingException;

public class Test8 {

	public static void main(String[] args) {
		try {
			/*
			 * Display name of the least expensive product from specified category
			 */
			List<Product> productList = populateProductList();
			productList.forEach(p -> System.out.println(p));
			Category category = Category.SPICES;
			Comparator<Product> comp = (p1, p2) -> ((Double) p1.getPrice()).compareTo(p2.getPrice());
//		Optional<Product> minPricedProduct = productList.stream() // Stream<Product>
//				.filter(p -> p.getProductCategory() == category) // Stream<Product> : filtered
//				.min(comp);
//		if(minPricedProduct.isPresent())
//			System.out.println(minPricedProduct.get());
//		Product cheapProduct=productList.stream() // Stream<Product>
//		.filter(p -> p.getProductCategory() == category) // Stream<Product> : filtered
//			.min(comp)
//			.orElseThrow();
			Product cheapProduct=productList.stream() // Stream<Product>
					.filter(p -> p.getProductCategory() == category) // Stream<Product> : filtered
						.min(comp)
						.orElseThrow(() -> 
						new ProductHandlingException("No product found under specified category!!!"));
		System.out.println("name "+cheapProduct.getName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
