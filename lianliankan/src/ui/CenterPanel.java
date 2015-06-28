package ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import judge.CheckLink;
import control.GetImage;

public class CenterPanel extends JPanel {

	JPanel centerPanel = new JPanel();
	public final static int PADDING = 2; // ����һȦ�յ�button
	public final static int ROW = PADDING + 8;
	public static int COLUMN = PADDING + 11;
	private static final String imgDir = "./Graphics/picture/";
	private static int pCount = 0;
	private static int[][] map = new int[ROW][COLUMN];
	private JButton[][] dots = new JButton[ROW][COLUMN];
	GetImage getImg = new GetImage();
	private static Point[] p = new Point[2];

	public CenterPanel() {
		this.setLayout(new GridLayout(ROW - PADDING, COLUMN - PADDING));
		Random rnd = new Random();

		// Initialize the map
		for (int i = 0; i < ROW; i++)
			for (int j = 0; j < COLUMN; j++) {
				dots[i][j] = new JButton();
				// dots[i][j].setVisible(false);
				map[i][j] = -1; // ��ʼ��map�� 1 ��ʾ��ͼ�δ��ڣ�-1 ��ʾΪ�� ������
			}

		JButton[] tempBtn = new JButton[(ROW - 2) * (COLUMN - 2)];
		for (int i = 0; i < tempBtn.length; i = i + 2) {
			int picName = rnd.nextInt(36);
			tempBtn[i] = new JButton(getImg.getImage(imgDir + picName + ".jpg"));
			tempBtn[i + 1] = new JButton(getImg.getImage(imgDir + picName
					+ ".jpg"));
			tempBtn[i].setToolTipText(String.valueOf(picName));
			tempBtn[i + 1].setToolTipText(String.valueOf(picName));
		}

		// set buttons with pictures
		int count = 0;
		for (int i = 1; i < ROW - 1; i++) {
			for (int j = 1; j < COLUMN - 1; j++) {
				dots[i][j] = tempBtn[count];
				map[i][j] = 1; // ���map
				count++;
			}
		}

		// ����˳��
		for (int i = 1; i < ROW - 1; i++) {
			for (int j = 1; j < COLUMN - 1; j++) {
				int rnd1 = rnd.nextInt(ROW - PADDING) + 1;
				int rnd2 = rnd.nextInt(COLUMN - PADDING) + 1;
				JButton temp = null;
				temp = dots[i][j];
				dots[i][j] = dots[rnd1][rnd2];
				dots[rnd1][rnd2] = temp;
			}
		}

		for (int i = 1; i < ROW - 1; i++) {
			for (int j = 1; j < COLUMN - 1; j++) {
				dots[i][j].setMargin(new Insets(0, 0, 0, 0));
				dots[i][j].setFocusPainted(false);
				dots[i][j].setBorderPainted(false);
				dots[i][j].setBorder(null);
				dots[i][j].setActionCommand("" + i + "," + j);
				this.add(dots[i][j]);
				dots[i][j].addActionListener(new buttonAction());
			}
		}
		this.setVisible(true);
		this.setBackground(new Color(250, 250, 250));

	}

	public class buttonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JButton) {
				JButton button = (JButton) e.getSource();
				String offset = button.getActionCommand();
				String[] value = offset.split(",");
				int row = Integer.parseInt(value[0]);
				int col = Integer.parseInt(value[1]);
				// System.out.println("row=" + row + "  col=" + col);
				p[pCount] = new Point(row, col);
				if (pCount == 1) {
					pCount = 0;
					CheckLink jug = new CheckLink(p[0], p[1], map);
					if (jug.checkLink()
							&& dots[p[0].x][p[0].y].getToolTipText().equals(
									dots[p[1].x][p[1].y].getToolTipText())) {
						dots[p[0].x][p[0].y].setVisible(false);
						dots[p[1].x][p[1].y].setVisible(false);
						map[p[0].x][p[0].y] = -1;
						map[p[1].x][p[1].y] = -1;
					}

				} else {
					pCount++;
				}
			}
		}
	}

}
