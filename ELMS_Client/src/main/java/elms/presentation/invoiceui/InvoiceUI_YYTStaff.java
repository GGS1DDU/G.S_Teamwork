package elms.presentation.invoiceui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import elms.businesslogic.financebl.InitAll;
import elms.businesslogic.invoicebl.ArrivalListBL;
import elms.businesslogic.invoicebl.IncomeListBL;
import elms.businesslogic.invoicebl.LoadingListBL;
import elms.businesslogic.invoicebl.SendingListBL;
import elms.businesslogic.memberbl.CarBL;
import elms.businesslogic.memberbl.DriverBL;
//import elms.presentation.MyButton;
//import elms.presentation.MyPanel;
import elms.presentation.memberui.MemberUI_CarMain;
import elms.presentation.memberui.MemberUI_DriverMain;
import elms.presentation.storageui.TableModel;
import elms.presentation.uihelper.MyButton;
import elms.presentation.uihelper.MyPanel;
import elms.vo.ArrivalListVO;
import elms.vo.IncomeListVO;
import elms.vo.LoadingListVO;
import elms.vo.SendingListVO;
import elms.vo.UserVO;

public class InvoiceUI_YYTStaff extends JFrame{
	//营业厅业务员主界面就是ArrivalList的主界面
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();

	int button=40;
	
	public static TableModel model;
	public static JTable table;
	public UserVO voa;
	final JComboBox<String> jcb;
	static JPanel user;
	
	Invoice_unaduit un;
	MemberUI_DriverMain dm;
	MemberUI_CarMain cm;
	
	public static ArrayList<ArrivalListVO> arr=new ArrayList<ArrivalListVO>();
	
	public static void main(String arg[]){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
//				UserVO vo=new UserVO();
				UserVO vo = new UserVO("00000001","891213","周颖婷","营业厅业务员");
				JFrame YYTStaff=new InvoiceUI_YYTStaff(vo);
			}
		});
	}
	
	public InvoiceUI_YYTStaff(final UserVO vo){
		voa=vo;
		setLayout(null);
		setTitle("营业厅管理");
		setResizable(false);
		setBounds(screenWidth/6,screenHeight/8,screenWidth*2/3,screenHeight*3/4);
		
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			} catch (InstantiationException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			} catch (IllegalAccessException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			} catch (UnsupportedLookAndFeelException e2) {
				// TODO 自动生成的 catch 块
				e2.printStackTrace();
			}
		
//		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final MyPanel contentPane=new MyPanel("inbg.jpg");
		contentPane.setBounds(0,0,this.getWidth(),this.getHeight());
		add(contentPane);
		contentPane.setLayout(null);
		
		final JPanel buttonPanel=new JPanel();
		buttonPanel.setBorder(new TitledBorder(new EtchedBorder()));
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(0, 0, 200, this.getHeight());
		buttonPanel.setBackground(Color.white);
		contentPane.add(buttonPanel);
		
		final JButton inv=new MyButton("单据信息",20);
