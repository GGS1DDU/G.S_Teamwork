package elms.presentation;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel{

	Toolkit tk = Toolkit.getDefaultToolkit();
	private String iconName;
	private ImageIcon imgicon;
	private Image img;
	private float alpha = 1.0f;
	
	public MyPanel(String icon){
		
//		super();
		setLayout(null);
		setBackground(Color.white);
//		this.iconName = icon;
		imgicon = new ImageIcon(icon);
		img = imgicon.getImage();
	}
	
	public MyPanel(String icon,float alpha){
		this(icon);
		this.alpha = alpha;
		
	}
//	public void paint(Graphics g){
//		Image img = tk.getImage(iconName);
//		if(img==null){
//			super.paint(g);
//		}else{
//			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
//		}
//	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		
		AlphaComposite alphaComposite=AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
	    g2d.setComposite(alphaComposite);//透明度
		g2d.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), this);
	}
}
