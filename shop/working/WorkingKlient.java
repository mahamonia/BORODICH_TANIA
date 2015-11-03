package shop.working;

import java.util.Scanner;

import shop.objects.Create;
import shop.objects.Klient;
import shop.objects.Order;


public class WorkingKlient {
	
	public Scanner inp = new Scanner(System.in);
	public int N, K, P;
	public int i, n;
	
	public Klient currentKlient;

	public void makeOrder(Klient currentKlientt) {
		System.out.println("klients"+ Menu.currentKlient.nameKlient);

		if (Menu.currentKlient.isStatys() != true)
			System.out.println("Счет заблокирован. Обратитесь к администратору!");
		else {
			System.out.println("Выберите продукт");
			for (i = 0; i < Create.ProductList.size(); i++) {
				// s = String();
				System.out.println(i + 1 + ". " + Create.ProductList.get(i).getName() + " ");
			}
			P = inp.nextInt();// Product
			System.out.println("Введите количество");
			N = inp.nextInt(); // ammount

			if (N > Create.ProductList.get(P - 1).getAmount())
				System.out.println("!!превышает количество");

			else {
				// добавляем заказ в OrderWaitList
				n=Create.OrderWaitList.size(); 
				System.out.println(" size OrderWaitList-- "+n);
					Order temp = new Order(	Create.OrderWaitList.get(n-1).getNumber() + 1, Create.ProductList.get(P-1).getPrice() * N, false, Menu.currentKlient, Create.ProductList.get(P-1));
					Create.OrderWaitList.add(temp);
				}
				System.out.println(" size OrderWaitList -- "+Create.OrderWaitList.size());
				System.out.println("Ожидайте подтверждения к оплате.");
			}
		
	}

	public void pay(Klient currentKlient) {

		// проверяем хватает ли денег на счету у клиента
		
//		 if (currentKlient.getSumMoney() < OrderList.get(n).getOrderSum())
//		 System.out.println("У вас недостаточно денег");
		
		// выводим что нужно оплатить из OrderReadyList
		System.out.println("Выберите заказ к оплате:");

		for (i = 0; i < Create.OrderReadyList.size(); i++) {
			if (Create.OrderReadyList.get(i).isStatys() == false)
				System.out.println(Create.OrderReadyList.get(i)+ ". Сумма " + Create.OrderReadyList.get(i).getOrderSum());
		}
		n = inp.nextInt();// выбрали заказ кот будем оплачивать

		// списали со счета клиента
		Menu.currentKlient.setSumMoney(Menu.currentKlient.getSumMoney() - (Create.OrderReadyList.get(n).getOrderSum()));
	
		Create.OrderReadyList.get(n).setStatys(true);
	}

}
