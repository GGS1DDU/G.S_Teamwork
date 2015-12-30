package elms.presentation.mainui;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elms.presentation.MyButton;
import elms.presentation.MyFrame;
import elms.presentation.uihelper.ScreenSize;

public class MainUI extends MyFrame{
	
	public static void main(String[] args){
		MyFrame jf = new MainUI();
		jf.setVisible(true);
	}
	
	public MainUI(){

		super("background.jpg");
		MyButton sign = new MyButton();
		sign.setBounds(this.getWidth()/2-120,this.getHeight()*3/4,this.getWidth()/4+20,this.getHeight()/4-30);
		sign.setIcon("user-1.png");
		sign.setRolloverIcon("user-2.png");
		contentPane.add(sign);
		
		MyButton inquiry = new MyButton();
		inquiry.setBounds(sign.getX()-sign.getWidth(),this.getHeight()/2+50,sign.getWidth(),sign.getHeight());
		inquiry.setIcon("search-1.png");
		inquiry.setRolloverIcon("search-2.png");
		contentPane.add(inquiry);
		
		MyButton about = new MyButton();
		about.setBounds(sign.getX()+sign.getWidth(), inquiry.getY(), sign.getWidth(), sign.getHeight());
		about.setIcon("about-1.png");
		about.setRolloverIcon("about-2.png");
		contentPane.add(about);
		

		
		sign.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame login = new LoginUI();
				login.setBounds(r);
				login.setVisible(true);
			}
			
		});
		
		inquiry.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame find = new FindOrder();
				find.setVisible(true);
			}
			
		});
	}
	
	
}
