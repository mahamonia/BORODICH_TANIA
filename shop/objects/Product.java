package shop.objects;

public class Product {
	public  String name;
    public int amount;//количество
	public int price; //цена

	public Product ( String name, int amount, int price){
		this.name=name;
		this.amount=amount;
		this.price=price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public  String getName() {
		return name;
	}
	
	public  void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}
	
}
