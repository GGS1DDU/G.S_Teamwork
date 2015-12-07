package elms.presentation.financeui.bankaccount;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.JButton;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.BankAccountManager;
import elms.businesslogic.storagebl.Storage;
import elms.po.BankAccountPO;
import elms.presentation.storageui.Storage_init;
import elms.presentation.storageui.Storage_main;
import elms.vo.BankAccountVO;
import elms.vo.UserVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
/*
 * 银行账户管理主界面，点进来之后直接显示现有的所有银行账户清单，可以在下面选择所属银行
 * 根据所选择的银行显示对应的银行账户清单
 * 左下角是buttonpanel区，包含新建，删除/修改，转账三个按钮，
 * 最下方一栏可显示当前时间 格式为yyyy-mm-dd hh:mm:ss  需要修改对应数据区中比较时间的方法
 */
public class BankAccount_main extends JFrame {

	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
	JTextArea text=new JTextArea(10,10);
	String bank = null;
	JComboBox<String> bank_c;
	ArrayList<BankAccountVO> arr;//全部的账户vo
	BankAccountManager bam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserVO vo = new UserVO();
					BankAccount_main frame = new BankAccount_main(vo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BankAccount_main(final UserVO vo) {
		setLayout(null);
		setTitle("银行账户管理");
		setResizable(false);
		setSize(screenWidth/2,3*screenHeight/4);
		setLocation(screenWidth/4, screenHeight/8);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel jl=new JLabel("  当前用户：  "+vo.getName()+"  身份：  "+vo.getJob()+"  编号   "+vo.getId());
		jl.setForeground(Color.lightGray);
		JPanel user=new JPanel();
		user.add(jl);
		user.setBounds(0, 0, this.getWidth(),25);	
		

		Border li=BorderFactory.createEtchedBorder();
		Border t=BorderFactory.createTitledBorder(li);
		Border l2=BorderFactory.createLoweredBevelBorder();
		user.setBorder(t);
		add(user);
		
		//账户管理和初始化的表头（选择）
		JMenuBar bar = new JMenuBar();
		JMenu manage_m = new JMenu("银行账户管理");
		manage_m.setSelected(true);manage_m.setEnabled(false);
		final JMenu init_m = new JMenu("账户初始化");
		bar.add(manage_m);
		bar.add(init_m);
		setJMenuBar(bar);
		//初始化
		init_m.addMenuListener(new MenuListener(){

			@Override
			public void menuCanceled(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void menuDeselected(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void menuSelected(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				int a=(int)(Math.random()*1000);
		    	String s=a+"";
		    	
		    	String obj=JOptionPane.showInputDialog("请输入 验证码  "+a+" 确认初始化库存");
				if(obj.equals(s)){
				BankAccount_main.this.dispose();
				new BankAccount_init(vo);
				BankAccountManager bankaccount = new BankAccountManager();
				try {
					ResultMessage rm = bankaccount.init();
					if(rm==ResultMessage.changeFailed){
						int opt = JOptionPane.showConfirmDialog(null, "仍有账户余额不为0，确认继续？");
						if(opt==0){
							bankaccount.initIgnoreAmount();
							JOptionPane.showMessageDialog(null, "初始化成功!");
						}else
							JOptionPane.showMessageDialog(null, "停止初始化!");
					}else{
						bankaccount.initIgnoreAmount();
					}
					
						
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else  JOptionPane.showMessageDialog(null, "验证码错误！",null,0);
					
			
				
			}
			
		});
		
		//在账户管理界面上显示的各种清单列表
		JLabel zhqd=new JLabel("账户清单");
		JPanel info=new JPanel();
		info.setLayout(new java.awt.BorderLayout()); 
		info.add(zhqd);
		info.setBounds(0, 23, 70,25);
		info.setBorder(l2);
		add(info);
		
		//表头和内容
		JPanel info2=new JPanel();
		info2.setLayout(null);
		info2.setBackground(Color.white);
		info2.setBounds(50,75,this.getWidth()-110,this.getHeight()/2-70);
//		text=new JTextArea(10,10);
		text.setEditable(false);
		text.setFont(new Font("Serif",Font.PLAIN,14));
	    
		JScrollPane scrollpane=new JScrollPane(text);
		info2.add(scrollpane);
		scrollpane.setBounds(0,0,this.getWidth()-40,this.getHeight()/2-70);
		
		JMenuBar jbar = new JMenuBar();
		class Menu extends JMenu{
			public Menu(String s){
				super(s);
				this.setFont(new Font("楷体",Font.CENTER_BASELINE,15));
			}
		}  
		JMenu j1 = new Menu("     ID    "); JMenu j2 = new Menu("     账户名        "); JMenu j3 = new Menu("    余额       ");
		JMenu j4 = new Menu("    所属银行      ");
		jbar.add(j1); jbar.add(j2); jbar.add(j3); jbar.add(j4);
		jbar.setBounds(50,50,this.getWidth()-110,25);
		add(jbar);
		add(info2);
		
		//选择银行类别的combobox
		bank_c = new JComboBox<String>();
		bank_c.addItem("全部"); bank_c.addItem("中国银行"); bank_c.addItem("中国人民银行");
		bank_c.addItem("中国工商银行"); bank_c.addItem("中国邮政银行");
		bank_c.setBackground(Color.white);bank_c.setFont(new Font("楷体",Font.CENTER_BASELINE,15));
		add(bank_c); bank_c.setBounds(3*this.getWidth()/4, this.getHeight()/2+30,135, 25);
		bam = new BankAccountManager();
		try {
			arr = bam.getAllAccount();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} 
		for(BankAccountVO vo1:arr){
			text.append("        "+vo1.getID()+"         "+vo1.getName()+"                         "+vo1.getAmount()+
					"                          "+vo1.getBank()+"              \r\n");
		} 
		
		
		bank_c.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				text.setText("");
				bank = bank_c.getSelectedItem().toString();
				
				try {
					arr = bam.getAllAccount();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					System.out.println("there is no account in the file!");
					e.printStackTrace();
				}
				System.out.println(arr==null);
//				for(BankAccountVO vo:arr){
//					text.append("   "+vo.getID()+"    "+vo.getName()+"   "+vo.getAmount()+
//							"    "+vo.getBank()+"  ");
//				}; 
				switch(bank){
				case"全部": for(BankAccountVO vo:arr){
					text.append("        "+vo.getID()+"         "+vo.getName()+"                         "+vo.getAmount()+
							"                          "+vo.getBank()+"              \r\n");
				}; break;
				default:{
					arr = bam.inquiryAccountByBank(bank);
					for(BankAccountVO vo:arr){
						text.append("        "+vo.getID()+"         "+vo.getName()+"                         "+vo.getAmount()+
								"                          "+vo.getBank()+"              \r\n");
					}
				}
				}
			}
			
		});
		
		//buttonpanel  用来放各种按钮
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		JButton add = new JButton("新建");
		JButton delete = new JButton("更改/删除");
		JButton trans = new JButton("转账");
		JButton refresh = new JButton("刷新");refresh.setForeground(Color.GREEN);
		JButton back = new JButton("返回");back.setForeground(Color.red);
		buttonPanel.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);

		
		 add.setBounds(50, 30, 102, 30);delete.setBounds(200, 30, 104, 30);  trans.setBounds(350, 30, 102, 30);
		    refresh.setBounds(560,15,80,30);  back.setBounds(560,55,80,30);
		buttonPanel.add(add); buttonPanel.add(delete); buttonPanel.add(trans); 
		buttonPanel.add(refresh); buttonPanel.add(back);

		add(buttonPanel);
		
		//各种按钮的监听
		add.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame addAccount = new BankAccount_add();
//				refresh();
				addAccount.setVisible(true);
			}
			
		});
		
		delete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame find = new BankAccount_find(vo);
				find.setVisible(true);
			}
			
		});
		
		trans.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame transfer = new BankAccount_transfer(vo);
				transfer.setVisible(true);
			}
			
		});
		
		refresh.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
