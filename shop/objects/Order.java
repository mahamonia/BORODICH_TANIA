package shop.objects;


public class Order {
	public int number;
	public int orderSum;
	public boolean statys;
	public Klient Klient;
	public Product Product;
	
	
	public  Order ( int number, int orderSum, boolean statys, Klient  Klient, Product Product){
		this.number=number;
		this.orderSum=orderSum;
		this.statys=statys;
		this.Klient=Klient;
		this.Product=Product;
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	public int getOrderSum() {
		return orderSum;
	}

	public void setOrderSum(int orderSum) {
		this.orderSum = orderSum;
	}

	public boolean isStatys() {
		return statys;
	}

	public void setStatys(boolean statys) {
		this.statys = statys;
	}

	public Klient getKlient() {
		return Klient;
	}

	public Product getProduct() {
		return Product;
	}
	
	

}
