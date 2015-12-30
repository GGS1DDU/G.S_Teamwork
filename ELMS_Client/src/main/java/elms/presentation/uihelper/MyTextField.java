package elms.presentation.uihelper;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class MyTextField extends JTextField{

	private ImageIcon imgicon;
	private Image img;
	private float alpha = 1.0f;
	
	public MyTextField(String s,String icon,float alpha){
		super(s);
		imgicon = new ImageIcon(icon);
		img = imgicon.getImage();
	}
	
	public MyTextField(){
//		this(null,"text.jpg",1.0f);
//		setOpaque(false);
		setBorder(BorderFactory.createLineBorder(Color.black,0));
		setFont(new Font("微软雅黑", Font.BOLD, 20));
	}
	
	public MyTextField(float alpha){
		this(null,"text.jpg",alpha);
	}
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2d=(Graphics2D)g;
		
		AlphaComposite alphaComposite=AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
	    g2d.setComposite(alphaComposite);//透明度
		g2d.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), this);
		
		super.paintComponent(g2d);
	}

	
}
