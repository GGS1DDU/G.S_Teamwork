package elms.presentation.managerui.staff.staffhelper;

public class GetIdentifier {

	public String getIdentifier(String job){
		String identify = null;
		switch (job) {
		case "全部":
			break;
		case "快递员":
			identify = "kd";
			break;
		case "中转中心仓库管理员":
			identify = "zc";
			break;
		case "中转中心业务员":
			identify = "zy";
			break;
		case "营业厅业务员":
			identify = "yy";
			break;
		case "财务人员":
			identify = "cw";
			break;
		case "总经理":
			identify = "zj";
			break;
		case "系统管理员":
			identify = "xt";
			break;
		}
		return identify;
	}
}
