package models;

public class Product implements java.io.Serializable{

	int id;
	int supplierId;
	String name;
	String company;
	String category;
	double price;
	int stock;
	int onDiscount;
	int sold;
	
	public Product() {
		
	}
	
	public Product(int id, int supplierId, String name, String company,
			String category, double price, int stock, int onDiscount, int sold) {
		this.id = id;
		this.supplierId = id;
		this.name = name;
		this.company = company;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.onDiscount = onDiscount;
		this.sold = sold;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getOnDiscount() {
		return onDiscount;
	}

	public void setOnDiscount(int onDiscount) {
		this.onDiscount = onDiscount;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

}
