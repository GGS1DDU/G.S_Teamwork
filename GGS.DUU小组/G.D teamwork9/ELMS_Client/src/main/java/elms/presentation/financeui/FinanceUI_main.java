package elms.presentation.financeui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.border.Border;

import elms.presentation.uihelper.UserInfo;
import elms.vo.UserVO;

/*
 * 主界面，负责对不同操作模块的选择
 */
public class FinanceUI_main extends JFrame {

	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int screenWidth = (int) screenSize.getWidth();
	int screenHeight = (int) screenSize.getHeight();

	public static void main(String[] args) {
		UserVO vo = new UserVO();
		JFrame fm = new FinanceUI_main(vo);
	}

	public FinanceUI_main(UserVO vo) {
		setLayout(null);
		setTitle("财务人员");
		setResizable(false);
		setSize(screenWidth / 2, 1 * screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 8);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel user = new UserInfo(vo);

		user.setBounds(0, 0, this.getWidth(), 25);

		Border li = BorderFactory.createEtchedBorder();
		Border t = BorderFactory.createTitledBorder(li);
		// Border l2=BorderFactory.createLoweredBevelBorder();
		user.setBorder(t);
		add(user);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(0, 25, this.getWidth(), this.getHeight() - 25);

		int bpwid = buttonPanel.getWidth();
		int bphet = buttonPanel.getHeight();

		JButton inAndEx_b = new JButton("收支管理");
		inAndEx_b.setBounds(bpwid / 5, bphet / 6, bpwid / 5, bphet / 6);
		inAndEx_b.setBackground(Color.WHITE);

		JButton bank_b = new JButton("银行账户管理");
		bank_b.setBounds(3 * bpwid / 5, bphet / 6, bpwid / 5, bphet / 6);
		bank_b.setBackground(Color.WHITE);

		JButton init_b = new JButton("期初建账");
		init_b.setBounds(bpwid / 5, bphet / 2, bpwid / 5, bphet / 6);
		init_b.setBackground(Color.WHITE);

		JButton log_b = new JButton("查看系统日志");
		log_b.setBounds(3 * bpwid / 5, bphet / 2, bpwid / 5, bphet / 6);
		log_b.setBackground(Color.WHITE);

		buttonPanel.add(inAndEx_b);
		buttonPanel.add(bank_b);
		buttonPanel.add(init_b);
		buttonPanel.add(log_b);
		add(buttonPanel);
	}
}
