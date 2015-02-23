package 动态绑定与继承;

class Animal {
	private String name;
	Animal(String name) 
	{
		this.name=name;
	}
	
	public void enjoy() 
	{
		System.out.println("叫声........");
	}
	
}

class Dog extends Animal {
	private String furColor;
	Dog(String n,String c)
	{
		super(n);
		furColor = c;
	}
	
	public void enjoy()						//如果不重写则不会输出狗叫声 ，输出叫声
	{
		System.out.println("狗叫声.......");
	}
}

class Cat extends Animal {
	private String eyesColor;
	Cat(String n,String c) 
	{
		super(n);
		eyesColor = c;
	}
	
	public void enjoy() 
	{
		System.out.println("猫叫声.......");
	}
}

class Bird extends Animal {
	Bird() 
	{
		super("bird");
	}
	
	public void enjoy() 
	{
		System.out.println("鸟叫声.......");
	}
}

class Lady {
	private String name;
	private Animal pet;
	Lady(String name,Animal pet) 
	{
		this.name=name;
		this.pet=pet;
	}
	public void myPetEnjoy()
	{
		pet.enjoy();
	}
}

public class TestPolymorph {
	public static void main(String args[]) {
		Cat c = new Cat("catname","blue");
		Dog d = new Dog("dogname","black");
		//Bird b = new Bird();
		Lady L1 = new Lady("L1",c);
		Lady L2 = new Lady("L2",d);
		//Lady L3 = new Lady("L3",b);
		L1.myPetEnjoy();
		L2.myPetEnjoy();
		//L3.myPetEnjoy();
	}
}
