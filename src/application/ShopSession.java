package application;

public class ShopSession {
	private static ShopSession session = null;
	private Shop currentUser;
	
	private ShopSession() {
		
	}
	
	public static ShopSession getSession() {
		if(session == null) {
			session = new ShopSession();
		}
		return session;
	}
	
	public Shop fetchShop() {
		return currentUser;
	}
	
	public void setShop(Shop currentUser) {
		this.currentUser = currentUser;
	}
}
