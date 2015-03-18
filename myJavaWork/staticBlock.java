
class ExA {

	static {
		System.out.println("父类--静态代码块");
	}

	public ExA() {
		System.out.println("父类--构造函数");
	}

	{
		System.out.println("父类--非静态代码块");
	}
}

class ExB extends ExA {

	static {
		System.out.println("子类--静态代码块");
	}

	{
		System.out.println("子类--非静态代码块");
	}

	public ExB() {
		System.out.println("子类--构造函数");
	}
}

public class Main {

	public static void main(String[] args) {
		new ExB();
	}
}

//非静态代码并不是一定在静态代码之后执行的
/*
class ExA {
	private static ExA a = new ExA();

	static {
		System.out.println("父类--静态代码");
	}

	public ExA() {
		System.out.println("父类--构造函数");
	}

	{
		System.out.println("父类--非静态代码块");
	}
}

class ExB extends ExA {
	private static ExB b = new ExB();

	static {
		System.out.println("子类--静态代码块");
	}

	{
		System.out.println("子类--非静态代码块");
	}

	public ExB() {
		System.out.println("子类--构造函数");
	}
}

public class Main {
	public static void main(String[] args) {
		new ExB();
	}
}
*/