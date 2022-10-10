package com.Financial;

import java.util.Date;

public class repairOther {

	private int roID;
	private int cID;
	private String company;
	private Date date;
	private String description;
	private String spare;
	private int qty;
	private float cost;
	
	public repairOther(int roID, int cID, String company, Date date, String description, String spare, int qty, float cost) {
		super();
		this.roID = roID;
		this.cID = cID;
		this.company = company;
		this.date = date;
		this.description = description;
		this.spare = spare;
		this.qty = qty;
		this.cost = cost;
	}

	public int getRoID() {
		return roID;
	}

	public int getcID() {
		return cID;
	}
	
	public String getCompany() {
		return company;
	}
	
	public Date getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public String getSpare() {
		return spare;
	}

	public int getQty() {
		return qty;
	}

	public float getCost() {
		return cost;
	}
}
