package judge;

import java.awt.Point;

public class TwoCorner extends Scan {

	public TwoCorner(Point a, Point b, int[][] map) {
		super(a, b, map);
	}

	@Override
	public boolean twoCorner() {
		Vertical vertical = new Vertical(a, b, map);
		Horizon horizon = new Horizon(a, b, map);
		super.scan();
		if (linklist.isEmpty())
			return false;
		for (int index = 0; index < linklist.size(); index++) {
			Line line = linklist.get(index);

			if (line.getDirect() == 1) {
				if (vertical.vertical(a, line.getA())
						&& vertical.vertical(b, line.getB())) {
					return true;
				}

			} else if (horizon.horizon(a, line.getA())
					&& horizon.horizon(b, line.getB())) {
				return true;
			}

		}
		return false;
	}

}
