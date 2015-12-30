package elms.presentation.dealui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import elms.vo.UserVO;

import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class DealUI_Main extends JFrame implements ActionListener {
	
	
	


	UserVO vo;
	
	int width;
	int height;
	
	private JPanel jp1;
	private JButton xjdd;
	private JButton srsjxx;
	private JButton cxdd;
	
	
	
	private JPanel jp2;
	private JLabel dqyh;
	private JLabel dqyh2;
	private JLabel sf;
	private JLabel sf2;
	private JLabel bh;
	private JLabel bh2;
		
	private JPanel jp3;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton button;


	public DealUI_Main(UserVO vo) {
		getContentPane().setBackground(Color.WHITE);
		this.vo=vo;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		width = (int)screensize.getWidth();
		height = (int)screensize.getHeight();
		
		setBounds(width/6, height/8, width*2/3, height*3/4);
		getContentPane().setLayout(null);
		
		jp1=new JPanel();
		jp1.setBackground(new Color(240, 248, 255));
		jp1.setLayout(null);
		getContentPane().add(jp1);
		jp1.setBounds(0, 0, 200, height*3/4);
		
		
		
		xjdd=new JButton("新建订单");
		xjdd.setBackground(Color.WHITE);
		xjdd.setForeground(Color.BLACK);
		xjdd.setFont(new Font("宋体", Font.PLAIN, 22));
		xjdd.setBounds(0, 0, 200, 40);
		xjdd.addActionListener(this);
		jp1.add(xjdd);
			
		
		srsjxx=new JButton("输入收件信息");
		srsjxx.setBackground(Color.WHITE);
		srsjxx.setForeground(Color.BLACK);
		srsjxx.setFont(new Font("宋体", Font.PLAIN, 22));
		srsjxx.setBounds(0, 40, 200, 40);
		srsjxx.addActionListener(this);
		jp1.add(srsjxx);
		
		
		
		cxdd=new JButton("查询订单");
		cxdd.setBackground(Color.WHITE);
		cxdd.setForeground(Color.BLACK);
		cxdd.setFont(new Font("宋体", Font.PLAIN, 22));
		cxdd.setBounds(0, 80, 200, 40);
		cxdd.addActionListener(this);
		jp1.add(cxdd);
		
		
		separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBounds(215, 34, -7, 1160);
		jp1.add(separator);
		jp1.setBorder(new TitledBorder(new EtchedBorder()));
		
		button = new JButton("退出系统");
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DealUI_Main.this.dispose();
			}
		});
		button.setBackground(Color.WHITE);
		button.setBounds(0, height*3/4-100, 200, 40);

		button.setFont(new Font("宋体", Font.PLAIN, 22));
		jp1.add(button);
		
		
		jp2=new JPanel();
		jp2.setBackground(new Color(240, 248, 255));
		jp2.setLayout(null);
		getContentPane().add(jp2);
		jp2.setBounds(198, 0, width*2/3-200, 36);
		jp2.setBorder(new TitledBorder(new EtchedBorder()));
		
		
		dqyh=new JLabel("当前用户:");
		dqyh.setBackground(SystemColor.controlDkShadow);
		dqyh.setForeground(Color.DARK_GRAY);
		dqyh.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		dqyh.setBounds(70,0,99,33);
		jp2.add(dqyh);
		
		dqyh2=new JLabel(vo.getName());
		dqyh2.setBackground(SystemColor.controlDkShadow);
		dqyh2.setForeground(Color.DARK_GRAY);
		dqyh2.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		dqyh2.setBounds(186, 0, 122, 33);
		jp2.add(dqyh2);
		
		sf=new JLabel("身份:");
		sf.setBackground(SystemColor.controlDkShadow);
		sf.setForeground(Color.DARK_GRAY);
		sf.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		sf.setBounds(348,0,65,33);
		jp2.add(sf);
		
		sf2=new JLabel(vo.getJob());
		sf2.setBackground(SystemColor.controlDkShadow);
		sf2.setForeground(Color.DARK_GRAY);
		sf2.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		sf2.setBounds(416, 0, 141, 33);
		jp2.add(sf2);
		
		
		bh=new JLabel("编号:");
		bh.setBackground(SystemColor.controlDkShadow);
		bh.setForeground(Color.DARK_GRAY);
		bh.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		bh.setBounds(603, 0, 65, 33);
		jp2.add(bh);
		
		bh2=new JLabel(vo.getId());
		bh2.setBackground(SystemColor.controlDkShadow);
		bh2.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		bh2.setForeground(Color.DARK_GRAY);
		bh2.setBounds(658, 0, 192, 33);
		jp2.add(bh2);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(UIManager.getColor("InternalFrame.borderDarkShadow"));
		separator_1.setBounds(0, 210, 1002, 2);
		jp2.add(separator_1);
		
		
		jp3=new DealUI_BuildAnOrder(vo);
		jp3.setLayout(null);
		getContentPane().add(jp3);
		jp3.setBounds(198, 37,  width*2/3-200,height*3/4-36);
		
		

	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==xjdd){
			getContentPane().remove(jp3);
			jp3=new DealUI_BuildAnOrder(vo);
			jp3.setBounds(198, 37,  width*2/3-200,height*3/4-36);
			getContentPane().add(jp3);
			getContentPane().revalidate();
			getContentPane().repaint();
			xjdd.setBounds(0, 0, 200, 60);
			srsjxx.setBounds(0, 60, 200, 40);
			cxdd.setBounds(0,100 , 200, 40);
			
			
		}
		
		
		
		if(e.getSource()==srsjxx){
			getContentPane().remove(jp3);
			jp3=new DealUI_Receival(vo);
			jp3.setBounds(198, 37,  width*2/3-200,height*3/4-36);
			getContentPane().add(jp3);		
			getContentPane().revalidate();
			getContentPane().repaint();
			
			xjdd.setBounds(0, 0, 200, 40);
			srsjxx.setBounds(0, 40, 200, 60);
			cxdd.setBounds(0,100 , 200, 40);
		}
		
		
		if(e.getSource()==cxdd){
			
			getContentPane().remove(jp3);
			jp3=new DealUI_CheckAnOrder(vo);
			jp3.setBounds(198, 37,  width*2/3-200,height*3/4-36);
			getContentPane().add(jp3);		
			getContentPane().revalidate();
			getContentPane().repaint();
			
			xjdd.setBounds(0, 0, 200, 40);
			srsjxx.setBounds(0, 40, 200, 40);
			cxdd.setBounds(0,80, 200, 60);
					
		}
		
		
		
	}
	
	
	

}




