//				text.setText("");
//				bank = bank_c.getSelectedItem().toString();
//				
//				try {
//					arr = bam.getAllAccount();
//				} catch (Exception ex) {
//					// TODO 自动生成的 catch 块
//					System.out.println("there is no account in the file!");
//					ex.printStackTrace();
//				}
//				System.out.println(arr==null);
//
//				switch(bank){
//				case"全部": for(BankAccountVO vo:arr){
//					text.append("        "+vo.getID()+"         "+vo.getName()+"                         "+vo.getAmount()+
//							"                          "+vo.getBank()+"              \r\n");
//				}; break;
//				default:{
//					arr = bam.inquiryAccountByBank(bank);
//					for(BankAccountVO vo:arr){
//						text.append("        "+vo.getID()+"         "+vo.getName()+"                         "+vo.getAmount()+
//								"                          "+vo.getBank()+"              \r\n");
//					}
//				}
//				}
				refresh();
			}
			
			
		});
		
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}
			
		});
		
	}
	
	public void refresh(){
		text.setText("");
		bank = bank_c.getSelectedItem().toString();
		
		try {
			arr = bam.getAllAccount();
		} catch (Exception ex) {
			// TODO 自动生成的 catch 块
			System.out.println("there is no account in the file!");
			ex.printStackTrace();
		}
		System.out.println(arr==null);

		switch(bank){
		case"全部": for(BankAccountVO vo:arr){
			text.append("        "+vo.getID()+"         "+vo.getName()+"                         "+vo.getAmount()+
					"                          "+vo.getBank()+"              \r\n");
		}; break;
		default:{
			arr = bam.inquiryAccountByBank(bank);
			for(BankAccountVO vo:arr){
				text.append("        "+vo.getID()+"         "+vo.getName()+"                         "+vo.getAmount()+
						"                          "+vo.getBank()+"              \r\n");
			}
		}
		}
	}
	
	
	
	
	
}
