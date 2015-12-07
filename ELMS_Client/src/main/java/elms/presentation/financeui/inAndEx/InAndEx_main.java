package elms.presentation.financeui.inAndEx;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import elms.presentation.financeui.inAndEx.expense.Expense_main;
import elms.presentation.financeui.inAndEx.income.Income_main;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.UserInfo;
import elms.vo.UserVO;

public class InAndEx_main extends JFrame{

	int screenWidth = ScreenSize.screenWidth;
	int screenHeight = ScreenSize.screenHeight;
	Dimension d;
	
	
	JPanel income_p;
	JPanel expense_p;
	JPanel static_p;
//	JPanel contentPane;
	
	
	JMenu income_m;
	JMenu expense_m;
	JMenu static_m;
	
	JMenuBar bar;
	
	public static void main(String[] args){
		UserVO vo = new UserVO();
		JFrame im = new InAndEx_main(vo);
	}
	
	public InAndEx_main(final UserVO vo){
		setLayout(null);
		setTitle("收支管理");
		setResizable(false);
		setSize(screenWidth/2,3*screenHeight/4);
		setLocation(screenWidth/4, screenHeight/8);
		d = new Dimension(this.getWidth(),this.getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		contentPane = new JPanel();
//		contentPane.setBounds(0, 0, this.getWidth(), this.getHeight());
//		add(contentPane);
		
		JPanel user = new UserInfo(vo);
		user.setBounds(0, 0, this.getWidth(), 25);
		add(user);
		
		//账户管理和初始化的表头（选择）
		bar = new JMenuBar();
		income_m = new JMenu("收入管理");
		income_m.setSelected(true);
		income_m.setEnabled(false);
		expense_m = new JMenu("支出管理");
		static_m = new JMenu("统计数据");
		
		bar.add(income_m);
		bar.add(expense_m);
		bar.add(static_m);
		setJMenuBar(bar);
		
		income_p = new Income_main(d,vo);
		income_p.setLocation(0,25);
		income_p.setVisible(true);
		add(income_p);
		
		expense_p = new Expense_main(d,vo);
		expense_p.setLocation(0,25);
		expense_p.setVisible(true);
//		add(expense_p);
		validate();
		repaint();
		
		income_m.addMenuListener(new MenuListener(){

			public void menuCanceled(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			public void menuDeselected(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			public void menuSelected(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				income_m.setSelected(true);
				income_m.setEnabled(false);
//				expense_p.setVisible(false);
				remove(expense_p);
				expense_m.setEnabled(true);
//				income_p.setVisible(true);
				add(income_p);
				
				revalidate();
				repaint();
			}
			
		});
		
		expense_m.addMenuListener(new MenuListener(){

			public void menuCanceled(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void menuDeselected(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void menuSelected(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				income_m.setSelected(false);
				expense_m.setSelected(true);
				income_m.setEnabled(true);
				expense_m.setEnabled(false);

				remove(income_p);
				add(expense_p);
//				income_p.setVisible(false);
//				expense_p.setVisible(true);
				
				revalidate();
				repaint();
				
				
			}
			
		});
		
		static_m.addMenuListener(new MenuListener(){

			@Override
			public void menuCanceled(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void menuDeselected(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void menuSelected(MenuEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame time = new InAndEx_findTime();
				time.setVisible(true);
				//为什么输入时建的窗口刚刚建出来的时候总是在这个窗口的下面？
			}
			
		});
		setVisible(true);
		
		
	}
}
