package elms.presentation.financeui.bankaccount;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import elms.businesslogic.financebl.BankAccountManager;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.UserInfo;
import elms.vo.BankAccountVO;
import elms.vo.UserVO;

public class BankAccount_init extends JFrame{

	JTextArea text=new JTextArea(10,10);
	String bank = null;
	JComboBox<String> bank_c;
	ArrayList<BankAccountVO> arr;//全部的账户vo
	BankAccountManager bam = new BankAccountManager();
	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	
	public static void main(String args[]){
		UserVO vo = new UserVO();
		BankAccount_init bi = new BankAccount_init(vo);
	}
	
	public BankAccount_init(final UserVO vo){
		setLayout(null);
		setTitle("库存初始化");
		setResizable(false);
		setSize(screenWidth/2,screenHeight/2-60);
		setLocation(screenWidth/4, screenHeight/8);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel user = new UserInfo(vo);
		user.setBounds(0, 0, this.getWidth(),25);	
		add(user);
		//在账户管理界面上显示的各种清单列表
				JLabel zhqd=new JLabel("账户清单");
				JPanel info=new JPanel();
				info.setLayout(new java.awt.BorderLayout()); 
				info.add(zhqd);
				info.setBounds(0, 23, 70,25);
				Border l2=BorderFactory.createLoweredBevelBorder();
				info.setBorder(l2);
				add(info);
				
				//表头和内容
				JPanel info2=new JPanel();
				info2.setLayout(null);
				info2.setBackground(Color.white);
				info2.setBounds(50,75,this.getWidth()-110,this.getHeight()/2-70);

				//				text=new JTextArea(10,10);
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
				add(bank_c); bank_c.setBounds(3*this.getWidth()/4-20, this.getHeight()/2+15,135, 25);
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
//						for(BankAccountVO vo:arr){
//							text.append("   "+vo.getID()+"    "+vo.getName()+"   "+vo.getAmount()+
//									"    "+vo.getBank()+"  ");
//						}; 
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
				
				
				JButton add=new JButton("添加账户");JButton delete=new JButton("修改账户");JButton back=new JButton("返回");
				add(add);add.setBounds(screenWidth/12, screenHeight/4+20, 100, 28);
				add(delete);delete.setBounds(screenWidth/5, screenHeight/4+20, 100, 28);
				add(back);back.setBounds(screenWidth/3, screenHeight/4+20, 100, 28);
				
				add.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						JFrame j_add = new BankAccount_add();
						j_add.setVisible(true);
					}
					
				});
				
				delete.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						JFrame j_change = new BankAccount_find(vo);
						j_change.setVisible(true);
					}
					
				});
				
				back.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						BankAccount_init.this.dispose();
					}
					
				});
				setVisible(true);
	}
}
