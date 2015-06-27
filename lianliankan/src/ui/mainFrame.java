package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class mainFrame extends JFrame {

	CenterPanel contentPanel = new CenterPanel();
	SouthPanel southPanel = new SouthPanel();
	NorthPanel northPanel = new NorthPanel();
	WestPanel westPanel = new WestPanel();

	public mainFrame() throws InterruptedException {
		this.setTitle("Java Á¬Á¬¿´");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		// this.setLocationRelativeTo(null);
		setSize(1000, 700);
		this.setLayout(new BorderLayout());
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(contentPanel, BorderLayout.CENTER);
		// this.add(westPanel, BorderLayout.WEST);

	}
}
