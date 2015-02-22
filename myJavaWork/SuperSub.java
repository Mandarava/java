package 继承中的构造方法;

class SuperClass {
	private int n;
	
	SuperClass() {
		System.out.println("SuperClass()");
	}
	
	SuperClass(int n) {
		System.out.println("SuperClass("+n+")");
		this.n=n;
	}
	
}

class SubClass extends SuperClass {
	private int n;

	SubClass(int n) {
		//super();   不写系统自动执行该语句 SuperClass();
		System.out.println("SubClass("+n+")");
		this.n=n;
	}

	SubClass() {
		super(300);     //必须是函数调用的第一个语句
		System.out.println("SubClass()");
	}
}

public class Main {
	public static void main(String args[]) {
		SubClass sc1= new SubClass();
		SubClass sc2 = new SubClass(400);
	}
}
