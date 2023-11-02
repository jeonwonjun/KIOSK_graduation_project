package KIOSK_graduation_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Code {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Code window = new Code();
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
	public Code() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("KIOSK");
		frame.setBounds(100, 100, 340, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel codePanel = new JPanel();
		codePanel.setBackground(new Color(226, 240, 217));
		codePanel.setBounds(0, 40, 326, 423);
		frame.getContentPane().add(codePanel);
		codePanel.setLayout(null);
		
		JButton btnKeyboard1 = new JButton("1");
		btnKeyboard1.setBounds(39, 135, 75, 60);
		codePanel.add(btnKeyboard1);
		btnKeyboard1.setBackground(new Color(245, 243, 165));
		btnKeyboard1.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard1.setBorderPainted(false);
		
		JLabel NumberInputLabel = new JLabel("회원번호/전화번호를 입력해주세요");
		NumberInputLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		NumberInputLabel.setBounds(40, 25, 249, 44);
		NumberInputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		codePanel.add(NumberInputLabel);
		
		JLabel InputLabel = new JLabel("입력");
		InputLabel.setBackground(new Color(226, 240, 217));
		InputLabel.setForeground(new Color(192, 192, 192));
		InputLabel.setBounds(40, 75, 249, 40);
		InputLabel.setOpaque(true); 
		codePanel.add(InputLabel);
		
		JButton btnKeyboard2 = new JButton("2");
		btnKeyboard2.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard2.setBorderPainted(false);
		btnKeyboard2.setBackground(new Color(245, 243, 165));
		btnKeyboard2.setBounds(126, 135, 75, 60);
		codePanel.add(btnKeyboard2);
		
		JButton btnKeyboard3 = new JButton("3");
		btnKeyboard3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKeyboard3.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard3.setBorderPainted(false);
		btnKeyboard3.setBackground(new Color(245, 243, 165));
		btnKeyboard3.setBounds(213, 135, 75, 60);
		codePanel.add(btnKeyboard3);
		
		JButton btnKeyboard4 = new JButton("4");
		btnKeyboard4.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard4.setBorderPainted(false);
		btnKeyboard4.setBackground(new Color(245, 243, 165));
		btnKeyboard4.setBounds(39, 200, 75, 60);
		codePanel.add(btnKeyboard4);
		
		JButton btnKeyboard5 = new JButton("5");
		btnKeyboard5.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard5.setBorderPainted(false);
		btnKeyboard5.setBackground(new Color(245, 243, 165));
		btnKeyboard5.setBounds(126, 200, 75, 60);
		codePanel.add(btnKeyboard5);
		
		JButton btnKeyboard6 = new JButton("6");
		btnKeyboard6.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard6.setBorderPainted(false);
		btnKeyboard6.setBackground(new Color(245, 243, 165));
		btnKeyboard6.setBounds(213, 200, 75, 60);
		codePanel.add(btnKeyboard6);
		
		JButton btnKeyboard7 = new JButton("7");
		btnKeyboard7.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard7.setBorderPainted(false);
		btnKeyboard7.setBackground(new Color(245, 243, 165));
		btnKeyboard7.setBounds(40, 266, 75, 60);
		codePanel.add(btnKeyboard7);
		
		JButton btnKeyboard8 = new JButton("8");
		btnKeyboard8.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard8.setBorderPainted(false);
		btnKeyboard8.setBackground(new Color(245, 243, 165));
		btnKeyboard8.setBounds(127, 266, 75, 60);
		codePanel.add(btnKeyboard8);
		
		JButton btnKeyboard9 = new JButton("9");
		btnKeyboard9.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard9.setBorderPainted(false);
		btnKeyboard9.setBackground(new Color(245, 243, 165));
		btnKeyboard9.setBounds(214, 266, 75, 60);
		codePanel.add(btnKeyboard9);
		
		JButton btnKeyboard_지움 = new JButton("<-");
		btnKeyboard_지움.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard_지움.setBorderPainted(false);
		btnKeyboard_지움.setBackground(new Color(169, 209, 142));
		btnKeyboard_지움.setBounds(40, 332, 75, 60);
		codePanel.add(btnKeyboard_지움);
		
		JButton btnKeyboard0 = new JButton("0");
		btnKeyboard0.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard0.setBorderPainted(false);
		btnKeyboard0.setBackground(new Color(245, 243, 165));
		btnKeyboard0.setBounds(127, 332, 75, 60);
		codePanel.add(btnKeyboard0);
		
		JButton btnKeyboard_확인 = new JButton("확인");
		btnKeyboard_확인.setFont(new Font("함초롬돋움", Font.PLAIN, 15));
		btnKeyboard_확인.setBorderPainted(false);
		btnKeyboard_확인.setBackground(new Color(169, 209, 142));
		btnKeyboard_확인.setBounds(214, 332, 75, 60);
		codePanel.add(btnKeyboard_확인);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(169, 209, 142));
		titlePanel.setBounds(0, 0, 326, 40);
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel CodeLabel = new JLabel("회원번호/전화번호");
		CodeLabel.setBounds(12, 10, 134, 23);
		CodeLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		titlePanel.add(CodeLabel);
		
		JLabel CancelLabel = new JLabel("X");
		CancelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CancelLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 17));
		CancelLabel.setBounds(294, 11, 20, 20);
		titlePanel.add(CancelLabel);
	}
}
