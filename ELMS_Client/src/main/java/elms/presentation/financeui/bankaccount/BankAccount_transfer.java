package elms.presentation.financeui.bankaccount;

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
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.UserInfo;
import elms.vo.BankAccountVO;
import elms.vo.UserVO;

public class BankAccount_transfer extends JFrame{

	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	
	BankAccountManager bam = new BankAccountManager();
	
	JLabel j1;
	JLabel j2;
	JLabel j3;
	
	JComboBox<String> out;
	JComboBox<String> in;
	JTextField amount;
	
	JButton ok;
	JButton back;
	
	public static void main(String[] args){
		UserVO vo = new UserVO();
		BankAccount_transfer bt = new BankAccount_transfer(vo);
	}
	
	public BankAccount_transfer(UserVO vo){
		setLayout(null);
		setTitle("转账");
		setBounds(screenWidth/3,screenHeight/4,screenWidth/3,screenHeight/2+20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel user = new UserInfo(vo);
		user.setBounds(0, 0, this.getWidth(), 25);
		add(user);
		
		j1 = new JLabel("转出账户");
		j1.setBounds(this.getWidth()/5,this.getHeight()/6,80,30);
		add(j1);
		
		j2 = new JLabel("转入账户");
		j2.setBounds(this.getWidth()/5,this.getHeight()*2/6,80,30);
		add(j2);
		
		j3 = new JLabel("转账金额");
		j3.setBounds(this.getWidth()/5,this.getHeight()*3/6,80,30);
		add(j3);
		
		
		String[] out_label = getAccounts();
		String[] in_label = getAccounts();
		out = new JComboBox<String>(out_label);
		in = new JComboBox<String>(in_label);
		out.setBounds(this.getWidth()/5+80,this.getHeight()/6,140,30);
		in.setBounds(this.getWidth()/5+80,this.getHeight()*2/6,140,30);
		add(out);
		add(in);
		
		amount = new JTextField();
		amount.setBounds(this.getWidth()/5+80,this.getHeight()*3/6,140,30);
		add(amount);
		
		ok = new JButton("确定");
		ok.setBounds(this.getWidth()/6,this.getHeight()*4/6+15,80,30);
		add(ok);
		
		back = new JButton("返回");
		back.setBounds(this.getWidth()*4/6,this.getHeight()*4/6+15,80,30);
		add(back);
	
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				BankAccount_transfer.this.dispose();
			}
			
		});
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				
				double money = Double.parseDouble(amount.getText());
				try {
					ResultMessage rm = bam.transferAccount(out.getSelectedItem().toString(),
							in.getSelectedItem().toString(), money);
					if(rm==ResultMessage.findIDFailed)
						JOptionPane.showMessageDialog(null, "未找到对应账户！", "失败", JOptionPane.ERROR_MESSAGE);
					if(rm==ResultMessage.lessThanMin)
						JOptionPane.showMessageDialog(null, "账户余额不足","失败",JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "成功转账！","成功",JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
		});
		
		
		
		
		setVisible(true);
	}
	
	public String[] getAccounts(){
		
			ArrayList<BankAccountVO> outArr = new ArrayList<BankAccountVO>();
			try {
				outArr = bam.getAllAccount();
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			String[] out_label = new String[outArr.size()];
			for(int i = 0; i < out_label.length; i++){
				out_label[i] = outArr.get(i).getName();
			}
	
		return out_label;
	}
}
