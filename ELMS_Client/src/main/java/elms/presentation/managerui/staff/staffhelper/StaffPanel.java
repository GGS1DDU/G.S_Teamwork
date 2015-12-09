package elms.presentation.managerui.staff.staffhelper;

import java.awt.Dimension;
import java.util.ArrayList;

import elms.presentation.uihelper.ListPanel;
import elms.vo.StaffVO;

public class StaffPanel extends ListPanel {

	public StaffPanel(Dimension d) {
		super(d);
		// TODO 自动生成的构造函数存根
		addTag("员工列表");
		String[] item = { "   员工id    ", "   姓名   ", " 性别 ", "   联系方式    ",
				" 身份 ", " 基本工资 ", "  薪水计算方式  " };
		addMenu(item);
	}

	private String getOutput(StaffVO vo) {
		String gender = null;
		if (vo.getGender()) {
			gender = "男";
		} else {
			gender = "女";
		}
		String s = vo.getID() + "                 " + vo.getName() + "                       " + gender + "           "
				+ vo.getPhoneNum() + "        " +vo.getJob()+"       "+ vo.getEssentialSalary() + "                       "
				+ vo.getSalaryStrategy()+"\r\n";
		return s;

	}
	
	public void appendText(ArrayList<StaffVO> staff){
		text.setText("");
		for(int i = 0; i < staff.size(); i++){
			StaffVO vo = staff.get(i);
			text.append(getOutput(vo));
		}
	}
	
//	public void clear(){
//		text.setText("");
//	}

}
