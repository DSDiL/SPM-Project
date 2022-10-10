package com.Financial;

public class Report {
	

	
	private int rid ;
	private int bid ;
	private float sparepartprice ;
	private int qty;
	private float servicecharges ;
	private float total;
	private String date;
	

	
	public Report(int rid, int bid, float sparepartprice, int qty, float servicecharges, float total, String date) {
		super();
		this.rid = rid;
		this.bid = bid;
		this.sparepartprice = sparepartprice;
		this.qty = qty;
		this.servicecharges = servicecharges;
		this.total = total;
		this.date = date;
		
		
		
		
	}
	public int getRid() {
		return rid;
	}
	public int getBid() {
		return bid;
	}
	public float getSparepartprice() {
		return sparepartprice;
	}
	public int getQty() {
		return qty;
	}
	public float getServicecharges() {
		return servicecharges;
	}
	public float getTotal() {
		return total;
	}
	public String getDate() {
		return date;
	}
	
	
	
	
	
	
	

}
