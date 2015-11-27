package elms.presentation.financeui.income;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;

import elms.vo.FIncomeVO;

public class Income_change_message extends JFrame {

	private JPanel contentPane;
	private JTextField incomeAmount;
	private JTextField incomeAccount;
	private JTextField recordTime;
//	private JTextField incomeID;
	private JTextField recordClerk;
	private JTextField incomeID;
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
////					Income_change_message frame = new Income_change_message();
////					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Income_change_message(FIncomeVO vo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("收入营业厅");
		label.setBounds(91, 122, 74, 15);
		contentPane.add(label);
		
		JComboBox incomeHall = new JComboBox();
		incomeHall.setModel(new DefaultComboBoxModel(new String[]{"南京市鼓楼营业厅","南京市仙林营业厅"}));
//		incomeHall.set
		incomeHall.setBounds(199, 119, 111, 21);
		contentPane.add(incomeHall);
		
		JLabel lblNewLabel = new JLabel("收入金额");
		lblNewLabel.setBounds(101, 168, 54, 15);
		contentPane.add(lblNewLabel);
		
		incomeAmount = new JTextField();
		incomeAmount.setBounds(199, 165, 111, 21);
		contentPane.add(incomeAmount);
		incomeAmount.setColumns(10);
		
		JLabel lblid = new JLabel("入账银行账户ID");
		lblid.setBounds(91, 218, 84, 15);
		contentPane.add(lblid);
		
		incomeAccount = new JTextField();
		incomeAccount.setBounds(199, 215, 111, 21);
		contentPane.add(incomeAccount);
		incomeAccount.setColumns(10);
		
		JButton change_b = new JButton("更改信息");
		change_b.setBounds(42, 356, 93, 23);
		contentPane.add(change_b);
		
		JButton delete_b = new JButton("删除该项");
		delete_b.setBounds(170, 356, 93, 23);
		contentPane.add(delete_b);
		
		JButton return_b = new JButton("返回");
		return_b.setBounds(303, 356, 93, 23);
		contentPane.add(return_b);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 41, 402, 2);
		contentPane.add(separator);
		
		recordTime = new JTextField();
		recordTime.setBounds(199, 261, 111, 21);
		contentPane.add(recordTime);
		recordTime.setColumns(10);
		
		JLabel label_1 = new JLabel("收入记录时间");
		label_1.setBounds(91, 264, 73, 15);
		contentPane.add(label_1);
		
		JLabel lblid_2 = new JLabel("记录人ID");
		lblid_2.setBounds(101, 309, 54, 15);
		contentPane.add(lblid_2);
		
		recordClerk = new JTextField();
		recordClerk.setBounds(199, 306, 113, 21);
		contentPane.add(recordClerk);
		recordClerk.setColumns(10);
		
		JLabel lblid_1 = new JLabel("收入项ID");
		lblid_1.setBounds(101, 73, 54, 15);
		contentPane.add(lblid_1);
		
		incomeID = new JTextField();
		
		incomeID.setBounds(197, 70, 113, 21);
		contentPane.add(incomeID);
		incomeID.setColumns(10);
	}
}
