package elms.presentation.financeui.inAndEx.expense;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import elms.businesslogic.financebl.inandex.ExpenseManager;


import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.UserInfo;
import elms.vo.FExpenseVO;
import elms.vo.UserVO;

public class Expense_edit extends JFrame{

	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;
	
	private FExpenseVO exvo;
	private UserVO uservo;
	
	private JPanel user;
	private JPanel buttonPanel;
	
	private JTextField id;
	private JTextField time;
	private JTextField amount;
	private JComboBox<String> type;
	private JComboBox<String> account;
	private JTextField executor;
	private JTextField recorder;
	
	private JButton save_b;
	private JButton delete_b;
	private JButton back_b;
	
	private BankAccountManager bam = new BankAccountManager();
	private ExpenseManager em = new ExpenseManager();
	
	public static void main(String[] args){
		FExpenseVO vo = new FExpenseVO();
		UserVO vo1 = new UserVO();
		JFrame jf = new Expense_edit(vo,vo1);
	}
	
	public Expense_edit(final FExpenseVO vo,UserVO u_vo){
		this.exvo = vo;
		this.uservo = u_vo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(screenWidth/3,screenHeight/7,screenWidth/3,screenHeight*3/5+100);
	
		user = new UserInfo(u_vo);
		user.setBounds(0, 0, this.getWidth(), 30);
		user.setBackground(Color.white);
		getContentPane().add(user);
		
		JLabel lblid = new JLabel("支出项ID");
		lblid.setBounds(this.getWidth()/5,this.getHeight()/8,80,30);
		getContentPane().add(lblid);
		
		JLabel lblNewLabel = new JLabel("支出记录时间");
		lblNewLabel.setBounds(this.getWidth()/5,this.getHeight()/8+50,80,30);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("支出金额");
		label.setBounds(this.getWidth()/5,this.getHeight()/8+100,80,30);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("支出类型");
		label_1.setBounds(this.getWidth()/5,this.getHeight()/8+150,80,30);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("支出账户");
		label_2.setBounds(this.getWidth()/5,this.getHeight()/8+200,80,30);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("支出人员");
		label_3.setBounds(this.getWidth()/5,this.getHeight()/8+250,80,30);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("支出记录人员");
		label_4.setBounds(this.getWidth()/5,this.getHeight()/8+300,80,30);
		getContentPane().add(label_4);
		
		id = new JTextField();
		id.setBounds(this.getWidth()/5+80,this.getHeight()/8,140,30);
		id.setText(vo.getID());
		id.setEditable(false);
		getContentPane().add(id);
		
		time = new JTextField();
		time.setBounds(this.getWidth()/5+80,this.getHeight()/8+50,140,30);
		time.setText(vo.getTime());
		time.setEditable(false);
		getContentPane().add(time);
		
		amount = new JTextField();
		amount.setBounds(this.getWidth()/5+80,this.getHeight()/8+100,140,30);
		amount.setText(""+vo.getExpense());
		getContentPane().add(amount);
		
		String[] typeList = {"人员工资","运费","租金"};
		type = new JComboBox<String>(typeList);
		type.setBounds(this.getWidth()/5+80,this.getHeight()/8+150,140,30);
		type.setSelectedItem(vo.getCategory());
		getContentPane().add(type);
		
		executor = new JTextField();
		executor.setBounds(this.getWidth()/5+80,this.getHeight()/8+250,140,30);
		executor.setText(vo.getClerk());
		executor.setEditable(false);
		getContentPane().add(executor);
		
		recorder = new JTextField();
		recorder.setBounds(this.getWidth()/5+80,this.getHeight()/8+300,140,30);
		recorder.setText(vo.getAssistant());
		recorder.setEditable(false);
		getContentPane().add(recorder);
		
		String[] accountList = bam.getNameList();
		account = new JComboBox<String>(accountList);
		account.setBounds(this.getWidth()/5+80,this.getHeight()/8+200,140,30);
		account.setSelectedItem(vo.getBankAccountName());
		getContentPane().add(account);
		
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(0, this.getHeight()/2+25, this.getWidth(), this.getHeight()/2-50);
//		buttonPanel.setBackground(Color.white);
		add(buttonPanel);
		
		save_b = new JButton("保存");
		save_b.setBounds(buttonPanel.getWidth()/7,buttonPanel.getHeight()*2/3-25,buttonPanel.getWidth()/7,buttonPanel.getHeight()/6);
		save_b.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				
					FExpenseVO vo = getVO();
					ArrayList<FExpenseVO> in = Expense_main.arr;
					
					em.changeExpense(vo);
					JOptionPane.showMessageDialog(null, "信息修改成功！");
					int i = 0;
					for(; i < in.size(); i++){
						if(in.get(i).getID().equals(vo.getID())){
							in.remove(i);
							in.add(i, vo);
							break;
						}
					}
					Expense_main.arr = in;
					Expense_edit.this.dispose();
				
			}
			
		});
		buttonPanel.add(save_b);
		
		delete_b = new JButton("删除");
		delete_b.setBounds(3*buttonPanel.getWidth()/7,buttonPanel.getHeight()*2/3-25,buttonPanel.getWidth()/7,buttonPanel.getHeight()/6);
		delete_b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					ResultMessage rm = em.deleteExpense(exvo);
					if(rm==ResultMessage.Success){
						ArrayList<FExpenseVO> in = Expense_main.arr;
						int i = 0;
						for(; i < in.size(); i++){
							if(in.get(i).getID().equals(getVO().getID())){
								Expense_main.arr.remove(i);
								break;
							}
						}
						JOptionPane.showMessageDialog(null, "删除收入项成功！");
					}else if(rm==ResultMessage.changeFailed){
						JOptionPane.showConfirmDialog(null, "找不到对应银行账户");
					}else if(rm==ResultMessage.lessThanMin){
						JOptionPane.showMessageDialog(null,"银行账户余额不足，不可删除！","失败",JOptionPane.ERROR_MESSAGE);
						
					}
					Expense_edit.this.dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
			
		});
		buttonPanel.add(delete_b);
		
		back_b = new JButton("返回");
		back_b.setBounds(5*buttonPanel.getWidth()/7,buttonPanel.getHeight()*2/3-25,buttonPanel.getWidth()/7,buttonPanel.getHeight()/6);
		back_b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Expense_edit.this.dispose();
			}
			
		});
		buttonPanel.add(back_b);
		
		
		JPanel userPanel = new UserInfo(u_vo);
		userPanel.setBounds(0, 0, this.getWidth(), 30);
		add(userPanel);
		setVisible(true);
	}
	
	private FExpenseVO getVO(){
		FExpenseVO vo = new FExpenseVO(account.getSelectedItem().toString(),id.getText(),
				type.getSelectedItem().toString(),time.getText(),Double.parseDouble(amount.getText()),
				recorder.getText(),executor.getText());
		return vo;
	}
}
