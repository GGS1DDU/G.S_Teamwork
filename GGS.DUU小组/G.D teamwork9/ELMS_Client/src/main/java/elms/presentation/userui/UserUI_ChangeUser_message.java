package elms.presentation.userui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import elms.businesslogic.userbl.UserManage;
import elms.vo.UserVO;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserUI_ChangeUser_message extends JFrame {
	UserVO vo=null;
	private JButton deleteUser;
	private JTextField password;
	private JComboBox jobchoose;





	public UserUI_ChangeUser_message(UserVO VO){
		this.vo=VO;
		
		setDefaultCloseOperation(JFrame. HIDE_ON_CLOSE);
		setBounds(100, 100, 427, 443);
		JPanel UserMessage = new JPanel();
		UserMessage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(UserMessage);
		UserMessage.setLayout(null);
		
		JLabel ID = new JLabel("账户");
		ID.setBounds(39, 50, 36, 21);
		UserMessage.add(ID);
		
		JLabel IDmessage = new JLabel(vo.getId());
		IDmessage.setBounds(138, 50, 134, 21);
		UserMessage.add(IDmessage);
		
		JLabel PW = new JLabel("密码");
		PW.setBounds(39, 122, 41, 21);
		UserMessage.add(PW);
		
		JLabel name = new JLabel("姓名");
		name.setBounds(39, 195, 41, 21);
		UserMessage.add(name);
		
		JLabel namemessage = new JLabel(vo.getName());
		namemessage.setBounds(138, 195, 134, 21);
		UserMessage.add(namemessage);
		
		JLabel job = new JLabel("职务");
		job.setBounds(39, 271, 41, 21);
		UserMessage.add(job);
		
		JButton change = new JButton("修改信息");
		change.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserManage userbl=new UserManage();
				try {
					
					userbl.updateJob(vo.getId(),password.getText(),vo.getName(),jobchoose.getSelectedItem().toString());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "该账户信息已修改成功!", "成功!", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		change.setBounds(15, 344, 115, 29);
		UserMessage.add(change);
		
		deleteUser = new JButton("删除账户");
		deleteUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserManage user=new UserManage();
				UserVO uservo=new UserVO(vo.getId(),password.getText(),vo.getName(),jobchoose.getSelectedItem().toString());
				
				try {
					user.deleteUser(uservo);
					UserUI_ChangeUser_message.this.dispose();
					JOptionPane.showMessageDialog(null, "已成功删除该账户！", "成功!", JOptionPane.INFORMATION_MESSAGE);
				} catch (RemoteException e) {
					e.printStackTrace();
				}

				
			}
		});
		deleteUser.setForeground(new Color(255, 0, 51));
		deleteUser.setBackground(Color.WHITE);
		deleteUser.setBounds(145, 344, 115, 29);
		UserMessage.add(deleteUser);
		
		JButton btnNewButton_1 = new JButton("确定");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserUI_ChangeUser_message.this.dispose();
			}
		});
		btnNewButton_1.setBounds(276, 344, 115, 29);
		UserMessage.add(btnNewButton_1);
		
		password = new JTextField();
		password.setBounds(138, 119, 134, 21);
		password.setText(vo.getPassword());
		UserMessage.add(password);
		password.setColumns(10);
		
		jobchoose = new JComboBox();
		jobchoose.setModel(new DefaultComboBoxModel(new String[] {"快递员", "营业厅业务员", "中转中心业务员", "中转中心仓库管理人员", "财务人员", "总经理", "系统管理员"}));
		if(vo.getJob().equals("快递员")){
			jobchoose.setSelectedIndex(0);
		}
		if(vo.getJob().equals("营业厅业务员")){
			jobchoose.setSelectedIndex(1);
		}
		if(vo.getJob().equals("中转中心业务员")){
			jobchoose.setSelectedIndex(2);
		}
		if(vo.getJob().equals("中转中心仓库管理人员")){
			jobchoose.setSelectedIndex(3);
		}
		if(vo.getJob().equals("财务人员")){
			jobchoose.setSelectedIndex(4);
		}
		if(vo.getJob().equals("总经理")){
			jobchoose.setSelectedIndex(5);
		}
		if(vo.getJob().equals("系统管理员")){
			jobchoose.setSelectedIndex(6);
		}		
		jobchoose.setBounds(138, 268, 134, 24);
		UserMessage.add(jobchoose);
	}
}


		
		
		


