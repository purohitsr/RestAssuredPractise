package com.home.model;

import java.util.ArrayList;
import java.util.List;

public class Apartments {

	String address;
	int price;
	int square;
	List<String> features = new ArrayList<String>();
	boolean active;
	
	public Apartments(String address,int price,int square,List<String> features,boolean active){
		
		this.address=address;
		this.price=price;
		this.square=square;
		this.features=features;
		this.active=active;
	}
	public String getAddress() {
		return address;
	}
	/*public void setAddress(String address) {
		this.address = address;
	}*/
	public int getPrice() {
		return price;
	}
	/*public void setPrice(int price) {
		this.price = price;
	}*/
	public int getSquare() {
		return square;
	}
	/*public void setSquare(int square) {
		this.square = square;
	}*/
	public List<String> getFeatures() {
		return features;
	}
	/*public void setFeatures(List<String> features) {
		this.features = features;
	}*/
	public boolean isActive() {
		return active;
	}
	/*public void setActive(boolean active) {
		this.active = active;
	}*/
	
}
