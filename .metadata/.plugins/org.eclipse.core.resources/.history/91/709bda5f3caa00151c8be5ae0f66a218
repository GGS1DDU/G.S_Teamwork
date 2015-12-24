package elms.presentation.financeui.bankaccount;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import elms.businesslogic.ResultMessage;
import elms.businesslogic.financebl.BankAccountManager;

import elms.vo.BankAccountVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;

import javax.swing.JComboBox;

public class BankAccount_add extends JFrame {

	private JPanel contentPane;
	private JTextField accountName;
	private JComboBox bankName;
	private BankAccountList accountList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					BankAccount_add frame = new BankAccount_add();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BankAccount_add(BankAccountList list) {
		this.accountList = list;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("银行账户名");
		label.setBounds(107, 43, 71, 15);
		contentPane.add(label);

		accountName = new JTextField();
		accountName.setBounds(188, 40, 89, 21);
		contentPane.add(accountName);
		accountName.setColumns(10);

		JLabel label_1 = new JLabel("所属银行");
		label_1.setBounds(110, 84, 54, 15);
		contentPane.add(label_1);

		bankName = new JComboBox();
		bankName.setModel(new DefaultComboBoxModel(new String[] { "中国银行",
				"中国人民银行" }));
		bankName.setBounds(188, 81, 89, 21);
		contentPane.add(bankName);

		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankAccountManager accountManage = new BankAccountManager();
				BankAccountVO vo = new BankAccountVO("ba00000001", accountName
						.getText(), 0.0, bankName.getSelectedItem().toString());

				ResultMessage rm = accountManage.addAccount(vo);

				if (rm == ResultMessage.Success) {
					BankAccount_add.this.dispose();
					JOptionPane.showMessageDialog(null, "该账户已成功新建!", "成功!",
							JOptionPane.INFORMATION_MESSAGE);
					accountList.addData(vo);

				} else if (rm == ResultMessage.findIDFailed) {
					JOptionPane.showMessageDialog(null, "该账户名已存在，请重新输入！",
							"失败!", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "该账户名已存在，请重新输入！",
							"失败!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(45, 147, 93, 23);
		contentPane.add(btnNewButton);

		JButton button = new JButton("取消");
		button.setBounds(274, 147, 93, 23);
		contentPane.add(button);

	}
}
