package com.home.model;

public class Landlord {
	
	String firstName;
	String lastName;
	boolean trusted;
	Apartments apartment;

	
	public Landlord(String firstName,String lastName,boolean trusted){
		this.firstName=firstName;
		this.lastName=lastName;
		this.trusted=trusted;
	}
	
	public Landlord(String firstName,String lastName,boolean trusted,Apartments apartment){
		this.firstName=firstName;
		this.lastName=lastName;
		this.trusted=trusted;
		this.apartment=apartment;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean isTrusted() {
		return trusted;
	}
	
	
	

	
	

}
