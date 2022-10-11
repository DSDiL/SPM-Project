package appointment;

import java.util.Date;

public class appointment {
	private int apoid;
	private String servicetype;
	private String description;
	private String timeslot;
	private Date requireddate;
	private int cid;
	
	public appointment(int apoid, String servicetype, String description, String timeslot, Date requireddate, int cid) {
	
		this.apoid = apoid;
		this.servicetype = servicetype;
		this.description = description;
		this.timeslot = timeslot;
		this.requireddate = requireddate;
		this.cid = cid;
	}

	public int getApoid() {
		return apoid;
	}

	public String getServicetype() {
		return servicetype;
	}

	public String getDescription() {
		return description;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public Date getRequireddate() {
		return requireddate;
	}
	
	public int getCid() {
		return cid;
	}	
}
