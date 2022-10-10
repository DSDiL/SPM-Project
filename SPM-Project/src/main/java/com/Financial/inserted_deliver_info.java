package com.Financial;

import java.util.Date;

public class inserted_deliver_info {
	
	private int billID;
	private Date orderDate;
	private float total;
	private String orderID;
	private float tax;
	private float cost;
	private Date billDate;
	private int cusid;
	
	
	
	
	
	public inserted_deliver_info(int billID, Date orderDate, float total, String orderID, float tax, float cost,
			Date billDate, int cusid) {
		super();
		this.billID = billID;
		this.orderDate = orderDate;
		this.total = total;
		this.orderID = orderID;
		this.tax = tax;
		this.cost = cost;
		this.billDate = billDate;
		this.cusid = cusid;
	}




	public int getBillID() {
		return billID;
	}




	public Date getOrderDate() {
		return orderDate;
	}




	public float getTotal() {
		return total;
	}




	public String getOrderID() {
		return orderID;
	}




	public float getTax() {
		return tax;
	}




	public float getCost() {
		return cost;
	}




	public Date getBillDate() {
		return billDate;
	}




	public int getCusid() {
		return cusid;
	}
	

	
	
	
}
