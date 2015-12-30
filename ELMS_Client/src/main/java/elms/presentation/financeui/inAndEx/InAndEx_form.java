package elms.presentation.financeui.inAndEx;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;








import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;





import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.ArrayList;














import elms.businesslogic.financebl.inandex.StatisticManager;
import elms.presentation.financeui.inAndEx.expense.ExpenseList;
import elms.presentation.financeui.inAndEx.income.IncomeList;
import elms.presentation.uihelper.CheckFormat;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.FExpenseVO;
import elms.vo.FIncomeVO;
import elms.vo.UserVO;


public class InAndEx_form extends JPanel {


	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;

	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JTextField start;
	private JTextField end;
	private JLabel part;
	
	
	private JTextField totalIn;
	private JTextField totalEx;
	private JTextField profit;
	
	protected JButton derive;
	private JButton back;
	
	
	private ArrayList<FIncomeVO> incomeList;
	private ArrayList<FExpenseVO> expenseList;
	private IncomeList inPanel;
	private ExpenseList exPanel;
	private UserVO uservo;
	
	private String dateFormat;
	private CheckFormat check = new CheckFormat();

	private StatisticManager sm = new StatisticManager();

	/**
	 * Create the frame.
	 */
	public InAndEx_form(Dimension d,String time1,String time2,UserVO u_vo) {
		
		setLayout(null);
		
		setSize(d.width,d.height);
		setOpaque(false);
		
		start = new JTextField(time1);
		end = new JTextField(time2);
		part = new JLabel("--");
		dateFormat = "yyyy-MM-dd hh:mm:ss";
		start.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				if(!(check.checkData(dateFormat, start.getText())||check.checkData(dateFormat, end.getText()))){
					JOptionPane.showMessageDialog(null, "请输入格式为"+dateFormat+"的时间！");
					return;
				}else if(!check.lessThan(dateFormat, start.getText(), end.getText())){
					JOptionPane.showMessageDialog(null, "输入时间顺序错误！");
				}
				getShowList(start.getText(),end.getText());
				showList();
				
				double inAmount = sm.getTotalIn(incomeList);
				double exAmount = sm.getTotalEx(expenseList);
				
				totalIn.setText(""+inAmount);
				totalEx.setText(""+exAmount);
				profit.setText(""+(inAmount-exAmount));
				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
		
				if(!(check.checkData(dateFormat, start.getText())||check.checkData(dateFormat, end.getText()))){
					JOptionPane.showMessageDialog(null, "请输入格式为"+dateFormat+"的时间！");
					return;
				}else if(!check.lessThan(dateFormat, start.getText(), end.getText())){
					JOptionPane.showMessageDialog(null, "输入时间顺序错误！");
				}
				getShowList(start.getText(),end.getText());
				showList();
				double inAmount = sm.getTotalIn(incomeList);
				double exAmount = sm.getTotalEx(expenseList);
				
				totalIn.setText(""+inAmount);
				totalEx.setText(""+exAmount);
				profit.setText(""+(inAmount-exAmount));
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
			
		});
		
		end.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO 自动生成的方法存根
				getShowList(start.getText(),end.getText());
				showList();
				double inAmount = sm.getTotalIn(incomeList);
				double exAmount = sm.getTotalEx(expenseList);
				
				totalIn.setText(""+inAmount);
				totalEx.setText(""+exAmount);
				profit.setText(""+(inAmount-exAmount));
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO 自动生成的方法存根
				getShowList(start.getText(),end.getText());
				showList();
				double inAmount = sm.getTotalIn(incomeList);
				double exAmount = sm.getTotalEx(expenseList);
				
				totalIn.setText(""+inAmount);
				totalEx.setText(""+exAmount);
				profit.setText(""+(inAmount-exAmount));
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
		});
		start.setBounds(this.getWidth()/2-140,0,130,30);
		end.setBounds(this.getWidth()/2+10,0,130,30);
		part.setBounds(start.getX()+130,start.getY(),130,30);
		add(start);
		add(end);
		add(part);
		
//		JButton test = new JButton("test");
//		test.setBounds(0,0,130,30);
//		add(test);
		
		Dimension ind = new Dimension(this.getWidth(),this.getHeight()/3);
		inPanel = new IncomeList(ind,uservo);
		
		inPanel.setLocation(0,30);
		add(inPanel);
		
		
		jl1 = new JLabel("总收入");
		jl2 = new JLabel("总支出");
		jl3 = new JLabel("总利润");
		
		
		jl1.setBounds(this.getWidth()*3/4-50,(int)ind.getHeight(),50,30);
		jl2.setBounds(this.getWidth()*3/4-50,(int)ind.getHeight()*2,50,30);
		jl3.setBounds(this.getWidth()*3/4-50,this.getHeight()-140,50,30);
		add(jl1);
		add(jl2);
		add(jl3);
		
		
		exPanel = new ExpenseList(ind,uservo);
		exPanel.setLocation(0,this.getHeight()/2-100);
		add(exPanel);
		
		System.out.println(time2);
		incomeList = sm.getIncome(time1, time2);
		expenseList = sm.getExpense(time1, time2);
		
		double inAmount = sm.getTotalIn(incomeList);
		double exAmount = sm.getTotalEx(expenseList);
		
		if(incomeList!=null){
			inPanel.removeAllData();
			inPanel.addAllData(incomeList);
		}else{
			inPanel.removeAllData();
		}
		if(expenseList!=null){
			exPanel.removeAllData();
			exPanel.addAllData(expenseList);
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
		derive.setBounds(50,jl3.getY(),140,30);
		add(derive);
		
		back = new JButton("返回");
		back.setBounds(250, derive.getY(), 140, 30);
		add(back);
		
//		back.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO 自动生成的方法存根
//				InAndEx_form.this.dispose();
//			}
//			
//		});
	}
	
	//根据时间获取收入项信息
		private void getShowList(String startTime,String endTime){
//			if(startTime.length()<1&&endTime.length()<1){  //若开始和结束输入框中全为空，默认查询所有

				incomeList = sm.getIncome(startTime, endTime);
				expenseList = sm.getExpense(startTime, endTime);
//			}else if(startTime.length()<1||endTime.length()<1){
//				arr = im.inquiryAll();
//			}else{
//				String hallName = hall.getSelectedItem().toString();
//				if(hallName.equals("全部")){
//					arr = im.inquiryIncomeByTime(startTime, endTime);
//				}else{
//					arr = im.inquiryInByTimeHall(startTime, endTime,hallName );
//				}
				
//			}
		}
		
		private void showList(){
			inPanel.removeAllData();
			exPanel.removeAllData();
			if(incomeList==null||expenseList==null){
				return;
			}
			for(int i = 0; i < incomeList.size(); i++){
				FIncomeVO vo = incomeList.get(i);
				inPanel.addData(vo);
			}
			for(int i = 0; i < expenseList.size(); i++){
				FExpenseVO vo = expenseList.get(i);
				exPanel.addData(vo);
			}
		}
		
		
	
}
