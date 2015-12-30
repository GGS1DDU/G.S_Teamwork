package elms.presentation.financeui.bankaccount;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import elms.businesslogic.financebl.BankAccountManager;
import elms.presentation.uihelper.CheckFormat;
import elms.vo.BankAccountVO;
import elms.vo.UserVO;

public class BankAccount_find extends JFrame{

	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
	
	JTextField id_f;
	
	BankAccountManager bam = new BankAccountManager();
	BankAccountList accountList;
	private CheckFormat check = new CheckFormat();
	
	public static void main(String args[]){
		UserVO vo = new UserVO();
//		JFrame jf = new BankAccount_find(vo);
	}
	
	public BankAccount_find(BankAccountList list,final UserVO vo){
		this.accountList = list;
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(screenWidth/4,screenHeight/3,screenWidth/2,screenHeight/4);
		
		
		
		JLabel label = new JLabel("ID:");
		label.setBounds(this.getWidth()/4,this.getHeight()/5,40,30);
		label.setBackground(Color.BLACK);
		add(label);
	
		id_f = new JTextField();
		id_f.setBounds(this.getWidth()/4+50,this.getHeight()/5,this.getWidth()*2/5,30);
//		id.setVisible(true);
		add(id_f);
		
		
		JButton ensure = new JButton("确定");
		ensure.setBounds(this.getWidth()/5,3*this.getHeight()/5,70,20);
		
			ensure.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent arg0) {
					String id = id_f.getText();
					BankAccountVO b_vo = null;
					try {
						b_vo = bam.inquiryAccount(id);
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					// TODO 自动生成的方法存根
					if(!(check.checkID(id, "ba", 10))){
						JOptionPane.showMessageDialog(null, "请输入格式为ba加8位数字的ID！");
						return;
					}
					
					if(b_vo==null)
						JOptionPane.showMessageDialog(null, "系统中没有此账户！，请重新输入");
					else{
						JFrame edit = new BankAccount_edit(accountList,b_vo,vo);
						edit.setVisible(true);
						BankAccount_find.this.dispose();
					}
				}
				
			});
		
		add(ensure);
		
		JButton back = new JButton("返回");
		back.setBounds(this.getWidth()*3/5+50,3*this.getHeight()/5,70,20);
		back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				BankAccount_find.this.dispose();
			}
			
		});
		add(back);
		
		setVisible(true);
		
	}
}
