package employee;

public class leaveApply {
	
	private int id;
	private String reason;
	private int period;
	private String date;
	private String nic;
	private String status;
	private int casual;
	private int sick;
	private String more;
	
	public leaveApply(int id, String reason, int period, String date, String status, String nic) {
		super();
		this.id = id;
		this.reason = reason;
		this.period = period;
		this.date = date;
		this.status = status;
		this.nic = nic;
	}

	public leaveApply(int id2, String nic2, String reason2, int period2, String date2, String status2, int casual, int sick, String more) {
		super();
		this.id = id2;
		this.nic = nic2;
		this.reason = reason2;
		this.period = period2;
		this.date = date2;
		this.status = status2;
		this.casual = casual;
		this.sick = sick;
		this.more = more;
	}

	public leaveApply(int id2, String reason2, int period2, String date2, String more2, String status2, String nic2) {
		this.id = id2;
		this.reason = reason2;
		this.period = period2;
		this.date = date2;
		this.status = status2;
		this.nic = nic2;
		this.more = more2;
		}

	public int getId() {
		return id;
	}

	public String getReason() {
		return reason;
	}

	public int getPeriod() {
		return period;
	}

	public String getDate() {
		return date;
	}

	public String getNic() {
		return nic;
	}

	public String getStatus() {
		return status;
	}

	public int getCasual() {
		return casual;
	}

	public int getSick() {
		return sick;
	}
	
	public String getMore() {
		return more;
	}
}
