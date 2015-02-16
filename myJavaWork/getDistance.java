package getDistance;
class Point {
	private int x;
	private int y;
	private int z;
	
	Point(int x, int y, int z)
	{
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	void setX(int x)
	{
		this.x=x;
	}
	
	void setY(int y)
	{
		this.y=y;
	}
	
	void setZ(int z)
	{
		this.z=z;
	}
	
	int getDistance(Point p)    // the distance to point p
	{
		return (x-p.x)*(x-p.x)+(y-p.y)*(y-p.y)+(z-p.z)*(z-p.z);
	}
		
}

public class getDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1=new Point(1,2,3);
		Point p2=new Point(0,0,0);
		System.out.println(p1.getDistance(p2));
		p1.setX(3);
		System.out.println(p1.getDistance(p2));
	}
}
