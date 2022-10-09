package employee;

public class report {
	private String nic;
	private int sick;
	private int casual;
	private String name;
	private int total;
	
	public report(String nic, int sick, int casual, String name, int total) {
		this.nic = nic;
		this.sick = sick;
		this.casual = casual;
		this.name = name;
		this.total = total;
	}

	public String getNic() {
		return nic;
	}

	public int getSick() {
		return sick;
	}

	public int getCasual() {
		return casual;
	}

	public String getName() {
		return name;
	}

	public int getTotal() {
		return total;
	}
}
