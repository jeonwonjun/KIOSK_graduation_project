package KIOSK_graduation_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MutableAttributeSet;

import services.DBConnection;

public class AD extends JFrame {

	private JFrame jframe = new JFrame();
	private SetItem buttonSet = new SetItem();
	private MutableAttributeSet center;
	services.ProductService productService;

	// 메뉴 버튼 title
	public static String[] menuTitle = { "라네즈 크림스킨", "라운드랩1025 독도 토너", "아누아 어성초 77% 토너", "구달 청귤 비타C 잡티케어 세럼",
			"웰라쥬 리얼 히알루로닉 블루100 앰플", "토리든 다이브인 저분자 히알루론산 세럼", "닥터지 레드 블레미쉬 클리어 수딩 크림", "에스트라 아토베리어365 크림",
			"피지오겔 DMT 페이셜 크림", "메디힐 티트리 에센셜 마스크", "메디힐 워터마이드 에센셜 마스크", "아비브 어성초 스팟 패드 카밍터치" };
	// 메뉴 버튼 가격
	public static String[] menuPrice = { "26400", "13500", "22800", "21280", "29900", "22400", "27600", "31000",
			"29900", "2000", "2000", "16800" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBConnection dbConnection = new DBConnection();
					dbConnection.connect();
					AD window = new AD();
					window.jframe.setVisible(true);
					window.mainPurchasePanel.setVisible(false);
					window.optionPanel.setVisible(false);
					window.AccPayPanel.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JLabel advertisingScene = new JLabel(); // 광고이미지 바꾸는 씬
	JPanel mainPurchaseScene = new JPanel();
	JPanel packagingDeliveringScene = new JPanel() {
		public void paintComponent(Graphics g) {
			Dimension d = getSize();
			ImageIcon image = new ImageIcon("./imgs/empty.png");
			g.drawImage(image.getImage(), 0, 0, d.width, d.height, this);
		}
	};

	JLabel pressKeyText = new JLabel();
	ChangeAdvertisingScene changeAdvertisingScene = new ChangeAdvertisingScene(advertisingScene);

	// 1. 장바구니 테이블, 합계 패널
	private JPanel basketPanel; // scrollPane, sumPanel이 붙을 패널
	private JScrollPane scrollPane; // 테이블 스크롤 가능
	private JTable table; // 장바구니 테이블
	private String header[] = { "상품명", "단가", "수량", "가격" }; // 테이블 헤더
	public static DefaultTableModel model; // 테이블 모델
	private int row = -1; // 테이블 클릭시 선택된 행
	private static JPanel sumPanel; // 합계 패널
	public static JLabel sumPrice; // 합계

	JPanel mainPurchasePanel = new JPanel();
	JPanel mainItemPanel = new JPanel();
	JButton[] btnItem = new JButton[12];

	JPanel optionPanel = new JPanel();
	JPanel optionItemPanel = new JPanel();

	JPanel AccPayPanel = new JPanel();

	int menupage = 0;
	int menuHorizontalLength = 30; // 첫번째 메뉴의 가로위치
	int menuVerticalLength = 0; // 첫번째 매뉴의 세로위치
	int menuImageWidth = 100; // 메뉴들의 가로 길이
	int menuImageHeight = 100; // 메뉴들의 세로 길이
	int menuHorizontalInterval = 115; // 메뉴들사이의 간격

	public AD() {

		jframe = new JFrame();
		jframe.setBounds(0, 0, 540, 700);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setTitle("KIOSK");
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.getContentPane().setLayout(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X로 frame을 종료했을 때

		advertisingScene.setBounds(0, 0, 540, 700);
		jframe.getContentPane().add(advertisingScene);
		advertisingScene.setLayout(null);

		advertisingScene.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				advertisingScene.setVisible(false);
				mainPurchasePanel.setVisible(true);
				optionPanel.setVisible(false);
				// insertCardButton.setEnabled(true); //결제 후 비활성화 된 카드 투입버튼을 광고창이 나타날때 활성화 시킴
				// insertCardImage.setIcon(new ImageIcon("./otherimages/카드투입.png"));
				// restart = "";
				buttonSet.setItem(btnItem);

			}
		});

