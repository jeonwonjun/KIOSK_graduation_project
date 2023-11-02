package KIOSK_graduation_project;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChangeAdvertisingScene extends Thread{
	
	JLabel advertisingScene; // 광고이미지 바꾸는 씬
	boolean running = true;
	
	public ChangeAdvertisingScene(JLabel advertisingScene){
		this.advertisingScene = advertisingScene;
	}
	
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage();  //ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg); 
		return xyimg;
	}
	
	@Override
	public synchronized void run() {
		while (running) {
			try {
				
				ImageIcon imgTest1 = new ImageIcon("./imgs/ol1.jpg");
				imgTest1 = imageSetSize(imgTest1, 540, 700);
				advertisingScene.setIcon(imgTest1);
				sleep(5000);
				
				ImageIcon imgTest2 = new ImageIcon("./imgs/ol2.jpg");
				imgTest2 = imageSetSize(imgTest2, 540, 700);
				advertisingScene.setIcon(imgTest2);
				sleep(5000);
				
			} catch (InterruptedException e) {
				running = false;
			}
		}
	}
}
