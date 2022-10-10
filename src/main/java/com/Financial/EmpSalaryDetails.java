package com.Financial;

public class EmpSalaryDetails {
	
	int salID;
	float epf;
	float etf;
	float ot;
	float bonus;
	String nic;
	float total;
	public EmpSalaryDetails(int salID, float epf, float etf, float ot, float bonus, String nic, float total) {
		super();
		this.salID = salID;
		this.epf = epf;
		this.etf = etf;
		this.ot = ot;
		this.bonus = bonus;
		this.nic = nic;
		this.total = total;
	}
	public int getSalID() {
		return salID;
	}
	public float getEpf() {
		return epf;
	}
	public float getEtf() {
		return etf;
	}
	public float getOt() {
		return ot;
	}
	public float getBonus() {
		return bonus;
	}
	public String getNic() {
		return nic;
	}
	public float getTotal() {
		return total;
	}

	
	
	
}
