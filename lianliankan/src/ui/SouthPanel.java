package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SouthPanel extends JPanel {

	JPanel southPanel = new JPanel();
	JButton exitButton = new JButton("退出");
	JButton newlyButton = new JButton("再来一局");

	public SouthPanel() {

		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		newlyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					new mainFrame().setVisible(true);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		this.add(exitButton);
		this.add(newlyButton);

		exitButton.setBackground(new Color(250, 250, 250));
		newlyButton.setBackground(new Color(250, 250, 250));
		this.setBackground(new Color(216, 191, 216));
	}
}
