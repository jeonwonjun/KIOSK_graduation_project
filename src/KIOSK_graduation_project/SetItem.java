package KIOSK_graduation_project;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class SetItem {

	JButton btnItem[];
	JRadioButton rdbtn;
	ArrayList<String> Product_arr = new ArrayList();
	String image_path = "./skincareImages/";
	String category = "";

	

	// 메뉴 버튼 title
	public static String[][] menuTitle = new String[12][];
	// 메뉴 버튼 가격
	public static String[][] menuPrice = new String[12][];

	// MainCategory별 이름 정하기
	public void mainCategory(JRadioButton rdbtn) {
		if (rdbtn.isSelected()) {
			String category = ""; // mysql의 MainCategory 가져오기
		}
	}

	// subCategory별 이름 정하기
	public void subCategory(JRadioButton rdbtn) {
		if (rdbtn.isSelected()) {
			String category = ""; // mysql의 subcategory 가져오기
		}
	}

	public void setItem(JButton[] btnItem) {

		// button 이미지 넣기
		btnItem[0].setIcon(new ImageIcon(image_path + "스킨/라네즈 크림스킨.png"));
		btnItem[1].setIcon(new ImageIcon(image_path + "스킨/라운드랩1025독도 토너.png"));
		btnItem[2].setIcon(new ImageIcon(image_path + "스킨/아누아어성초77토너.png"));
		btnItem[3].setIcon(new ImageIcon(image_path + "스킨/파티온 노스카나인 트러블클리어 토너.png"));
		btnItem[4].setIcon(new ImageIcon(image_path + "앰플세럼/구달청귤 비타C 잡티케어 세럼.png"));
		btnItem[5].setIcon(new ImageIcon(image_path + "앰플세럼/나인위시스 하이드라 수분앰플.png"));
		btnItem[6].setIcon(new ImageIcon(image_path + "앰플세럼/웰라쥬 리얼 히알루로닉 블루 100앰플.png"));
		btnItem[7].setIcon(new ImageIcon(image_path + "앰플세럼/토리든 다이브인 저분자 히알루론산 세럼.png"));
		btnItem[8].setIcon(new ImageIcon(image_path + "크림/닥터지 레드블레미쉬 수딩 크림.png"));
		btnItem[9].setIcon(new ImageIcon(image_path + "크림/에스트라 아토베리어365크림.png"));
		btnItem[10].setIcon(new ImageIcon(image_path + "크림/피지오겔 DMT 페이셜 크림.png"));
		btnItem[11].setIcon(new ImageIcon(image_path + "크림/한율 어린쑥 수분 진정 크림.png"));
	}

}
