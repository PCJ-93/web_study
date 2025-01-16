package com.app.dto.study;

public class BmiList {
	
	String name;
	double height;
	double weight;
	double bmi;
	
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public BmiList() {
	}
	public BmiList(String name, double height, double weight, double bmi) {
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

}
