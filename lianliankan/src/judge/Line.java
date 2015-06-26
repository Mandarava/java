package judge;

import java.awt.Point;

public class Line {
	private Point a;
	private Point b;
	private int direct; // 连线方向1:水平直连 0:垂直直连

	public Line(int direct, Point a, Point b) {
		this.a = a;
		this.b = b;
		this.direct = direct;
	}

	public int getDirect() {
		return direct;
	}

	public Point getA() {
		return a;
	}

	public Point getB() {
		return b;
	}

}
