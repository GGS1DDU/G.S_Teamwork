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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import elms.businesslogic.financebl.inandex.ExpenseManager;
import elms.presentation.financeui.inAndEx.income.Income_edit;
import elms.presentation.uihelper.CheckFormat;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.TagPanel;
import elms.presentation.uihelper.UserInfo;
import elms.vo.FExpenseVO;
import elms.vo.FIncomeVO;
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
	private JButton edit;
	private JButton find;
	private JButton back;
	
	private JComboBox<String> type;   //支出类型（人员工资（月，快递元提成，司机计次，业务员月薪），物流运费（次），租金（按年）
	
	private JLabel j1;//起始时间
	private JLabel j2;//结束时间
	
	private JTextField start;
	private JTextField end;
	
	private UserVO u_vo;
	
	private ExpenseManager em = new ExpenseManager();
	private ExpenseList exList;
	private CheckFormat check;
	
	public static ArrayList<FExpenseVO> arr;
	
	
	
	
	public Expense_main(Dimension d,UserVO u_vo){
		check = new CheckFormat();
		this.d = d;
		setSize(d.width,d.height-25);
		setLayout(null);
		this.u_vo = u_vo;
		
		bar = new JMenuBar();
		
		tag = new TagPanel("支出清单");
		tag.setBounds(0, 23, 70, 25);
		add(tag);
		
		addButton();
//		addMenu();
		addList();
		addTime();
		
		String startTime = start.getText();
		String endTime = end.getText();
		
		getShowList(startTime,endTime);
//		showList();
		
	}
	
	
	
	private void addButton(){
		bp = new JPanel();
		bp.setLayout(null);
		bp.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);
		add(bp);
		
		
		
		add = new JButton("新建");
		delete = new JButton("删除");
		edit = new JButton("更改");
		find = new JButton("查询");   
		back = new JButton("返回");      back.setForeground(Color.red);
		
		add.setBounds(50, 30, 102, 30);
		delete.setBounds(200, 30, 104, 30);  
		edit.setBounds(350, 30, 102, 30);
		find.setBounds(560,15,80,30);  
		back.setBounds(560,55,80,30);
		
		bp.add(add);
		bp.add(delete);
		bp.add(edit);
		bp.add(find);
		bp.add(back);
		
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame addEx = new Expense_add(exList,u_vo);
				addEx.setVisible(true);
			}
			
		});
		
		delete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
//				JFrame findEx = new Expense_find(u_vo);
//				findEx.setVisible(true);
				exList.removeData();
			}
			
		});
		
		edit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String id = exList.getSelectedID();
				if (id == null) {
					JOptionPane.showMessageDialog(null, "请选择要修改的支出项!");
				} else {
					try {
						FExpenseVO inVO = em.inquiryExpense(id);
						Expense_edit edit = new Expense_edit(exList,inVO, u_vo);
						edit.setVisible(true);
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

				}
			}
			
		});
		
		find.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame findframe = new Expense_find(exList,u_vo);
				findframe.setVisible(true);
			}
			
		});
		
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
		});
	}
	
	
	
	private void addList(){

		Dimension exD = new Dimension(d.width,d.height*2/3-100);
		exList = new ExpenseList(exD,u_vo);
		add(exList);
	}
	
	private void getShowList(String startTime,String endTime){
		if(startTime.length()<1&&endTime.length()<1){  //若开始和结束输入框中全为空，默认查询所有

			arr = em.inquiryAll();
		}else if(startTime.length()<1||endTime.length()<1){
			arr = em.inquiryAll();
		}else{
			
			arr = em.inquiryByTime(startTime, endTime);
		}
	}
	
	private void showList(){
		exList.removeAllData();
		if(arr==null){
			return;
		}
		for(int i = 0; i < arr.size(); i++){
			FExpenseVO vo = arr.get(i);
			exList.addData(vo);
		}
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
		
		//开始和结束时间的输入框中加监听，自动显示规定时间内的支出项
		start.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				if (start.getText().length() < 10) {
					return;
				}
				if (check.checkData("yyyy-MM-dd hh:mm:ss", end.getText())) {
					if (check.checkData("yyyy-MM-dd hh:mm:ss", start.getText())) {
						if (check.lessThan("yyyy-MM-dd hh:mm:ss", start.getText(),
								end.getText())) {
							getShowList(start.getText(), end.getText());
							showList();
						} else {
							JOptionPane
									.showMessageDialog(null, "开始时间必须小于结束时间！");
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"请在开始时间一栏中输入格式为yyyy-MM-dd hh:mm:ss格式的时间！");
					}
				} else {
					if (end.getText().length() < 1)
						JOptionPane.showMessageDialog(null,
								"请在结束时间一栏中输入格式为yyyy-MM-dd hh:mm:ss格式的时间!");
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				if (start.getText().length() < 10) {
					return;
				}
				if (check.checkData("yyyy-MM-dd hh:mm:ss", end.getText())) {
					if (check.checkData("yyyy-MM-dd hh:mm:ss", start.getText())) {
						getShowList(start.getText(), end.getText());
						showList();

					} else {
						JOptionPane.showMessageDialog(null,
								"请在开始时间一栏中输入格式为yyyy-MM-dd hh:mm:ss格式的时间！");
					}
				} else {
					// if(end.getText().length()<1)
					// JOptionPane.showMessageDialog(null,
					// "请在结束时间一栏中输入格式为yyyy-MM-dd格式的时间!");
				}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				arr = em.inquiryAll();
				showList();
			}
		});

		end.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				if (end.getText().length() != 10)
					return;
				if (check.checkData("yyyy-MM-dd hh:mm:ss", end.getText())) {
					if (check.checkData("yyyy-MM-dd hh:mm:ss", start.getText())) {
						if (check.lessThan("yyyy-MM-dd hh:mm:ss", start.getText(),
								end.getText())) {
							getShowList(start.getText(), end.getText());
							showList();
						} else {
							JOptionPane
									.showMessageDialog(null, "开始时间必须小于结束时间！");
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"请在开始时间一栏中输入格式为yyyy-MM-dd hh:mm:ss时间！");
					}
				} else {

					JOptionPane.showMessageDialog(null,
							"请在结束时间一栏中输入格式为yyyy-MM-dd hh:mm:ss时间!");
				}
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				if (end.getText().length() != 10)
					return;
				if (check.checkData("yyyy-MM-dd hh:mm:ss", end.getText())) {
					if (check.checkData("yyyy-MM-dd hh:mm:ss", start.getText())) {
						if (check.lessThan("yyyy-MM-dd hh:mm:ss", start.getText(),
								end.getText())) {
							getShowList(start.getText(), end.getText());
							showList();
						} else {
							JOptionPane
									.showMessageDialog(null, "开始时间必须小于结束时间！");
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"请在开始时间一栏中输入格式为yyyy-MM-dd hh:mm:ss时间！");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"请在结束时间一栏中输入格式为yyyy-MM-dd hh:mm:ss时间!");
				}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO 自动生成的方法存根
				arr = em.inquiryAll();
				showList();
			}

		});
	}
}
