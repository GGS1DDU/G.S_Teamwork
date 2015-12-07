package elms.presentation.managerui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.UserInfo;
import elms.vo.UserVO;

public class ManagerUI_main extends JFrame{

	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	
	private JPanel user;
	private JPanel buttonPanel;
	
	private JButton freight_b;
	private JButton member_b;
	private JButton log_b;
	private JButton approval_b;
	private JButton form_b;
	
	public static void main(String[] args){
		UserVO vo = new UserVO();
		JFrame jf = new ManagerUI_main(vo);
	}
	
	public ManagerUI_main(UserVO u_vo){
		setLayout(null);
		setTitle("总经理");
		setResizable(false);
		setSize(screenWidth/2,1*screenHeight/2);
		setLocation(screenWidth/4, screenHeight/8);
		
		
		
		user = new UserInfo(u_vo);
		user.setBounds(0,0,this.getWidth(),30);
		add(user);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0, user.getHeight(), this.getWidth(), this.getHeight()-user.getHeight());
		buttonPanel.setLayout(null);
		add(buttonPanel);
		
		
		freight_b = new MyButton("运费策略");
		member_b = new MyButton("人员管理");
		approval_b = new MyButton("审批单据");
		form_b = new MyButton("查看统计报表");
		log_b = new MyButton("查看系统日志");
		
		buttonPanel.add(freight_b);
		buttonPanel.add(member_b);
		buttonPanel.add(approval_b);
		buttonPanel.add(form_b);
		buttonPanel.add(log_b);
		int width = buttonPanel.getWidth();
		int height = buttonPanel.getHeight();
		
		freight_b.setBounds(width*2/7,height/5,width/7,height/6);
		member_b.setBounds(width*4/7,height/5,width/7,height/6);
		form_b.setBounds(width/7,height*3/5-20,width/7+20,height/6);
		approval_b.setBounds(width*3/7,height*3/5-20,width/7,height/6);
		log_b.setBounds(width*5/7-10,height*3/5-20,width/7+20,height/6);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class MyButton extends JButton{
		public MyButton(String s){
			super(s);
			this.setBackground(Color.WHITE);
		}
	}
}
