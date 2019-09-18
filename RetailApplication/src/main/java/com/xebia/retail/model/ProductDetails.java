package com.xebia.retail.model;

public class ProductDetails {
	
	private String prodName;
	private String prodCategory;
	private double price;
	
	@Override
	public String toString() {
		return "ProductDetails [prodName=" + prodName + ", prodCategory=" + prodCategory + ", price=" + price + "]";
	}
	
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
