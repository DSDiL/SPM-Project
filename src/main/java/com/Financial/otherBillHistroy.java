package com.Financial;

import java.util.Date;

public class otherBillHistroy {

	private int billID;
	private int roID;
	private String name;
	private Date date;
	private String spare;
	private int qty;
	private float cost;
	private float spareprice;
	private Date billdate;
	private float service;
	private float total;
	
	public otherBillHistroy(int billID, int roID, String name, Date date, String spare, int qty, float cost, float spareprice,
			Date billdate, float service, float total) {
		super();
		this.billID = billID;
		this.roID = roID;
		this.name = name;
		this.date = date;
		this.spare = spare;
		this.qty = qty;
		this.cost = cost;
		this.spareprice = spareprice;
		this.billdate = billdate;
		this.service = service;
		this.total = total;
	}

	public int getBillID() {
		return billID;
	}

	public int getRoID() {
		return roID;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
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
	
	public float getSpareprice() {
		return spareprice;
	}

	public Date getBilldate() {
		return billdate;
	}

	public float getService() {
		return service;
	}

	public float getTotal() {
		return total;
	}
	
}
