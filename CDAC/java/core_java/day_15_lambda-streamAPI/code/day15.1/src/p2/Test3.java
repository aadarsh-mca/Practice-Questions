package p2;
import static com.shop.utils.ShopUtils.*;

import java.util.Map;

import com.shop.core.Product;

public class Test3 {

	public static void main(String[] args) {
		// get product map from utils n display it(pid n product details) using FP
		Map<Integer, Product> productMap = 
				populateProductMap(populateProductList());
		System.out.println("All products ");
		/*
		 * Imperative - values - for-each loop
		 * In Modern Java -
		 * new default method - in Map<K,V>
		 * public default void forEach(BiConsumer<? super K,? super V> action)
		 * java.util.function.BiConsumer : func i/f
		 * SAM - public abstract void accept(T t, U u)
		 */
		productMap.forEach((pid,product) ->
		System.out.println(product));
		

	}

}
