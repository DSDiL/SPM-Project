package techscope;

import java.util.Date;

public class completedComputer {

	private int rcID;
	private int cID;
	private String company;
	private String deliver;
	private Date date;
	private String description;
	private String spare;
	private int qty;
	private float cost;
	private String type;
	private Date comDate;
	
	public completedComputer(int rcID, int cID, String company, String deliver, Date date, String description, String spare, int qty, float cost, String type, Date comDate) {
		this.rcID = rcID;
		this.cID = cID;
		this.company = company;
		this.deliver = deliver;
		this.date = date;
		this.description = description;
		this.spare = spare;
		this.qty = qty;
		this.cost = cost;
		this.type = type;
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

	public String getDeliver() {
		return deliver;
	}

	public Date getDate() {
		return date;
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
	
	public Date getComDate() {
		return comDate;
	}
}
