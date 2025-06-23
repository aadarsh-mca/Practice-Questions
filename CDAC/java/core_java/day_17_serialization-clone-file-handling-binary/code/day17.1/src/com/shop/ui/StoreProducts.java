package com.shop.ui;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;

import com.shop.core.Product;

import static com.shop.utils.ShopUtils.*;

public class StoreProducts {

	public static void main(String[] args) {
		/*
		 * get product map from utils store this product map in bin file using ser.
		 */
		System.out.println("Enter file name to persist products");
		try (Scanner sc = new Scanner(System.in);
				// Java App ---> OOS --> FOS --> bin file
				ObjectOutputStream out = 
						new ObjectOutputStream
						(new FileOutputStream(sc.nextLine()))) {
			Map<Integer, Product> productMap = 
					populateProductMap(populateProductList());
			//perform ser.
			out.writeObject(productMap);
			System.out.println("products stored....");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
