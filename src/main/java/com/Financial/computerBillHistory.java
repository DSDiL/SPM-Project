package com.Financial;

import java.util.Date;

public class computerBillHistory {
	
	
	private int billID;
	private int cusID;
	private String name;
	private String deliver;
	private Date date;
	private String spare;
	private int qty;
	private float spareprice;
	private Date billdate;
	private float service;
	private float total;
	
	
	
	
	public computerBillHistory(int billID, int cusID, String name, Date date, String deliver, String spare, int qty, float spareprice,
			Date billdate, float service, float total) {
		super();
		this.billID = billID;
		this.cusID = cusID;
		this.name = name;
		this.deliver = deliver;
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




	public int getCusID() {
		return cusID;
	}




	public String getName() {
		return name;
	}


	public String getDeliver() {
		return deliver;
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
