package com.Financial;

import java.util.Date;

public class billhistory {
	
	int billID;
	float sparePartPrice;
	Date date;
	int rid;
	float serviceCharges;
	float total;
	
	



	public billhistory(int billID2, float sparepartprice2, Date date2, float serviceCharges2, float total2, int rid2) {
		
		super();
		this.billID = billID2;
		this.rid = rid2;
		this.sparePartPrice = sparepartprice2;
		this.date = date2;
		this.serviceCharges = serviceCharges2;
		this.total = total2;
	}





	public int getBillID() {
		return billID;
	}





	public float getSparePartPrice() {
		return sparePartPrice;
	}





	public Date getDate() {
		return date;
	}





	public int getRid() {
		return rid;
	}





	public float getServiceCharges() {
		return serviceCharges;
	}





	public float getTotal() {
		return total;
	}


	
	
	
	

}
