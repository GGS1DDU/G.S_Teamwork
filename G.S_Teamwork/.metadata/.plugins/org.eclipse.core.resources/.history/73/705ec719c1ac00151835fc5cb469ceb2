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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import elms.businesslogic.invoicebl.TransferListBL;
import elms.vo.TransferListVO;
import elms.vo.UserVO;

public class InvoiceUI_ZZZXStaff_TL extends JFrame{
	
	//中转中心业务员主界面任务栏选择中转单就是TransferList的主界面
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int) screenSize.getHeight();
	JTextArea text;

	public static ArrayList<TransferListVO> arr=new ArrayList<TransferListVO>();
	
	public static void main(String arg[]){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
//				UserVO vo=new UserVO();
				UserVO vo = new UserVO("00000001","891213","周颖婷","中转中心业务员");
				JFrame ZZZXStaff_TL=new InvoiceUI_ZZZXStaff_TL(vo);
			}
		});
	}
	
	public InvoiceUI_ZZZXStaff_TL(final UserVO vo){
		setLayout(null);
		setTitle("中转中心管理");
		setResizable(false);
		setSize(screenWidth/2,3*screenHeight/4);
		setLocation(screenWidth/4,screenHeight/8);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar bar=new JMenuBar();
		JMenu m1=new JMenu("接收单管理");		
		JMenu m2=new JMenu("中转单管理");
		m2.setSelected(true);m2.setEnabled(false);
		JMenu m3=new JMenu("装车单管理");
		
		bar.add(m1);
		bar.add(m2);
		bar.add(m3);
		
		setJMenuBar(bar);
		setJMenuBar(bar);
		m1.addMenuListener(new MenuListener(){

			public void menuSelected(MenuEvent e) {
				InvoiceUI_ZZZXStaff_TL.this.dispose();
				new InvoiceUI_ZZZXStaff(vo);
			}

			public void menuDeselected(MenuEvent e) {
			}

			public void menuCanceled(MenuEvent e) {
			}
			});
		
		m3.addMenuListener(new MenuListener(){

			public void menuSelected(MenuEvent e) {
				InvoiceUI_ZZZXStaff_TL.this.dispose();
				new InvoiceUI_ZZZXStaff_LL(vo);
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
		
		JLabel jsd=new JLabel("    中转单");
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
		scrollpane.setBounds(5,70,this.getWidth(),this.getHeight()/2-70);
		
		JMenuBar jbar=new JMenuBar();
		class Menu extends JMenu{
			public Menu(String s){
				super(s);
				this.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
			}
		}
		
		JMenu j1=new Menu(" ID");JMenu j2=new Menu("   装车日期");JMenu j3=new Menu("    中转单编号");
		JMenu j4=new Menu("   航班/车次号");JMenu j5=new Menu("出发地");JMenu j6=new Menu("到达地");
		JMenu j7=new Menu("货柜号");JMenu j8=new Menu("监装员");JMenu j9=new Menu("运费");
		JMenu j10=new Menu("所属中转中心");JMenu j11=new Menu("生成者");
		jbar.add(j1);jbar.add(j2);jbar.add(j3);jbar.add(j4);jbar.add(j5);jbar.add(j6);
		jbar.add(j7);jbar.add(j8);jbar.add(j9);jbar.add(j10);jbar.add(j11);
		add(jbar);
		jbar.setBounds(5,48,this.getWidth(),20);
		add(info2);
		info2.setBounds(0,0,this.getWidth(),this.getHeight()/2);
		
		JButton xjjsd=new JButton("新建中转单");
		JButton find=new JButton("查询");
		JButton refresh=new JButton("刷新(R)");refresh.setForeground(Color.GREEN);
		JButton back=new JButton("返回(B)");back.setForeground(Color.RED);
		JPanel buttonPal=new JPanel();
		buttonPal.setLayout(null);
		buttonPal.add(xjjsd);buttonPal.add(find);buttonPal.add(refresh);buttonPal.add(back);
		xjjsd.setBounds(100,30,102,30);find.setBounds(320,30,102,30);
		refresh.setBounds(550,15,80,30);
		back.setBounds(550,55,80,30);
		add(buttonPal);
		buttonPal.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);
		buttonPal.setBorder(BorderFactory.createTitledBorder("中转单操作"));
		
		xjjsd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new InvoiceUI_TransferList(vo);
			}	
		});
		find.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new InvoiceUI_TransferListFind();			
			}		
		});
		
		refresh.addActionListener(new ActionListener(){
			TransferListBL transferlistdata=new TransferListBL();

			public void actionPerformed(ActionEvent e) {
			    
				text.setText("");
				try{
					arr=transferlistdata.inquiryAll();
				}catch(IOException e1){
					e1.printStackTrace();
				}
				for(TransferListVO alvo:arr)
					text.append(" "+alvo.getID()+" "+alvo.getTime()+" "+alvo.getTransferID()+" "+alvo.getTransportNum()+"   "+alvo.getDeparture()+
							"    "+alvo.getArrival()+"   "+alvo.getSeatNumber()+"  "+alvo.getSurpervior()+" "+alvo.getCost()+"  "+alvo.getPlace()+"  "+alvo.getMaker()+"\r\n");				
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
