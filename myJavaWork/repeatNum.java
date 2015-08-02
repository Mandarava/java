import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class repeatNum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		String[] inputNumber = input.split(" ");
		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < inputNumber.length; i++) {
			try {
				new BigDecimal(inputNumber[i]);
				hs.add(inputNumber[i]);
			} catch (Exception ex) {
				System.out.println("please input number");
				System.exit(0);
			}
		}
		Iterator<String> iterator = hs.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

	}

}
