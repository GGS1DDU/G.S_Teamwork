package elms.presentation.userui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import elms.businesslogic.userbl.UserManage;
import elms.vo.UserVO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.awt.Color;
/**
 * 
 * @author ZWH
 *
 */
public class UserUI_ChangeUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton ensureChange;
	private JButton cancelChange;
	UserVO vo=null;


	/** 
	 * Create the frame.
	 */
	public UserUI_ChangeUser() {
		Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		setDefaultCloseOperation(JFrame. HIDE_ON_CLOSE);
		setBounds((width-714)/2, (height-600)/2, 714, 222);
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
		ensureChange.setBackground(Color.WHITE);
		ensureChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserManage user=new UserManage();
				String ID=textField.getText();
				UserVO vo;
				try {
					vo = user.findUser(ID);
					if(vo==null){
						JOptionPane.showMessageDialog(null, "系统找不到该账户！", "失败!", JOptionPane.ERROR_MESSAGE);
					}
					else{
						
					JFrame UserMessage=new UserUI_ChangeUser_message(vo);
					UserMessage.setVisible(true);
					
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
							

				
			}
		});
		ensureChange.setBounds(403, 107, 112, 45);
		contentPane.add(ensureChange);
		
		cancelChange = new JButton("取消");
		cancelChange.setBackground(Color.WHITE);
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

