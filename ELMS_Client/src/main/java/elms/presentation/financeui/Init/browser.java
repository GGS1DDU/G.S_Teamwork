package elms.presentation.financeui.Init;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import elms.presentation.uihelper.UserInfo;
import elms.vo.AccountVO;
import elms.vo.UserVO;

public class browser extends JPanel {
	static ArrayList<AccountVO> arr = new ArrayList<AccountVO>();

	private JPanel user;
	private UserVO uservo;

	public browser(Dimension d, ArrayList<AccountVO> arr,UserVO uvo) {
		setLayout(null);
		setOpaque(false);
		setSize(d.width, d.height);
		
		uservo = uvo;
		user = new UserInfo(uservo);
		user.setBounds(0, 0, d.width, 25);
		add(user);
		
		JMenuBar jbar = new JMenuBar();
		JMenu j1 = new JMenu(
				"账目名                                               ");
		JMenu j2 = new JMenu("操作人员");
		JMenu j3 = new JMenu("操作时间                                  ");
		jbar.add(j1);
		jbar.add(j3);
		jbar.add(j2);
		add(jbar);
		jbar.setBounds(0, 25, this.getWidth(), 20);
		jbar.setFont(new Font("Serif", Font.PLAIN, 14));
		JTextArea text = new JTextArea(10, 10);
		text.setEditable(false);
		text.setFont(new Font("Serif", Font.PLAIN, 14));
		for (AccountVO vo : arr)
			text.append(vo.getName() + "                           "
					+ vo.getDate() + "                         "
					+ vo.getOperator() + "\n");

		JScrollPane scrollpane = new JScrollPane(text);
		add(scrollpane);
		scrollpane.setBounds(2, jbar.getY()+jbar.getHeight(), this.getWidth() - 8, this.getHeight() / 2);

		JButton back = new JButton("返回");
		add(back);
		back.setBounds(this.getWidth()/2-50, scrollpane.getHeight()+scrollpane.getY()+20, 100, 25);
		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}

		});
	}

}
