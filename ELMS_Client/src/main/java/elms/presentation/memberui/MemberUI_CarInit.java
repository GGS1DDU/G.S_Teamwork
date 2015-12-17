package elms.presentation.memberui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import elms.businesslogic.memberbl.CarBL;
import elms.presentation.invoiceui.InvoiceUI_YYTStaff;
import elms.presentation.invoiceui.InvoiceUI_YYTStaff_IL;
import elms.presentation.invoiceui.InvoiceUI_YYTStaff_LL;
import elms.presentation.invoiceui.InvoiceUI_YYTStaff_SL;
import elms.vo.CarVO;
import elms.vo.UserVO;

public class MemberUI_CarInit extends JFrame{
	Toolkit kit=Toolkit.getDefaultToolkit();
	Dimension screenSize=kit.getScreenSize();
	int screenWidth=(int) screenSize.getWidth();
	int screenHeight=(int)screenSize.getHeight();
	JTextArea text;
	
	CarBL cardata;
	
	static ArrayList<CarVO> arr=new ArrayList<CarVO>();
	
	public MemberUI_CarInit(final UserVO vo){
		setLayout(null);
		setTitle("车辆初始化");
		setResizable(false);
		setSize(screenWidth/2,screenHeight/2-60);
		setLocation(screenWidth/4, screenHeight/8);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar bar=new JMenuBar();
		JMenu m1=new JMenu("到达单管理");	
		JMenu m2=new JMenu("派件单管理");
		JMenu m3=new JMenu("装车单管理");
		JMenu m4=new JMenu("收款单管理");
		JMenu m5=new JMenu("车辆信息管理");		
		JMenu m6=new JMenu("司机信息管理");
		JMenu m7=new JMenu("车辆初始化");
		m7.setSelected(true);m7.setEnabled(false);
		JMenu m8=new JMenu("司机初始化");
		
		bar.add(m1);
		bar.add(m2);
		bar.add(m3);
		bar.add(m4);
		bar.add(m5);
		bar.add(m6);
		bar.add(m7);
		bar.add(m8);
		
		setJMenuBar(bar);
		m1.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_CarInit.this.dispose();
				new InvoiceUI_YYTStaff(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m2.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_CarInit.this.dispose();
				new InvoiceUI_YYTStaff_SL(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m3.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_CarInit.this.dispose();
				new InvoiceUI_YYTStaff_LL(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m4.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_CarInit.this.dispose();
				new InvoiceUI_YYTStaff_IL(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m6.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_CarInit.this.dispose();
				new MemberUI_DriverMain(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		m8.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e) {
				MemberUI_CarInit.this.dispose();
				new MemberUI_DriverInit(vo);
			}
			public void menuDeselected(MenuEvent e) {			
			}
			public void menuCanceled(MenuEvent e) {		
			}		
		});
		
		JPanel info2=new JPanel();
		info2.setLayout(null);
		text=new JTextArea(10,10);
		text.setEditable(false);
		text.setFont(new Font("Serif",Font.PLAIN,14));
		
		JScrollPane scrollpane=new JScrollPane(text);
		info2.add(scrollpane);
		scrollpane.setBounds(5,70,this.getWidth()-40,this.getHeight()/2-70);
		
		JMenuBar jbar=new JMenuBar();
		class Menu extends JMenu{
			public Menu(String s){
				super(s);
				this.setFont(new Font("楷体",Font.CENTER_BASELINE,12));
			}
		}
		
		JMenu j1=new Menu("         车辆代号              ");JMenu j2=new Menu("           车牌号             ");JMenu j3=new Menu("         服役时间           ");
		jbar.add(j1);jbar.add(j2);jbar.add(j3);
		add(jbar);
		jbar.setBounds(5,48,this.getWidth(),20);
		add(info2);
		info2.setBounds(0,0,this.getWidth(),this.getHeight()/2);
		
		JButton add=new JButton("添加车辆");JButton delete=new JButton("删除车辆");JButton back=new JButton("返回");
		add(add);add.setBounds(screenWidth/12, screenHeight/4+20, 100, 28);
		add(delete);delete.setBounds(screenWidth/5, screenHeight/4+20, 100, 28);
		add(back);back.setBounds(screenWidth/3, screenHeight/4+20, 100, 28);
		
		add.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new MemberUI_CarNew();
			}
	    	
	    });
		delete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
			new MemberUI_CarFind();
				
			}
			
		});
		back.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});

	}
	

}
