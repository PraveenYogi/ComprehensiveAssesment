package qtn_1;

public class CurrentAccount extends Account {

	public static void main(String[] args) {

		CurrentAccount act = new CurrentAccount();
		long total = act.get_Interest(10000, 5, 2);
		System.out.println("The interest amount:" + total);
	}
}
