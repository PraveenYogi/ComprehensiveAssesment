
public class Account {
	long interest = 0;
	public long get_Interest(long P, int T, float R) {
	interest = (long) ((P * T * R) / 100);
	return interest;
	}

}
