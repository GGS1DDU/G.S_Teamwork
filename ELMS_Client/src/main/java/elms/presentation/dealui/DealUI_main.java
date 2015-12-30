package elms.presentation.dealui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import elms.presentation.uihelper.MyButton;
import elms.presentation.uihelper.MyPanel;
import elms.vo.UserVO;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DealUI_Main extends JFrame implements ActionListener {
	UserVO vo;	
	private JPanel jp1;
	private MyButton xjdd;
	private MyButton srsjxx;
	private MyButton cxdd;
	private JPanel jp2;	
	private JPanel jp3;
	private MyButton button;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
public static void main(String args[]){
	UserVO vo=new UserVO();
	new DealUI_Main(vo);
}
	public DealUI_Main(UserVO vo) {
		setLayout(null);
		setVisible(true);
		setTitle("订单管理");
		setResizable(false);
		setBounds(screenWidth/6,screenHeight/8,screenWidth*2/3,screenHeight*3/4);
		this.vo=vo;	
		final MyPanel contentPane = new MyPanel("inbg.jpg");
		contentPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(contentPane);
		contentPane.setLayout(null);
		
		jp1=new JPanel();jp1.setOpaque(false);
		jp1.setLayout(null);jp1.setBorder(new TitledBorder(new EtchedBorder()));
		contentPane.add(jp1);
		jp1.setBounds(0, 0, 200, screenHeight*3/4);
		
		
		 xjdd = new MyButton("新建订单",20);xjdd.setForeground(Color.gray);
		 jp1.add(xjdd);	xjdd.setBounds(0,0,200,60);
		 xjdd.addActionListener(this);
		
			
		
		srsjxx=new MyButton("输入收件信息",15);
		jp1.add(srsjxx);srsjxx.setBounds(0, 60, 200, 40);
		srsjxx.addActionListener(this);
	
	
		
		cxdd=new MyButton("查询订单",15);
		jp1.add(cxdd);	cxdd.setBounds(0, 100, 200, 40);
		cxdd.addActionListener(this);
		
		
		button = new MyButton("退出系统",20);	jp1.add(button);
		button.setBounds(0, screenHeight*3/4-100, 200, 40);	
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DealUI_Main.this.dispose();
			}
		});
	
	

		
		jp2=new JPanel();jp2.setOpaque(false);
		jp2.setLayout(null);
		contentPane.add(jp2);
		jp2.setBounds(200, 0, screenWidth*2/3-200, screenHeight*3/4);
		JLabel jl=new JLabel(" 当前用户：  "+vo.getName()+"  身份：  "+vo.getJob()+"  编号   "+vo.getId());
		jp2.add(jl);jl.setBounds(200, 0, this.getWidth()-200, 25);

		
		jp3=new JPanel();jp3.setLayout(null);  jp3.setOpaque(false);
		jp2.add(jp3);
		jp3.setBounds(-1, 40,  screenWidth*2/3-200,screenHeight*3/4-40);
		DealUI_BuildAnOrder s=new DealUI_BuildAnOrder(vo);
		JScrollPane js=new JScrollPane(s);
		jp3.add(js);js.setBounds(0, 0,screenWidth*2/3 -200, screenHeight*3/4-40);
		s.setPreferredSize(new Dimension(screenWidth*2/3-220,1120));
		 js.setOpaque(false);js.getViewport().setOpaque(false);
		js.getVerticalScrollBar().setUnitIncrement(20);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==xjdd){
			jp3.setVisible(false);
			jp3=new JPanel();jp3.setLayout(null);  jp3.setOpaque(false);
			jp2.add(jp3);
			jp3.setBounds(-1, 40,  screenWidth*2/3-200,screenHeight*3/4-40);
			DealUI_BuildAnOrder s=new DealUI_BuildAnOrder(vo);
			JScrollPane js=new JScrollPane(s);
			jp3.add(js);js.setBounds(0, 0,screenWidth*2/3 -200, screenHeight*3/4-40);
			s.setPreferredSize(new Dimension(screenWidth*2/3-220,1120));
			 js.setOpaque(false);js.getViewport().setOpaque(false);
			js.getVerticalScrollBar().setUnitIncrement(20);
			xjdd.setBounds(0, 0, 200, 60);xjdd.setFont(new Font("宋体",1,20));xjdd.setForeground(Color.gray);
			srsjxx.setBounds(0, 60, 200, 40);srsjxx.setFont(new Font("宋体",1,15));srsjxx.setForeground(Color.black);
			cxdd.setBounds(0,100 , 200, 40);cxdd.setFont(new Font("宋体",1,15));cxdd.setForeground(Color.black);
				
}
		
		
		
		if(e.getSource()==srsjxx){
			jp3.setVisible(false);	
			jp3=new DealUI_Receival(vo);jp2.add(jp3);
			jp3.setBounds(0, 40,  screenWidth*2/3-200,screenHeight*3/4-40);	
			xjdd.setBounds(0, 0, 200, 40);xjdd.setFont(new Font("宋体",1,15));xjdd.setForeground(Color.black);
			srsjxx.setBounds(0, 40, 200, 60);srsjxx.setFont(new Font("宋体",1,20));srsjxx.setForeground(Color.gray);
			cxdd.setBounds(0,100 , 200, 40);cxdd.setFont(new Font("宋体",1,15));cxdd.setForeground(Color.black);
		}
		
		
		if(e.getSource()==cxdd){
			
			jp3.setVisible(false);
			jp3=new JPanel();jp3.setLayout(null);  jp3.setOpaque(false);
			jp2.add(jp3);
			jp3.setBounds(-1, 40,  screenWidth*2/3-200,screenHeight*3/4-40);
			DealUI_CheckAnOrder s=new DealUI_CheckAnOrder(vo);
			JScrollPane js=new JScrollPane(s);
			jp3.add(js);js.setBounds(0, 0,screenWidth*2/3 -200, screenHeight*3/4-40);
			s.setPreferredSize(new Dimension(screenWidth*2/3-220,1150));
			 js.setOpaque(false);js.getViewport().setOpaque(false);
			js.getVerticalScrollBar().setUnitIncrement(20);
			
			xjdd.setBounds(0, 0, 200, 40);xjdd.setFont(new Font("宋体",1,15));xjdd.setForeground(Color.black);
			srsjxx.setBounds(0, 40, 200, 40);srsjxx.setFont(new Font("宋体",1,15));srsjxx.setForeground(Color.black);
			cxdd.setBounds(0,80, 200, 60);cxdd.setFont(new Font("宋体",1,20));cxdd.setForeground(Color.gray);
					
		}		
	}
}
