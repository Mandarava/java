package ³éÏóÀà;


abstract class Animal {
	private String name;
	Animal(String name) 
	{
		this.name=name;
	}
	
	public abstract void enjoy();	
}

class Dog extends Animal {
	private String furColor;
	Dog(String n,String c)
	{
		super(n);
		furColor = c;
	}
	
	public void enjoy()						//±ØÐëÖØÐ´
	{
		System.out.println("¹·½ÐÉù.......");
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
		System.out.println("Ã¨½ÐÉù.......");
	}
}

class Bird extends Animal {
	Bird() 
	{
		super("bird");
	}
	
	public void enjoy() 
	{
		System.out.println("Äñ½ÐÉù.......");
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

public class TestAbstract {
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
