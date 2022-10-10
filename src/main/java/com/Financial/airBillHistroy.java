package com.Financial;

import java.util.Date;

public class airBillHistroy {

	private int billID;
	private int raID;
	private String name;
	private Date date;
	private String spare;
	private int qty;
	private float spareprice;
	private Date billdate;
	private float service;
	private float total;
	
	public airBillHistroy(int billID, int raID, String name, Date date, String spare, int qty, float spareprice,
			Date billdate, float service, float total) {
		super();
		this.billID = billID;
		this.raID = raID;
		this.name = name;
		this.date = date;
		this.spare = spare;
		this.qty = qty;
		this.spareprice = spareprice;
		this.billdate = billdate;
		this.service = service;
		this.total = total;
	}

	public int getBillID() {
		return billID;
	}

	public int getRaID() {
		return raID;
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
