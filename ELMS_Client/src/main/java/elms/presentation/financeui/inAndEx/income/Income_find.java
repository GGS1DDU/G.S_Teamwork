package elms.presentation.financeui.inAndEx.income;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import elms.businesslogic.financebl.inandex.IncomeManager;
import elms.presentation.financeui.bankaccount.BankAccount_edit;
import elms.presentation.financeui.bankaccount.BankAccount_find;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.BankAccountVO;
import elms.vo.FIncomeVO;
import elms.vo.UserVO;
public class Income_find extends JFrame{

	
	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	
	JTextField id_f;
	IncomeManager im = new IncomeManager();
	
	public Income_find(final UserVO vo){
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
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String id = id_f.getText();
					FIncomeVO b_vo = null;
					try {
						b_vo = im.inquiryIncome(id);
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					// TODO 自动生成的方法存根
					if(b_vo==null){
						JOptionPane.showMessageDialog(null, "系统中没有此账户！，请重新输入");
						id_f.setText("");
					}else{
						JFrame edit = new Income_edit(b_vo,vo);
						edit.setVisible(true);
						Income_find.this.dispose();
					}
				}
				
			});
		
		add(ensure);
		
		JButton back = new JButton("返回");
		back.setBounds(this.getWidth()*3/5+50,3*this.getHeight()/5,70,20);
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Income_find.this.dispose();
			}
			
		});
		add(back);
		
		setVisible(true);
	}
}
