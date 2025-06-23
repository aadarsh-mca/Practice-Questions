package p2;

import static com.shop.utils.ShopUtils.populateProductList;

import java.util.List;
import java.util.Scanner;

import com.shop.core.Product;

public class Test2 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("orig list");
			// get product list from utils n display it using FP
			List<Product> productList = populateProductList();
			productList.forEach(p -> System.out.println(p));
			//accept discount amount from user n apply discount on all products
			//display list again
			System.out.println("Enter discount");
	//		double discount=sc.nextDouble();
			productList.forEach(p -> p.setPrice(p.getPrice()-sc.nextDouble()));
			System.out.println("list after discount");
			productList.forEach(pr -> System.out.println(pr));
		}

	}

}
