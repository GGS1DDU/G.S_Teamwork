package elms.presentation.managerui.staff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import elms.businesslogic.financebl.InitAll;
import elms.businesslogic.managerbl.StaffManager;
import elms.presentation.JTabbedPanel;
import elms.presentation.MyButton;
import elms.presentation.managerui.ManagerUI_main;
import elms.presentation.managerui.staff.staffhelper.StaffList;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.TagPanel;
import elms.presentation.uihelper.UserInfo;
import elms.vo.StaffVO;
import elms.vo.UserVO;

public class StaffUI_main extends JPanel {

	private UserVO uservo;
	private boolean needInit = false;
	private Dimension d1;
	private Dimension d2;

	private StaffList staffList;
	// private JPanel user;
	private JPanel bp;
	private JTabbedPanel tabbedPane;
	private JPanel content;
	private JButton add;
	private JButton delete;
	private JButton edit;
	private JButton find;
	private JButton init;
	private JButton editSalary;
	private JButton finishInit;

	private JLabel jl1;// job
	private JLabel time;// 时间显示

	private JComboBox<String> job;

	public static ArrayList<StaffVO> arr = new ArrayList<StaffVO>();

	private StaffManager sm = new StaffManager();

	public static String[] jobList = { "全部", "快递员", "中转中心仓库管理员", "中转中心业务员",
			"营业厅业务员", "财务人员", "总经理", "系统管理员" };

	public StaffUI_main(Dimension d, final UserVO uservo) {

		setOpaque(false);
		this.uservo = uservo;
		setLayout(null);
		setSize(d.width, d.height);
		d1 = new Dimension(this.getWidth(), this.getHeight() / 2);

		// 账户管理和初始化的表头（选择）

		addTimer();

		tabbedPane = new JTabbedPanel();
		tabbedPane.setBounds(0, 30, d.width, d.height - 25 - time.getHeight());
		add(tabbedPane);

		content = new JPanel();
		content.setOpaque(false);
		content.setBounds(0, 0, tabbedPane.getWidth(), tabbedPane.getHeight());
		content.setLayout(null);
		add(content);

		tabbedPane.addTab("职工管理", content);

		staffList = new StaffList(d1, uservo);
		staffList.setLocation(0, 0);
		content.add(staffList);
		staffList.setOpaque(false);

		jl1 = new JLabel("职务:");
		jl1.setBounds(this.getWidth() - 250, d1.height, 50, 30);
		content.add(jl1);

		job = new JComboBox<String>(jobList);
		job.setBounds(jl1.getX() + jl1.getWidth(), jl1.getY(), 140, 30);
		content.add(job);

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
		// addInitListener();
		// addActionListener();
	}

	public JButton getInitButton(final Dimension bd, final int changedHeight) {
		init = new MyButton("初始化");
		init.setSize(bd);
		init.setForeground(Color.BLACK);
		init.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				init.setSize(bd.width, changedHeight);
				init.setForeground(Color.gray);

				int a = (int) (Math.random() * 1000);
				String s = a + "";

				String obj = JOptionPane.showInputDialog("请输入 验证码  " + a
						+ " 确认初始化人员信息");
				if (obj.equals(s)) {
					sm.initAll();
					staffList.removeAllData();
					JOptionPane.showMessageDialog(null, "开始初始化！");
					bp.add(finishInit);
					
					validate();
					repaint();

				} else
					JOptionPane.showMessageDialog(null, "验证码错误！", null, 0);
			}

		});
		return init;
	}

	private void addButton() {
		bp = new JPanel();
		bp.setLayout(null);
		bp.setBounds(0, this.getHeight() / 2 + 75, this.getWidth() - 30, 120);
		content.add(bp);
		bp.setOpaque(false);

		add = new JButton("新建");
		delete = new JButton("删除");
		edit = new JButton("更改");
		find = new JButton("查询");
		addFinishInit();

		// back.setForeground(Color.red);
		editSalary = new JButton("修改职位工资");

		add.setBounds(30, 60, 102, 30);
		delete.setBounds(150, 60, 104, 30);
		edit.setBounds(270, 60, 102, 30);
		editSalary.setBounds(390, 60, 150, 30);
		find.setBounds(570, 60, 80, 30);

		// back.setBounds(570, 55, 80, 30);

		bp.add(editSalary);
		bp.add(add);
		bp.add(delete);
		bp.add(edit);
		bp.add(find);
		// bp.add(back);

		editSalary.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame editS = new StaffUI_editSalary(staffList);
				editS.setVisible(true);
			}

		});

		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame add = new StaffUI_add(staffList);
				add.setVisible(true);
			}

		});

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				staffList.removeData();
			}

		});

		edit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String id = staffList.getSelectedID();
				if (id == null) {
					JOptionPane.showMessageDialog(null, "请选择要修改的支出项!");
				} else {
					try {
						StaffVO staffvo = sm.findStaff(id);
						StaffUI_edit edit = new StaffUI_edit(staffList, staffvo);
						edit.setVisible(true);
					} catch (Exception e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}

				}
			}

		});

		find.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame findframe = new StaffUI_find(staffList);
				findframe.setVisible(true);
			}

		});

	}

	private void addFinishInit() {
		finishInit = new JButton("完成初始化");
		finishInit.setBounds(300, 0, 100, 30);
//		bp.add(finishInit);

		finishInit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

				int a = (int) (Math.random() * 1000);
				String s = a + "";

				String obj = JOptionPane.showInputDialog("请输入 验证码  " + a
						+ " 确认完成人员初始化");
				if (obj.equals(s)) {
					
					InitAll ia=new InitAll();
					try {
						ia.setInitState(1);
						JOptionPane.showMessageDialog(null, "初始化结束！");
						bp.remove(finishInit);
					} catch (RemoteException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					

				} else {
					JOptionPane.showMessageDialog(null, "验证码错误！", null, 0);
				}
			}

		});
	}

	public void showList() {
		arr = sm.findByJob(job.getSelectedItem().toString());
		if (arr != null) {
			staffList.addAllData(arr);
		}
	}

	private void addTimer() {
		time = new JLabel("1", JLabel.CENTER);
		time.setFont(new Font("微软雅黑", Font.BOLD, 15));
		time.setBounds(0, this.getHeight() - 30, this.getWidth(), 30);
		add(time);
		Timer timer = new Timer(100, new ActionListener() {
			InitAll i = new InitAll();

			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				try {
					if (i.getInitState(1)) {
						needInit = true;
						time.setText("需要初始化！");
					
						
					} else {
						time.setText(sdf.format(new Date()));
//						bp.remove(finishInit);
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		
		timer.start();
	}

}
