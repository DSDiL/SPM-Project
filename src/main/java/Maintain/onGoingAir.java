package techscope;

import java.util.Date;

public class onGoingAir {
	
	private int raID;
	private int cID;
	private String company;
	private Date date;
	private String description;
	private String spare;
	private int qty;
	private float cost;
	private String type;

public onGoingAir(int raID, int cID, String company, Date date, String description, String spare, int qty, float cost, String type) {
		super();
		this.raID = raID;
		this.cID = cID;
		this.company = company;
		this.date = date;
		this.description = description;
		this.spare = spare;
		this.qty = qty;
		this.cost = cost;
		this.type = type;
	}

	public int getRaID() {
		return raID;
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
