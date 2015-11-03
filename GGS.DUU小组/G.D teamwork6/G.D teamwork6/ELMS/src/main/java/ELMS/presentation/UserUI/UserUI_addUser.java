package ELMS.presentation.UserUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserUI_addUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUI_addUser frame = new UserUI_addUser();
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
	public UserUI_addUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("账户");
		lblId.setBounds(55, 63, 42, 21);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("密码");
		lblPassword.setBounds(55, 128, 42, 21);
		contentPane.add(lblPassword);
		
		JLabel lblName = new JLabel("姓名");
		lblName.setBounds(55, 206, 42, 21);
		contentPane.add(lblName);
		
		JLabel label = new JLabel("职务");
		label.setBounds(55, 275, 42, 29);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(149, 63, 123, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 128, 123, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(149, 206, 123, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(149, 279, 123, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton ensureAddUser = new JButton("确定");
		ensureAddUser.setBounds(169, 341, 87, 43);
		contentPane.add(ensureAddUser);
		
		JButton btnNewButton = new JButton("取消");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserUI_addUser.this.dispose();
			}
		});
		btnNewButton.setBounds(287, 341, 87, 43);
		contentPane.add(btnNewButton);
	}
}
