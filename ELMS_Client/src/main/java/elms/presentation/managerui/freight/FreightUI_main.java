package elms.presentation.managerui.freight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import elms.businesslogic.managerbl.FreightStrategyManager;

import elms.presentation.managerui.freight.freighthelper.FreightList;

import elms.presentation.uihelper.ScreenSize;

import elms.vo.FreightStrategyVO;
import elms.vo.UserVO;

public class FreightUI_main extends JFrame {

	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;
	private Dimension listD;


	private FreightList freightList;


	private JPanel bp;
	private JButton edit;
//	private JButton find;
	private JButton back;
	public static ArrayList<FreightStrategyVO> arr = new ArrayList<FreightStrategyVO>();
	
	private FreightStrategyManager fsm = new FreightStrategyManager();

	public static void main(String[] args) {
		UserVO vo = new UserVO("00000001","123123","张文玘","快递员");
		JFrame jf = new FreightUI_main(vo);
		jf.setVisible(true);
	}

	public FreightUI_main(UserVO u_vo) {
		arr = fsm.findAll();
		
		setLayout(null);
		setTitle("运费策略");
		setResizable(false);
		setSize(screenWidth / 2, screenHeight / 2 + 100);
		setLocation(screenWidth / 4, screenHeight / 8);
		listD = new Dimension(this.getWidth() - 50, this.getHeight() * 2 / 3);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		FreightListPanel fListPanel = new FreightListPanel(listD);
//		fListPanel.setLocation(25, 0);
//		add(fListPanel);
		freightList = new FreightList(listD,u_vo);
		freightList.setLocation(25,0);
		add(freightList);
		
//		ArrayList<FreightStrategyVO> list = fsm.findAll();
//		if(list!=null)
		freightList.addAllData(arr);

//		buttonD = new Dimension(this.getWidth(), this.getHeight() / 3);
//		JPanel buttonPanel = new FreightButton(buttonD);
//		buttonPanel.setLocation(0, this.getHeight() * 2 / 3);
//		add(buttonPanel);
		addButtons();

	}
	
	private void addButtons(){
		bp = new JPanel();
		bp.setLayout(null);
		bp.setBounds(0,this.getHeight()/2+100,this.getWidth()-30,90);
		add(bp);
		
		
		
//		add = new JButton("新建");
//		delete = new JButton("删除");
		edit = new JButton("更改");
//		find = new JButton("查询");   
		back = new JButton("返回");      back.setForeground(Color.red);
		
//		add.setBounds(50, 30, 102, 30);
//		delete.setBounds(200, 30, 104, 30);  
		edit.setBounds(bp.getWidth()/5, 30, 102, 30);
//		find.setBounds(bp.getWidth()*2/5,30,100,30);  
		back.setBounds(bp.getWidth()*3/5,30,100,30);
		
//		bp.add(add);
//		bp.add(delete);
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
				
			}
			
		});
	}
//	private void add(){
//		
//	}

}
