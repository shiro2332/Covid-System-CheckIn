package application;

public class CustomerSession {
	private static CustomerSession session = null;
	private Customer currentUser;
	
	private CustomerSession() {
		
	}
	
	//Singleton method that return current customer session
	public static CustomerSession getSession() {
		if(session == null) {
			session = new CustomerSession();
		}
		return session;
	}
	
	public Customer fetchCustomer() {
		return currentUser;
	}
	
	public void setCustomer(Customer currentUser) {
		this.currentUser = currentUser;
	}
}
