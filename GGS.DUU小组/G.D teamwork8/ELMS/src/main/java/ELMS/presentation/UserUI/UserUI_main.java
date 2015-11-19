package ELMS.presentation.UserUI;

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

public class UserUI_main extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUI_main frame = new UserUI_main();
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
	public UserUI_main() {
		setRootPaneCheckingEnabled(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 457);
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
		adduser.setBounds(236, 44, 222, 58);
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
		changeUser.setBounds(236, 159, 222, 58);
		contentPane.add(changeUser);
		exitUserUI.setBounds(236, 271, 222, 58);
		contentPane.add(exitUserUI);
	}
}
