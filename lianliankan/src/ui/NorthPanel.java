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
				if (time.isEnd()) {
					System.out.println("!!!!!!!");

					// System.exit(0);
				}
			}
		};

		Date date = new Date();
		long delay = 10;
		timer.schedule(task, date, delay);

		pause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				pause.setText(flag == false ? "¼ÌÐø" : "ÔÝÍ£");
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
