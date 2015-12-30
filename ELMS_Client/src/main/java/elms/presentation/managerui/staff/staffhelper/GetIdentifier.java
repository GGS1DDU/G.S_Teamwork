package elms.presentation.managerui.staff.staffhelper;

public class GetIdentifier {

	public String getIdentifier(String job){
		String identify = null;
		
		if(job.equals("全部")){
			
		}else if(job.equals("快递员")){
			identify = "kd";
		}else if(job.equals("中转中心仓库管理员")){
			identify = "zc";
		}else if(job.equals("中转中心业务员")){
			identify = "zy";
		}else if(job.equals("营业厅业务员")){
			identify = "yy";
		}else if(job.equals("财务人员")){
			identify = "cw";
		}else if(job.equals("总经理")){
			identify = "zj";
		}else if(job.equals("系统管理员")){
			identify = "xt";
		}
		
		return identify;
	}
}
