package shop.working;
import java.util.Scanner;

import shop.objects.Create;
import shop.objects.Klient;

public class Menu {

	public Scanner inp = new Scanner(System.in);
	public int choiceUser, choice;// для вывода меню
	public int NAccount, i, n; // для проверки наличия акаунта
	public boolean statysShop = true;
	public static Klient currentKlient = null;

	public Create create = new Create();
	public WorkingKlient workingklient = new WorkingKlient();
	public WorkingAdmin workingadmin = new WorkingAdmin();

	public void menu() {
		create.createObject(); // вызов метода кот. создает все "данные"

		do {
			choiceUsers();
			switch (choiceUser) {
			case 1: // "Admin"
				menuAdmin();
				break;
			case 2: // "Клиент"
				ChoiceKlient();
				menuKlients(currentKlient);
				break;
			case 3: // выходим
				System.out.println("Вы закончили работу.");
				System.exit(0);
			}
		} while (choiceUser != 3 || ChoiceKlient() == null);
		inp.close();
	}

	public void choiceUsers() {
		System.out.println("  Выберите действие: ");
		System.out.println("    1. Войти как администратор. ");
		System.out.println("    2. Войти как клиетн.");
		System.out.println("    3. Закончить работу. ");
		choiceUser = inp.nextInt();
	}

	public Klient ChoiceKlient() {
		System.out.println("Введите номер счтета");
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

		System.out.println("Вы вошли как АДМИНИТРАТОР");
		do {
			System.out.println("  Выберите один из пунктов:");
			System.out.println("    1. Добавить информацию о товаре. ");
			System.out.println("    2. Обработать заказ." + " ("+Create.OrderWaitList.size()+")");
			System.out.println("    3. Зарегистрировать продажу. " + " ("+Create.OrderReadyList.size()+")");
			System.out.println("    4. Закончить работу.");
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
				System.out.println("Вы закончили работу.");
				break;
			}
		} while (choice != 4);
	}

	public void menuKlients(Klient currentKlient) {
		if (currentKlient.isStatys() != true)
			System.out.println("Счет заблокирован.\n Обратитесь к администратору.");
		else {
			System.out.println("Вы вошли как КЛИЕНТ");
			do {
				System.out.println("Выберите один из пунктов:");
				System.out.println("   1. Сделать заказ.");
				System.out.println("   2. Оплатить заказ." + " ()");
				System.out.println("   3. Закончить работу.");
				choice = inp.nextInt();
				switch (choice) {
				case 1:
					workingklient.makeOrder(currentKlient);
					System.out.println();
					break;
				case 2:
					workingklient.pay(currentKlient);
					break;
				case 3:// закончить работу
					System.out.println("Вы закончили работу.");
					break;
				}
			} while (choice != 3);
		}
	}
}
