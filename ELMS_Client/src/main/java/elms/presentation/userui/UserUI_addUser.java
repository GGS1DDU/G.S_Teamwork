package elms.presentation.userui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import elms.businesslogic.userbl.UserManage;
import elms.vo.UserVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.RemoteException;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserUI_addUser extends JFrame {

	private JPanel contentPane;
	private JTextField IDtext;
	private JTextField passwordtext;
	private JTextField nametext;



	/**
	 * Create the frame.
	 */
	public UserUI_addUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 442);
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
		
		IDtext = new JTextField();
		IDtext.setBounds(149, 63, 123, 21);
		contentPane.add(IDtext);
		IDtext.setColumns(10);
		
		passwordtext = new JTextField();
		passwordtext.setBounds(149, 128, 123, 21);
		contentPane.add(passwordtext);
		passwordtext.setColumns(10);
		
		nametext = new JTextField();
		nametext.setBounds(149, 206, 123, 21);
		contentPane.add(nametext);
		nametext.setColumns(10);
		
		final JComboBox job = new JComboBox();
		job.setModel(new DefaultComboBoxModel(new String[] {"快递员", "营业厅业务员", "中转中心业务员", "中转中心仓库管理人员", "财务人员", "总经理"}));
		job.setBounds(149, 276, 123, 28);
		contentPane.add(job);
		
		JButton ensureAddUser = new JButton("确定");
		ensureAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserVO uservo=new UserVO(IDtext.getText(),passwordtext.getText(),nametext.getText(), job.getSelectedItem().toString());
				UserManage user=new UserManage();
				boolean addsucceed=false;
				try {							
						addsucceed = user.addUser(uservo);				
					}
				catch (Exception e) {
				}
				if(addsucceed==true){
					UserUI_addUser.this.dispose();
					JOptionPane.showMessageDialog(null, "该账户已成功生成!", "成功!", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "该账户名已存在！请重新输入一个新的账户名！", "失败!", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
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

