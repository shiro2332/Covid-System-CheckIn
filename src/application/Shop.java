package application;

public class Shop{
	private String Name;
	private String Phone;
	private String Status;
	private String Manager;
	
	public Shop(String Name, String Phone, String Status, String Manager) {
		this.Name = Name;
		this.Phone = Phone;
		this.Manager = Manager;
		this.Status = Status;
	}
	
	public String fetchName(){
		return Name;
	}
	
	public String fetchPhone() {
		return Phone;
	}
	
	public String fetchStatus() {
		return Status;
	}
	
	public String fetchManager() {
		return Manager;
	}
}