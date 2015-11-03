package ELMS.presentation.UserUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ELMS.vo.UserVO;

public class UserUI_ChangeUser_message extends JFrame {

	private JPanel UserMessage;
	UserVO vo=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUI_ChangeUser_message frame = new UserUI_ChangeUser_message();
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
	public UserUI_ChangeUser_message() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 479);
		UserMessage = new JPanel();
		UserMessage.setBorder(new EmptyBorder(5, 5, 5, 5));
		UserMessage.setLayout(new BorderLayout(0, 0));
		setContentPane(UserMessage);
		
	}

}
