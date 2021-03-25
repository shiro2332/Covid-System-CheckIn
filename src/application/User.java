package application;

public class User{
	protected String Username;
	protected String Password;
	
	public User(String Username) {
		this.Username = Username;
	}
	
	public User(String Username, String Password) {
		this.Username = Username;
		this.Password = Password;
	}
	
	public String fetchUsername(){
		return Username;
	}
	
	public String fetchPassword() {
		return Password;
	}
	
	public void setUsername(String Username) {
		this.Username = Username;
	}

}