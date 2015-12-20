package elms.presentation.managerui.staff.staffhelper;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import elms.presentation.managerui.staff.StaffUI_editSalary;
import elms.presentation.managerui.staff.StaffUI_find;
import elms.presentation.managerui.staff.StaffUI_add;
import elms.presentation.uihelper.ButtonPanel;
import elms.vo.UserVO;

public class StaffButtonPanel extends ButtonPanel{

	public StaffButtonPanel(Dimension d,UserVO vo) {
		super(d);
		// TODO 自动生成的构造函数存根
		find.setText("修改职务工资");
		find.setSize(120,30);
		addActionListener();
	}
	
	public JButton getRefreshButton(){
		return this.refresh;
	}
	
	public JButton getBackButton(){
		return this.back;
	}
	
	public JButton getAddButton(){
		return this.add;
	}
	
	public JButton getDeleteButton(){
		return this.delete;
	}
	
	private void addActionListener(){
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
		
		find.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFrame edit = new StaffUI_editSalary();
				edit.setVisible(true);
			}
			
		});
	}

}
