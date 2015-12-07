package elms.presentation.financeui.inAndEx;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.xml.soap.Text;

import elms.presentation.uihelper.ListPanel;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.TagPanel;
import elms.vo.FIncomeVO;

public class InPanel extends ListPanel {

	private JPanel in_info;
	private JPanel in_info2;
	private JTextArea in_text;

	public InPanel(Dimension d) {
		super(d);
		// TODO 自动生成的构造函数存根
		addTag("收入清单");
		String[] incomeMenu = { "   ID      ", "    收入记录时间       ",
				"   收入金额     ", "   收入营业厅      ", " 记录人员    ", " 入帐账户      " };
		addMenu(incomeMenu);
	}

	public void appendText(ArrayList<FIncomeVO> in) {

		for (FIncomeVO vo : in) {
			in_text.append(getOutput(vo));
		}
	}

	private String getOutput(FIncomeVO vo) {
		String result = " " + vo.getID() + "   " + vo.getTime()
				+ "            " + vo.getIncome() + "             "
				+ vo.getShop() + "     " + vo.getBankAccountName()
				+ "         " + vo.getClerk() + "\r\n";
		return result;
	}
}
