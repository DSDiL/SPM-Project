package Customer;

public class Verify {
	
	private int id;
	private String email;
	private int code;

	public Verify(int id, String email, int code) {
		super();
		this.id = id;
		this.email = email;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
