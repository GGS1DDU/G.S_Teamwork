package elms.presentation;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel extends JLabel {

	private ImageIcon imgicon;
	private Image img;
	private float alpha;

	public MyLabel(String s,float alpha) {
		this(s,"bg.jpg");
		this.alpha = alpha;
	}
	
	public MyLabel(String s,String icon){
		super(s);
		imgicon = new ImageIcon(icon);
		img = imgicon.getImage();
	}
	
	public MyLabel(String s,String icon,float alpha){
		this(s,icon);
		this.alpha = alpha;
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		AlphaComposite alphaComposite = AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER, alpha);
		g2d.setComposite(alphaComposite);// 透明度
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

		
	}
}
