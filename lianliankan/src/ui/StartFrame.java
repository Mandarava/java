package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
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
	public static int rowEasyHard = 8;
	public static int colEasyHard = 11;

	GetImage getImg = new GetImage();

	public StartFrame() throws Exception {
		this.setTitle("Java Á¬Á¬¿´");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 700);
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width) / 4;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height) / 5;
		this.setLocation(w, h);
		this.setResizable(false);
		JButton btnNewButton = new JButton(getImg.getImage(imgDir + "start"
				+ ".jpg"));
		JButton hardButton = new JButton(getImg.getImage(imgDir + "hard"
				+ ".jpg"));
		JButton easyButton = new JButton(getImg.getImage(imgDir + "easy"
				+ ".jpg"));

		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);

		hardButton.setMargin(new Insets(0, 0, 0, 0));
		hardButton.setFocusPainted(false);
		hardButton.setBorderPainted(false);
		hardButton.setBorder(null);

		easyButton.setMargin(new Insets(0, 0, 0, 0));
		easyButton.setFocusPainted(false);
		easyButton.setBorderPainted(false);
		easyButton.setBorder(null);

		ImagePanel panel = new ImagePanel();
		panel.add(btnNewButton);
		panel.add(hardButton);
		panel.add(easyButton);
		add(panel);
		setVisible(true);
		hardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					StartFrame.this.dispose();
					rowEasyHard = 10;
					colEasyHard = 17;
					new mainFrame().setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		easyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					StartFrame.this.dispose();
					rowEasyHard = 8;
					colEasyHard = 11;
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