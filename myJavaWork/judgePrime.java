import java.util.Scanner;

public class judgePrime {

	public static void main(String[] args) {
		while (true) {
			Scanner in = new Scanner(System.in);
			try {
				long number = in.nextLong();
				System.out.println(isPrime(number));
			} catch (Exception ex) {
				System.out.println("false");
			}
		}
	}

	static boolean isPrime(long number) {
		if (number < 2) {
			return false;
		} else {
			for (int i = 2; i <= Math.sqrt(number); i++) {
				if (number % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	// public static void main(String[] args) {
	// Scanner in = new Scanner(System.in);
	// BigInteger num = in.nextBigInteger();
	// System.out.println(num.isProbablePrime(10));
	// }
}
