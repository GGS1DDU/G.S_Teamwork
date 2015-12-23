package elms.presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elms.presentation.mainui.LoginUI;
import elms.presentation.uihelper.ScreenSize;

public class MainUI extends JFrame{

	int screenWeidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	
	private JPanel contentPane;
	private JPanel imagePane;
	
	
	
	public static void main(String[] args){
		JFrame jf = new MainUI();
		jf.setVisible(true);
	}
	
	public MainUI(){
		setBounds(screenWeidth/6,screenHeight/8,screenWeidth*2/3,screenHeight*3/4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new MyPanel("bg5.jpg");

		add(contentPane);
		contentPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		
		imagePane = new MyPanel("bg.jpg",0.1f);
		imagePane.setOpaque(false);
		
		contentPane.add(imagePane);
		imagePane.setBounds(this.getWidth()/2-80,this.getHeight()/5,this.getWidth()/3+50,this.getHeight()/2);
//		imagePane.setBackground(getBackground());
		
		MyButton sign = new MyButton();
		sign.setBounds(this.getWidth()/2-30,this.getHeight()/4,this.getWidth()/4+25,this.getHeight()/4-25);
		sign.setIcon("sign.jpg");
//		contentPane.add(sign);
		
		MyButton inquiry = new MyButton();
		inquiry.setBounds(this.getWidth()/2-30,this.getHeight()/2-25,this.getWidth()/4+25,this.getHeight()/4-25);
		inquiry.setIcon("inquiry.jpg");
//		contentPane.add(inquiry);
		
		JPanel tuBiao = new MyPanel("logo2.png");
		tuBiao.setOpaque(false);
		tuBiao.setBounds(this.getWidth()/8, this.getHeight()/4, this.getWidth()/4, this.getWidth()/4);
		contentPane.add(tuBiao);
		
		sign.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame login = new LoginUI();
				login.setVisible(true);
			}
			
		});
		
		inquiry.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
			
		});
//		addLabel();
	}
	
	private void addLabel(){
		
	}
}
