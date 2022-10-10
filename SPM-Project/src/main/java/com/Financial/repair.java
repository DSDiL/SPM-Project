package com.Financial;

public class repair {
	private int rid;
	private float billamount;
	private int qty;
	
	

	
	public repair(int rid, float billamount , int qty) {
	
		this.rid = rid;
		this.billamount = billamount;
		this.qty=qty;
	
	}


	public int getQty() {
		return qty;
	}



	public int getRid() {
		return rid;
	}


	public Float getBillamount() {
		return billamount;
	}




}
