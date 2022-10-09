package employee;

import java.util.Date;

public class employee {
	private String nic;
	private String name;
	private String email;
	private int mobile;
	private String position;
	private Date dob;
	private float basicSalary;
	private String section;
	private String password;
	
	public employee(String nic, String name, String email, int mobile, String position, Date dob, float basicSalary, String section, String password) {
		this.nic = nic;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.position = position;
		this.dob = dob;
		this.basicSalary = basicSalary;
		this.section = section;
		this.password = password;
	}

	/*public employee(String nic2, String name2, String position2, String password2, String email2) {
		this.nic = nic2;
		this.name = name2;
		this.email = email2;
		this.password = password2;
		this.position = position2;
	}*/

	public String getPassword() {
		return password;
	}

	public String getNic() {
		return nic;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getMobile() {
		return mobile;
	}

	public String getPosition() {
		return position;
	}

	public Date getDob() {
		return dob;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public String getSection() {
		return section;
	}
}
