package judge;

import java.awt.Point;

import javax.swing.JButton;

import ui.CenterPanel;

public class Tip {
	JButton p[][] = new JButton[CenterPanel.ROW][CenterPanel.COLUMN];
	Point temp[] = new Point[CenterPanel.ROW * CenterPanel.COLUMN];
	JButton btTemp[] = new JButton[CenterPanel.ROW * CenterPanel.COLUMN];
	int map[][] = null;

	public Tip(JButton p[][], int map[][]) {
		this.p = p;
		this.map = map;
	}

	public Point[] getTips() {
		Point ans[] = new Point[2];
		int count = 0;
		for (int i = 0; i < CenterPanel.ROW; i++)
			for (int j = 0; j < CenterPanel.COLUMN; j++) {
				temp[count] = new Point(i, j);
				btTemp[count] = p[i][j];
				count++;
			}

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {

				int row1 = i / CenterPanel.COLUMN; // 一维数组里的值化成坐标
				int row2 = j / CenterPanel.COLUMN;
				int col1 = i % CenterPanel.COLUMN;
				int col2 = j % CenterPanel.COLUMN;

				CheckLink check = new CheckLink(temp[i], temp[j], map);

				if (map[row1][col1] == 1
						&& map[row2][col2] == 1 // 判断是否不是四周一圈的button
						&& btTemp[i].getToolTipText().equals(
								btTemp[j].getToolTipText())
						&& check.checkLink()) {
					ans[0] = new Point(row1, col1);
					ans[1] = new Point(row2, col2);
					return ans;
				}
			}

		}
		return new Point[] { new Point(-1, -1), new Point(-1, -1) };
	}
}
