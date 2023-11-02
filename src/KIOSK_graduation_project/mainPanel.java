package KIOSK_graduation_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class mainPanel extends JPanel{

	private JFrame f;
	JPanel mainPurchasePanel = new JPanel();
	JPanel mainItemPanel = new JPanel();
	JButton[] btnItem = new JButton[13];
	
	 // 1. 장바구니 테이블, 합계 패널
    private JPanel basketPanel; // scrollPane, sumPanel이 붙을 패널
    private JScrollPane scrollPane; // 테이블 스크롤 가능
    private JTable table; // 장바구니 테이블
    private String header[] = {"상품명", "단가", "수량", "가격"}; // 테이블 헤더
    public static DefaultTableModel model; // 테이블 모델
    private int row = -1; // 테이블 클릭시 선택된 행
    private static JPanel sumPanel; // 합계 패널
    public static JLabel sumPrice; // 합계
    
	public mainPanel(JFrame f) {
		this.f = f;
		 // 배치관리자
        setLayout(new BorderLayout());
        // 폰트
        Font font = new Font("맑은 고딕", Font.PLAIN, 23);
        
		// 1. 장바구니 패널 - 테이블, 합계
        // 장바구니 패널 생성, 배치관리자 설정
        basketPanel = new JPanel();
        basketPanel.setLayout(new BorderLayout());

        // 테이블 생성, 마우스 리스너 붙이기
        model = new DefaultTableModel(header, 0);  // defaultTableModel 생성
        table = new JTable(model);

        //table.addMouseListener(new TableMouseListener());
        scrollPane = new JScrollPane(table);
        
        // 테이블에 폰트 적용
        table.getTableHeader().setFont(font); // 헤더
        table.setFont(font); // 셀
        table.setRowHeight(30);

        // 합계 패널
        font = new Font("맑은 고딕", Font.BOLD, 30);
        sumPanel = new JPanel();
        sumPrice = new JLabel("0원");
        sumPrice.setFont(font);
        JLabel str = new JLabel("합계");
        str.setFont(font);
        sumPanel.add(str);
        sumPanel.add(sumPrice);
        
		//mainPurchase 화면
		mainPurchasePanel.setBackground(new Color(226, 240, 217));
		mainPurchasePanel.setBounds(0, 0, 540, 700);
		mainPurchasePanel.setLayout(null);
		f.add(mainPurchasePanel);

		mainItemPanel.setBackground(new Color(226, 240, 217));
		mainItemPanel.setBounds(0, 40, 526, 415);
		mainPurchasePanel.add(mainItemPanel);
		mainItemPanel.setLayout(null);

		JButton btnPurchaseSelection = new JButton("...");
		btnPurchaseSelection.setBounds(477, 10, 35, 35);
		mainItemPanel.add(btnPurchaseSelection);
		btnPurchaseSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPurchasePanel.setVisible(false);
				//optionPanel.setVisible(true);
			}
		});

		JLabel purchaseDetailLabel = new JLabel("세부사항을 선택하세요");
		purchaseDetailLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		purchaseDetailLabel.setBackground(new Color(255, 255, 255));
		purchaseDetailLabel.setBounds(12, 10, 500, 35);
		purchaseDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseDetailLabel.setOpaque(true); //Label 배경색 지정가능 설정
		mainItemPanel.add(purchaseDetailLabel);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(509, 46, 17, 369);
		mainItemPanel.add(scrollBar);
		
		JPanel basketPanel = new JPanel();
		basketPanel.setBackground(new Color(169, 209, 142));
		basketPanel.setBounds(0, 453, 526, 210);
		mainPurchasePanel.add(basketPanel);
		basketPanel.setLayout(null);

		JCheckBox chckbxCheck = new JCheckBox("");
		chckbxCheck.setBackground(new Color(245, 243, 165));
		chckbxCheck.setBounds(0, 0, 30, 30);
		basketPanel.add(chckbxCheck);

		JLabel ItemLabel = new JLabel("제품명");
		ItemLabel.setBounds(38, 0, 242, 30);
		basketPanel.add(ItemLabel);

		JButton btnNext = new JButton("<HTML>다<br>음</HTML>");
		btnNext.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnNext.setBackground(new Color(245, 243, 165));
		btnNext.setBounds(489, 0, 37, 210);
		btnNext.setBorderPainted(false);
		basketPanel.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPurchasePanel.setVisible(false);
				//AccPayPanel.setVisible(true);
			}
		});

		/*
		 * JButton btnPlus = new JButton("+"); btnPlus.setBackground(new Color(245, 243,
		 * 165)); btnPlus.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		 * btnPlus.setBounds(280, 0, 41, 30); btnPlus.setBorderPainted(false);
		 * basketPanel.add(btnPlus);
		 * 
		 * JButton btnMinus = new JButton("-"); btnMinus.setBackground(new Color(245,
		 * 243, 165)); btnMinus.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		 * btnMinus.setBounds(355, 0, 40, 30); btnMinus.setBorderPainted(false);
		 * basketPanel.add(btnMinus);
		 */

		JLabel CountLabel = new JLabel("수량");
		CountLabel.setBounds(320, 0, 30, 30);
		basketPanel.add(CountLabel);

		JLabel PriceLabel = new JLabel("가격");
		PriceLabel.setBounds(397, 0, 92, 30);
		basketPanel.add(PriceLabel);

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(169, 209, 142));
		titlePanel.setBounds(0, 0, 526, 40);
		mainPurchasePanel.add(titlePanel);
		
		JList list = new JList();
		list.setBounds(0, 481, 489, 180);
		basketPanel.add(list);

		JLabel Main_Label = new JLabel("제품");
		Main_Label.setFont(new Font("함초롬돋움", Font.PLAIN, 19));
		titlePanel.add(Main_Label);
	}
			
}


