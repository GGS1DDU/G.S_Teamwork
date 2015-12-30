package elms.presentation.financeui.inAndEx.expense;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import elms.businesslogic.financebl.inandex.ExpenseManager;
import elms.presentation.uihelper.CheckFormat;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.FExpenseVO;
import elms.vo.UserVO;

public class Expense_find extends JFrame {

	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;
	
	private JTextField id_f;
	private ExpenseManager em;
	private ExpenseList exList;
	private UserVO uservo;
	private CheckFormat check = new CheckFormat();

	public Expense_find(ExpenseList list, UserVO u_vo) {
		this.exList = list;
		this.uservo = u_vo;
		em = new ExpenseManager();
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(screenWidth / 4, screenHeight / 3, screenWidth / 2,
				screenHeight / 4);

		JLabel label = new JLabel("ID:");
		label.setBounds(this.getWidth() / 4, this.getHeight() / 5, 40, 30);
		label.setBackground(Color.BLACK);
		add(label);

		id_f = new JTextField();
		id_f.setBounds(this.getWidth() / 4 + 50, this.getHeight() / 5,
				this.getWidth() * 2 / 5, 30);
		// id.setVisible(true);
		add(id_f);

		JButton ensure = new JButton("确定");
		ensure.setBounds(this.getWidth() / 5, 3 * this.getHeight() / 5, 70, 20);

		ensure.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String id = id_f.getText();
				FExpenseVO e_vo = null;
				try {
					e_vo = em.inquiryExpense(id);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				// TODO 自动生成的方法存根
				if(!(check.checkID(id, "ex", 10))){
					JOptionPane.showMessageDialog(null, "请输入格式为ex加8位数字的ID！");
					return;
				}
				if (e_vo == null)
					JOptionPane.showMessageDialog(null, "系统中没有此支出项！，请重新输入");
				else {
					JFrame edit = new Expense_edit(exList, e_vo, uservo);
					edit.setVisible(true);
					Expense_find.this.dispose();
				}
			}

		});

		add(ensure);

		JButton back = new JButton("返回");
		back.setBounds(this.getWidth() * 3 / 5 + 50, 3 * this.getHeight() / 5,
				70, 20);
		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Expense_find.this.dispose();
			}

		});
		add(back);

		setVisible(true);
	}
}
