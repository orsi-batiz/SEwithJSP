package data;

import java.util.*;

import models.Customer;

public class Customers {

	public static HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>() {
		{
			put(Integer.valueOf(1), new Customer(1, "benyi", "benyi", "Andrei", "Benyi", "andreibenyi@gmail.com", "M", true));
			put(Integer.valueOf(2), new Customer(2, "orsi", "orsi", "Orsolya", "Batiz", "orsolyabatiz@gmail.com", "F", false));
			put(Integer.valueOf(3), new Customer(3, "vlad", "vlad", "Vlad", "Petrutiu", "vladpetrutiu@gmail.com", "M", false));
		}	
	};
	
	public static void addCustomer(Integer id, Customer customer) {
		customers.put(id, customer);
	}
}
