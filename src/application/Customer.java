package application;

public class Customer extends User {
	private String phoneNum;
	private String status;
	
	public Customer(String Username, String phoneNum, String status) {
		super(Username);
		this.phoneNum = phoneNum;
		this.status = status;
	}

	public String fetchPhoneNum() {
		return phoneNum;
	}

	public String fetchStatus() {
		return status;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}