		// 처음 화면 (광고화면)
		pressKeyText.setBounds(0, 598, 550, 100);
		pressKeyText.setLayout(null);
		pressKeyText.setText("화면을 터치해 주세요");
		pressKeyText.setHorizontalAlignment(SwingConstants.CENTER);
		pressKeyText.setFont(new Font("굴림", Font.BOLD, 21));
		pressKeyText.setForeground(Color.white);
		advertisingScene.add(pressKeyText);

		changeAdvertisingScene.start();

		// 메뉴 이미지 버튼 초기화
		for (int i = 0; i < 12; i++) {
			mainItemPanel.add(btnItem[i] = new JButton("" + i));

			btnItem[i].setHorizontalAlignment(SwingConstants.CENTER);

			if (i < 4) {
				menuVerticalLength = 60;
				btnItem[i].setBounds(menuHorizontalLength, menuVerticalLength, menuImageWidth, menuImageHeight);
				btnItem[i].setBackground(new Color(255, 255, 255)); // 이미지로 채울 예정

			} else if ((i >= 4) && (i < 8)) {
				menuVerticalLength = 180;
				btnItem[i].setBounds(menuHorizontalLength, menuVerticalLength, menuImageWidth, menuImageHeight);
				btnItem[i].setBackground(new Color(255, 255, 255));

			} else if ((i >= 8) && (i < 12)) {
				menuVerticalLength = 300;
				btnItem[i].setBounds(menuHorizontalLength, menuVerticalLength, menuImageWidth, menuImageHeight);
				btnItem[i].setBackground(new Color(255, 255, 255));
			}

			menuHorizontalLength = menuHorizontalInterval + menuHorizontalLength;

			if ((i + 1) % 4 == 0) {
				menuHorizontalLength = 30;
			}

			btnItem[i].addActionListener(new MenuBtnActionListener());

			// btnItem[i].setVisible(true);
			btnItem[i].setBorderPainted(false);
			// btnItem[i].setContentAreaFilled(false);
			btnItem[i].setFocusPainted(false);

		}

