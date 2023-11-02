package KIOSK_graduation_project;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;

public class test {

	JFrame frame;

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
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setBounds(100, 100, 480, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel imgPanel = new JPanel();
		JButton[] btnItem = new JButton[13];
		JPanel mainPanel = new JPanel();

		int menupage = 0;
		int menuHorizontalLength = 30; //첫번째 메뉴의 가로위치
		int menuVerticalLength = 0; //첫번째 매뉴의 세로위치
		int menuImageWidth = 100;   //메뉴들의 가로 길이
		int menuImageHeight = 100;  //메뉴들의 세로 길이
		int menuHorizontalInterval = 110; //메뉴들사이의 간격

		imgPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				imgPanel.setVisible(false);// 창이 보이지 않게
				mainPanel.setVisible(true);// 창이 보이게
			}
		});

		// 메뉴 이미지 버튼 초기화
		for (int i = 0; i < btnItem.length; i++) {
			mainPanel.add(btnItem[i] = new JButton());

			btnItem[i].setHorizontalAlignment(SwingConstants.CENTER);

			if (i < 4) {
				menuVerticalLength = 90;
				btnItem[i].setBounds(menuHorizontalLength, menuVerticalLength, menuImageWidth, menuImageHeight);

			} else if ((i >= 4) && (i < 8)) {
				menuVerticalLength = 210;
				btnItem[i].setBounds(menuHorizontalLength, menuVerticalLength, menuImageWidth, menuImageHeight);

			} else if ((i >= 8) && (i < 12)) {
				menuVerticalLength = 330;
				btnItem[i].setBounds(menuHorizontalLength, menuVerticalLength, menuImageWidth, menuImageHeight);

			}

			menuHorizontalLength = menuHorizontalInterval + menuHorizontalLength;

			if ((i + 1) % 4 == 0) {
				menuHorizontalLength = 30;
			}

			// btnItem[i].setVisible(true);
			btnItem[i].setBorderPainted(false);
			// btnItem[i].setContentAreaFilled(false);
			btnItem[i].setFocusPainted(false);
		}

		JLabel lblNewLabel = new JLabel("화면을 터치해 주세요");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("문체부 제목 돋음체", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(110, 660, 314, 41);
		imgPanel.add(lblNewLabel);
		imgPanel.add(lblNewLabel, BorderLayout.SOUTH);
		imgPanel.setBackground(new Color(192, 192, 192));
		imgPanel.setForeground(new Color(0, 0, 0));
		imgPanel.setBounds(0, 0, 464, 601);
		frame.getContentPane().add(imgPanel);

		mainPanel.setBackground(new Color(128, 255, 0));
		mainPanel.setForeground(new Color(0, 0, 0));
		mainPanel.setBounds(0, 0, 464, 601);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
	}
}
