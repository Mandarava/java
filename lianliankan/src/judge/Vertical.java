package judge;

import java.awt.Point;

interface VerticalInterface {
	boolean vertical(Point a, Point b);
}

public class Vertical implements VerticalInterface {

	private Point a;
	private Point b;
	private int[][] map = null;

	public Vertical(Point a, Point b, int[][] map) {
		this.a = a;
		this.b = b;
		this.map = map;
	}

	@Override
	public boolean vertical(Point a, Point b) {
		if (a.x == b.x && a.y == b.y)
			return false;
		int y_start = a.x <= b.x ? a.x : b.x;
		int y_end = a.x <= b.x ? b.x : a.x;
		for (int y = y_start + 1; y < y_end; y++)
			if (map[y][a.y] != -1)
				return false;
		return true;
	}
}
