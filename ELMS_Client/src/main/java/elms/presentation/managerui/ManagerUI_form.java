package elms.presentation.managerui;

import elms.presentation.financeui.inAndEx.InAndEx_form;
import elms.vo.UserVO;

public class ManagerUI_form extends InAndEx_form{

	public ManagerUI_form(String time1, String time2, UserVO u_vo) {
		super(time1, time2, u_vo);
		// TODO 自动生成的构造函数存根
		this.remove(derive);
	}

	
}
