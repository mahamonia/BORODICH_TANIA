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
			System.out.println("���� ������������. ���������� � ��������������!");
		else {
			System.out.println("�������� �������");
			for (i = 0; i < Create.ProductList.size(); i++) {
				// s = String();
				System.out.println(i + 1 + ". " + Create.ProductList.get(i).getName() + " ");
			}
			P = inp.nextInt();// Product
			System.out.println("������� ����������");
			N = inp.nextInt(); // ammount

			if (N > Create.ProductList.get(P - 1).getAmount())
				System.out.println("!!��������� ����������");

			else {
				// ��������� ����� � OrderWaitList
				n=Create.OrderWaitList.size(); 
				System.out.println(" size OrderWaitList-- "+n);
					Order temp = new Order(	Create.OrderWaitList.get(n-1).getNumber() + 1, Create.ProductList.get(P-1).getPrice() * N, false, Menu.currentKlient, Create.ProductList.get(P-1));
					Create.OrderWaitList.add(temp);
				}
				System.out.println(" size OrderWaitList -- "+Create.OrderWaitList.size());
				System.out.println("�������� ������������� � ������.");
			}
		
	}

	public void pay(Klient currentKlient) {

		// ��������� ������� �� ����� �� ����� � �������
		
//		 if (currentKlient.getSumMoney() < OrderList.get(n).getOrderSum())
//		 System.out.println("� ��� ������������ �����");
		
		// ������� ��� ����� �������� �� OrderReadyList
		System.out.println("�������� ����� � ������:");

		for (i = 0; i < Create.OrderReadyList.size(); i++) {
			if (Create.OrderReadyList.get(i).isStatys() == false)
				System.out.println(Create.OrderReadyList.get(i)+ ". ����� " + Create.OrderReadyList.get(i).getOrderSum());
		}
		n = inp.nextInt();// ������� ����� ��� ����� ����������

		// ������� �� ����� �������
		Menu.currentKlient.setSumMoney(Menu.currentKlient.getSumMoney() - (Create.OrderReadyList.get(n).getOrderSum()));
	
		Create.OrderReadyList.get(n).setStatys(true);
	}

}
