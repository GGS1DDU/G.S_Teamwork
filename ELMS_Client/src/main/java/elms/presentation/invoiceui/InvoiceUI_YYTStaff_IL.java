package elms.presentation.invoiceui;

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
import elms.presentation.memberui.MemberUI_CarInit;
import elms.presentation.memberui.MemberUI_CarMain;
import elms.presentation.memberui.MemberUI_DriverInit;
import elms.presentation.memberui.MemberUI_DriverMain;
import elms.vo.ArrivalListVO;
import elms.vo.IncomeListVO;
import elms.vo.UserVO;

public class InvoiceUI_YYTStaff_IL extends JFrame{
	//此界面为营业厅业务员界面选项卡IncomeList的主界面
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	JTextArea text;
	
	public static ArrayList<IncomeListVO> arr=new ArrayList<IncomeListVO>();
	
	public static void main(String arg[]){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				UserVO vo=new UserVO();
				JFrame YYTStaff_IL=new InvoiceUI_YYTStaff_IL(vo);
			}
		});
	}

	
	public InvoiceUI_YYTStaff_IL(final UserVO vo){
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
		m4.setSelected(true);m4.setEnabled(false);
		JMenu m5=new JMenu("车辆信息管理");
		JMenu m6=new JMenu("司机信息管理");
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
				InvoiceUI_YYTStaff_IL.this.dispose();
				new InvoiceUI_YYTStaff(vo);				
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {			
			}			
		});
		
		m2.addMenuListener(new MenuListener(){

			public void menuSelected(MenuEvent e) {
				InvoiceUI_YYTStaff_IL.this.dispose();
				new InvoiceUI_YYTStaff_SL(vo);				
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuCanceled(MenuEvent e) {	
			}			
		});
		
		m3.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				InvoiceUI_YYTStaff_IL.this.dispose();
				new InvoiceUI_YYTStaff_LL(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m5.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				InvoiceUI_YYTStaff_IL.this.dispose();
				new MemberUI_CarMain(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m6.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				InvoiceUI_YYTStaff_IL.this.dispose();
				new MemberUI_DriverMain(vo);
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
					InvoiceUI_YYTStaff_IL.this.dispose();
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
					InvoiceUI_YYTStaff_IL.this.dispose();
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
		
		JLabel jsd=new JLabel("    收款单");
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
		
		JMenu j1=new Menu("         收款日期");JMenu j2=new Menu("       收费金额");
		JMenu j3=new Menu("       快递员姓名"); JMenu j4=new Menu("       到达日期"); JMenu j5=new Menu("         所属营业厅");
		jbar.add(j1);jbar.add(j2);jbar.add(j3);jbar.add(j4);jbar.add(j5);
		add(jbar);
		jbar.setBounds(5,48,this.getWidth(),20);
		add(info2);
		info2.setBounds(0,0,this.getWidth(),this.getHeight()/2);
		
		JButton xjskd=new JButton("新建收款单");
		JButton find=new JButton("查询");
		JButton refresh=new JButton("刷新(R)");refresh.setForeground(Color.GREEN);
		JButton back=new JButton("返回(B)");back.setForeground(Color.RED);
		JPanel buttonPal=new JPanel();
		buttonPal.setLayout(null);
		buttonPal.add(xjskd);buttonPal.add(find);buttonPal.add(refresh);buttonPal.add(back);
		xjskd.setBounds(100,30,102,30);find.setBounds(320,30,102,30);
		refresh.setBounds(550,15,80,30);
		back.setBounds(550,55,80,30);
		add(buttonPal);
		buttonPal.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);
		buttonPal.setBorder(BorderFactory.createTitledBorder("收款单操作"));
		
		xjskd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new InvoiceUI_IncomeList();
			}	
		});
		find.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new InvoiceUI_IncomeListFind();			
			}		
		});
		
		refresh.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				ArrayList<IncomeListVO> temp=new ArrayList<IncomeListVO>();
				temp=arr;
//				if(arr.size()!=0)
					arr=temp;
				text.setText("");
				for(IncomeListVO alvo:arr)
					text.append(alvo.getID()+"   "+alvo.getPostage()+"   "+alvo.getCourier()+"   "+alvo.getTime()+"    "+alvo.getPlace()+"\r\n");				
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
