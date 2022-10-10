package com.Financial;

public class Empdetails {
	
	String nic;
	String name;
	String email;
	String position;
	Float basicsalary;
	
	public Empdetails(String nic, String name, String email, String position, Float basicsalary) {
		super();
		this.nic = nic;
		this.name = name;
		this.email = email;
		this.position = position;
		this.basicsalary = basicsalary;
		
		
	}
	public String getNic() {
		return nic;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPosition() {
		return position;
	}
	public Float getBasicsalary() {
		return basicsalary;
	}

	
	
}
