package elms.presentation.financeui.inAndEx;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;


import java.util.ArrayList;



import elms.businesslogic.financebl.inandex.StatisticManager;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.FExpenseVO;
import elms.vo.FIncomeVO;


public class InAndEx_form extends JFrame {


	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;

	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel start;
	private JLabel end;
	private JLabel part;
	
	
	private JTextField totalIn;
	private JTextField totalEx;
	private JTextField profit;
	
	private JButton derive;
	
	private ArrayList<FIncomeVO> incomeList;
	private ArrayList<FExpenseVO> expenseList;

	private StatisticManager sm = new StatisticManager();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InAndEx_form frame = new InAndEx_form("123","123");
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
	public InAndEx_form(String time1,String time2) {
		
		setTitle("统计报表");
		setLayout(null);
		setBounds(screenWidth/4, 1,screenWidth/2,screenHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		start = new JLabel(time1);
		end = new JLabel(time2);
		part = new JLabel("--");
		
		start.setBounds(this.getWidth()/2-140,0,130,30);
		end.setBounds(this.getWidth()/2+10,0,130,30);
		part.setBounds(start.getX()+130,start.getY(),130,30);
		add(start);
		add(end);
		add(part);
		
//		JButton test = new JButton("test");
//		test.setBounds(0,0,130,30);
//		add(test);
		
		Dimension d = new Dimension(this.getWidth(),this.getHeight()/3);
		InPanel income = new InPanel(d);
		income.setBackground(Color.WHITE);
		
		income.setLocation(0,30);
		add(income);
		
		
		jl1 = new JLabel("总收入");
		jl2 = new JLabel("总支出");
		jl3 = new JLabel("总利润");
		
		
		jl1.setBounds(this.getWidth()*3/4-50,30+(int)d.getHeight(),50,30);
		jl2.setBounds(this.getWidth()*3/4-50,jl1.getHeight()+(int)d.getHeight()*2+35,50,30);
		jl3.setBounds(this.getWidth()*3/4-50,this.getHeight()-140,50,30);
		add(jl1);
		add(jl2);
		add(jl3);
		
		
		ExPanel expense = new ExPanel(d);
		expense.setLocation(0,310);
		add(expense);
		
		incomeList = sm.getIncome(time1, time2);
		expenseList = sm.getExpense(time1, time2);
		
		double inAmount = sm.getTotalIn(incomeList);
		double exAmount = sm.getTotalEx(expenseList);
		
		if(incomeList!=null){
			income.appendText(incomeList);
		}
		if(expenseList!=null){
			expense.appendText(expenseList);
		}
		
		totalIn = new JTextField();
		totalIn.setBounds(jl1.getX()+jl1.getWidth(),jl1.getY(),140,30);
		totalIn.setText(""+inAmount);
		totalIn.setEditable(false);
		add(totalIn);
		
		totalEx = new JTextField();
		totalEx.setBounds(jl2.getX()+jl2.getWidth(),jl2.getY(),140,30);
		totalEx.setText(""+exAmount);
		totalEx.setEditable(false);
		add(totalEx);
		
		profit  = new JTextField();
		profit.setBounds(jl3.getX()+jl3.getWidth(),jl3.getY(),140,30);
		profit.setText(""+(inAmount-exAmount));
		profit.setEditable(false);
		add(profit);
		
		derive = new JButton("导出报表");
		derive.setBounds(150,jl3.getY(),140,30);
		add(derive);
	}
	
	
		
	
}
