import java.util.Scanner;

public class bubbleSort {

	public static void main(String[] args) {
		try {
			System.out.println("how many numbers do you want to sort?");
			Scanner in = new Scanner(System.in);
			int count = in.nextInt();
			int num[] = new int[count];
			for (int i = 0; i < num.length; i++) {
				num[i] = in.nextInt();
			}
			for (int i = 0; i < num.length; i++)
				for (int j = num.length - 1; j > i; j--) {
					if (num[j] < num[j - 1]) {
						int temp = num[j];
						num[j] = num[j - 1];
						num[j - 1] = temp;
					}
				}
			for (int i : num)
				System.out.print(i + " ");
		} catch (Exception ex) {
			System.out.println("input error");
		}
	}

}
