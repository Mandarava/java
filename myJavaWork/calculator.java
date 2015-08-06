import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class calculator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private String firstNum = "";
	private String secondNum = "";
	private String result = ""; // 运算结果
	private char operator = '+'; // 操作符
	private int operatorCount = 0;// 用与检测是否重复输入操作符
	public int btnCount = 0; // 用于判断第一个是否为“-”
	public int pointCount = 0;
	public int equalCount = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					calculator frame = new calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public calculator() {
		setTitle("\u8BA1\u7B97\u5668");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField(result);
		textField.setFont(new Font("宋体", Font.PLAIN, 25));
		textField.setBounds(14, 13, 459, 70);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setHorizontalAlignment(SwingConstants.SOUTH_EAST);

		ActionListener btnListener = new btnListener();

		JButton btnZero = new JButton("0");
		btnZero.addActionListener(btnListener);
		btnZero.setBounds(14, 308, 105, 40);
		btnZero.setActionCommand("0");
		contentPane.add(btnZero);

		JButton btnOne = new JButton("1");
		btnOne.addActionListener(btnListener);
		btnOne.setBounds(14, 255, 105, 40);
		btnOne.setActionCommand("1");
		contentPane.add(btnOne);

		JButton btnTwo = new JButton("2");
		btnTwo.addActionListener(btnListener);
		btnTwo.setBounds(130, 255, 105, 40);
		btnTwo.setActionCommand("2");
		contentPane.add(btnTwo);

		JButton btnThree = new JButton("3");
		btnThree.addActionListener(btnListener);
		btnThree.setBounds(249, 255, 105, 40);
		btnThree.setActionCommand("3");
		contentPane.add(btnThree);

		JButton btnFour = new JButton("4");
		btnFour.addActionListener(btnListener);
		btnFour.setBounds(14, 202, 105, 40);
		btnFour.setActionCommand("4");
		contentPane.add(btnFour);

		JButton btnFive = new JButton("5");
		btnFive.addActionListener(btnListener);
		btnFive.setBounds(130, 202, 105, 40);
		btnFive.setActionCommand("5");
		contentPane.add(btnFive);

		JButton btnSix = new JButton("6");
		btnSix.addActionListener(btnListener);
		btnSix.setBounds(249, 202, 105, 40);
		btnSix.setActionCommand("6");
		contentPane.add(btnSix);

		JButton btnSeven = new JButton("7");
		btnSeven.addActionListener(btnListener);
		btnSeven.setBounds(14, 149, 105, 40);
		btnSeven.setActionCommand("7");
		contentPane.add(btnSeven);

		JButton btnEight = new JButton("8");
		btnEight.addActionListener(btnListener);
		btnEight.setBounds(130, 149, 105, 40);
		btnEight.setActionCommand("8");
		contentPane.add(btnEight);

		JButton btnNine = new JButton("9");
		btnNine.addActionListener(btnListener);
		btnNine.setBounds(249, 149, 105, 40);
		btnNine.setActionCommand("9");
		contentPane.add(btnNine);

		JButton btnPoint = new JButton(".");
		btnPoint.addActionListener(btnListener);
		btnPoint.setBounds(130, 308, 105, 40);
		btnPoint.setActionCommand(".");
		contentPane.add(btnPoint);

		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(btnListener);
		btnAdd.setBounds(368, 149, 105, 40);
		btnAdd.setActionCommand("+");
		contentPane.add(btnAdd);

		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(btnListener);
		btnMinus.setBounds(368, 202, 105, 40);
		btnMinus.setActionCommand("-");
		contentPane.add(btnMinus);

		JButton btnMulti = new JButton("*");
		btnMulti.addActionListener(btnListener);
		btnMulti.setBounds(368, 255, 105, 40);
		btnMulti.setActionCommand("*");
		contentPane.add(btnMulti);

		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(btnListener);
		btnDivide.setBounds(368, 308, 105, 40);
		btnDivide.setActionCommand("/");
		contentPane.add(btnDivide);

		JButton btnResult = new JButton("=");
		btnResult.addActionListener(btnListener);
		btnResult.setBounds(249, 308, 105, 40);
		btnResult.setActionCommand("=");
		contentPane.add(btnResult);

		JButton btnClr = new JButton("clr");
		btnClr.setActionCommand("clr");
		btnClr.setBounds(368, 96, 105, 40);
		btnClr.addActionListener(btnListener);
		contentPane.add(btnClr);

		JButton button = new JButton(" ");
		button.setBounds(249, 96, 105, 40);
		contentPane.add(button);

		JButton button_1 = new JButton(" ");
		button_1.setBounds(130, 96, 105, 40);
		contentPane.add(button_1);

		JButton button_2 = new JButton(" ");
		button_2.setBounds(14, 96, 105, 40);
		contentPane.add(button_2);
	}

	public void clearText() {
		textField.setText("");
		pointCount = 0;
		firstNum = "";
		secondNum = "";
		operatorCount = 0;
		btnCount = 0;
		equalCount = 0;
		result = "";
	}

	class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (result != ""
					&& operatorCount == 0
					&& (e.getActionCommand() == "0"
							|| e.getActionCommand() == "1"
							|| e.getActionCommand() == "2"
							|| e.getActionCommand() == "3"
							|| e.getActionCommand() == "4"
							|| e.getActionCommand() == "5"
							|| e.getActionCommand() == "6"
							|| e.getActionCommand() == "7"
							|| e.getActionCommand() == "8"
							|| e.getActionCommand() == "9" || e
							.getActionCommand() == ".")) {
				clearText();
			}

			if (e.getActionCommand() == "0" || e.getActionCommand() == "1"
					|| e.getActionCommand() == "2"
					|| e.getActionCommand() == "3"
					|| e.getActionCommand() == "4"
					|| e.getActionCommand() == "5"
					|| e.getActionCommand() == "6"
					|| e.getActionCommand() == "7"
					|| e.getActionCommand() == "8"
					|| e.getActionCommand() == "9") {
				secondNum += e.getActionCommand();
				textField.setText(secondNum);
				btnCount++;
			} else if (e.getActionCommand() == ".") {
				if (pointCount == 0) {
					secondNum += e.getActionCommand();
					textField.setText(secondNum);
				}
				pointCount++;
			} else if (btnCount == 0 && e.getActionCommand() == "-"
					&& result == "") {
				secondNum += e.getActionCommand();
				textField.setText(secondNum);
				btnCount++;
			} else if ((e.getActionCommand() == "+"
					|| e.getActionCommand() == "-"
					|| e.getActionCommand() == "*" || e.getActionCommand() == "/")
					&& operatorCount == 0) {
				btnCount = 0;
				pointCount = 0;
				operatorCount++;
				firstNum = secondNum;
				secondNum = "";
				operator = e.getActionCommand().charAt(0);
				textField.setText(firstNum + operator);
			} else if (e.getActionCommand() == "=") { // 按下=号时的处理
				if (firstNum == "" && secondNum == "") {
					firstNum = "0";
					secondNum = "0";
				}

				if (firstNum == "") {
					firstNum = "0";
				}
				if (secondNum == "") {
					secondNum = "0";
				}

				try {
					// System.out.println(firstNum + "," + secondNum);
					new BigDecimal(firstNum);
					new BigDecimal(secondNum);
				} catch (Exception ex) {
					textField.setText("ERROR");
				}
				switch (operator) {
				case '+':
					result = new BigDecimal(firstNum).add(new BigDecimal(
							secondNum)) + "";
					textField.setText(result);
					break;
				case '-':
					result = new BigDecimal(firstNum).subtract(new BigDecimal(
							secondNum)) + "";
					textField.setText(result);
					break;
				case '*':
					result = new BigDecimal(firstNum).multiply(new BigDecimal(
							secondNum)) + "";
					textField.setText(result);
					break;
				case '/':
					StringBuffer result2 = new StringBuffer();
					try {
						result = new BigDecimal(firstNum).divide(
								new BigDecimal(secondNum), 15,
								BigDecimal.ROUND_HALF_EVEN).doubleValue()
								+ "";
						if (result.matches("*.0+")) {
							for (int i = 0; i < result.length(); i++) {
								if (result.charAt(i) == '.') {
									break;
								} else {
									result2.append(result.charAt(i));
								}
							}
						}
						textField.setText(result2+"");
					} catch (Exception ex) {
						textField.setText("ERROR");
					}
					break;
				}
				firstNum = "";
				secondNum = result;
				// result = "";
				operatorCount = 0;
				btnCount = 0;

			} else if (e.getActionCommand() == "clr") { // 按下归零时的处理，所有计数归零
				clearText();
			}
		}
	}
}
