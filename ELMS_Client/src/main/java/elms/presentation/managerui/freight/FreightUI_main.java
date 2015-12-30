package elms.presentation.managerui.freight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import elms.businesslogic.managerbl.FreightStrategyManager;
import elms.presentation.TimeLabel;
import elms.presentation.managerui.ManagerUI_main;
import elms.presentation.managerui.freight.freighthelper.FreightList;
import elms.presentation.uihelper.ScreenSize;
import elms.vo.FreightStrategyVO;
import elms.vo.UserVO;

public class FreightUI_main extends JPanel {

	private Dimension listD;


	private FreightList freightList;
	private UserVO uservo;


	private JPanel bp;
	private JButton edit;
	private JButton back;
	public static ArrayList<FreightStrategyVO> arr = new ArrayList<FreightStrategyVO>();
	
	private FreightStrategyManager fsm = new FreightStrategyManager();
	
	public FreightUI_main(Dimension d,UserVO u_vo) {
		arr = fsm.findAll();
		setOpaque(false);
		this.uservo = u_vo;
		
		setLayout(null);
		setSize(d.width,d.height);
		
	
		listD = new Dimension(this.getWidth() - 50, this.getHeight() * 2 / 3);
		freightList = new FreightList(listD,u_vo);
		freightList.setLocation(25,10);
		add(freightList);
		
		freightList.addAllData(arr);

		addButtons();

	}
	
		
		
	
	private void addButtons(){
		bp = new JPanel();
		bp.setLayout(null);
//		bp.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);
//		bp.setBackground(Color.black);
		bp.setBounds(0, freightList.getY()+freightList.getHeight(), this.getWidth()-30, 90);
		add(bp);
		bp.setOpaque(false);
		
		
		
//		add = new JButton("新建");
//		delete = new JButton("删除");
		edit = new JButton("更改");
//		find = new JButton("查询");   
		back = new JButton("返回");      back.setForeground(Color.red);
		
		edit.setBounds(bp.getWidth()/5, 30, 102, 30);
		back.setBounds(bp.getWidth()*3/5,30,100,30);
		
		bp.add(edit);
//		bp.add(find);
		bp.add(back);
		
//		add.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO 自动生成的方法存根
//				JFrame addEx = new Expense_add(exList,u_vo);
//				addEx.setVisible(true);
//			}
//			
//		});
		
//		delete.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO 自动生成的方法存根
////				JFrame findEx = new Expense_find(u_vo);
////				findEx.setVisible(true);
//				exList.removeData();
//			}
//			
//		});
		
		edit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String id = freightList.getSelectedID();
				if (id == null) {
					JOptionPane.showMessageDialog(null, "请选择要修改的支出项!");
				} else {
					try {
						FreightStrategyVO inVO = fsm.getFreightStrategy(id);
						FreightUI_change edit = new FreightUI_change(freightList,inVO);
						edit.setVisible(true);
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

				}
			}
			
		});
		
//		find.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO 自动生成的方法存根
////				JFrame findframe = new Expense_find(exList,u_vo);
////				findframe.setVisible(true);
//			}
//			
//		});
		
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame jf = new ManagerUI_main(uservo);
				jf.setVisible(true);
				
			}
			
		});
	}
//	private void add(){
//		
//	}

}
