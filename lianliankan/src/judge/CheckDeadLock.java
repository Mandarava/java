package judge;

import java.awt.Point;

import javax.swing.JButton;

import ui.CenterPanel;

public class CheckDeadLock {
	JButton p[][] = new JButton[CenterPanel.ROW][CenterPanel.COLUMN];
	Point temp[] = new Point[CenterPanel.ROW * CenterPanel.COLUMN];
	JButton btTemp[] = new JButton[CenterPanel.ROW * CenterPanel.COLUMN];
	int map[][] = null;

	public CheckDeadLock(JButton p[][], int map[][]) {
		this.p = p;
		this.map = map;
	}

	public boolean isDeadLock() {
		int count = 0;
		for (int i = 0; i < CenterPanel.ROW; i++)
			for (int j = 0; j < CenterPanel.COLUMN; j++) {
				temp[count] = new Point(i, j);
				btTemp[count] = p[i][j];
				count++;
			}

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {

				int row1 = i / CenterPanel.COLUMN; // һά�������ֵ��������
				int row2 = j / CenterPanel.COLUMN;
				int col1 = i % CenterPanel.COLUMN;
				int col2 = j % CenterPanel.COLUMN;

				CheckLink check = new CheckLink(temp[i], temp[j], map);

				if (map[row1][col1] == 1
						&& map[row2][col2] == 1 // �ж��Ƿ�������һȦ��button
						&& btTemp[i].getToolTipText().equals(
								btTemp[j].getToolTipText())
						&& check.checkLink()) {
					return false;
				}
			}
		}
		return true;
	}
}