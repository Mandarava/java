import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LianLianKan implements ActionListener 

	@Override
	public void actionPerformed(ActionEvent e) { // �ӿ�ʵ��
		if (e.getSource() == newlyButton) {
			int grid[][] = new int[8][7];// ��������
			this.grid = grid;
			randomBuild();
			mainFrame.setVisible(false);// ���ڲ��ɼ�
			pressInformation = false;
			init();
		}
		if (e.getSource() == exitButton)
			System.exit(0);
		if (e.getSource() == resetButton)
			reload();
		for (int cols = 0; cols < 6; cols++) {
			for (int rows = 0; rows < 5; rows++) {
				if (e.getSource() == diamondsButton[cols][rows])
					estimateEven(cols + 1, rows + 1, diamondsButton[cols][rows]);
			}
		}
		if (e.getSource() == timer) {
			if (time.isEnd()) {
				timer.stop();// ʱ�䵽����ʾ
				if (JOptionPane.showConfirmDialog(mainFrame,
						"������ʱ�䵽�ˣ��������� o(����)o \nҪ����һ����", "��ʾ",
						JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) 
					
					
		
				}
			}
		}
	}
}