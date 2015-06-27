package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

class TimePanel extends JPanel {
	int cnt = 0;
	private static final int W_WIDTH = 1000;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.fillRect(0, 0, cnt, 200);

	}

	public boolean isEnd() {
		System.out.println(cnt);
		if (cnt++ > W_WIDTH)
			return true;
		repaint();
		return false;
	}

}