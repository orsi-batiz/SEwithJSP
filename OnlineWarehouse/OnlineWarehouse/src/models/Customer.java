package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Customer implements java.io.Serializable{

	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private boolean newsletter = false;
	private ArrayList<Product> cart = new ArrayList<Product>();
	private ArrayList<Integer> quantities = new ArrayList<Integer>();
	private ArrayList<Product> favourites = new ArrayList<Product>();
	
	public Customer() {
		
	}
	
	public Customer(int id, String username, String password, String firstName, 
			String lastName, String email, String gender, boolean newsletter) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
	
	public void addProductToCart(Product product) {
		boolean found = false;
		int q = 0;
		int poz = 0;
		for(int i = 0; i < cart.size(); i++) {
			if (cart.get(i).equals(product)) {
				q = quantities.get(i);
				poz = i;
				found = true;
			}
		}
		if(found) {
			quantities.set(poz, q+1);
		} else {
			cart.add(product);
			quantities.add(1);
		}
	}
	
	public void removeProductFromCart(Product product) {
		int poz = 0;
		for(int i = 0; i < cart.size(); i++) {
			if (cart.get(i).equals(product)) {
				poz = i;
			}
		}
		cart.remove(poz);
		quantities.remove(poz);
	}
	
	public ArrayList<Product> getCart() {
		if(!cart.isEmpty())
			return cart;
		else
			return null;
	}
	
	public void addProductToFavourites(Product product) {
		favourites.add(product);
	}
	
	public void removeProductFromFavourotes(Product product) {
		favourites.remove(product);
	}
	
	public ArrayList<Product> getFavourites() {
		return favourites;
	}
}
