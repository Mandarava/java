package ui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;


class TimePanel extends JPanel {
	int cnt = 0;

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.fillRect(this.getWidth() - cnt, 0, cnt, this.getHeight());
	}

	public boolean isEnd() {
		if (cnt++ > this.getWidth())
			return true;
		repaint();
		return false;
	}
}