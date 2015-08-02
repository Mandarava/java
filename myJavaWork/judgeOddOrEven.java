import java.math.BigInteger;
import java.util.Scanner;

public class judgeOddOrEven {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String number = in.nextLine();
		try {
			new BigInteger(number);
			if (number.charAt(number.length() - 1) % 2 == 0) {
				System.out.println("even");
			} else {
				System.out.println("odd");
			}
		} catch (Exception ex) {
			System.out.println("false");
		}
	}

}
