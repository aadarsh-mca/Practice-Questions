package com.cms.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.cms.core.Customer;

public interface IOUtils {
	
	static void storeCustomers(Map<String, Customer> customerMap, String fileName) throws IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
			out.writeObject(customerMap);
		}
	};
	
	@SuppressWarnings("unchecked")
	static Map<String, Customer> restoreCustomer(String fileName) {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			Object map = in.readObject();
			return (Map<String, Customer>) map;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new HashMap<>();
		}
	}
}
