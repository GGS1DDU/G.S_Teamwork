package elms.presentation.mainui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elms.presentation.uihelper.MyButton;
import elms.presentation.uihelper.MyFrame;
import elms.presentation.uihelper.MyLabel;
import elms.presentation.uihelper.MyPanel;

public class AboutUs extends MyFrame{
	
	private JButton back;
	private MyButton set;
	private JLabel info;
	
	public static void main(String[] args){
		MyFrame jf = new AboutUs();
		jf.setVisible(true);
	}

	public AboutUs(){
		
		super("star.jpg");
		
		contentPane.remove(close);
		contentPane.remove(mini);
		
		info = new MyLabel("pale.jpg",0.5f);
//		info.setOpaque(true);
		info.setBounds(30,30,this.getWidth()-60,this.getHeight()-150);
		contentPane.add(info);
		
		set = new MyButton("设置服务器地址",15);
		set.setBounds(this.getWidth()/4,this.getHeight()-100, 150, 50);
		set.setForeground(Color.white);
		
		contentPane.add(set);
		
	}
	
}
