package elms.presentation.mainui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import elms.businesslogic.dealbl.DealBL;
import elms.businesslogic.userbl.UserManage;
import elms.presentation.MyButton;
import elms.presentation.MyFrame;
import elms.presentation.MyPanel;
import elms.presentation.MyTextField;
import elms.presentation.dealui.DealUI_main;
import elms.presentation.dealui.DealUI_Search;
import elms.presentation.dealui.DealUI_trackMessage;
import elms.presentation.financeui.FinanceUI_main;
import elms.presentation.managerui.ManagerUI_main;
import elms.presentation.storageui.Storage_main;
import elms.presentation.userui.UserUI_main;
import elms.vo.DealVO;
import elms.vo.UserVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.RemoteException;

public class LoginUI extends MyFrame {

//	private JPanel contentPane;
	private JTextField IDtext;
	private JPasswordField pwtext;
	UserVO vo;
	private JButton login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		super("star.jpg");
		Login();
		
		JButton logout = new MyButton("退出",15);
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginUI.this.dispose();
			}
		});
		logout.setBounds(549, 439, 135, 47);
		contentPane.add(logout);

		JLabel welcome = new JLabel("欢迎使用快递物流管理系统");
		welcome.setFont(new Font("微软雅黑", Font.PLAIN, 48));
		welcome.setForeground(Color.white);
		welcome.setBounds(163, 51, 600, 126);
		contentPane.add(welcome);

		JLabel ID = new JLabel("账户");
		ID.setForeground(Color.WHITE);
		ID.setFont(new Font("宋体", Font.PLAIN, 20));
		ID.setBounds(211, 224, 40, 30);
		contentPane.add(ID);

		JLabel pw = new JLabel("密码");
		pw.setForeground(Color.white);
		pw.setFont(new Font("宋体", Font.PLAIN, 20));
		pw.setBounds(211, 315, 40, 21);
		contentPane.add(pw);

		IDtext = new MyTextField();

//		IDtext.setForeground(Color.WHITE);

		IDtext.setBounds(330, 224, 239, 30);
		contentPane.add(IDtext);
		IDtext.setColumns(10);

		pwtext = new JPasswordField();
		pwtext.setFont(new Font("宋体", Font.PLAIN, 20));
		pwtext.setBounds(330, 310, 239, 30);
		contentPane.add(pwtext);
		pwtext.setColumns(10);

	}

	private void Login() {

		login = new MyButton("登录",15);

		login.setBounds(196, 439, 135, 47);
		contentPane.add(login);
		login.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UserManage user = new UserManage();
				int n = 0;

				try {
					String s = new String(pwtext.getPassword());
					n = user.login(IDtext.getText(), s);
					vo = user.findUser(IDtext.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (n == -1) {
					JOptionPane.showMessageDialog(null, "您输入的密码错误，请重新输入",
							"失败!", JOptionPane.ERROR_MESSAGE);
				}
				if (n == -2) {
					JOptionPane.showMessageDialog(null, "该账户不存在", "失败!",
							JOptionPane.ERROR_MESSAGE);
				}

				if (n == 0) {

				}
				if (n == 1) {// 系统管理员 进入UserUI_main
					JFrame jframe = new UserUI_main();
					jframe.setVisible(true);
					LoginUI.this.dispose();
				}
				if (n == 2) {
					JFrame dm = new DealUI_main(vo);
					dm.setVisible(true);
					LoginUI.this.dispose();
					// 快递员，进入DealUI_main界面
				}
				if (n == 3) {

				}
				if (n == 5) {
					JFrame Storage_main = new Storage_main(vo);
					Storage_main.setVisible(true);
					LoginUI.this.dispose();
				}
				if (n == 6) {
					JFrame Finance_main = new FinanceUI_main(vo);
					Finance_main.setVisible(true);
					LoginUI.this.dispose();
				}
				if (n == 7) {
					JFrame Manager_main = new ManagerUI_main(vo);
					Manager_main.setVisible(true);
					LoginUI.this.dispose();
				}

			}
		});
	}
}
