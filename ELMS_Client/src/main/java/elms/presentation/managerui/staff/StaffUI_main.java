package elms.presentation.managerui.staff;

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
import elms.businesslogic.storagebl.Storage;
import elms.presentation.managerui.staff.staffhelper.StaffButtonPanel;
import elms.presentation.managerui.staff.staffhelper.StaffPanel;
import elms.presentation.storageui.Storage_init;
import elms.presentation.storageui.Storage_main;
import elms.presentation.uihelper.ButtonPanel;
import elms.presentation.uihelper.ListPanel;
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

	private StaffPanel staffPanel;
	private JPanel user;
	private StaffButtonPanel buttonPanel;
	private JPanel initSelect;

	private JLabel jl1;// job

	private JComboBox<String> job;

	private ArrayList<StaffVO> arr = new ArrayList<StaffVO>();

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
		setSize(screenWidth / 2, 3 * screenHeight / 4 - 100);
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

		staffPanel = new StaffPanel(d1);
		staffPanel.setLocation(0, 25);
		add(staffPanel);

		jl1 = new JLabel("职务:");
		jl1.setBounds(this.getWidth() - 200, d1.height + user.getHeight(), 50,
				30);
		add(jl1);

		job = new JComboBox<String>(jobList);
		job.setBounds(jl1.getX() + jl1.getWidth(), jl1.getY(), 140, 30);
		add(job);

		showList();

		d2 = new Dimension(this.getWidth(), this.getHeight()
				- (user.getHeight() + staffPanel.getHeight() + job.getHeight()));
		buttonPanel = new StaffButtonPanel(d2, uservo);
		buttonPanel.setLocation(0, this.getHeight() - d2.height + 20);
		add(buttonPanel);

		JButton refresh = buttonPanel.getRefreshButton();
		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				showList();
			}

		});
		JButton back = buttonPanel.getBackButton();
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				StaffUI_main.this.dispose();
			}

		});

		addInitListener();
		// addActionListener();
	}
	
	private void addInitListener(){
		initSelect.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO 自动生成的方法存根
				initSelect.setBorder(BorderFactory.createLoweredBevelBorder());
				int a=(int)(Math.random()*1000);
		    	String s=a+"";
		    	
		    	String obj=JOptionPane.showInputDialog("请输入 验证码  "+a+" 确认初始化库存");
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
			staffPanel.appendText(arr);
		}
		job.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根

				arr = sm.findByJob(job.getSelectedItem().toString());
				staffPanel.appendText(arr);
			}
		});
	}

}
