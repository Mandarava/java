import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		// HashSet
		long f = System.currentTimeMillis();
		Random rnd = new Random();
		Object[] a = new Object[10000];
		HashSet<Integer> hs = new HashSet<Integer>(); // HashSet最佳，数组次之，ArrayList最差
		for (int i = 0; i < a.length; i++) {
			int number = rnd.nextInt(200000 - 100000 + 1) + 100000;	//生成10000到20000的随机数
			if (hs.contains(number))
				i--;
			hs.add(number);
		}
		System.out.println((System.currentTimeMillis() - f) + " ms ");

		// ArrayList
		long t = System.currentTimeMillis();
		Random rnd2 = new Random();
		Object[] obj = new Object[10000];
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < obj.length; i++) {
			int number = rnd.nextInt(20000 - 10000 + 1 ) + 10000;
			if (al.contains(number))
				i--;
			else {
				al.add(number);
			}
		}
		System.out.println((System.currentTimeMillis() - t) + " ms ");
	}
}