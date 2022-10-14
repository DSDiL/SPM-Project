package techscope;

import java.util.Date;

public class onGoingOther {

	private int roID;
	private int cID;
	private String company;
	private Date date;
	private String devices;
	private String description;
	private String spare;
	private int qty;
	private float cost;
	private String type;
	
	public onGoingOther(int roID, int cID, String company, Date date, String devices, String description, String spare, int qty, float cost, String type) {
		this.roID = roID;
		this.cID = cID;
		this.company = company;
		this.date = date;
		this.devices = devices;
		this.description = description;
		this.spare = spare;
		this.qty = qty;
		this.cost = cost;
		this.type = type;
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

	public String getDevices() {
		return devices;
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
	
	public String getType() {
		return type;
	}	
}
