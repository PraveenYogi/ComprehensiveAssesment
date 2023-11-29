package qtn_1;

public class SavingsAccount extends Account {

	public static void main(String[] args) {

		SavingsAccount act = new SavingsAccount();
		long total = act.get_Interest(2000, 4, 8);
		System.out.println("The interest amount:" + total);
	}
}
