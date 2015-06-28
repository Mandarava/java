package judge;

import java.awt.Point;
import java.util.LinkedList;

import ui.CenterPanel;

public abstract class Scan {

	protected Point a;
	protected Point b;
	protected int[][] map = null;
	protected LinkedList<Line> linklist = new LinkedList<>();

	public Scan(Point a, Point b, int[][] map) {
		this.a = a;
		this.b = b;
		this.map = map;
	}

	public void scan() {
		Vertical vertical = new Vertical(a, b, map);
		Horizon horizon = new Horizon(a, b, map);
		// ���a��,b�������Ƿ��ܹ���ֱֱ��
		for (int i = a.y; i >= 0; i--)
			if (map[a.x][i] == -1 && map[b.x][i] == -1
					&& vertical.vertical(new Point(a.x, i), new Point(b.x, i)))
				linklist.add(new Line(0, new Point(a.x, i), new Point(b.x, i)));

		// ���a��,b����Ҳ��Ƿ��ܹ���ֱֱ��
		for (int y = a.y; y < CenterPanel.COLUMN; y++)
			if (map[a.x][y] == -1 && map[b.x][y] == -1
					&& vertical.vertical(new Point(a.x, y), new Point(b.x, y)))
				linklist.add(new Line(0, new Point(a.x, y), new Point(b.x, y)));

		// ���a��,b����ϲ��Ƿ��ܹ�ˮƽֱ��
		for (int x = a.x; x >= 0; x--)
			if (map[x][a.y] == -1 && map[x][b.y] == -1
					&& horizon.horizon(new Point(x, a.y), new Point(x, b.y)))
				linklist.add(new Line(1, new Point(x, a.y), new Point(x, b.y)));

		// ���a��,b����²��Ƿ��ܹ�ˮƽֱ��
		for (int x = a.x; x < CenterPanel.ROW; x++)
			if (map[x][a.y] == -1 && map[x][b.y] == -1
					&& horizon.horizon(new Point(x, a.y), new Point(x, b.y)))
				linklist.add(new Line(1, new Point(x, a.y), new Point(x, b.y)));
	}

	public abstract boolean twoCorner();

}
