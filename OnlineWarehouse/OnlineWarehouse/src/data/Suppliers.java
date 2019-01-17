package data;

import java.util.HashMap;

import models.Supplier;

public class Suppliers {
	public static HashMap<Integer, Supplier> suppliers = new HashMap<Integer, Supplier>() {
		{
			put(1, new Supplier(1, "supp_user", "Pa$$w0rd", "DemoCompany1"));
			put(2, new Supplier(2, "demo_supp", "Pwd123@", "DemoCompany2"));
		}	
	};

	public static void addSupplier(int id, Supplier supplier) {
		suppliers.put(id, supplier);
	}
}
