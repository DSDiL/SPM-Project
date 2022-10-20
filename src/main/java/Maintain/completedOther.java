package techscope;

import java.util.Date;

public class completedOther {

	private int roID;
	private int cID;
	private String company;
	private Date date;
	private String description;

	private float cost;
	private Date comDate;
	
	public completedOther(int roID, int cID, String company, Date date,  String description,   float cost,  Date comDate) {
		this.roID = roID;
		this.cID = cID;
		this.company = company;
		this.date = date;
		
		this.description = description;
	
	
		this.cost = cost;
		
		this.comDate = comDate;
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
