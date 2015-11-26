package elms.presentation.financeui.bankaccount;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankAccount_main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankAccount_main frame = new BankAccount_main();
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
	public BankAccount_main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("新建账户");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame add = new BankAccount_add();
				add.setVisible(true);
			}
		});
		button.setBounds(157, 28, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("删除账户");
		button_1.setBounds(157, 87, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("更改账户");
		button_2.setBounds(157, 145, 93, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("返回");
		button_3.setBounds(157, 207, 93, 23);
		contentPane.add(button_3);
	}
}
