package shop.working;

import java.util.Scanner;

import shop.objects.Create;
import shop.objects.Klient;
import shop.objects.Order;
import shop.objects.Product;


public class WorkingAdmin {
	public Scanner inp = new Scanner(System.in);
	public int N, K, P;
	public static int i, n;
	public String nameProduct;

	
	public void addProduct() {
		System.out.println("������� ������������ ������");
		this.nameProduct = inp.nextLine();
		System.out.println("����������");
		K = inp.nextInt();
		System.out.println("����");
		P = inp.nextInt();

		Product temp = new Product(this.nameProduct, K, P);

		for (i = 0; i < Create.ProductList.size(); i++) {
			if (Create.ProductList.get(i).getName().equals(this.nameProduct))
				Create.ProductList.get(i).setAmount(Create.ProductList.get(i).getAmount() + K);
			else {
				System.out.println("����� �����");
				Create.ProductList.add(temp);
			}
		}

	}

	public void orderProcessing() {

	        	// ������������ ������
		System.out.println("�������� ����� ��� ���������");
		System.out.println(" OrderWaitList.size -- "+Create.OrderWaitList.size());
		for (i = 0; i < Create.OrderWaitList.size(); i++) {
			System.out.println(" ����� � . " + i+1 + " statys order"+ Create.OrderWaitList.get(i).isStatys());

		}
		n=inp.nextInt()-1;
		

		// ��������� � OrderReadyList
		// �� OrderWaitList �������
			
			Order temp = new Order(	Create.OrderReadyList.get(n).getNumber() + 1, Create.OrderWaitList.get(n).getOrderSum(), false, Create.OrderWaitList.get(n).getKlient(), Create.OrderWaitList.get(n).getProduct());
			Create.OrderReadyList.add(temp);
			
			Create.OrderWaitList.remove(Create.OrderWaitList.get(n));
	
	}

	public void registersSale() {

		System.out.println("�������� ����� ��� ���������");
		
		for (i = 0; i < Create.OrderReadyList.size(); i++) {
			System.out.println(" ����� � . " + Create.OrderReadyList.get(i) + " statys order "+ Create.OrderReadyList.get(i).isStatys());
		}
		n = inp.nextInt();
		
		// ���� ������ �� �������� true (�������)
		// �� ��������� � ������ OrderList
		// �� OrderReadyList �������
		
		Order temp = new Order(	Create.OrderList.get(n).getNumber() + 1, Create.OrderReadyList.get(n).getOrderSum(), true, Create.OrderReadyList.get(n).getKlient(), Create.OrderReadyList.get(n).getProduct());
		Create.OrderList.add(temp);
		
		Create.OrderReadyList.remove(Create.OrderList.get(n));
	}

	public void addBlackList(Klient currentKlient) {
		currentKlient.setStatys(false);
	}
}
