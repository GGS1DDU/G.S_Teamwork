package elms.presentation.managerui.staff;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import elms.businesslogic.managerbl.StaffManager;
import elms.presentation.managerui.staff.staffhelper.StaffList;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.UserInfo;
import elms.vo.StaffVO;
import elms.vo.UserVO;

public class StaffUI_init extends JFrame {

	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;

	private StaffList staffList;
	private UserVO uservo;
	private StaffManager sm = new StaffManager();

	public StaffUI_init(UserVO vo) {
		this.uservo = vo;
		setLayout(null);
		setTitle("员工初始化");
		setResizable(false);
		setSize(screenWidth / 2, screenHeight / 2 );
		setLocation(screenWidth / 4, screenHeight / 8);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel user = new UserInfo(vo);
		user.setBounds(0, 0, this.getWidth(), 25);
		add(user);

		Dimension d = new Dimension(this.getWidth(), this.getHeight() / 2+50);
		staffList = new StaffList(d, uservo);
		staffList.setLocation(0, 30);
		add(staffList);
		
		staffList.removeAllData();

		JButton add = new JButton("新建");
		JButton delete = new JButton("修改");
		JButton refresh = new JButton("刷新");
		JButton back = new JButton("返回");
		add(add);
		add.setBounds(this.getWidth() / 5 - 50, this.getHeight()*2 / 4 + 60, 100, 30);
		add(delete);
		delete.setBounds(this.getWidth() * 2 / 5 - 50, add.getY(), 100, 30);
		add(back);
		back.setBounds(this.getWidth() * 3 / 5 - 50, add.getY(), 100, 30);
		add(refresh);
		refresh.setBounds(this.getWidth() * 4 / 5 - 50, add.getY(), 100, 30);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame addFrame = new StaffUI_add(staffList);
				addFrame.setVisible(true);
			}

		});
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame find = new StaffUI_find(staffList);
				find.setVisible(true);
			}

		});
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				StaffUI_init.this.dispose();
			}

		});

		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				ArrayList<StaffVO> arr = sm.findByJob("全部");
				staffList.removeAllData();
				staffList.addAllData(arr);

			}

		});
	}
}
