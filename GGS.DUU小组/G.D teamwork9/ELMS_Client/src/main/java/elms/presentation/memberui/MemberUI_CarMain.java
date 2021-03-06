package elms.presentation.memberui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import elms.presentation.invoiceui.InvoiceUI_YYTStaff;
import elms.presentation.invoiceui.InvoiceUI_YYTStaff_IL;
import elms.presentation.invoiceui.InvoiceUI_YYTStaff_LL;
import elms.presentation.invoiceui.InvoiceUI_YYTStaff_SL;
import elms.vo.CarVO;
import elms.vo.UserVO;

public class MemberUI_CarMain extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	JTextArea text;
	
	public static ArrayList<CarVO> arr=new ArrayList<CarVO>();
	
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				UserVO vo=new UserVO();
				JFrame Car=new MemberUI_CarMain(vo);
			}
		});
	}
	
	public MemberUI_CarMain(final UserVO vo){
		setLayout(null);
		setTitle("营业厅管理");
		setResizable(false);
		setSize(screenWidth/2,3*screenHeight/4);
		setLocation(screenWidth/4,screenHeight/8);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar bar=new JMenuBar();
		JMenu m1=new JMenu("到达单管理");	
		JMenu m2=new JMenu("派件单管理");
		JMenu m3=new JMenu("装车单管理");
		JMenu m4=new JMenu("收款单管理");
		JMenu m5=new JMenu("车辆信息管理");
		m5.setSelected(true);m5.setEnabled(false);
		JMenu m6=new JMenu("司机信息管理");
		
		bar.add(m1);
		bar.add(m2);
		bar.add(m3);
		bar.add(m4);
		bar.add(m5);
		bar.add(m6);
		
		setJMenuBar(bar);
		m1.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_CarMain.this.dispose();
				new InvoiceUI_YYTStaff(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m2.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_CarMain.this.dispose();
				new InvoiceUI_YYTStaff_SL(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m3.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_CarMain.this.dispose();
				new InvoiceUI_YYTStaff_LL(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m4.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_CarMain.this.dispose();
				new InvoiceUI_YYTStaff_IL(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m6.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_CarMain.this.dispose();
				new MemberUI_DriverMain(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		JLabel jl=new JLabel("   当前用户： "+vo.getName()+"   身份： "+vo.getJob()+"   编号： "+vo.getId());
		jl.setForeground(Color.lightGray);
		JPanel user=new JPanel();
		user.add(jl);
		user.setBounds(0,0,this.getWidth(),25);
		
		Border li=BorderFactory.createEtchedBorder();
		Border t=BorderFactory.createTitledBorder(li);
		Border l2=BorderFactory.createLoweredBevelBorder();
		user.setBorder(t);
		add(user);
		
		JLabel jsd=new JLabel("    车辆信息管理");
		JPanel info=new JPanel();
		info.setLayout(new java.awt.BorderLayout());
		info.add(jsd);
		info.setBounds(0, 23, 70, 25);
		info.setBorder(l2);
		add(info);
		
		JPanel info2=new JPanel();
		info2.setLayout(null);
		text=new JTextArea(10,10);
		text.setEditable(false);
		text.setFont(new Font("Serif",Font.PLAIN,14));
		
		JScrollPane scrollpane=new JScrollPane(text);
		info2.add(scrollpane);
		scrollpane.setBounds(5,70,this.getWidth()-40,this.getHeight()/2-70);
		
		JMenuBar jbar=new JMenuBar();
		class Menu extends JMenu{
			public Menu(String s){
				super(s);
				this.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
			}
		}
		
		JMenu j1=new Menu("         车辆代号              ");JMenu j2=new Menu("           车牌号             ");JMenu j3=new Menu("         服役时间           ");
		jbar.add(j1);jbar.add(j2);jbar.add(j3);
		add(jbar);
		jbar.setBounds(5,48,this.getWidth(),20);
		add(info2);
		info2.setBounds(0,0,this.getWidth(),this.getHeight()/2);
		
		
		JButton xzcl=new JButton("新增车辆信息");
		JButton find=new JButton("查询");
		JButton refresh=new JButton("刷新(R)");refresh.setForeground(Color.GREEN);
		JButton back=new JButton("返回(B)");back.setForeground(Color.RED);
		JPanel buttonPal=new JPanel();
		buttonPal.setLayout(null);
		buttonPal.add(xzcl);buttonPal.add(find);buttonPal.add(refresh);buttonPal.add(back);
		xzcl.setBounds(100,30,120,30);find.setBounds(320,30,102,30);
		refresh.setBounds(550,15,80,30);
		back.setBounds(550,55,80,30);
		add(buttonPal);
		buttonPal.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);
		buttonPal.setBorder(BorderFactory.createTitledBorder("车辆信息管理"));
		
		xzcl.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new MemberUI_CarNew();
			}	
		});
		find.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new MemberUI_CarFind();			
			}		
		});
		
		refresh.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ArrayList<CarVO> temp=new ArrayList<CarVO>();
				temp=arr;
//				if(arr.size()!=0)
					arr=temp;
				text.setText("");
				for(CarVO alvo:arr)
					text.append(alvo.getID()+alvo.getPlateNumber()+alvo.getUsingTime()+"\r\n");
			}
			
		});
		
		back.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		JPanel tp=new JPanel();
		final JLabel time=new JLabel();
	    time.setFont(new Font("Serif",Font.BOLD,15));	    
	    tp.add(time);	    
	    add(tp);
	    tp.setBounds(0,this.getHeight()-80,this.getWidth(),40);
		
	    Timer timer = new Timer(100,new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				time.setText(sdf.format(new Date()));				

			}
	    	
	    });
	    timer.start();
		
	}

}
