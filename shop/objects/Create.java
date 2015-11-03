package shop.objects;

import java.util.ArrayList;
import java.util.List;

public class Create {
	
	public static List<Admin> AdminList = new ArrayList<Admin>();

	public static List <Klient> KlientList = new ArrayList<Klient>();

	public static List<Product> ProductList = new ArrayList<Product>();
	
	public static List<Order> OrderList = new ArrayList<Order>();
	public static List<Order> OrderWaitList = new ArrayList<Order>();
	public static List<Order> OrderReadyList = new ArrayList<Order>();
	
	

	public void createObject() {
		
		Admin ShopAdmin1 = new Admin("Администратор1", 11, 1111, 1000, KlientType.ADMIN);
		Admin ShopAdmin2 = new Admin("Администратор1", 22, 2222, 1000, KlientType.ADMIN);
		AdminList.add(ShopAdmin1);
		AdminList.add(ShopAdmin2);	
		
		Klient klient1 = new Klient("Анна Петрова", 12, 1212, 1500, true, KlientType.KLIENT);
		Klient klient2 = new Klient("Ольга Иванова", 17, 1717, 2250, true, KlientType.KLIENT);
		KlientList.add(klient1);
		KlientList.add(klient2);
		
		Product Book = new Product("Словарь", 2, 50);
		Product Pen = new Product("TM", 10, 5);
		Product Magazin = new Product("Oops!", 10, 20);
		ProductList.add(Book);
		ProductList.add(Pen);
		ProductList.add(Magazin);
		
		Order Order1 = new Order(1, 10, true, KlientList.get(0), ProductList.get(0));
		OrderList.add(Order1);
		

		OrderWaitList.add(Order1);
		

		OrderReadyList.add(Order1);
		
		
		
	}
}
