package elms.presentation.financeui.inAndEx.income;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;










import elms.businesslogic.financebl.inandex.IncomeManager;
import elms.presentation.uihelper.TagPanel;
import elms.vo.FIncomeVO;
import elms.vo.UserVO;

public class Income_main extends JPanel{

	
	private JButton add;
	private JButton delete;
	private JButton findByTime;
	private JButton refresh;
	private JButton back;

	

	private JLabel jl3;
	
	private JPanel findInfo;
	private JPanel info;
	
	private JTextArea text;

	private JComboBox<String> hall;
	
	public static ArrayList<FIncomeVO> arr = new ArrayList<FIncomeVO>();
	
	
	IncomeManager im= new IncomeManager();
	UserVO vo;
	
	public Income_main(Dimension d,final UserVO vo){
		this.vo = vo;
		
		setSize(d.width,d.height-25);

		setLayout(null);
		setVisible(true);
		
		info = new TagPanel("收入清单");
		info.setBounds(0, 23, 70, 25);
		
		JPanel info2=new JPanel();
		info2.setLayout(null);
		info2.setBackground(Color.white);
		info2.setBounds(30,80,this.getWidth()-80,this.getHeight()/2-70);
		text=new JTextArea(10,10);
		
		text.setEditable(false);
		text.setFont(new Font("Serif",Font.PLAIN,14));
	    
		JScrollPane scrollpane=new JScrollPane(text);
		info2.add(scrollpane);
		scrollpane.setBounds(0,0,this.getWidth()-80,this.getHeight()/2-70);
		scrollpane.setBackground(Color.white);
		
		JMenuBar jbar = new JMenuBar();
		class Menu extends JMenu{
			public Menu(String s){
				super(s);
				this.setFont(new Font("楷体",Font.CENTER_BASELINE,14));
			}
		}  
		JMenu j1 = new Menu("   ID      "); JMenu j2 = new Menu("    收入记录时间       "); JMenu j3 = new Menu("   收入金额     ");
		JMenu j4 = new Menu("   收入营业厅      ");JMenu j5 = new Menu(" 记录人员    ");JMenu j6 = new Menu(" 入帐账户      ");
		jbar.add(j1); jbar.add(j2); jbar.add(j3); jbar.add(j4); jbar.add(j6); jbar.add(j5);
		jbar.setBounds(30,55,this.getWidth()-80,25);
		add(jbar);
		add(info2);
		
		findInfo = new JPanel();
		findInfo.setBounds(0, d.height-275, d.width, 30);
		findInfo.setLayout(null);
		add(findInfo);
		

		jl3 = new JLabel("收入营业厅"); jl3.setBounds(390,0,70,30);
		
		
		String[] hallList = {"全部","南京市鼓楼营业厅","南京市仙林营业厅"};
		hall = new JComboBox<String>(hallList);
		hall.setBounds(460,0,140,30);

		findInfo.add(jl3);
		findInfo.add(hall);
		
		show("全部");
		
		hall.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				String sHall = hall.getSelectedItem().toString();
				
				show(sHall);
			}
			
		});
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0,50,d.width,d.height/2);
		scroll.setBackground(Color.WHITE);
		add(scroll);
		
		//buttonpanel  用来放各种按钮
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		add = new JButton("新建");
		delete = new JButton("更改/删除");
		findByTime = new JButton("收入项查询");
		refresh = new JButton("刷新");refresh.setForeground(Color.GREEN);
		back = new JButton("返回");back.setForeground(Color.red);
		buttonPanel.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);

				
		add.setBounds(50, 30, 102, 30);delete.setBounds(200, 30, 104, 30);  findByTime.setBounds(350, 30, 102, 30);
		   refresh.setBounds(560,15,80,30);  back.setBounds(560,55,80,30);
		buttonPanel.add(add); buttonPanel.add(delete); buttonPanel.add(findByTime); 
		buttonPanel.add(refresh); buttonPanel.add(back);
		add(buttonPanel);
		addActionListener();
				
		
		add(info);
		
	}
	
	
	private void addActionListener(){
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame j_add = new Income_add(vo);
				j_add.setVisible(true);
			}
			
		});
		delete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame j_find = new Income_find(vo);
				j_find.setVisible(true);
			}
			
		});
		findByTime.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame find_time = new Income_findTime(hall.getSelectedItem().toString());
				find_time.setVisible(true);
			}
			
		});
		refresh.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				text.setText("");
				for(FIncomeVO in_vo:arr){
					text.append(getOutput(in_vo));
				}
			}
			
		});
		
	}
	
	private void show(String choose){
		if(choose.equals("全部")){
			arr = im.inquiryAll();
			text.setText("");
			for(FIncomeVO in_vo:arr){
				
				text.append(getOutput(in_vo));
			}
		}else{
			arr = im.inquiryIncomeByHall(choose);
			text.setText("");
			for(FIncomeVO in_vo:arr){
				
				text.append(getOutput(in_vo));
			}
		}
	}
	
	private String getOutput(FIncomeVO vo){
		String result = " "+vo.getID()+"   "+vo.getTime()+"            "+vo.getIncome()+"             "+vo.getShop()+
				"     "+
				vo.getBankAccountName()+"         "+vo.getClerk()+"\r\n";
		return result;
	}
	

	
	
}
