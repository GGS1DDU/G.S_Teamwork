package elms.presentation.memberui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import elms.businesslogic.memberbl.CarBL;
import elms.businesslogic.memberbl.DriverBL;
import elms.presentation.invoiceui.InvoiceUI_YYTStaff;
import elms.presentation.invoiceui.InvoiceUI_YYTStaff_IL;
import elms.presentation.invoiceui.InvoiceUI_YYTStaff_LL;
import elms.presentation.invoiceui.InvoiceUI_YYTStaff_SL;
import elms.vo.DriverVO;
import elms.vo.UserVO;

public class MemberUI_DriverMain extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	JTextArea text;
	
	public static ArrayList<DriverVO> arr=new ArrayList<DriverVO>();
	
	public static void main(String arg[]){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				UserVO vo=new UserVO();
				JFrame Driver=new MemberUI_DriverMain(vo);
			}
		});
	}
	
	public MemberUI_DriverMain(final UserVO vo){
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
		JMenu m6=new JMenu("司机信息管理");
		m6.setSelected(true);m6.setEnabled(false);
		JMenu m7=new JMenu("车辆初始化");
		JMenu m8=new JMenu("司机初始化");
		
		bar.add(m1);
		bar.add(m2);
		bar.add(m3);
		bar.add(m4);
		bar.add(m5);
		bar.add(m6);
		bar.add(m7);
		bar.add(m8);
		
		setJMenuBar(bar);
		m1.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_DriverMain.this.dispose();
				new InvoiceUI_YYTStaff(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m2.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_DriverMain.this.dispose();
				new InvoiceUI_YYTStaff_SL(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m3.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_DriverMain.this.dispose();
				new InvoiceUI_YYTStaff_LL(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m4.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_DriverMain.this.dispose();
				new InvoiceUI_YYTStaff_IL(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m5.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_DriverMain.this.dispose();
				new MemberUI_CarMain(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m7.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				int a=(int)(Math.random()*1000);
				String s=a+"";
				
				String obj=JOptionPane.showInputDialog("请输入 验证码  "+a+" 确认初始化车辆");
				if(obj.equals(s)){
					MemberUI_DriverMain.this.dispose();
					new MemberUI_CarInit(vo);
					CarBL cardata=new CarBL();
					try{
						cardata.init();
					}catch(IOException e1){
						e1.printStackTrace();
					}
				}else JOptionPane.showMessageDialog(null, "验证码错误",null,0);
				
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m8.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				int a=(int)(Math.random()*1000);
				String s=a+"";
				
				String obj=JOptionPane.showInputDialog("请输入 验证码  "+a+" 确认初始化司机");
				if(obj.equals(s)){
					MemberUI_DriverMain.this.dispose();
					new MemberUI_DriverInit(vo);
					CarBL cardata=new CarBL();
					try{
						cardata.init();
					}catch(IOException e1){
						e1.printStackTrace();
					}
				}else JOptionPane.showMessageDialog(null, "验证码错误",null,0);
				
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
		
		JLabel jsd=new JLabel("    司机信息管理");
		JPanel info=new JPanel();
		info.setLayout(new java.awt.BorderLayout());
		info.add(jsd);
		info.setBounds(0, 23, 110, 25);
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
		
		JMenu j1=new Menu("  编号    ");JMenu j2=new Menu("   姓名   ");JMenu j3=new Menu(" 出生日期    ");
		JMenu j4=new Menu(" 身份证号     ");JMenu j5=new Menu("  手机号     ");JMenu j6=new Menu(" 性别     ");
		JMenu j7=new Menu("  行驶证期限   ");
		jbar.add(j1);jbar.add(j2);jbar.add(j3);jbar.add(j4);jbar.add(j5);jbar.add(j6);jbar.add(j7);
		add(jbar);
		jbar.setBounds(5,48,this.getWidth(),20);
		add(info2);
		info2.setBounds(0,0,this.getWidth(),this.getHeight()/2);
		
		
		JButton xzsj=new JButton("新增司机信息");
		JButton find=new JButton("查询");
		JButton refresh=new JButton("刷新(R)");refresh.setForeground(Color.GREEN);
		JButton back=new JButton("返回(B)");back.setForeground(Color.RED);
		JPanel buttonPal=new JPanel();
		buttonPal.setLayout(null);
		buttonPal.add(xzsj);buttonPal.add(find);buttonPal.add(refresh);buttonPal.add(back);
		xzsj.setBounds(100,30,120,30);find.setBounds(320,30,102,30);
		refresh.setBounds(550,15,80,30);
		back.setBounds(550,55,80,30);
		add(buttonPal);
		buttonPal.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);
		buttonPal.setBorder(BorderFactory.createTitledBorder("司机信息管理"));
		
		xzsj.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new MemberUI_DriverNew();
			}	
		});
		find.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new MemberUI_DriverFind();			
			}		
		});
		
		refresh.addActionListener(new ActionListener(){
            DriverBL driverdata=new DriverBL();
            
			public void actionPerformed(ActionEvent e) {
				
				text.setText("");
				try{
					arr=driverdata.inquiryAll();
				}catch(IOException e1){
					e1.printStackTrace();
				}
				for(DriverVO alvo:arr)
					text.append(" "+alvo.getID()+"        "+alvo.getName()+"      "+alvo.getBirthday()+
							"       "+alvo.getIDcard()+"           "+alvo.getCallNumber()+"           "
							+alvo.getGender()+"                 "+alvo.getLicenseDate()+"\r\n");
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
