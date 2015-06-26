package judge;

import java.awt.Point;

interface HorizonInterface {
	boolean horizon(Point a, Point b);
}

public class Horizon implements HorizonInterface {

	private Point a;
	private Point b;
	private int[][] map = null;

	public Horizon(Point a, Point b, int[][] map) {
		this.a = a;
		this.b = b;
		this.map = map;
	}

	@Override
	public boolean horizon(Point a, Point b) {
		if (a.x == b.x && a.y == b.y)// 如果点击的是同一个图案，直接返回false
			return false;
		int x_start = a.y <= b.y ? a.y : b.y;
		int x_end = a.y <= b.y ? b.y : a.y;
		for (int x = x_start + 1; x < x_end; x++)
			// 只要一个不是-1，直接返回false
			if (map[a.x][x] != -1) {
				return false;
			}
		return true;
	}
}
