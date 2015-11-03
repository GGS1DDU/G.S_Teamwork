package ELMS.presentation.UserUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import ELMS.vo.UserVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserUI_ChangeUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton ensureChange;
	private JButton cancelChange;
	UserVO vo=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUI_ChangeUser frame = new UserUI_ChangeUser();
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
	public UserUI_ChangeUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("请输入需要更改的账户");
		label.setBounds(15, 43, 204, 27);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(263, 43, 247, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		ensureChange = new JButton("确定");
		ensureChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String ID=textField.getText();
				//将ID传给BL层,BL层回传该ID对应的USERVO
				
				vo=new UserVO("zwh","郑闻昊","111111","快递员");
				JFrame UserMessage=new UserUI_ChangeUser_message();
				UserMessage.setVisible(true);
				
			}
		});
		ensureChange.setBounds(403, 107, 112, 45);
		contentPane.add(ensureChange);
		
		cancelChange = new JButton("取消");
		cancelChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserUI_ChangeUser.this.dispose();
			}
		});
		cancelChange.setBounds(544, 107, 112, 45);
		contentPane.add(cancelChange);
	}
	
	public UserVO getMessage(){
		return vo;
	}

}