//		UIManager.put("Button.background", false);
		inv.setEnabled(false);
		inv.setForeground(Color.gray);
		inv.setBounds(0,0,200,(int) (1.5*button));
		buttonPanel.add(inv);
		
		final JButton una = new MyButton("未通过单据",15);
		una.setBounds(0,(int) (1.5*button),200,button);
		una.setBackground(Color.black);
		buttonPanel.add(una);
		
		final JButton drman=new MyButton("司机信息管理",15);
		drman.setBounds(0,(int)(1.5*button)+button,200,button);
		drman.setBackground(Color.black);
		buttonPanel.add(drman);
		
		final JButton drini=new MyButton("司机信息初始化",15);
		drini.setBounds(0,(int)(1.5*button)+2*button,200,button);
		drini.setBackground(Color.black);
		buttonPanel.add(drini);
		
		final JButton drin=new MyButton("确认司机信息初始化",15);
		drin.setBounds(0,(int)(1.5*button)+3*button,200,button);
		drin.setBackground(Color.black);
		buttonPanel.add(drin);
		
		final JButton caman=new MyButton("车辆信息管理",15);
		caman.setBounds(0,(int)(1.5*button)+4*button,200,button);
		caman.setBackground(Color.black);
		buttonPanel.add(caman);
		
		final JButton caini=new MyButton("车辆信息初始化",15);
		caini.setBounds(0,(int)(1.5*button)+5*button,200,button);
		caini.setBackground(Color.black);
		buttonPanel.add(caini);
		
		final JButton cain=new MyButton("确认车辆信息初始化",15);
		cain.setBounds(0,(int)(1.5*button)+6*button,200,button);
		cain.setBackground(Color.black);
		buttonPanel.add(cain);
		
		JLabel jl=new JLabel(" 当前用户：    "+vo.getName()+" 身份：   "+vo.getJob()+" 编号：   "+vo.getId());
		user=new JPanel(); user.setLayout(null);
		user.add(jl);jl.setBounds(200, 0, this.getWidth(), 25);
		user.setBounds(200, 0, this.getWidth()-200,this.getHeight());	
		contentPane.add(user);	
		user.setOpaque(false);
		
		//单据信息按钮的监听
		inv.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
			
				user.setBounds(200, 0, screenWidth-200,screenHeight);	
				contentPane.add(user);
				contentPane.add(buttonPanel);
				
				inv.setFont(new Font("宋体",1,20));
				inv.setForeground(Color.gray);inv.setBounds(0,0,200,(int) (1.5*button));
				inv.setEnabled(false);
				buttonPanel.add(inv);
				
				una.setFont(new Font("宋体",1,15));
				una.setForeground(Color.black);una.setBounds(0,(int) (1.5*button),200,button);
				una.setEnabled(true);
				buttonPanel.add(una);
				
				drman.setFont(new Font("宋体",1,15));
				drman.setForeground(Color.black);drman.setBounds(0,(int)(1.5*button)+button,200,button);
				drman.setEnabled(true);
				buttonPanel.add(drman);
				
				drini.setFont(new Font("宋体",1,15));
				drini.setForeground(Color.black);drini.setBounds(0,(int)(1.5*button)+2*button,200,button);
				drini.setEnabled(true);
				buttonPanel.add(drini);
				
				drin.setFont(new Font("宋体",1,15));
				drin.setForeground(Color.black);drin.setBounds(0,(int)(1.5*button)+3*button,200,button);
				drin.setEnabled(true);
				buttonPanel.add(drin);
				
				caman.setFont(new Font("宋体",1,15));
				caman.setForeground(Color.black);caman.setBounds(0,(int)(1.5*button)+4*button,200,button);
				caman.setEnabled(true);
				buttonPanel.add(caman);
				
				caini.setFont(new Font("宋体",1,15));
				caini.setForeground(Color.black);caini.setBounds(0,(int)(1.5*button)+5*button,200,button);
				caini.setEnabled(true);
				buttonPanel.add(caini);
				
				cain.setFont(new Font("宋体",1,15));
				cain.setForeground(Color.black);cain.setBounds(0,(int)(1.5*button)+6*button,200,button);
				cain.setEnabled(true);
				buttonPanel.add(cain);
				
				validate();
				repaint();
			}
			
		});
		
		//审批状态查看的按钮监听
		una.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(buttonPanel);
				
				inv.setFont(new Font("宋体",1,15));
				inv.setForeground(Color.black);inv.setBounds(0,0,200,button);
				inv.setEnabled(true);
				buttonPanel.add(inv);
				
				una.setFont(new Font("宋体",1,20));
				una.setForeground(Color.gray);una.setBounds(0,button,200,(int) (1.5*button));
				una.setEnabled(false);
				buttonPanel.add(una);
				
				drman.setFont(new Font("宋体",1,15));
				drman.setForeground(Color.black);drman.setBounds(0,(int)(1.5*button)+button,200,button);
				drman.setEnabled(true);
				buttonPanel.add(drman);
				
				drini.setFont(new Font("宋体",1,15));
				drini.setForeground(Color.black);drini.setBounds(0,(int)(1.5*button)+2*button,200,button);
				drini.setEnabled(true);
				buttonPanel.add(drini);
				
				drin.setFont(new Font("宋体",1,15));
				drin.setForeground(Color.black);drin.setBounds(0,(int)(1.5*button)+3*button,200,button);
				drin.setEnabled(true);
				buttonPanel.add(drin);
				
				caman.setFont(new Font("宋体",1,15));
				caman.setForeground(Color.black);caman.setBounds(0,(int)(1.5*button)+4*button,200,button);
				caman.setEnabled(true);
				buttonPanel.add(caman);
				
				caini.setFont(new Font("宋体",1,15));
				caini.setForeground(Color.black);caini.setBounds(0,(int)(1.5*button)+5*button,200,button);
				caini.setEnabled(true);
				buttonPanel.add(caini);
				
				cain.setFont(new Font("宋体",1,15));
				cain.setForeground(Color.black);cain.setBounds(0,(int)(1.5*button)+6*button,200,button);
				cain.setEnabled(true);
				buttonPanel.add(cain);
				
				try {
					user.setBounds(-screenWidth, 0, user.getWidth(), user.getHeight());

    				un=new Invoice_unaduit(vo);	

					contentPane.add(un);
					un.setBounds(200, 0, screenWidth-200,screenHeight);	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				validate();
				repaint();
				
			}
		});
		
		//司机信息管理的按钮监听
		drman.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    contentPane.removeAll();
			    contentPane.add(buttonPanel);
			    
				inv.setFont(new Font("宋体",1,15));
				inv.setForeground(Color.black);inv.setBounds(0,0,200,button);
				inv.setEnabled(true);
				buttonPanel.add(inv);
				
				una.setFont(new Font("宋体",1,15));
				una.setForeground(Color.black);una.setBounds(0,button,200,button);
				una.setEnabled(true);
				buttonPanel.add(una);
				
				drman.setFont(new Font("宋体",1,20));
				drman.setForeground(Color.gray);drman.setBounds(0,2*button,200,(int) (1.5*button));
				drman.setEnabled(false);
				buttonPanel.add(drman);
				
				drini.setFont(new Font("宋体",1,15));
				drini.setForeground(Color.black);drini.setBounds(0,(int)(1.5*button)+2*button,200,button);
				drini.setEnabled(true);
				buttonPanel.add(drini);
				
				drin.setFont(new Font("宋体",1,15));
				drin.setForeground(Color.black);drin.setBounds(0,(int)(1.5*button)+3*button,200,button);
				drin.setEnabled(true);
				buttonPanel.add(drin);
				
				caman.setFont(new Font("宋体",1,15));
				caman.setForeground(Color.black);caman.setBounds(0,(int)(1.5*button)+4*button,200,button);
				caman.setEnabled(true);
				buttonPanel.add(caman);
				
				caini.setFont(new Font("宋体",1,15));
				caini.setForeground(Color.black);caini.setBounds(0,(int)(1.5*button)+5*button,200,button);
				caini.setEnabled(true);
				buttonPanel.add(caini);
				
				cain.setFont(new Font("宋体",1,15));
				cain.setForeground(Color.black);cain.setBounds(0,(int)(1.5*button)+6*button,200,button);
				cain.setEnabled(true);
				buttonPanel.add(cain);
				
				try {
				    user.setBounds(-screenWidth, 0, user.getWidth(), user.getHeight());
					dm=new MemberUI_DriverMain(vo);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}			
				contentPane.add(dm);
				dm.setBounds(200, 0, screenWidth-200,screenHeight);				
		
				validate();
				repaint();
			}
		});
		
		//司机初始化的按钮监听
		drini.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				int a=(int)(Math.random()*10000);
				String s=a+"";
				
				String obj=JOptionPane.showInputDialog(contentPane,"请输入验证码  "+a+" 确认初始化司机信息");
				if(obj!=null){
					if(obj.equals(s)){
						contentPane.removeAll();
						contentPane.add(buttonPanel);
						
						inv.setFont(new Font("宋体",1,15));
						inv.setForeground(Color.black);inv.setBounds(0,0,200,button);
						inv.setEnabled(true);
						buttonPanel.add(inv);
								
						una.setFont(new Font("宋体",1,15));
						una.setForeground(Color.black);una.setBounds(0,button,200,button);
						una.setEnabled(true);
						buttonPanel.add(una);
								
						drman.setFont(new Font("宋体",1,15));
						drman.setForeground(Color.black);drman.setBounds(0,2*button,200,button);
						drman.setEnabled(true);
						buttonPanel.add(drman);
								
						drini.setFont(new Font("宋体",1,20));
						drini.setForeground(Color.gray);drini.setBounds(0,3*button,200,(int) (1.5*button));
					    drini.setEnabled(false);
					    buttonPanel.add(drini);
							
					    drin.setFont(new Font("宋体",1,15));
						drin.setForeground(Color.black);drin.setBounds(0,(int)(1.5*button)+3*button,200,button);
					    drin.setEnabled(true);
					    buttonPanel.add(drin);
					    
					    caman.setFont(new Font("宋体",1,15));
						caman.setForeground(Color.black);caman.setBounds(0,(int)(1.5*button)+4*button,200,button);
						caman.setEnabled(true);
						buttonPanel.add(caman);
					    
						caini.setFont(new Font("宋体",1,15));
						caini.setForeground(Color.black);caini.setBounds(0,(int)(1.5*button)+5*button,200,button);
						caini.setEnabled(true);
						buttonPanel.add(caini);
						
						cain.setFont(new Font("宋体",1,15));
						cain.setForeground(Color.black);cain.setBounds(0,(int)(1.5*button)+6*button,200,button);
						cain.setEnabled(true);
						buttonPanel.add(cain);
						
						DriverBL driverdata=new DriverBL();
						try{
							driverdata.init();
							JOptionPane.showMessageDialog(contentPane,"初始化司机信息成功",null,2);
						}catch(IOException e1){
							e1.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(contentPane, "验证码错误",null,0);
					}
				}						
			}
		});
				
		//确认司机初始化的按钮监听
		drin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int a=(int)(Math.random()*1000);
				String s=a+"";
				
				String obj=JOptionPane.showInputDialog("请输入 验证码"+ a+" 确认完成司机初始化");
				if(obj.equals(s)){
					contentPane.removeAll();
					contentPane.add(buttonPanel);
					
					inv.setFont(new Font("宋体",1,15));
					inv.setForeground(Color.black);inv.setBounds(0,0,200,button);
					inv.setEnabled(true);
					buttonPanel.add(inv);
							
					una.setFont(new Font("宋体",1,15));
					una.setForeground(Color.black);una.setBounds(0,button,200,button);
					una.setEnabled(true);
					buttonPanel.add(una);
							
					drman.setFont(new Font("宋体",1,15));
					drman.setForeground(Color.black);drman.setBounds(0,2*button,200,button);
					drman.setEnabled(true);
					buttonPanel.add(drman);
							
					drini.setFont(new Font("宋体",1,15));
					drini.setForeground(Color.black);drini.setBounds(0,3*button,200,button);
				    drini.setEnabled(true);
				    buttonPanel.add(drini);
						
				    drin.setFont(new Font("宋体",1,20));
					drin.setForeground(Color.gray);drin.setBounds(0,4*button,200,(int) (1.5*button));
				    drin.setEnabled(false);
				    buttonPanel.add(drin);
				    
				    caman.setFont(new Font("宋体",1,15));
					caman.setForeground(Color.black);caman.setBounds(0,(int)(1.5*button)+4*button,200,button);
					caman.setEnabled(true);
					buttonPanel.add(caman);
				    
					caini.setFont(new Font("宋体",1,15));
					caini.setForeground(Color.black);caini.setBounds(0,(int)(1.5*button)+5*button,200,button);
					caini.setEnabled(true);
					buttonPanel.add(caini);
					
					cain.setFont(new Font("宋体",1,15));
					cain.setForeground(Color.black);cain.setBounds(0,(int)(1.5*button)+6*button,200,button);
					cain.setEnabled(true);
					buttonPanel.add(cain);
					
					InitAll ia=new InitAll();
					try {
						ia.setInitState(5);
					} catch (RemoteException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					try {
						DriverBL driver=new DriverBL();
						driver.init();
				    } catch (IOException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(contentPane, "初始化司机成功", null, 2);
				}else{
					JOptionPane.showMessageDialog(null, "验证码错误！", null, 0);
				}
			}
		});
		
		
		//车辆信息管理的按钮监听
				caman.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
					    contentPane.removeAll();
					    contentPane.add(buttonPanel);
					    
						inv.setFont(new Font("宋体",1,15));
						inv.setForeground(Color.black);inv.setBounds(0,0,200,button);
						inv.setEnabled(true);
						buttonPanel.add(inv);
						
						una.setFont(new Font("宋体",1,15));
						una.setForeground(Color.black);una.setBounds(0,button,200,button);
						una.setEnabled(true);
						buttonPanel.add(una);
						
						drman.setFont(new Font("宋体",1,15));
						drman.setForeground(Color.black);drman.setBounds(0,2*button,200,button);
						drman.setEnabled(true);
						buttonPanel.add(drman);
						
						drini.setFont(new Font("宋体",1,15));
						drini.setForeground(Color.black);drini.setBounds(0,3*button,200,button);
						drini.setEnabled(true);
						buttonPanel.add(drini);
						
						drin.setFont(new Font("宋体",1,15));
						drin.setForeground(Color.black);drin.setBounds(0,4*button,200,button);
						drin.setEnabled(true);
						buttonPanel.add(drin);
						
						caman.setFont(new Font("宋体",1,20));
						caman.setForeground(Color.gray);caman.setBounds(0,5*button,200,(int)(1.5*button));
						caman.setEnabled(false);
						buttonPanel.add(caman);
						
						caini.setFont(new Font("宋体",1,15));
						caini.setForeground(Color.black);caini.setBounds(0,(int)(1.5*button)+5*button,200,button);
						caini.setEnabled(true);
						buttonPanel.add(caini);
						
						cain.setFont(new Font("宋体",1,15));
						cain.setForeground(Color.black);cain.setBounds(0,(int)(1.5*button)+6*button,200,button);
						cain.setEnabled(true);
						buttonPanel.add(cain);
						
						try {
						    user.setBounds(-screenWidth, 0, user.getWidth(), user.getHeight());
							cm=new MemberUI_CarMain(vo);
						} catch (IOException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}			
						contentPane.add(cm);
						cm.setBounds(200, 0, screenWidth-200,screenHeight);		
						
						validate();
						repaint();
					}
				});
		
		//车辆初始化的按钮监听
		caini.addActionListener(new ActionListener(){	    
			public void actionPerformed(ActionEvent arg0) {
				
				int a=(int)(Math.random()*10000);
				String s=a+"";
				
				String obj=JOptionPane.showInputDialog(contentPane,"请输入验证码  "+a+" 确认初始化司机信息");
				if(obj!=null){
					if(obj.equals(s)){
						contentPane.removeAll();
					    contentPane.add(buttonPanel);
					    
						inv.setFont(new Font("宋体",1,15));
						inv.setForeground(Color.black);inv.setBounds(0,0,200,button);
						inv.setEnabled(true);
						buttonPanel.add(inv);
								
						una.setFont(new Font("宋体",1,15));
						una.setForeground(Color.black);una.setBounds(0,button,200,button);
						una.setEnabled(true);
						buttonPanel.add(una);
								
						drman.setFont(new Font("宋体",1,15));
						drman.setForeground(Color.black);drman.setBounds(0,2*button,200,button);
						drman.setEnabled(true);
						buttonPanel.add(drman);
								
					    drini.setFont(new Font("宋体",1,15));
						drini.setForeground(Color.black);drini.setBounds(0,3*button,200,button);
						drini.setEnabled(true);
						buttonPanel.add(drini);
							
						drin.setFont(new Font("宋体",1,15));
						drin.setForeground(Color.black);drin.setBounds(0,4*button,200,button);
						drin.setEnabled(true);
						buttonPanel.add(drin);
						
						caman.setFont(new Font("宋体",1,15));
						caman.setForeground(Color.black);caman.setBounds(0,5*button,200,button);
						caman.setEnabled(true);
						buttonPanel.add(caman);
						
						caini.setFont(new Font("宋体",1,20));
					    caini.setForeground(Color.gray);caini.setBounds(0,6*button,200,(int) (1.5*button));
						caini.setEnabled(false);
						buttonPanel.add(caini);
						
						cain.setFont(new Font("宋体",1,20));
					    cain.setForeground(Color.black);cain.setBounds(0,6*button+(int) (1.5*button),200,button);
						cain.setEnabled(true);
						buttonPanel.add(cain);
											
						CarBL cardata=new CarBL();
						try{
							cardata.init();
							JOptionPane.showMessageDialog(contentPane,"初始化车辆信息成功",null,2);
						}catch(IOException e1){
							e1.printStackTrace();
						}
					}else{
						JOptionPane.showMessageDialog(contentPane, "验证码错误",null,0);
					}
				}				
			}
		});		
		
		//确认车辆初始化的按钮监听
				cain.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						int a=(int)(Math.random()*1000);
						String s=a+"";
						
						String obj=JOptionPane.showInputDialog("请输入 验证码"+ a+" 确认完成车辆初始化");
						if(obj.equals(s)){
							contentPane.removeAll();
							contentPane.add(buttonPanel);
							
							inv.setFont(new Font("宋体",1,15));
							inv.setForeground(Color.black);inv.setBounds(0,0,200,button);
							inv.setEnabled(true);
							buttonPanel.add(inv);
									
							una.setFont(new Font("宋体",1,15));
							una.setForeground(Color.black);una.setBounds(0,button,200,button);
							una.setEnabled(true);
							buttonPanel.add(una);
									
							drman.setFont(new Font("宋体",1,15));
							drman.setForeground(Color.black);drman.setBounds(0,2*button,200,button);
							drman.setEnabled(true);
							buttonPanel.add(drman);
									
							drini.setFont(new Font("宋体",1,15));
							drini.setForeground(Color.black);drini.setBounds(0,3*button,200,button);
						    drini.setEnabled(true);
						    buttonPanel.add(drini);
								
						    drin.setFont(new Font("宋体",1,15));
							drin.setForeground(Color.black);drin.setBounds(0,4*button,200,button);
						    drin.setEnabled(false);
						    buttonPanel.add(drin);
						    
						    caman.setFont(new Font("宋体",1,15));
							caman.setForeground(Color.black);caman.setBounds(0,5*button,200,button);
							caman.setEnabled(true);
							buttonPanel.add(caman);
						    
							caini.setFont(new Font("宋体",1,15));
							caini.setForeground(Color.black);caini.setBounds(0,6*button,200,button);
							caini.setEnabled(true);
							buttonPanel.add(caini);
							
							cain.setFont(new Font("宋体",1,20));
							cain.setForeground(Color.gray);cain.setBounds(0,7*button,200,(int)(1.5*button));
							cain.setEnabled(true);
							buttonPanel.add(cain);
							
							InitAll ia=new InitAll();
							try {
								ia.setInitState(2);
							} catch (RemoteException e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
							}

							try {
								DriverBL driver=new DriverBL();
								driver.init();
						    } catch (IOException e) {
								e.printStackTrace();
							}
							JOptionPane.showMessageDialog(contentPane, "初始化司机成功", null, 2);
						}else{
							JOptionPane.showMessageDialog(null, "验证码错误！", null, 0);
						}
					}
				});
	
		String[] title_name={"ID","单据状态","制表人","中转单编号","到达日期","到达状态","出发地","所属营业厅"};
		model=new TableModel(title_name);
		table=new JTable(model);
		
		table.addMouseListener(new MouseAdapter(){
			ArrivalListBL al=new ArrivalListBL();
			SendingListBL sl=new SendingListBL();
			IncomeListBL il=new IncomeListBL();
			LoadingListBL ll=new LoadingListBL();

			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				if(e.getClickCount()==2){
					if(table.getSelectedColumn()!=-1){
						String s=(String)model.getValueAt(table.getSelectedRow(), 0);
						String c=jcb.getSelectedItem().toString();
						
						if(c.equals("到达单")){
							try{
								new InvoiceUI_ArrivalListEdit(al.inquiry(s),false);
							}catch(IOException e1){
								e1.printStackTrace();
							}
						}else if(c.equals("派件单")){
							try{
								new InvoiceUI_SendingListEdit(sl.inquiry(s),false);	
							}catch(IOException e1){
								e1.printStackTrace();
							}
						}else if(c.equals("收款单")){
							try{
								new InvoiceUI_IncomeListEdit(il.inquiry(s),false);
							}catch(IOException e1){
								e1.printStackTrace();
							}
						}else if(c.equals("装车单")){
							try{
								new InvoiceUI_LoadingListEdit(ll.inquiry(s),false);
							}catch(IOException e1){
								e1.printStackTrace();
							}
						}						
					}
				}				
			}
		});
		
		table.setBackground(Color.white);
		JScrollPane scrollpane=new JScrollPane(table);
		user.add(scrollpane);
		scrollpane.setBounds(-1,70,this.getWidth()-40,this.getHeight()/2-70);
        scrollpane.setOpaque(false);scrollpane.getViewport().setOpaque(false);

        jcb=new JComboBox<String>();
    	jcb.addItem("到达单");jcb.addItem("派件单");jcb.addItem("收款单");jcb.addItem("装车单");
    	jcb.setBackground(Color.white);jcb.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
    	user.add(jcb); jcb.setBounds(8*user.getWidth()/9-10, user.getHeight()/2,user.getWidth()/9 , 25);jcb.setOpaque(false);
    	
        jcb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setrows();	
				
				if(jcb.getSelectedIndex()==2){   
					JButton scsrx=new JButton("生成收款项");
		        	System.out.println("lala");
		        	user.add(scsrx);
		        	scsrx.setBounds(2*screenWidth/5-280, 3*screenHeight/4-130, 100, 25);
		        	
		        	scsrx.addActionListener(new ActionListener(){

						public void actionPerformed(ActionEvent e) {
						
							IncomeListBL incomelistdata=new IncomeListBL();
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
							String date=sdf.format(new Date());
							IncomeListVO vo2=new IncomeListVO();
							String id=vo.getId();
							ArrayList<String> res=new ArrayList<String>();
							try {
								res=incomelistdata.addByCenter(vo2, date, id);
							} catch (IOException e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
							}
//							res.add("2015-12-31");
//							res.add("1200.0");
//							res.add("南京仙林");
							JOptionPane.showMessageDialog(contentPane, "收款日期: "+res.get(0)+"\n"+"收款金额: "+res.get(1)+"\n"+"收款机构: "+res.get(2)+"营业厅",null,0);
							
							
						}
		        		
		        	});
		        }
			}		
		});
        
        
        
        
        
		JButton xjddd=new JButton("新建单据");
		JButton find=new JButton("查询");
		JButton back=new JButton("返回");back.setForeground(Color.RED);
		user.add(xjddd);user.add(find);user.add(back);
		xjddd.setBounds(this.getWidth()/5-100, 3*this.getHeight()/4-50, 100, 25);
		find.setBounds(2*this.getWidth()/5-100, 3*this.getHeight()/4-50, 100, 25);
		back.setBounds(3*this.getWidth()/5-100, 3*this.getHeight()/4-50, 100, 25);
		
		xjddd.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				int a=jcb.getSelectedIndex();
				switch(a){
				case 0:{new InvoiceUI_ArrivalList(vo);break;}
				case 1:{new InvoiceUI_SendingList(vo);break;}
				case 2:{new InvoiceUI_IncomeList(vo);break;}
				case 3:{new InvoiceUI_LoadingList(vo);break;}
				default :{}
				}				
			}
		});
		
		find.addActionListener(new ActionListener(){
			  
			public void actionPerformed(ActionEvent e) { 
				int a=jcb.getSelectedIndex();
				switch(a){
				case 0:{new InvoiceUI_ArrivalListFind();break;}
				case 1:{new InvoiceUI_SendingListFind();break;}
				case 2:{new InvoiceUI_IncomeListFind();break;}
				case 3:{new InvoiceUI_LoadingListFind();break;}
				default :{}
				}			
			}		
		});	

		back.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		final JLabel time=new JLabel();
	    time.setFont(new Font("Serif",Font.BOLD,15));	    
		user.add(time);	    
		time.setBounds(this.getWidth()/3,this.getHeight()-60,200,40);
			
	    Timer timer = new Timer(100,new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				time.setText(sdf.format(new Date()));				
			}	    	
	    });
	    timer.start();
	}
	
	protected void setrows(){
		int a=jcb.getSelectedIndex();
		model.removeAllRows(model.getRowCount());
		try{
			ArrivalListBL al=new ArrivalListBL();
			SendingListBL sl=new SendingListBL();
			IncomeListBL il=new IncomeListBL();
			LoadingListBL ll=new LoadingListBL();
			
			switch(a){
			case 0:{
				String[] title_name={"ID","单据状态","制表人","中转单编号","到达日期","到达状态","出发地","所属营业厅"};
	            model=new TableModel(title_name);	
	            table.setModel(model);
	            ArrayList<ArrivalListVO> arr0=al.inquiryByMaker(voa.getId());
	            for(ArrivalListVO vo:arr0)
	            	model.addRow(model.newchangeRow_Arl(vo));
	            break;
			}
			case 1:{
				String[] title_name={"ID","单据状态","制表人","托运订单条形号码","派送员","到达日期","所属营业厅"};
				model=new TableModel(title_name);	
	            table.setModel(model);
	            ArrayList<SendingListVO> arr1=sl.inquiryByMaker(voa.getId());
	            for(SendingListVO vo:arr1)
	            	model.addRow(model.newchangeRow_Sdl(vo));
	            break;
			}
			case 2:{
				String[] title_name={"ID","单据状态","制表人","收费金额","快递员","收款日期","所属营业厅"};
				model=new TableModel(title_name);	
	            table.setModel(model);
	            ArrayList<IncomeListVO> arr2=il.inquiryByMaker(voa.getId());
	            for(IncomeListVO vo:arr2)
	            	model.addRow(model.newchangeRow_Icl(vo));
	            break;
			}
			case 3:{
				String[] title_name={"ID","单据状态","制表人","装车时间","营业厅编号","汽运编号","到达地","车辆代号","监装员","押运员","运费","所属营业厅"};
				model=new TableModel(title_name);	
	            table.setModel(model);
	            ArrayList<LoadingListVO> arr3=ll.inquiryByMaker(voa.getId());
	            for(LoadingListVO vo:arr3)
	            	model.addRow(model.newchangeRow_Lol(vo));
	            break;			
			}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		table.updateUI();
	}
	
}


