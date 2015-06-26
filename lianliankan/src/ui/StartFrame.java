package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.GetImage;

public class StartFrame extends JFrame {

	private JPanel contentPane;

	private static final String imgDir = "./Graphics/string/";
	private static Image Image_BG = new ImageIcon(
			"Graphics/background/bg01.jpg").getImage();

	GetImage getImg = new GetImage();

	public StartFrame() {
		this.setTitle("Java Á¬Á¬¿´");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		// this.setResizable(false);
		JButton btnNewButton = new JButton(getImg.getImage(imgDir + "start"
				+ ".jpg"));
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		ImagePanel panel = new ImagePanel();
		panel.add(btnNewButton);
		add(panel);
		setVisible(true);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					new mainFrame().setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	class ImagePanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			g.drawImage(Image_BG, 0, 0, 1000, 700, 0, 0, 1280, 946, null);
		}
	}
}