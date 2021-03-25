package application;

public class history{
	private String date;
	private String time;
	private String CustomerName;
	private String ShopName;
	
	public history(String date, String time, String CustomerName, String ShopName) {
		this.date = date;
		this.time = time;
		this.CustomerName = CustomerName;
		this.ShopName = ShopName;
	}
	
	public String fetchDate(){
		return date;
	}
	
	public String fetchTime() {
		return time;
	}
	
	public String fetchCustomerName() {
		return CustomerName;
	}
	
	public String fetchShopName() {
		return ShopName;
	}
}