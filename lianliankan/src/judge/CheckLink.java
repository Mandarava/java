package judge;

import java.awt.Point;

public class CheckLink {
	Point a;
	Point b;
	int[][] map = null;

	public CheckLink(Point a, Point b, int[][] map) {
		this.a = a;
		this.b = b;
		this.map = map;
	}

	public boolean checkLink() {
		Horizon horizon = new Horizon(a, b,map);
		Vertical vertical = new Vertical(a, b, map);
		OneCorner oneCorner = new OneCorner(a, b, map);
		Scan scan = new TwoCorner(a, b, map);

		if (map[a.x][a.y] != map[b.x][b.y])// 如果图案不同，直接为false
			return false;
		if (a.x == b.x && horizon.horizon(a, b))
			return true;
		if (a.y == b.y && vertical.vertical(a, b))
			return true;
		if (oneCorner.oneCorner())
			return true;
		else
			return scan.twoCorner();
	}
}
