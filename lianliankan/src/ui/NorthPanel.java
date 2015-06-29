package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NorthPanel extends JPanel {
	JPanel northPanel = new JPanel();
	TimePanel time = new TimePanel();
	Timer timer = new Timer(true);
	JButton pause = new JButton("ÔÝÍ£");
	boolean flag = false;

	public NorthPanel() {

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				if (CenterPanel.btnLeft == 0) {
					// TODO SOMETHING
					mainFrame.contentPanel.removeAll();
					mainFrame.contentPanel.add(mainFrame.winPanel);
					mainFrame.winPanel.setSize(
							mainFrame.contentPanel.getWidth(),
							mainFrame.contentPanel.getHeight());
					this.cancel();
					pause.setEnabled(false);
				}

				if (time.isEnd()) {
					mainFrame.contentPanel.removeAll();
					mainFrame.contentPanel.add(mainFrame.gameOverPanel);
					mainFrame.gameOverPanel.setSize(
							mainFrame.contentPanel.getWidth(),
							mainFrame.contentPanel.getHeight());
					this.cancel();
					pause.setEnabled(false);
				}
			}
		};

		Date date = new Date();
		long delay = 500;
		timer.schedule(task, date, delay);

		pause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (flag == false) {
					pause.setText("¼ÌÐø");
					timer.cancel();
					mainFrame.contentPanel.setVisible(false);

				} else {
					pause.setText("ÔÝÍ£");
					mainFrame.contentPanel.setVisible(true);
					timer = new Timer();
					TimerTask task = new TimerTask() {

						@Override
						public void run() {
							if (CenterPanel.btnLeft == 0) {
								mainFrame.contentPanel.removeAll();
								mainFrame.contentPanel.add(mainFrame.winPanel);
								mainFrame.winPanel.setSize(
										mainFrame.contentPanel.getWidth(),
										mainFrame.contentPanel.getHeight());
								this.cancel();
								pause.setEnabled(false);
							}
							if (time.isEnd()) {
								mainFrame.contentPanel.removeAll();
								mainFrame.contentPanel
										.add(mainFrame.gameOverPanel);
								mainFrame.gameOverPanel.setSize(
										mainFrame.contentPanel.getWidth(),
										mainFrame.contentPanel.getHeight());
								this.cancel();
								pause.setEnabled(false);
							}
						}
					};
					timer.schedule(task, date, delay);
				}
				flag = !flag;

			}
		});

		this.setLayout(new BorderLayout());
		this.add(time, BorderLayout.CENTER);
		this.add(pause, BorderLayout.EAST);
		this.setBackground(new Color(255, 0, 0));
		pause.setBackground(Color.green);

	}
}
