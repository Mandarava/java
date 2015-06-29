package ui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import judge.Tip;

public class SouthPanel extends JPanel {

	JPanel southPanel = new JPanel();
	JButton exitButton = new JButton("�˳�");
	JButton newlyButton = new JButton("����һ��");
	JButton tipsButton = new JButton("��ʾ");

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

		tipsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Tip tip = new Tip(CenterPanel.dots, CenterPanel.map);
				Point p[] = new Point[2];
				p = tip.getTips();
				if (p != null) {
					CenterPanel.dots[p[0].x][p[0].y].setBorderPainted(true);// ��ʾ�߿�
					Border lineBorder = BorderFactory
							.createLineBorder(Color.GREEN);
					Border etchedBorder = BorderFactory
							.createEtchedBorder(EtchedBorder.LOWERED);// ���ñ߿���

					CenterPanel.dots[p[0].x][p[0].y].setBorder(BorderFactory
							.createCompoundBorder(lineBorder, etchedBorder));
					CenterPanel.dots[p[0].x][p[0].y].setRolloverEnabled(true);

					CenterPanel.dots[p[1].x][p[1].y].setBorderPainted(true);// ��ʾ�߿�
					CenterPanel.dots[p[1].x][p[1].y].setBorder(BorderFactory
							.createCompoundBorder(lineBorder, etchedBorder));
					CenterPanel.dots[p[1].x][p[1].y].setBorder(BorderFactory
							.createCompoundBorder(lineBorder, etchedBorder));
				}

			}

		});

		this.add(exitButton);
		this.add(newlyButton);
		this.add(tipsButton);
		exitButton.setBackground(new Color(250, 250, 250));
		newlyButton.setBackground(new Color(250, 250, 250));
		tipsButton.setBackground(new Color(250, 250, 250));
		this.setBackground(new Color(216, 191, 216));
	}
}
