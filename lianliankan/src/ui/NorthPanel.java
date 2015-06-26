package ui;

import javax.swing.JPanel;
import javax.swing.Timer;

public class NorthPanel extends JPanel {
	JPanel northPanel = new JPanel();
	TimePanel time = new TimePanel();
	Timer timer;

	public NorthPanel() {

		// this.setLayout(new BorderLayout());
		// this.add(time, BorderLayout.CENTER);
		this.add(time);

	}

}
