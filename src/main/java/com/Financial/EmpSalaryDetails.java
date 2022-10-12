package com.Financial;

import java.util.Date;

public class EmpSalaryDetails {
	
	int salID;
	float basicsalary;
	float etf;
	float epf;
	float ot;
	float bonus;
	String nic;
	float total;
	Date date;
	
	public EmpSalaryDetails(int salID, float basicsalary, float epf, float etf, float ot, float bonus, String nic, float total, Date date) {
		super();
		this.salID = salID;
		this.basicsalary = basicsalary;
		this.epf = epf;
		this.etf = etf;
		this.ot = ot;
		this.bonus = bonus;
		this.nic = nic;
		this.total = total;
		this.date = date;
	}
	public int getSalID() {
		return salID;
	}
	public float getBasicsalary() {
		return basicsalary;
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
	public Date getDate() {
		return date;
	}

	
	
	
}
