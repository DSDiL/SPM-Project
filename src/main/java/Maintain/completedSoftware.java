package techscope;

import java.util.Date;

public class completedSoftware {

	private int raID;
	private int cID;
	private String company;
	private Date date;
	private String description;
	
	private float cost;
	private Date comDate;

public completedSoftware(int raID, int cID, String company, Date date, String description, float cost,  Date comDate) {
		super();
		this.raID = raID;
		this.cID = cID;
		this.company = company;
		this.date = date;
		this.description = description;
		
		this.cost = cost;
		this.comDate = comDate;
		
		
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



	public float getCost() {
		return cost;
	}
	
	
	public Date getComDate() {
		return comDate;
	}
}
