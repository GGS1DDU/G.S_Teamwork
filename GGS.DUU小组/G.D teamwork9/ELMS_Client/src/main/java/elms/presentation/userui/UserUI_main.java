package elms.presentation.userui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
public class UserUI_main extends JFrame {
	private JPanel contentPane;

	public UserUI_main() {
		setRootPaneCheckingEnabled(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame. HIDE_ON_CLOSE);
		setBounds(100, 100, 807, 557);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 
		JButton adduser = new JButton("新增用户");
		adduser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame addUser=new UserUI_addUser();
				addUser.setVisible(true);
			}
		});
		adduser.setBackground(Color.WHITE);
		adduser.setActionCommand("addUser");
		adduser.setBounds(276, 44, 222, 58);
		contentPane.add(adduser);
		
		JButton exitUserUI = new JButton("退出系统");
		exitUserUI.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				UserUI_main.this.dispose();
				
			}
		});
		exitUserUI.setBackground(Color.WHITE);
		exitUserUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton changeUser = new JButton("更改用户");
		changeUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFrame UserUI_ChangeUser=new UserUI_ChangeUser();
				UserUI_ChangeUser.setVisible(true);
				
			}
		});
		changeUser.setBackground(Color.WHITE);
		changeUser.setBounds(276, 166, 222, 58);
		contentPane.add(changeUser);
		exitUserUI.setBounds(276, 383, 222, 58);
		contentPane.add(exitUserUI);
		
		JButton ALLUSER = new JButton("查看所有账户");
		ALLUSER.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame UserUI_AllUser =new UserUI_AllUser();
			}
		});
		ALLUSER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ALLUSER.setBounds(276, 284, 222, 58);
		contentPane.add(ALLUSER);
	}
}

