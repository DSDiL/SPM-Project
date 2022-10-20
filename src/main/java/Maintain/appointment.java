package techscope;

import java.util.Date;

public class appointment {

	private int appID;
	private String type;
	private String description;
	private String timeslot;
	private Date reqDate;
	private int cid;
	
	public appointment(int appID, String type, String description, String timeslot, Date reqDate, int cid) {
		super();
		this.appID = appID;
		this.type = type;
		this.description = description;
		this.timeslot = timeslot;
		this.reqDate = reqDate;
		this.cid = cid;
	}

	public int getAppID() {
		return appID;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public int getCid() {
		return cid;
	}
	
}
