package ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class WinPanel extends JPanel{
	private static Image Image_BG = new ImageIcon(
			"Graphics/background/bg02.jpg").getImage();

	public WinPanel() {
		this.setLayout(new BorderLayout());
	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(Image_BG, 0, 0, 1000, 700, 0, 0, 1405, 829, null);
	}
}
