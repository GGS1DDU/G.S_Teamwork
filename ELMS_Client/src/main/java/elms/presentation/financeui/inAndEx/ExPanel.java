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

import elms.presentation.uihelper.TagPanel;
import elms.vo.FExpenseVO;

public class ExPanel extends JPanel{
	
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

	public ExPanel(Dimension d){
		setSize(d.width,d.height);
		setLayout(null);
		
		bar = new JMenuBar();
		
		tag = new TagPanel("支出清单");
		tag.setBounds(0, 0, 70, 25);
		add(tag);
		
		addMenu();
		addList();
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
		bar.setBounds(0,25,this.getWidth()-20,25);

		
		add(bar);
	}
	
	private void addList(){
		text = new JTextArea(10,10);
		text.setEditable(false);
		text.setFont(new Font("Serif",Font.PLAIN,14));
	    
		scrollP = new JPanel();
		scrollP.setLayout(null);
		scrollP.setBackground(Color.white);
		
		scrollP.setBounds(0,50,this.getWidth(),this.getHeight());
		scroll=new JScrollPane(text);
		scrollP.add(scroll);
		scroll.setBounds(0,0,this.getWidth(),this.getHeight());
		scroll.setBackground(Color.white);
		
		add(scrollP);
	}
	
	private String getOutput(FExpenseVO vo){
		String s = " "+vo.getID()+"   "+vo.getTime()+"            "+vo.getCategory()+"                 "+vo.getExpense()+
				"        "+
				vo.getBankAccountName()+"      "+vo.getClerk()+"          "+vo.getAssistant()+"\r\n";
		return s;
	}
	
	public void appendText(ArrayList<FExpenseVO> ex){
		
		for(FExpenseVO vo:ex){
			text.append(getOutput(vo));
		}
	}
}
