package elms.businesslogic.managerbl;

import java.util.ArrayList;

public class Auditing {

	ArrayList non_audit = new ArrayList();  //未审核通过的所有单据po
	
	public void addAudit(父类  po){
		non_audit.add(po);
	}
	
	
	public void audit(String id){
		//调用 设置通过 方法
	}
	
	public void no_Audit(String id){
		//调用 设置不通过 方法
	}
	
	public ArrayList getNon_audit(){
		return non_audit;
	}
}
