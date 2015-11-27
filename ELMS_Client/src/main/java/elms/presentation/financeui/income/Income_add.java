package elms.presentation.financeui.income;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;

import elms.businesslogic.financebl.IncomeManager;
import elms.businesslogic.userbl.UserManage;
import elms.vo.FIncomeVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;

public class Income_add extends JFrame {

	private JPanel contentPane;
	private JTextField incomeAmount;
	private JTextField inBankAccount;
	private JComboBox incomeHall;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Income_add frame = new Income_add();
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
	public Income_add() {
		this.setTitle("新建收入项");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("收入营业厅");
		label.setBounds(80, 59, 73, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("收入金额");
		label_1.setBounds(80, 100, 54, 15);
		contentPane.add(label_1);
		
		incomeAmount = new JTextField();
		incomeAmount.setBounds(210, 97, 122, 21);
		contentPane.add(incomeAmount);
		incomeAmount.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 37, 414, 2);
		contentPane.add(separator);
		
		inBankAccount = new JTextField();
		inBankAccount.setBounds(210, 134, 122, 21);
		contentPane.add(inBankAccount);
		inBankAccount.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 183, 414, 2);
		contentPane.add(separator_1);
		
		incomeHall = new JComboBox();
		incomeHall.setModel(new DefaultComboBoxModel(new String[] {"南京市仙林营业厅", "南京市鼓楼营业厅"}));
		incomeHall.setBounds(210, 56, 122, 21);
		contentPane.add(incomeHall);
		
		JButton ensure = new JButton("确定");
		ensure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar ca = Calendar.getInstance();
				UserManage um = new UserManage(); //试验，感觉不应该把usermanage和界面层连起来
				IncomeManager im = new IncomeManager();
			    boolean addSuccess = false;
				
				int year = ca.get(Calendar.YEAR);
				int month = ca.get(Calendar.MONTH);
				int day = ca.get(Calendar.DATE);
				
				String time = ""+year+"-"+month+"-"+day;
				try {
					FIncomeVO vo = new FIncomeVO(inBankAccount.getText(),"in00000001",time,
							Double.parseDouble(incomeAmount.getText()),incomeHall.getSelectedItem().toString(),
							um.getCurrentUser().getId());
//							"123456");    //如何获取当前用户id
					addSuccess = im.addIncome(vo);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} //我要怎么获取当前操作者的po？
				
				if(addSuccess){
					Income_add.this.dispose();
					JOptionPane.showMessageDialog(null, "该收入项已成功添加!", "成功!", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "该银行账户不存在，请重新输入一个银行账户名！", "失败!", JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		ensure.setBounds(80, 206, 93, 23);
		contentPane.add(ensure);
		
		JButton cancel = new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Income_add.this.dispose();
			}
		});
		cancel.setBounds(269, 206, 93, 23);
		contentPane.add(cancel);
		
		JLabel label_2 = new JLabel("入账银行账户");
		label_2.setBounds(77, 135, 87, 18);
		contentPane.add(label_2);
		
		
		
		
	}
}
