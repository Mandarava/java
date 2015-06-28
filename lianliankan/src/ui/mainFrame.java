package ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainFrame extends JFrame {

	public static JPanel contentPanel;
	SouthPanel southPanel = new SouthPanel();
	NorthPanel northPanel = new NorthPanel();
	public static GameOverPanel gameOverPanel = new GameOverPanel();

	public mainFrame() throws InterruptedException {
		contentPanel = new CenterPanel();
		this.setTitle("Java Á¬Á¬¿´");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width) / 4;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height) / 5;
		this.setLocation(w, h);
		// this.setLocationRelativeTo(null);
		setSize(1000, 700);
		this.setLayout(new BorderLayout());
		this.add(gameOverPanel, BorderLayout.CENTER);
		gameOverPanel.setSize(0, 0);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(contentPanel, BorderLayout.CENTER);

	}
}
