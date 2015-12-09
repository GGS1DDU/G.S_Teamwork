package elms.presentation.managerui.staff;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import elms.businesslogic.managerbl.StaffManager;
import elms.presentation.managerui.staff.staffhelper.StaffPanel;
import elms.presentation.uihelper.ScreenSize;
import elms.presentation.uihelper.UserInfo;
import elms.vo.StaffVO;
import elms.vo.UserVO;

public class StaffUI_init extends JFrame{

	private int screenWidth = ScreenSize.screenWidth;
	private int screenHeight = ScreenSize.screenHeight;
	
	private StaffPanel staffList ;
	private StaffManager sm = new StaffManager();
	
	public StaffUI_init(UserVO vo){
		setLayout(null);
		setTitle("员工初始化");
		setResizable(false);
		setSize(screenWidth/2,screenHeight/2-60);
		setLocation(screenWidth/4, screenHeight/8);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel user = new UserInfo(vo);
		user.setBounds(0, 0, this.getWidth(),25);	
		add(user);
		
		Dimension d = new Dimension(this.getWidth(),this.getHeight()/2);
		staffList = new StaffPanel(d);
		staffList.setLocation(0,30);
		add(staffList);
		
		JButton add = new JButton("新建");
		JButton delete = new JButton("修改");
		JButton refresh = new JButton("刷新");
		JButton back = new JButton("返回");
		add(add);
		add.setBounds(this.getWidth()/5-10,screenHeight / 4 + 20,100,30);
		add(delete);
		delete.setBounds(this.getWidth()*2/5-10,add.getY(), 100, 30);
		add(back);
		back.setBounds(this.getWidth()*3/5-10,add.getY(), 100, 30);
		add(refresh);
		refresh.setBounds(this.getWidth()*4/5-10,add.getY(),100,30);
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame addFrame = new StaffUI_add();
				addFrame.setVisible(true);
			}
			
		});
		delete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				JFrame find = new StaffUI_find();
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
		
		refresh.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				ArrayList<StaffVO> arr = sm.findByJob("全部");
				
					staffList.appendText(arr);
				
			}
			
		});
	}
}
