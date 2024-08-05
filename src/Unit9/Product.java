package Unit9;

import java.io.*;
public class Product implements Serializable{
	private int productId;
	private String productName;
	private int productQuantity;
	
	public Product() {
		productId = 0;
		productName = "";
		productQuantity = 0;
	}
	
	public Product(int id, String name, int qty) {
		productId = id;
		productName = name;
		productQuantity = qty;
	}
	
	public int getId() {
		return productId;
	}
	
	public String getName() {
		return productName;
	}
	
	public int getQuantity() {
		return productQuantity;
	}
	
	public void setId(int id) {
		productId = id;
	}
	
	public void setName(String name){
		productName = name;
	}
	
	public void setQuantity(int qty) {
		productQuantity = qty;
	}
	
	public String toString() {
		return "Product ID: "+productId+" - Product Name: "+productName+" - ProductQuantity: "+productQuantity;
	}
}
