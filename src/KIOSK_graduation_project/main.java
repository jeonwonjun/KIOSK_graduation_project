package KIOSK_graduation_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JMenu;
import java.awt.Panel;
import javax.swing.JTextField;

import org.w3c.dom.css.RGBColor;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;

public class main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private MutableAttributeSet center;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(226, 240, 217));
		frame.setBounds(0,0,540,700);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_selection = new JButton("New button");
		btnNewButton_selection.setBounds(479, 45, 35, 35);
		frame.getContentPane().add(btnNewButton_selection);
		
		JTextPane textPane_10 = new JTextPane();
		textPane_10.setText("제품명 : \r\n가격 : ");
		textPane_10.setBounds(151, 409, 96, 33);
		frame.getContentPane().add(textPane_10);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setText("제품명 : \r\n가격 : ");
		textPane_6.setBounds(151, 288, 96, 33);
		frame.getContentPane().add(textPane_6);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setText("제품명 : \r\n가격 : ");
		textPane_4.setBounds(399, 168, 96, 33);
		frame.getContentPane().add(textPane_4);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setText("제품명 : \r\n가격 : ");
		textPane_7.setBounds(275, 288, 96, 33);
		frame.getContentPane().add(textPane_7);                   
		
		JTextPane textPane_12 = new JTextPane();
		textPane_12.setText("제품명 : \r\n가격 : ");
		textPane_12.setBounds(399, 409, 96, 33);
		frame.getContentPane().add(textPane_12);
		
		JTextPane textPane_9 = new JTextPane();
		textPane_9.setText("제품명 : \r\n가격 : ");
		textPane_9.setBounds(27, 409, 96, 33);
		frame.getContentPane().add(textPane_9);
		
		JTextPane textPane_11 = new JTextPane();
		textPane_11.setText("제품명 : \r\n가격 : ");
		textPane_11.setBounds(275, 409, 96, 33);
		frame.getContentPane().add(textPane_11);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setText("제품명 : \r\n가격 : ");
		textPane_5.setBounds(27, 288, 96, 33);
		frame.getContentPane().add(textPane_5);
		
		JTextPane textPane_8 = new JTextPane();
		textPane_8.setText("제품명 : \r\n가격 : ");
		textPane_8.setBounds(399, 288, 96, 33);
		frame.getContentPane().add(textPane_8);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("제품명 : \r\n가격 : ");
		textPane_3.setBounds(275, 168, 96, 33);
		frame.getContentPane().add(textPane_3);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setText("제품명 : \r\n가격 : ");
		textPane_2.setBounds(151, 168, 96, 33);
		frame.getContentPane().add(textPane_2);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("제품명 : \r\n가격 : ");
		textPane_1.setBounds(27, 168, 96, 33);
		frame.getContentPane().add(textPane_1);
		
		JButton btnNewButton_2 = new JButton();
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(149, 103, 100, 100);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(25, 103, 100, 100);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton();
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(397, 103, 100, 100);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(273, 103, 100, 100);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton();
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setBounds(25, 223, 100, 100);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton();
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setBackground(new Color(255, 255, 255));
		btnNewButton_6.setBounds(149, 223, 100, 100);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton();
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(new Color(255, 255, 255));
		btnNewButton_7.setBounds(273, 223, 100, 100);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton();
		btnNewButton_8.setForeground(new Color(255, 255, 255));
		btnNewButton_8.setBackground(new Color(255, 255, 255));
		btnNewButton_8.setBounds(397, 223, 100, 100);
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton();
		btnNewButton_9.setForeground(new Color(255, 255, 255));
		btnNewButton_9.setBackground(new Color(255, 255, 255));
		btnNewButton_9.setBounds(25, 344, 100, 100);
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton();
		btnNewButton_10.setForeground(new Color(255, 255, 255));
		btnNewButton_10.setBackground(new Color(255, 255, 255));
		btnNewButton_10.setBounds(149, 344, 100, 100);
		frame.getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton();
		btnNewButton_11.setForeground(new Color(255, 255, 255));
		btnNewButton_11.setBackground(new Color(255, 255, 255));
		btnNewButton_11.setBounds(273, 344, 100, 100);
		frame.getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton();
		btnNewButton_12.setForeground(new Color(255, 255, 255));
		btnNewButton_12.setBackground(new Color(255, 255, 255));
		btnNewButton_12.setBounds(397, 344, 100, 100);
		frame.getContentPane().add(btnNewButton_12);
		
		textField = new JTextField("제품");
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setBackground(new Color(169, 209, 142));
		textField.setBounds(0, 0, 526, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("세부사항을 선택하세요");
		textField_1.setHorizontalAlignment(JTextField.CENTER);
		textField_1.setBounds(10, 45, 504, 35);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(509, 103, 17, 350);
		frame.getContentPane().add(scrollBar);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setBounds(479, 45, 35, 35);
		frame.getContentPane().add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBackground(new Color(50, 72, 114));
		chckbxNewCheckBox.setBounds(1, 452, 30, 30);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton_13 = new JButton("<HTML>다<br>음</HTML>");
		btnNewButton_13.setBackground(new Color(245, 243, 165));
		btnNewButton_13.setBounds(489, 452, 37, 211);
		frame.getContentPane().add(btnNewButton_13);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("~~~제품명~~~");
		textPane.setBackground(new Color(169, 209, 142));
		textPane.setBounds(32, 453, 255, 30);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_13 = new JTextPane();
		textPane_13.setText("수량");
		textPane_13.setBackground(new Color(169, 209, 142));
		textPane_13.setBounds(323, 452, 35, 30);
		frame.getContentPane().add(textPane_13);
		
		JTextPane textPane_13_1 = new JTextPane();
		textPane_13_1.setText("가격");
		textPane_13_1.setBackground(new Color(169, 209, 142));
		textPane_13_1.setBounds(395, 452, 95, 30);
		frame.getContentPane().add(textPane_13_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(169, 209, 142));
		textField_2.setBounds(0, 452, 486, 210);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(142, 489, 200, 50);
		frame.getContentPane().add(menuBar);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
