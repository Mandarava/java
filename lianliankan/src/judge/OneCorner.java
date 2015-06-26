package judge;

import java.awt.Point;

interface oneCornerInterface {
	boolean oneCorner();
}

public class OneCorner implements oneCornerInterface {

	private Point a;
	private Point b;
	private int map[][] = null;

	public OneCorner(Point a, Point b, int[][] map) {
		this.a = a;
		this.b = b;
		this.map = map;
	}

	@Override
	public boolean oneCorner() {
		Horizon horizon = new Horizon(a, b, map);
		Vertical vertical = new Vertical(a, b, map);

		Point c = new Point(a.x, b.y);
		Point d = new Point(b.x, a.y);

		// 判断C点是否有元素
		if (map[c.x][c.y] == -1) {
			boolean method1 = horizon.horizon(a, c) && vertical.vertical(b, c);
			return method1;
		}

		// 判断D点是否有元素
		if (map[d.x][d.y] == -1) {
			boolean method2 = vertical.vertical(a, d) && horizon.horizon(b, d);
			return method2;
		} else {
			return false;
		}
	}
}
