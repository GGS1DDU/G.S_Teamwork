package elms.presentation.financeui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import elms.presentation.financeui.bankaccount.BankAccount_main;
import elms.presentation.financeui.income.Income_main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinanceUI_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinanceUI_main frame = new FinanceUI_main();
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
	public FinanceUI_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("收入管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame income = new Income_main();
				income.setVisible(true);
			}
		});
		btnNewButton.setBounds(154, 31, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("成本管理");
		btnNewButton_1.setBounds(154, 80, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("银行账户管理");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame bankAccount = new BankAccount_main();
				bankAccount.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(142, 132, 118, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("期初建账");
		btnNewButton_3.setBounds(154, 187, 93, 23);
		contentPane.add(btnNewButton_3);
	}
}
