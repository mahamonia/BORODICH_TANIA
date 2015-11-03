package shop.objects;
import java.util.Scanner;

public class Klient {
	public static Scanner inp = new Scanner(System.in);
	public String nameKlient;
	public int accountKlient;
	public int password;
	public int sumMoney;
	public boolean statys;
	public KlientType type;
	
	public Klient() {
	}

	public Klient(String nameKlient, int accountKlient, int password,
			int sumMoney, boolean statys, KlientType type) {
		this.nameKlient = nameKlient;
		this.accountKlient = accountKlient;
		this.password = password;
		this.sumMoney = sumMoney;
		this.statys = statys;
		this.type = type;
	}

	public Klient(String nameKlient, int accountKlient, int password,
			int sumMoney, KlientType type) {
		this.nameKlient = nameKlient;
		this.accountKlient = accountKlient;
		this.password = password;
		this.sumMoney = sumMoney;
		this.type = type;
	}

	public int getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(int sumMoney) {
		this.sumMoney = sumMoney;
	}

	public boolean isStatys() {
		return statys;
	}

	public void setStatys(boolean statys) {
		this.statys = statys;
	}

	public String getNameKlient() {
		return nameKlient;
	}

	public int getAccountKlient() {
		return accountKlient;
	}

	public KlientType getType() {
		return type;
	}

	public int getPassword() {

		System.out.print("Введите Ваш пароль: ");
		int pas = inp.nextInt();
		if (pas != this.password) {
			System.out.println("Вы ввели не верный пароль! ");
			return 0;
		}
		return password;
	}

	

}
