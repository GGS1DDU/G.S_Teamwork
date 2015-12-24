package elms.presentation.managerui.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import elms.businesslogic.managerbl.StaffManager;

import elms.presentation.managerui.staff.staffhelper.StaffList;


import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.TagPanel;
import elms.presentation.uihelper.UserInfo;

import elms.vo.StaffVO;
import elms.vo.UserVO;

public class StaffUI_main extends JFrame {

	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;
	
	private UserVO uservo;

	private Dimension d1;
	private Dimension d2;

//	private StaffListPanel staffPanel;
	private StaffList staffList;
	private JPanel user;
//	private StaffButtonPanel buttonPanel;
	private JPanel initSelect;
	private JPanel bp;
	private JButton add;
	private JButton delete;
	private JButton edit;
	private JButton find;
	private JButton back;
	private JButton editSalary;

	private JLabel jl1;// job

	private JComboBox<String> job;

	public static ArrayList<StaffVO> arr = new ArrayList<StaffVO>();

	private StaffManager sm = new StaffManager();
	
	public static String[] jobList = { "全部", "快递员", "中转中心仓库管理员", "中转中心业务员",
			"营业厅业务员", "财务人员", "总经理", "系统管理员" };

	public static void main(String[] args) {
		UserVO vo = new UserVO();
		JFrame jf = new StaffUI_main(vo);
		jf.setVisible(true);
	}

	public StaffUI_main(final UserVO uservo) {
		
		this.uservo = uservo;
		setLayout(null);
		setTitle("人员管理");
		setResizable(false);
		setSize(screenWidth / 2+200, 3 * screenHeight / 4 - 100);
		setLocation(screenWidth / 4, screenHeight / 8);
		d1 = new Dimension(this.getWidth(), this.getHeight() / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		user = new UserInfo(uservo);
		user.setBounds(0, 0, this.getWidth(), 25);
		add(user);

		initSelect = new TagPanel("初始化");
		initSelect.setBorder(BorderFactory.createRaisedBevelBorder());
		add(initSelect);
		initSelect.setBounds(70, user.getHeight(), 70, 25);

		staffList = new StaffList(d1,uservo);
		staffList.setLocation(0, 25);
		add(staffList);

		jl1 = new JLabel("职务:");
		jl1.setBounds(this.getWidth() - 200, d1.height + user.getHeight(), 50,
				30);
		add(jl1);

		job = new JComboBox<String>(jobList);
		job.setBounds(jl1.getX() + jl1.getWidth(), jl1.getY(), 140, 30);
		add(job);
		
		job.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				staffList.removeAllData();
				arr = sm.findByJob(job.getSelectedItem().toString());
				staffList.addAllData(arr);
			}
		});


		addButton();
		addInitListener();
		// addActionListener();
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
		editSalary = new JButton("修改职位工资");
		
		add.setBounds(50, 30, 102, 30);
		delete.setBounds(200, 30, 104, 30);  
		edit.setBounds(350, 30, 102, 30);
		editSalary.setBounds(500,30,150,30);
		find.setBounds(700,15,80,30);  
		back.setBounds(700,55,80,30);
		
		bp.add(editSalary);
		bp.add(add);
		bp.add(delete);
		bp.add(edit);
		bp.add(find);
		bp.add(back);
		
		editSalary.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame editS = new StaffUI_editSalary(staffList);
				editS.setVisible(true);
			}
			
		});
		
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame add = new StaffUI_add(staffList);
				add.setVisible(true);
			}
			
		});
		
		delete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
//				JFrame findEx = new Expense_find(u_vo);
//				findEx.setVisible(true);
				staffList.removeData();
			}
			
		});
		
		edit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String id = staffList.getSelectedID();
				if (id == null) {
					JOptionPane.showMessageDialog(null, "请选择要修改的支出项!");
				} else {
					try {
						StaffVO staffvo = sm.findStaff(id);
						StaffUI_edit edit = new StaffUI_edit(staffList,staffvo);
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
				JFrame findframe = new StaffUI_find(staffList);
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
	
	private void addInitListener(){
		initSelect.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				initSelect.setBorder(BorderFactory.createLoweredBevelBorder());
				int a=(int)(Math.random()*1000);
		    	String s=a+"";
		    	
		    	String obj=JOptionPane.showInputDialog("请输入 验证码  "+a+" 确认初始化人员信息");
				if(obj.equals(s)){
				StaffUI_main.this.dispose();
				JFrame jf = new StaffUI_init(uservo);
				jf.setVisible(true);
				sm.initAll();
				
				}
				else  JOptionPane.showMessageDialog(null, "验证码错误！",null,0);
					}
			
		});
	}

	public void showList() {
		arr = sm.findByJob(job.getSelectedItem().toString());
		if (arr != null) {
			staffList.addAllData(arr);
		}
//		job.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO 自动生成的方法存根
//				staffList.removeAllData();
//				arr = sm.findByJob(job.getSelectedItem().toString());
//				staffList.addAllData(arr);
//			}
//		});
	}

}
