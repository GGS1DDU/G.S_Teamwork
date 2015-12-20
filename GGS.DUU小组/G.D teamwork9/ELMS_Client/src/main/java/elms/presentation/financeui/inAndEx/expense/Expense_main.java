package elms.presentation.financeui.inAndEx.expense;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import elms.businesslogic.financebl.inandex.ExpenseManager;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.TagPanel;
import elms.presentation.uihelper.UserInfo;
import elms.vo.FExpenseVO;
import elms.vo.UserVO;

public class Expense_main extends JPanel{
	
	private Dimension d;

	private JScrollPane scroll;
	private JTextArea text;
	
	private JMenuBar bar;
	private JMenu jm1;  //id
	private JMenu jm2;  //支出时间
	private JMenu jm3;  //支出类型
	private JMenu jm4;  //支出金额
	private JMenu jm5;  //支出账户
	private JMenu jm6;  //实际支出人员
	private JMenu jm7;  //支出记录人员
	
	private JPanel bp;  //按钮存放panel
	private JPanel tag;
	private JPanel scrollP;
	private JPanel findInfo;
	
	private JButton add;
	private JButton delete;
	private JButton find;
	private JButton refresh;
	private JButton back;
	
	private JComboBox<String> type;   //支出类型（人员工资（月，快递元提成，司机计次，业务员月薪），物流运费（次），租金（按年）
	
	private JLabel j1;//起始时间
	private JLabel j2;//结束时间
	
	private JTextField start;
	private JTextField end;
	
	private UserVO u_vo;
	
	private ExpenseManager em = new ExpenseManager();
	
	public static ArrayList<FExpenseVO> arr;
	
	
	
	
	public Expense_main(Dimension d,UserVO u_vo){
		this.d = d;
		setSize(d.width,d.height-25);
		setLayout(null);
		this.u_vo = u_vo;
		
		bar = new JMenuBar();
		
		tag = new TagPanel("支出清单");
		tag.setBounds(0, 23, 70, 25);
		add(tag);
		
		addButton();
		addMenu();
		addList();
		addTime();
		
		String startTime = start.getText();
		String endTime = end.getText();
		
		getShowList(startTime,endTime);
		showList();
		
	}
	
	
	
	private void addButton(){
		bp = new JPanel();
		bp.setLayout(null);
		bp.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);
		add(bp);
		
		
		
		add = new JButton("新建");
		delete = new JButton("更改/删除");
		find = new JButton("查询");
		refresh = new JButton("刷新");   refresh.setForeground(Color.GREEN);
		back = new JButton("返回");      back.setForeground(Color.red);
		
		add.setBounds(50, 30, 102, 30);
		delete.setBounds(200, 30, 104, 30);  
		find.setBounds(350, 30, 102, 30);
		refresh.setBounds(560,15,80,30);  
		back.setBounds(560,55,80,30);
		
		bp.add(add);
		bp.add(delete);
		bp.add(find);
		bp.add(refresh);
		bp.add(back);
		
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame addEx = new Expense_add(u_vo);
				addEx.setVisible(true);
			}
			
		});
		
		delete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame findEx = new Expense_find(u_vo);
				findEx.setVisible(true);
			}
			
		});
		
		find.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				getShowList(start.getText(),end.getText());
				showList();
			}
			
		});
		
		refresh.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				getShowList(start.getText(),end.getText());
				showList();
			}
			
		});
		
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
		});
	}
	
	private void addMenu(){
		class Menu extends JMenu{
			public Menu(String s){
				super(s);
				this.setFont(new Font("楷体",Font.CENTER_BASELINE,14));
			}
		}
		bar = new JMenuBar();
		
		jm1 = new Menu("   ID   ");
		jm2 = new Menu("    支出记录时间 ");
		jm3 = new Menu("   支出类型 ");
		jm4 = new Menu("   支出金额 ");
		jm5 = new Menu(" 支出账户");
		jm6 = new Menu(" 实际支出人员");
		jm7 = new Menu(" 支出记录人员");
		bar.add(jm1);  bar.add(jm2);  bar.add(jm3);  bar.add(jm4);
		bar.add(jm5);  bar.add(jm6);  bar.add(jm7);
		bar.setBounds(10,50,this.getWidth()-20,25);

		
		add(bar);
	}
	
	private void addList(){
		text = new JTextArea(10,10);
		text.setEditable(false);
		text.setFont(new Font("Serif",Font.PLAIN,14));
	    
		scrollP = new JPanel();
		scrollP.setLayout(null);
		scrollP.setBackground(Color.white);
		
		scrollP.setBounds(10,80,this.getWidth()-20,this.getHeight()/2-70);
		scroll=new JScrollPane(text);
		scrollP.add(scroll);
		scroll.setBounds(0,0,this.getWidth()-20,this.getHeight()/2-70);
		scroll.setBackground(Color.white);
		
		add(scrollP);
	}
	
	private void getShowList(String startTime,String endTime){
		if(startTime.length()<1&&endTime.length()<1){  //若开始和结束输入框中全为空，默认查询所有

			arr = em.inquiryAll();
		}else if(startTime.length()<1||endTime.length()<1){
			
		}else{
			
			arr = em.inquiryByTime(startTime, endTime);
		}
	}
	
	private void showList(){
		text.setText("");
		if(arr==null){
			return;
		}
		for(int i = 0; i < arr.size(); i++){
			FExpenseVO vo = arr.get(i);
			text.append(getOutput(vo));
		}
	}
	
	private String getOutput(FExpenseVO vo){
		String s = " "+vo.getID()+"   "+vo.getTime()+"            "+vo.getCategory()+"                 "+vo.getExpense()+
				"        "+
				vo.getBankAccountName()+"      "+vo.getClerk()+"          "+vo.getAssistant()+"\r\n";
		return s;
	}
	
	private void addTime(){
		j1 = new JLabel("起始时间：");
		j2 = new JLabel("结束时间：");
		
		findInfo = new JPanel();
		findInfo.setBounds(0, d.height-275, d.width, 30);
		findInfo.setLayout(null);
		add(findInfo);
		
		j1.setBounds(findInfo.getWidth()/6,0,80,30);
		findInfo.add(j1);
		j2.setBounds(findInfo.getWidth()*3/6+10,0,80,30);
		findInfo.add(j2);
		
		//可以扩展，弹出一个日历的形式
		start = new JTextField();
		start.setBounds(j1.getX()+j1.getWidth(),0,140,30);
		findInfo.add(start);
		
		end = new JTextField();
		end.setBounds(j2.getX()+j2.getWidth(),0,140,30);
		findInfo.add(end);
		
		end.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");   	
					end.setText(sdf.format(new Date()));
				}
			}
		});
	}
}
