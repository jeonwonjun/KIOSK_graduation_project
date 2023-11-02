package KIOSK_graduation_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acc_Pay {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acc_Pay window = new Acc_Pay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Acc_Pay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("KIOSK");
		frame.setBounds(100, 100, 540, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Acc_Pay_Lable = new JLabel("적립 / 결제");
		Acc_Pay_Lable.setBackground(new Color(169, 209, 142));
		Acc_Pay_Lable.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 23));
		Acc_Pay_Lable.setHorizontalAlignment(SwingConstants.CENTER);
		Acc_Pay_Lable.setBounds(193, 10, 133, 42);
		frame.getContentPane().add(Acc_Pay_Lable);
		
		JPanel accPanel = new JPanel();
		accPanel.setBounds(0, 63, 524, 300);
		frame.getContentPane().add(accPanel);
		accPanel.setLayout(null);
		
		JLabel accLabel = new JLabel("1. 적립");
		accLabel.setFont(new Font("굴림", Font.PLAIN, 17));
		accLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accLabel.setBounds(12, 10, 100, 33);
		accPanel.add(accLabel);
		
		JPanel PhPanel = new JPanel();
		PhPanel.setBounds(204, 74, 115, 112);
		accPanel.add(PhPanel);
		PhPanel.setLayout(null);
		
		JLabel PhLabel = new JLabel("전화번호");
		PhLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PhLabel.setBounds(30, 95, 57, 15);
		PhPanel.add(PhLabel);
		
		JButton btnPh = new JButton("");
		btnPh.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\전원준(대)\\4-1\\졸업 프로젝트 - 김장영\\phone64px.png"));
		btnPh.setBounds(0, 0, 115, 95);
		PhPanel.add(btnPh);
		
		JPanel userIDPanel = new JPanel();
		userIDPanel.setBounds(45, 75, 115, 112);
		accPanel.add(userIDPanel);
		userIDPanel.setLayout(null);
		
		JLabel userIDLabel = new JLabel("회원번호");
		userIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userIDLabel.setBounds(31, 97, 57, 15);
		userIDPanel.add(userIDLabel);
		
		JButton btnUserID = new JButton("");
		btnUserID.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\전원준(대)\\4-1\\졸업 프로젝트 - 김장영\\user64px.png"));
		btnUserID.setBounds(0, 0, 115, 95);
		userIDPanel.add(btnUserID);
		
		JPanel payPanel = new JPanel();
		payPanel.setBounds(0, 361, 524, 300);
		frame.getContentPane().add(payPanel);
		payPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("2. 결제");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 96, 43);
		payPanel.add(lblNewLabel);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(45, 63, 115, 111);
		payPanel.add(cardPanel);
		cardPanel.setLayout(null);
		
		JButton btnCard = new JButton("");
		btnCard.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\전원준(대)\\4-1\\졸업 프로젝트 - 김장영\\card96px.png"));
		btnCard.setBounds(0, 0, 115, 95);
		cardPanel.add(btnCard);
		
		JLabel cardLabel = new JLabel("신용카드");
		cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardLabel.setBounds(31, 95, 57, 15);
		cardPanel.add(cardLabel);
		
		JPanel SApayPanel = new JPanel();
		SApayPanel.setBounds(204, 63, 115, 111);
		payPanel.add(SApayPanel);
		SApayPanel.setLayout(null);
		
		JButton btnPay = new JButton("");
		btnPay.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\전원준(대)\\4-1\\졸업 프로젝트 - 김장영\\NFC64px.png"));
		btnPay.setBounds(0, 0, 115, 95);
		SApayPanel.add(btnPay);
		
		JLabel SApayLabel = new JLabel("삼성/애플 페이");
		SApayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SApayLabel.setBounds(0, 96, 115, 15);
		SApayPanel.add(SApayLabel);
		
		JButton btnBack = new JButton("이전화면");
		btnBack.setBounds(331, 242, 147, 34);
		payPanel.add(btnBack);
	}
}
