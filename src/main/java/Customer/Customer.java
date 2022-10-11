package Customer;

public class Customer {
	
	
	private int idCustomer;
	private String Full_Name;
	private String Email;
	private String Phone_No;
	private String address;
	private String password;
	
	public Customer(int idCustomer, String full_Name, String email, String phone_No, String address, String password) {
		super();
		this.idCustomer = idCustomer;
		Full_Name = full_Name;
		Email = email;
		Phone_No = phone_No;
		this.address = address;
		this.password = password;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getFull_Name() {
		return Full_Name;
	}
	public void setFull_Name(String full_Name) {
		Full_Name = full_Name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone_No() {
		return Phone_No;
	}
	public void setPhone_No(String phone_No) {
		Phone_No = phone_No;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
