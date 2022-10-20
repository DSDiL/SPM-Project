package techscope;

import java.util.Date;

public class completedHardware {

	private int rcID;
	private int cID;
	private String company;
	private Date date;
	private String description;
	private int qty;
	private float cost;
	private Date comDate;

	
	public completedHardware(int rcID, int cID, String company, Date date, String description,  int qty, float cost,  Date comDate) {
		this.rcID = rcID;
		this.cID = cID;
		this.company = company;
		this.date = date;
		this.description = description;
		this.qty = qty;
		this.cost = cost;
		this.comDate = comDate;
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

	public String getDescription() {
		return description;
	}



	public int getQty() {
		return qty;
	}

	public float getCost() {
		return cost;
	}
	
	
	public Date getComDate() {
		return comDate;
	}
}
