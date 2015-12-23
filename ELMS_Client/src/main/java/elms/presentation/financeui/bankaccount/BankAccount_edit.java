package elms.presentation.financeui.bankaccount;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.BankAccountManager;
import elms.presentation.uihelper.UserInfo;
import elms.vo.BankAccountVO;
import elms.vo.UserVO;

public class BankAccount_edit extends JFrame{

	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
	
	BankAccountManager bam = new BankAccountManager();
	BankAccountList accountList;
	
	JPanel operator;
	JPanel info;
	JPanel buttonPanel;
	JLabel j1;
	JLabel j2;
	JLabel j3;
	JTextField name_j;
	JTextField balance_j;
	JTextField bank_j;
	JButton save_b;
	JButton delete_b;
	JButton back_b;
	
	public static void main(String[] args){
		BankAccountVO vo = new BankAccountVO();
		UserVO u_vo = new UserVO();
//		BankAccount_edit be = new BankAccount_edit(vo,u_vo);
	}
	
	public BankAccount_edit(BankAccountList list,final BankAccountVO vo,UserVO u_vo){
		this.accountList = list;
		setTitle("账户信息");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(screenWidth/3,screenHeight/7,screenWidth/3,screenHeight/2+50);
		
		
		info = new JPanel();
		info.setLayout(null);
		info.setBounds(0, 30, this.getWidth(), this.getHeight()/2);
//		info.setBackground(Color.white);
		add(info);
		
		j1 = new JLabel("账户名称"); j1.setBounds(this.getWidth()/5,this.getHeight()/8,80,30);
		j2 = new JLabel("账户余额"); j2.setBounds(this.getWidth()/5,2*this.getHeight()/8,80,30);
		j3 = new JLabel("所属银行"); j3.setBounds(this.getWidth()/5,3*this.getHeight()/8,80,30);
		info.add(j1);
		info.add(j2);
		info.add(j3);
		
		name_j = new JTextField(); 
		balance_j = new JTextField();
		
		name_j.setText(vo.getName());
		name_j.setBounds(this.getWidth()/5+80,this.getHeight()/8,140,30);
		balance_j.setText(""+vo.getAmount());
		balance_j.setBounds(this.getWidth()/5+80,2*this.getHeight()/8,140,30);
		balance_j.setEditable(false);
		info.add(balance_j);
		info.add(name_j);
		
		//需不需要写一个关于银行的功能？需要新建关联银行什么的
		
		bank_j = new JTextField();
		bank_j.setText(vo.getBank());
		bank_j.setEditable(false);
		bank_j.setBounds(this.getWidth()/5+80,3*this.getHeight()/8,140,30);
		info.add(bank_j);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(0, this.getHeight()/2+25, this.getWidth(), this.getHeight()/2-50);
//		buttonPanel.setBackground(Color.white);
		add(buttonPanel);
		
		save_b = new JButton("保存");
		save_b.setBounds(buttonPanel.getWidth()/7,buttonPanel.getHeight()/3,buttonPanel.getWidth()/7,buttonPanel.getHeight()/6);
		save_b.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				try {
					bam.changeAccount(vo.getID(), name_j.getText());
					vo.setName(name_j.getText());
					JOptionPane.showMessageDialog(null, "信息修改成功！");
					
					ArrayList<BankAccountVO> account = BankAccount_main.arr;
					for(int i = 0; i < account.size(); i++){
						BankAccountVO baVO = account.get(i);
						if(baVO.getID().equals(vo.getID())){
							account.remove(i);
							account.add(i, vo);
						}
					}
					
					BankAccount_main.arr = account;
					accountList.removeAllData();
					accountList.addAllData(account);
					BankAccount_edit.this.dispose();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
		});
		buttonPanel.add(save_b);
		
		delete_b = new JButton("删除");
		delete_b.setBounds(3*buttonPanel.getWidth()/7,buttonPanel.getHeight()/3,buttonPanel.getWidth()/7,buttonPanel.getHeight()/6);
		delete_b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					ResultMessage rm = bam.deleteAccount(vo.getID());
					if(rm==ResultMessage.Success)
						JOptionPane.showMessageDialog(null, "删除账号成功！");
					if(rm==ResultMessage.changeFailed)
						JOptionPane.showConfirmDialog(null, "账户余额不为0，确认删除？");
					BankAccount_edit.this.dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
			
		});
		buttonPanel.add(delete_b);
		
		back_b = new JButton("返回");
		back_b.setBounds(5*buttonPanel.getWidth()/7,buttonPanel.getHeight()/3,buttonPanel.getWidth()/7,buttonPanel.getHeight()/6);
		back_b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				BankAccount_edit.this.dispose();
			}
			
		});
		buttonPanel.add(back_b);
		
		
		JPanel userPanel = new UserInfo(u_vo);
		userPanel.setBounds(0, 0, this.getWidth(), 30);
		add(userPanel);
		setVisible(true);
		
	}
	
	
}
