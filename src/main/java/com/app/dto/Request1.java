package com.app.dto;

public class Request1 {
	
	public int category;
	public int product;
	
	
	
	public Request1() {
	}
	public Request1(int category, int product) {
		this.category = category;
		this.product = product;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}

}
