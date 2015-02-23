interface Singer {
	public void sing();
	public void sleep();
}

interface Painter {
	public void paint();
	public void eat();
}

class Student implements Singer {
	private String name;
	
	Student(String name) {
		this.name=name;
	}
	
	public void study() {
		System.out.println("studying");
	}
	
	public String getName() {return name;}
	
	public void sing() {
		System.out.println("student is singing");
	}
	
	public void sleep() {
		System.out.println("student is sleeping");
	}
}

class Teacher implements Singer,Painter {
	private String name;
	public String getString() {
		return name;
	}
	Teacher(String name) {this.name = name;}
	public void teach() {
		System.out.println("teachering");
	}
	
	public void sing() {
		System.out.println("teacher is singing");
	}
	
	public void sleep() {
		System.out.println("teacher is sleeping");
	}
	
	public void paint() {
		System.out.println("teacher is painting");
	}
	
	public void eat() {
		System.out.println("teacher is eating");
	}
}

public class TestInterface {
	public static void main(String args[]) {
		Singer s1 = new Student("le");   
		s1.sing();
		s1.sleep();
		Singer s2 = new Teacher("steven");//s2指向的是teacher对象，但只能看到Singer的方法，teacher的其他方法看不到
		s2.sing();
		s2.sleep();
		Painter p1 = (Painter) s2; //(...) p1=(..)s2 , p1也指向teacher这个对象, 只是把teacher当做painter来看
		p1.paint();
		p1.eat();
	}

}
