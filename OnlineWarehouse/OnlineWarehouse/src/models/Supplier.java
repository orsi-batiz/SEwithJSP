package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Supplier implements java.io.Serializable {

	private int id;
	private String username;
	private String password;
	private String company;
	
	public Supplier() {
		
	}
	
	public Supplier(int id, String username, String password, String company) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.company = company;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getCompany() {
		return this.company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
}
