package elms.presentation.uihelper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import elms.vo.FExpenseVO;
import elms.vo.FinanceVO;

/*
 * 列表父类，根据dimension生成对应大小的list，可以继承修改其中的方法addtag和addMenu，
 * 私有方法addList给这个panel加一个有滚动条的textarea
 * 另外，要给每个子类都实现一个叫做appendText方法来给textArea中添加数据
 */

public class ListPanel extends JPanel {

	private Dimension d;

	private JScrollPane scroll;
	protected JTextArea text;    //用于供子类在text中添加信息

	private JMenuBar bar;

	private JPanel tag;
	private JPanel scrollP;

	public ListPanel(Dimension d) {
		setSize(d.width, d.height);
		setLayout(null);

		bar = new JMenuBar();

		addList();

	}

	protected void addTag(String s) {
		tag = new TagPanel(s);
		tag.setBounds(0, 0, 70, 25);
		add(tag);

	}

	protected void addMenu(String[] menuList) {
		class Menu extends JMenu {
			public Menu(String s) {
				super(s);
				this.setFont(new Font("楷体", Font.CENTER_BASELINE, 14));
			}
		}
		bar = new JMenuBar();

		for (int i = 0; i < menuList.length; i++) {
			JMenu jm = new Menu(menuList[i]);
			bar.add(jm);
		}
		bar.setBounds(0, 25, this.getWidth(), 25);

		add(bar);
	}

	private void addList() {
		text = new JTextArea(10, 10);
		text.setEditable(false);
		text.setFont(new Font("Serif", Font.PLAIN, 14));

		scrollP = new JPanel();
		scrollP.setLayout(null);
		scrollP.setBackground(Color.white);

		scrollP.setBounds(0, 50, this.getWidth(), this.getHeight());
		scroll = new JScrollPane(text);
		scrollP.add(scroll);
		scroll.setBounds(0, 0, this.getWidth(), this.getHeight());
		scroll.setBackground(Color.white);

		add(scrollP);
	}

}
