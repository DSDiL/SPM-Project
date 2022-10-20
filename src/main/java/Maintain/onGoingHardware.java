package techscope;

import java.util.Date;

public class onGoingHardware {
	
	private int rcID;
	private int cID;
	private String company;
	
	private Date date;
	private String description;
	
	
	private float cost;
	
	
	public onGoingHardware(int rcID, int cID, String company,  Date date, String description, float cost) {
		this.rcID = rcID;
		this.cID = cID;
		this.company = company;
		
		this.date = date;
		this.description = description;
		
		
		this.cost = cost;
		
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





	public float getCost() {
		return cost;
	}

}
