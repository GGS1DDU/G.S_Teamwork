package elms.presentation.financeui.inAndEx.income;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.BankAccountManager;
import elms.businesslogic.financebl.inandex.IncomeManager;
import elms.presentation.financeui.bankaccount.BankAccount_edit;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.UserInfo;
import elms.vo.FIncomeVO;
import elms.vo.UserVO;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Income_edit extends JFrame {

	private JPanel contentPane;
	private JPanel user;
	private JPanel buttonPanel;
	
	private JButton save_b;
	private JButton delete_b;
	private JButton back_b;
	private JTextField id;
	private JTextField time;
	private JTextField amount;
	private JComboBox<String> hall;
	private JTextField clerk;
	private JComboBox<String> account;
	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	
	IncomeManager im = new IncomeManager();
	BankAccountManager bam = new BankAccountManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FIncomeVO vo= new FIncomeVO();
					UserVO u_vo = new UserVO();
					Income_edit frame = new Income_edit(vo,u_vo);
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
	public Income_edit(FIncomeVO vo,UserVO u_vo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(screenWidth/3,screenHeight/7,screenWidth/3,screenHeight*3/5+50);
	
		user = new UserInfo(u_vo);
		user.setBounds(0, 0, this.getWidth(), 30);
		user.setBackground(Color.white);
		getContentPane().add(user);
		
		JLabel lblid = new JLabel("收入项ID");
		lblid.setBounds(this.getWidth()/5,this.getHeight()/8,80,30);
		getContentPane().add(lblid);
		
		JLabel lblNewLabel = new JLabel("收入记录时间");
		lblNewLabel.setBounds(this.getWidth()/5,this.getHeight()/8+50,80,30);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("收入金额");
		label.setBounds(this.getWidth()/5,this.getHeight()/8+100,80,30);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("收入营业厅");
		label_1.setBounds(this.getWidth()/5,this.getHeight()/8+150,80,30);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("入帐账户");
		label_2.setBounds(this.getWidth()/5,this.getHeight()/8+200,80,30);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("记录人员");
		label_3.setBounds(this.getWidth()/5,this.getHeight()/8+250,80,30);
		getContentPane().add(label_3);
		
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
		amount.setText(""+vo.getIncome());
		getContentPane().add(amount);
		
		String[] hallList = {"南京市鼓楼营业厅","南京市仙林营业厅"};
		hall = new JComboBox<String>(hallList);
		hall.setBounds(this.getWidth()/5+80,this.getHeight()/8+150,140,30);
		hall.setSelectedItem(vo.getShop());
		getContentPane().add(hall);
		
		clerk = new JTextField();
		clerk.setBounds(this.getWidth()/5+80,this.getHeight()/8+250,140,30);
		clerk.setText(vo.getClerk());
		clerk.setEditable(false);
		getContentPane().add(clerk);
		
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
		save_b.setBounds(buttonPanel.getWidth()/7,buttonPanel.getHeight()/2,buttonPanel.getWidth()/7,buttonPanel.getHeight()/6);
		save_b.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				
					FIncomeVO vo = getVO();
					ArrayList<FIncomeVO> in = Income_main.arr;
					
					im.changeIncome(vo);
					JOptionPane.showMessageDialog(null, "信息修改成功！");
					int i = 0;
					for(; i < in.size(); i++){
						if(in.get(i).getID().equals(vo.getID())){
							in.remove(i);
							in.add(i, vo);
							break;
						}
					}
					Income_main.arr = in;
					Income_edit.this.dispose();
				
			}
			
		});
		buttonPanel.add(save_b);
		
		delete_b = new JButton("删除");
		delete_b.setBounds(3*buttonPanel.getWidth()/7,buttonPanel.getHeight()/2,buttonPanel.getWidth()/7,buttonPanel.getHeight()/6);
		delete_b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					ResultMessage rm = im.deleteIncome(getVO());
					if(rm==ResultMessage.Success){
						ArrayList<FIncomeVO> in = Income_main.arr;
						int i = 0;
						for(; i < in.size(); i++){
							if(in.get(i).getID().equals(getVO().getID())){
								Income_main.arr.remove(i);
								break;
							}
						}
						JOptionPane.showMessageDialog(null, "删除收入项成功！");
					}else if(rm==ResultMessage.changeFailed){
						JOptionPane.showConfirmDialog(null, "找不到对应银行账户");
					}else if(rm==ResultMessage.lessThanMin){
						JOptionPane.showMessageDialog(null,"银行账户余额不足，不可删除！","失败",JOptionPane.ERROR_MESSAGE);
						
					}
					Income_edit.this.dispose();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
			
		});
		buttonPanel.add(delete_b);
		
		back_b = new JButton("返回");
		back_b.setBounds(5*buttonPanel.getWidth()/7,buttonPanel.getHeight()/2,buttonPanel.getWidth()/7,buttonPanel.getHeight()/6);
		back_b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Income_edit.this.dispose();
			}
			
		});
		buttonPanel.add(back_b);
		
		
		JPanel userPanel = new UserInfo(u_vo);
		userPanel.setBounds(0, 0, this.getWidth(), 30);
		add(userPanel);
		setVisible(true);
		
	}
	
	public FIncomeVO getVO(){
		FIncomeVO vo = new FIncomeVO(account.getSelectedItem().toString(),id.getText(),time.getText(),
				Double.parseDouble(amount.getText()),hall.getSelectedItem().toString(),clerk.getText());
		return vo;
	}
}
