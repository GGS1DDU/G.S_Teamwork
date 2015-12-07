package elms.presentation.uihelper;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * ...宝宝现在觉得这个东西没用了
 */
public class ButtonPanel extends JPanel {

	protected JButton add;
	protected JButton delete;
	protected JButton find;
	protected JButton refresh;
	protected JButton back;

	public ButtonPanel(Dimension d) {

		setSize(d.width, d.height);
		setLayout(null);

		add = new JButton("新建");
		delete = new JButton("更改/删除");
		find = new JButton("查询");
		refresh = new JButton("刷新");
		refresh.setForeground(Color.GREEN);
		back = new JButton("返回");
		back.setForeground(Color.red);

		add.setBounds(50, 30, 102, 30);
		delete.setBounds(200, 30, 104, 30);
		find.setBounds(350, 30, 102, 30);
		refresh.setBounds(560, 15, 80, 30);
		back.setBounds(560, 55, 80, 30);

		add(add);
		add(delete);
		add(find);
		add(refresh);
		add(back);

	}
}
