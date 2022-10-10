package com.Financial;

import java.util.Date;

public class deliver {
	
	private String oderID;
	private String address;
	private String itemNO;
	private float unitprice;
	private Date date;
	private int cusid;
	private int qty;
	
	



	


	public deliver(String deliverID, String adress, String itemNO, int qty, float unitprice, Date date, int cusid) {
		
		this.oderID = deliverID;
		this.address = adress;
		this.itemNO = itemNO;
		this.unitprice = unitprice;
		this.date = date;
		this.cusid = cusid;
		this.qty = qty;
		
	}










	public int getQty() {
		return qty;
	}





	public String getOderID() {
		return oderID;
	}





	public String getAddress() {
		return address;
	}


	public String getItemNO() {
		return itemNO;
	}


	public float getUnitprice() {
		return unitprice;
	}


	public Date getDate() {
		return date;
	}


	public int getCusid() {
		return cusid;
	}

}
