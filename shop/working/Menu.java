package shop.working;
import java.util.Scanner;

import shop.objects.Create;
import shop.objects.Klient;

public class Menu {

	public Scanner inp = new Scanner(System.in);
	public int choiceUser, choice;// ��� ������ ����
	public int NAccount, i, n; // ��� �������� ������� �������
	public boolean statysShop = true;
	public static Klient currentKlient = null;

	public Create create = new Create();
	public WorkingKlient workingklient = new WorkingKlient();
	public WorkingAdmin workingadmin = new WorkingAdmin();

	public void menu() {
		create.createObject(); // ����� ������ ���. ������� ��� "������"

		do {
			choiceUsers();
			switch (choiceUser) {
			case 1: // "Admin"
				menuAdmin();
				break;
			case 2: // "������"
				ChoiceKlient();
				menuKlients(currentKlient);
				break;
			case 3: // �������
				System.out.println("�� ��������� ������.");
				System.exit(0);
			}
		} while (choiceUser != 3 || ChoiceKlient() == null);
		inp.close();
	}

	public void choiceUsers() {
		System.out.println("  �������� ��������: ");
		System.out.println("    1. ����� ��� �������������. ");
		System.out.println("    2. ����� ��� ������.");
		System.out.println("    3. ��������� ������. ");
		choiceUser = inp.nextInt();
	}

	public Klient ChoiceKlient() {
		System.out.println("������� ����� ������");
		NAccount = inp.nextInt();

		for (i = 0; i < Create.KlientList.size(); i++) {
			if (Create.KlientList.get(i).getAccountKlient() == NAccount)
				currentKlient = Create.KlientList.get(i);
		}
		if (currentKlient.getPassword() == 0) {
			currentKlient = null;
		}

		return currentKlient;
	}

	public void menuAdmin() {

		System.out.println("�� ����� ��� ������������");
		do {
			System.out.println("  �������� ���� �� �������:");
			System.out.println("    1. �������� ���������� � ������. ");
			System.out.println("    2. ���������� �����." + " ("+Create.OrderWaitList.size()+")");
			System.out.println("    3. ���������������� �������. " + " ("+Create.OrderReadyList.size()+")");
			System.out.println("    4. ��������� ������.");
			choice = inp.nextInt();

			switch (choice) {
			case 1:
				workingadmin.addProduct();
				break;
			case 2:
				workingadmin.orderProcessing();
				System.out.println();
				break;
			case 3:
				workingadmin.registersSale();
				System.out.println("---");
				break;
			case 4:
				System.out.println("�� ��������� ������.");
				break;
			}
		} while (choice != 4);
	}

	public void menuKlients(Klient currentKlient) {
		if (currentKlient.isStatys() != true)
			System.out.println("���� ������������.\n ���������� � ��������������.");
		else {
			System.out.println("�� ����� ��� ������");
			do {
				System.out.println("�������� ���� �� �������:");
				System.out.println("   1. ������� �����.");
				System.out.println("   2. �������� �����." + " ()");
				System.out.println("   3. ��������� ������.");
				choice = inp.nextInt();
				switch (choice) {
				case 1:
					workingklient.makeOrder(currentKlient);
					System.out.println();
					break;
				case 2:
					workingklient.pay(currentKlient);
					break;
				case 3:// ��������� ������
					System.out.println("�� ��������� ������.");
					break;
				}
			} while (choice != 3);
		}
	}
}
