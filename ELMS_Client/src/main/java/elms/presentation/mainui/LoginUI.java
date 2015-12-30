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

import elms.presentation.dealui.DealUI_Main;

import elms.presentation.dealui.DealUI_trackMessage;
import elms.presentation.financeui.FinanceUI_main;
import elms.presentation.invoiceui.InvoiceUI_ZZZXStaff;
import elms.presentation.managerui.ManagerUI_main;
import elms.presentation.storageui.Storage_main;

import elms.presentation.uihelper.MyButton;
import elms.presentation.uihelper.MyFrame;
import elms.presentation.uihelper.MyPanel;
import elms.presentation.uihelper.MyTextField;

import elms.presentation.userui.UserUI_AllUser;

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
	private MyButton login;

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
		setDefaultCloseOperation(3);
		MyButton logout = new MyButton();
		
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoginUI.this.dispose();
			}
		});
		logout.setBounds(600, 439, 100, 100);
		logout.setIcon("out.png");
		logout.setRolloverIcon("out1.png");
		
		contentPane.add(logout);

		JLabel welcome = new JLabel("Express Logistics Management System");
		welcome.setFont(new Font("Vladimir Script", Font.BOLD, 48));
		welcome.setForeground(Color.white);
		welcome.setBounds(120, 51, 800, 140);
		contentPane.add(welcome);

		JLabel ID = new JLabel("账户");
		ID.setForeground(Color.WHITE);
		ID.setFont(new Font("宋体", Font.PLAIN, 20));
		ID.setBounds(240, 224, 40, 30);
		contentPane.add(ID);

		JLabel pw = new JLabel("密码");
		pw.setForeground(Color.white);
		pw.setFont(new Font("宋体", Font.PLAIN, 20));
		pw.setBounds(240, 315, 40, 21);
		contentPane.add(pw);

		IDtext = new MyTextField();

//		IDtext.setForeground(Color.WHITE);

		IDtext.setBounds(360, 224, 239, 30);
		contentPane.add(IDtext);
		IDtext.setColumns(10);

		pwtext = new JPasswordField();
		pwtext.setFont(new Font("宋体", Font.PLAIN, 20));
		pwtext.setBounds(360, 310, 239, 30);
		contentPane.add(pwtext);
		pwtext.setColumns(10);

	}

	private void Login() {

		login = new MyButton();

		login.setBounds(200, 439, 110,110);
		login.setIcon("01.png");
		login.setRolloverIcon("02.png");
		
		contentPane.add(login);
		login.addMouseListener(new MouseAdapter() {
	
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
				
				if(n==999){
					JOptionPane.showMessageDialog(null, "服务器连接异常,请检查网络设置！", "失败!", JOptionPane.ERROR_MESSAGE);
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
					JFrame jframe = new UserUI_AllUser();
					jframe.setVisible(true);
					LoginUI.this.dispose();
				}
				if (n == 2) {
					JFrame dm = new DealUI_Main(vo);
					dm.setVisible(true);
					LoginUI.this.dispose();
					// 快递员，进入DealUI_main界面
				}
				if (n == 3) {

				}
				if(n==4){
					JFrame iz=new InvoiceUI_ZZZXStaff(vo);
					iz.setVisible(true);
					LoginUI.this.dispose();
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
