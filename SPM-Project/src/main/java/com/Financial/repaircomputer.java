package com.Financial;

import java.util.Date;

public class repaircomputer {
	
	private int rcID;
	private int cID;
	private String company;
	private Date date;
	private String deliver;
	private String description;
	private String spare;
	private int qty;
	private float cost;
	
	
	public repaircomputer(int rcID, int cID, String company, Date date, String deliver, String description,
			String spare, int qty, float cost) {
		super();
		this.rcID = rcID;
		this.cID = cID;
		this.company = company;
		this.date = date;
		this.deliver = deliver;
		this.description = description;
		this.spare = spare;
		this.qty = qty;
		this.cost = cost;
	}


	public int getRcID() {
		return rcID;
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


	public String getDeliver() {
		return deliver;
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
