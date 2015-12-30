package elms.presentation.financeui.inAndEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import elms.presentation.JTabbedPanel;
import elms.presentation.MyPanel;
import elms.presentation.financeui.FinanceUI_main;
import elms.presentation.financeui.inAndEx.expense.Expense_main;
import elms.presentation.financeui.inAndEx.income.IncomeList;
import elms.presentation.financeui.inAndEx.income.Income_main;
//import elms.presentation.financeui.inAndEx.income.Income_main;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.UserInfo;
import elms.vo.UserVO;

public class InAndEx_main extends JPanel{

	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	Dimension d;
	
	
	Income_main income_p;
	Expense_main expense_p;
	JPanel static_p;
//	JPanel contentPane;
//	JPanel contentPane;
	
	private JTabbedPanel tabbedPane;
	private JPanel content;
	
//	JMenu income_m;
//	JMenu expense_m;
//	JMenu static_m;
	UserVO uservo;
	
	public InAndEx_main(Dimension d,final UserVO vo){

		setLayout(null);
		uservo = vo;
		setSize(d.width,d.height);
//		setLocation(screenWidth/4, screenHeight/8);
//		d = new Dimension(this.getWidth(),this.getHeight());
		
		
		JPanel user = new UserInfo(vo);
		user.setBounds(0, 0, this.getWidth(), 25);
		user.setOpaque(false);
		add(user);
		
		content = new JPanel();
		content.setBounds(0, user.getHeight(), this.getWidth(), this.getHeight()-user.getHeight());
		content.setLayout(new BorderLayout());
		content.setOpaque(false);
		
//		content.setBackground(Color.black);
		add(content);
		//账户管理和初始化的表头（选择）
		
	
		
//		tabbedPane = new JTabbedPanel("star.jpg");
		tabbedPane = new JTabbedPanel();
		
		tabbedPane.setOpaque(false);
		tabbedPane.setSize(content.getWidth(),content.getHeight());
		
		content.add(tabbedPane,BorderLayout.CENTER);
		
		income_p = new Income_main(d,vo);
		
		income_p.setVisible(true);
		income_p.setOpaque(false);
	
		JButton in_back = income_p.getBackButton();
		addBackListener(in_back);
		tabbedPane.addTab("收入管理", income_p);
		
		expense_p = new Expense_main(d,vo);
		expense_p.setLocation(0,25);
		expense_p.setVisible(true);
		expense_p.setOpaque(false);
		tabbedPane.addTab("支出管理", expense_p);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		String endTime = sdf.format(new Date());
		static_p = new InAndEx_form(d,"2015-12-12 00:00:00",endTime,vo);
		static_p.setBounds(0, 25, d.width,d.height);
		tabbedPane.addTab("数据统计", static_p);
		
		JButton ex_back = expense_p.getBackButton();
		addBackListener(ex_back);

		validate();
		repaint();
		
		setVisible(true);
		
//		JButton back = income_p.getBackButton();
		
	}
	
	public void addBackListener(JButton back){
		back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame jf = new FinanceUI_main(uservo);
				jf.setVisible(true);
				
//				InAndEx_main.this.dispose();
			}
			
		});
	}
}
