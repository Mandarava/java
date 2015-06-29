package ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TimePanel extends JPanel {
	int cnt = 0;
	private static final int W_WIDTH = 1000;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.fillRect(0, 0, cnt, 200);
		g.setColor(Color.BLACK);
		g.drawString(String.valueOf((W_WIDTH - cnt) / 2), 500, 15);
	}

	public boolean isEnd() {
		if (cnt++ > W_WIDTH)
			return true;
		repaint();
		return false;
	}

}