		// mainPurchase 화면
		mainPurchasePanel.setBackground(new Color(226, 240, 217));
		mainPurchasePanel.setBounds(0, 0, 540, 700);
		mainPurchasePanel.setLayout(new BorderLayout());
		jframe.add(mainPurchasePanel);

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
				optionPanel.setVisible(true);
			}
		});

		JLabel purchaseDetailLabel = new JLabel("세부사항을 선택하세요");
		purchaseDetailLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		purchaseDetailLabel.setBackground(new Color(255, 255, 255));
		purchaseDetailLabel.setBounds(12, 10, 500, 35);
		purchaseDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseDetailLabel.setOpaque(true); // Label 배경색 지정가능 설정
		mainItemPanel.add(purchaseDetailLabel);

		/*
		 * JScrollBar scrollBar = new JScrollBar(); scrollBar.setBounds(509, 46, 17,
		 * 369); mainItemPanel.add(scrollBar);
		 */

		JPanel basketbackPanel;
		// 장바구니 패널 - 테이블, 합계
		basketbackPanel = new JPanel();
		basketbackPanel.setBackground(new Color(169, 209, 142));
		basketbackPanel.setBounds(0, 453, 489, 210);
		basketbackPanel.setLayout(new BorderLayout());
		mainPurchasePanel.add(basketbackPanel);

		// 장바구니 패널 - 테이블, 합계
		basketPanel = new JPanel();
		basketPanel.setBackground(new Color(169, 209, 142));
		basketPanel.setBounds(0, 453, 489, 150);
		basketPanel.setLayout(new BorderLayout());
		basketbackPanel.add(basketPanel);

		// 폰트
		Font font = new Font("맑은 고딕", Font.PLAIN, 12);

		// 테이블 생성, 마우스 리스너 붙이기, 내용 수정 불가(미완)
		model = new DefaultTableModel(header, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		}; // defaultTableModel 생성
		table = new JTable(model);
		setColumnWidths(table, 250, 100, 30, 109);
		table.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
		// table.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가

		// 테이블 내용 가운데 정렬하기
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		TableColumnModel tcm = table.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr); // 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여
			// 각각의 셀렌더러를 아까 생성한 dtcr에 set해줌
		}

		// table.addMouseListener(new TableMouseListener());
		scrollPane = new JScrollPane(table);
		
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());

		// 테이블에 폰트 적용
		table.getTableHeader().setFont(font); // 헤더
		table.setFont(font); // 셀
		table.setRowHeight(17);

		// 합계 패널
		font = new Font("맑은 고딕", Font.BOLD, 14);
		sumPanel = new JPanel();
		sumPrice = new JLabel("0원");
		sumPrice.setFont(font);
		JLabel str = new JLabel("합계");
		str.setFont(font);
		sumPanel.add(str);
		sumPanel.add(sumPrice);

		// 장바구니 패널에 테이블, 합계 붙이기
		basketPanel.add(scrollPane);
		basketbackPanel.add(sumPanel, "South");

		// Acc_Pay창으로 넘어가는 버튼
		JButton btnNext = new JButton("<HTML>다<br>음</HTML>");
		btnNext.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnNext.setBackground(new Color(245, 243, 165));
		btnNext.setBounds(489, 453, 37, 210);
		btnNext.setBorderPainted(false);
		mainPurchasePanel.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPurchasePanel.setVisible(false);
				AccPayPanel.setVisible(true);
			}
		});

		// title패널
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(169, 209, 142));
		titlePanel.setBounds(0, 0, 526, 40);
		mainPurchasePanel.add(titlePanel);

		JLabel Main_Label = new JLabel("제품");
		Main_Label.setFont(new Font("함초롬돋움", Font.PLAIN, 19));
		titlePanel.add(Main_Label);

		// optionPanel 화면
		optionPanel.setBackground(new Color(226, 240, 217));
		optionPanel.setBounds(0, 0, 540, 700);
		optionPanel.setLayout(null);
		jframe.add(optionPanel);

		optionItemPanel.setLayout(null);
		optionItemPanel.setBackground(new Color(226, 240, 217));
		optionItemPanel.setBounds(0, 40, 526, 623);
		optionPanel.add(optionItemPanel);

		JButton btnOptionSelection = new JButton("...");
		btnOptionSelection.setBounds(477, 10, 35, 35);
		optionItemPanel.add(btnOptionSelection);
		btnOptionSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPurchasePanel.setVisible(true);
				optionPanel.setVisible(false);
			}
		});

		JLabel optionDetailLabel = new JLabel("세부사항을 선택하세요");
		optionDetailLabel.setOpaque(true);
		optionDetailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		optionDetailLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		optionDetailLabel.setBackground(Color.WHITE);
		optionDetailLabel.setBounds(12, 10, 500, 35);
		optionItemPanel.add(optionDetailLabel);

		JPanel detailPanel = new JPanel();
		detailPanel.setBackground(new Color(226, 240, 217));
		detailPanel.setBounds(12, 45, 465, 362);
		optionItemPanel.add(detailPanel);
		detailPanel.setLayout(null);

		JRadioButton rdbtnHair = new JRadioButton("헤어");
		rdbtnHair.setBounds(0, 40, 155, 40);
		rdbtnHair.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnHair.setBackground(Color.WHITE);
		detailPanel.add(rdbtnHair);

		JRadioButton rdbtnFace = new JRadioButton("얼굴");
		rdbtnFace.setBounds(0, 80, 155, 40);
		rdbtnFace.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnFace.setBackground(Color.WHITE);
		detailPanel.add(rdbtnFace);

		JRadioButton rdbtnBody = new JRadioButton("바디");
		rdbtnBody.setBounds(0, 120, 155, 40);
		rdbtnBody.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnBody.setBackground(Color.WHITE);
		detailPanel.add(rdbtnBody);

		JRadioButton rdbtnEtc = new JRadioButton("기타");
		rdbtnEtc.setBounds(0, 160, 155, 40);
		rdbtnEtc.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnEtc.setBackground(Color.WHITE);
		detailPanel.add(rdbtnEtc);

		JLabel BodyLabel = new JLabel("신체부위");
		BodyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BodyLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		BodyLabel.setBackground(new Color(215, 215, 215));
		BodyLabel.setBounds(0, 0, 155, 40);
		BodyLabel.setOpaque(true);
		detailPanel.add(BodyLabel);

		JLabel KindLabel = new JLabel("종류");
		KindLabel.setOpaque(true);
		KindLabel.setHorizontalAlignment(SwingConstants.CENTER);
		KindLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		KindLabel.setBackground(new Color(215, 215, 215));
		KindLabel.setBounds(155, 0, 155, 40);
		detailPanel.add(KindLabel);

		JLabel TypeLabel = new JLabel("타입");
		TypeLabel.setOpaque(true);
		TypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TypeLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		TypeLabel.setBackground(new Color(215, 215, 215));
		TypeLabel.setBounds(310, 0, 155, 40);
		detailPanel.add(TypeLabel);

		JRadioButton rdbtnSkincare = new JRadioButton("스킨케어");
		rdbtnSkincare.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnSkincare.setBackground(Color.WHITE);
		rdbtnSkincare.setBounds(155, 40, 155, 40);
		detailPanel.add(rdbtnSkincare);

		JRadioButton rdbtnMaskpack = new JRadioButton("마스크팩");
		rdbtnMaskpack.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnMaskpack.setBackground(Color.WHITE);
		rdbtnMaskpack.setBounds(155, 80, 155, 40);
		detailPanel.add(rdbtnMaskpack);

		JRadioButton rdbtnCleansing = new JRadioButton("클렌징");
		rdbtnCleansing.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnCleansing.setBackground(Color.WHITE);
		rdbtnCleansing.setBounds(155, 120, 155, 40);
		detailPanel.add(rdbtnCleansing);

		JRadioButton rdbtnSuncare = new JRadioButton("선케어");
		rdbtnSuncare.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnSuncare.setBackground(Color.WHITE);
		rdbtnSuncare.setBounds(155, 160, 155, 40);
		detailPanel.add(rdbtnSuncare);

		JRadioButton rdbtnJi = new JRadioButton("지성");
		rdbtnJi.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnJi.setBackground(Color.WHITE);
		rdbtnJi.setBounds(310, 40, 155, 40);
		detailPanel.add(rdbtnJi);

		JRadioButton rdbtnBok = new JRadioButton("복합성");
		rdbtnBok.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnBok.setBackground(Color.WHITE);
		rdbtnBok.setBounds(310, 80, 155, 40);
		detailPanel.add(rdbtnBok);

		JRadioButton rdbtnJung = new JRadioButton("중성");
		rdbtnJung.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnJung.setBackground(Color.WHITE);
		rdbtnJung.setBounds(310, 120, 155, 40);
		detailPanel.add(rdbtnJung);

		JRadioButton rdbtnGun = new JRadioButton("건성");
		rdbtnGun.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnGun.setBackground(Color.WHITE);
		rdbtnGun.setBounds(310, 160, 155, 40);
		detailPanel.add(rdbtnGun);

		JRadioButton rdbtnMakeup = new JRadioButton("메이크업");
		rdbtnMakeup.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnMakeup.setBackground(Color.WHITE);
		rdbtnMakeup.setBounds(155, 200, 155, 40);
		detailPanel.add(rdbtnMakeup);

		JRadioButton rdbtnBodycare = new JRadioButton("바디케어");
		rdbtnBodycare.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnBodycare.setBackground(Color.WHITE);
		rdbtnBodycare.setBounds(155, 240, 155, 40);
		detailPanel.add(rdbtnBodycare);

		JRadioButton rdbtnHaircare = new JRadioButton("헤어케어");
		rdbtnHaircare.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnHaircare.setBackground(Color.WHITE);
		rdbtnHaircare.setBounds(155, 280, 155, 40);
		detailPanel.add(rdbtnHaircare);

		JRadioButton rdbtnTool = new JRadioButton("미용소품");
		rdbtnTool.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnTool.setBackground(Color.WHITE);
		rdbtnTool.setBounds(155, 320, 155, 40);
		detailPanel.add(rdbtnTool);

		JRadioButton rdbtnSu = new JRadioButton("수부지");
		rdbtnSu.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnSu.setBackground(Color.WHITE);
		rdbtnSu.setBounds(310, 200, 155, 40);
		detailPanel.add(rdbtnSu);

		JRadioButton rdbtnMin = new JRadioButton("민감성");
		rdbtnMin.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		rdbtnMin.setBackground(Color.WHITE);
		rdbtnMin.setBounds(310, 240, 155, 40);
		detailPanel.add(rdbtnMin);

		JPanel optionTitlePanel = new JPanel();
		optionTitlePanel.setBackground(new Color(169, 209, 142));
		optionTitlePanel.setBounds(0, 0, 526, 40);
		optionPanel.add(optionTitlePanel);

		JLabel optionLabel = new JLabel("제품");
		optionLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 19));
		optionTitlePanel.add(optionLabel);

		// Acc_Pay 화면
		AccPayPanel.setBackground(new Color(226, 240, 217));
		AccPayPanel.setBounds(0, 0, 540, 700);
		AccPayPanel.setLayout(null);
		jframe.add(AccPayPanel);

		JPanel AccPayTitlePanel = new JPanel();
		AccPayTitlePanel.setBackground(new Color(169, 209, 142));
		AccPayTitlePanel.setBounds(0, 0, 526, 40);
		AccPayPanel.add(AccPayTitlePanel);

		JLabel AccPayLable = new JLabel("적립 / 결제");
		AccPayLable.setHorizontalAlignment(SwingConstants.CENTER);
		AccPayLable.setForeground(Color.BLACK);
		AccPayLable.setFont(new Font("함초롬돋움", Font.PLAIN, 19));
		AccPayLable.setBackground(new Color(169, 209, 142));
		AccPayTitlePanel.add(AccPayLable);

		JPanel accPanel = new JPanel();
		accPanel.setBackground(new Color(226, 240, 217));
		accPanel.setBounds(0, 39, 524, 301);
		AccPayPanel.add(accPanel);
		accPanel.setLayout(null);

		JLabel accLabel = new JLabel("1. 적립");
		accLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		accLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accLabel.setBounds(35, 25, 70, 33);
		accPanel.add(accLabel);

		JPanel PhPanel = new JPanel();
		PhPanel.setBounds(205, 75, 120, 120);
		accPanel.add(PhPanel);
		PhPanel.setLayout(null);

		JButton btnPh = new JButton("");
		btnPh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NumberPad numberPad = new NumberPad();
				numberPad.setVisible(true);
			}
			
		});
		btnPh.setBackground(new Color(255, 255, 255));
		btnPh.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\전원준(대)\\4-1\\졸업 프로젝트 - 김장영\\phone64px.png"));
		btnPh.setBounds(0, 0, 120, 120);
		btnPh.setBorderPainted(false);
		PhPanel.add(btnPh);

		JPanel userIDPanel = new JPanel();
		userIDPanel.setBounds(45, 75, 120, 120);
		accPanel.add(userIDPanel);
		userIDPanel.setLayout(null);

		JButton btnUserID = new JButton("");
		btnUserID.setBackground(new Color(255, 255, 255));
		btnUserID.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\전원준(대)\\4-1\\졸업 프로젝트 - 김장영\\user64px.png"));
		btnUserID.setBounds(0, 0, 120, 120);
		btnUserID.setBorderPainted(false);
		userIDPanel.add(btnUserID);

		JLabel userIDLabel = new JLabel("회원번호");
		userIDLabel.setBounds(45, 195, 120, 25);
		accPanel.add(userIDLabel);
		userIDLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		userIDLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel PhLabel = new JLabel("전화번호");
		PhLabel.setBounds(205, 195, 120, 25);
		accPanel.add(PhLabel);
		PhLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		PhLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel payPanel = new JPanel();
		payPanel.setBackground(new Color(226, 240, 217));
		payPanel.setBounds(0, 340, 524, 321);
		AccPayPanel.add(payPanel);
		payPanel.setLayout(null);

		JLabel payLabel = new JLabel("2. 결제");
		payLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		payLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payLabel.setBounds(35, 25, 70, 33);
		payPanel.add(payLabel);

		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(45, 75, 120, 120);
		payPanel.add(cardPanel);
		cardPanel.setLayout(null);

		JButton btnCard = new JButton("");
		btnCard.setBackground(new Color(255, 255, 255));
		btnCard.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\전원준(대)\\4-1\\졸업 프로젝트 - 김장영\\card96px.png"));
		btnCard.setBounds(0, 0, 120, 120);
		btnCard.setBorderPainted(false);
		cardPanel.add(btnCard);

		JPanel SApayPanel = new JPanel();
		SApayPanel.setBounds(205, 75, 120, 120);
		payPanel.add(SApayPanel);
		SApayPanel.setLayout(null);

		JButton btnPay = new JButton("");
		btnPay.setBackground(new Color(255, 255, 255));
		btnPay.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\전원준(대)\\4-1\\졸업 프로젝트 - 김장영\\NFC64px.png"));
		btnPay.setBounds(0, 0, 120, 120);
		btnPay.setBorderPainted(false);
		SApayPanel.add(btnPay);

		JButton btnBack = new JButton("이전");
		btnBack.setBackground(new Color(169, 209, 142));
		btnBack.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnBack.setBounds(390, 265, 100, 30);
		btnBack.setBorderPainted(false);
		payPanel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPurchasePanel.setVisible(true);
				AccPayPanel.setVisible(false);
			}
		});

		JLabel cardLabel = new JLabel("신용카드");
		cardLabel.setBounds(45, 195, 120, 25);
		payPanel.add(cardLabel);
		cardLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		cardLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel SApayLabel = new JLabel("삼성/애플 페이");
		SApayLabel.setBounds(205, 195, 120, 25);
		payPanel.add(SApayLabel);
		SApayLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		SApayLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public static void setColumnWidths(JTable table, int... widths) {
		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 0; i < widths.length; i++) {
			if (i < columnModel.getColumnCount()) {
				columnModel.getColumn(i).setMaxWidth(widths[i]);
			} else
				break;
		}
	}

	class MenuBtnActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			int b = Integer.parseInt(btn.getText());

			// 장바구니에 담긴 서로 다른 메뉴의 개수
			int tableSize = model.getRowCount();
			// 장바구니에 담긴 해당 메뉴의 수량
			int quantity = 0;
			// 해당 메뉴의 가격
			int price = 0;
			// 이미 장바구니에 담겨져 있는 검사
			boolean inBasket = false;

			// 해당 메뉴 가격
			// for (int i = 0; i < menuTitle.length; i++)
			// if (b.equals(menuTitle[i]))
			price = Integer.parseInt(menuPrice[b]);

			// 장바구니에 이미 담겨있는지 검사
			for (int i = 0; i < tableSize; i++) {
				// 같은 값이 존재할 때
				if (menuTitle[b].equals(model.getValueAt(i, 0))) {
					String[] curMenu = new String[2];
					curMenu[0] = (String) model.getValueAt(i, 1); // 단가
					curMenu[1] = (String) model.getValueAt(i, 2); // 수량

					quantity = Integer.parseInt(curMenu[1]) + 1; // 수량 + 1
					price = quantity * price; // 수량 * 가격

					// table 업데이트
					model.setValueAt(Integer.toString(quantity), i, 2);
					model.setValueAt(Integer.toString(price), i, 3);

					inBasket = true;
					break;
				}

			}

			// 새로운 상품이라면
			if (!inBasket) {
				tableSize++; // 테이블 사이즈 + 1

				String[] newMenu = new String[4];
				newMenu[0] = menuTitle[b];
				newMenu[1] = Integer.toString(price);
				newMenu[2] = "1";
				newMenu[3] = Integer.toString(price);

				// table 업데이트
				model.addRow(newMenu);
			}

			// 합계 업데이트
			int sum = 0;
			for (int i = 0; i < tableSize; i++)
				sum += Integer.parseInt((String) model.getValueAt(i, 3));

			sumPrice.setText(Integer.toString(sum) + "원");

		}

	}

}
