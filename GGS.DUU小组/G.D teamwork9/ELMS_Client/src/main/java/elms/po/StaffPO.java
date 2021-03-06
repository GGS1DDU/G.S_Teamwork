package elms.po;

import java.io.Serializable;

/*
 * 
 */
public class StaffPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3623957444911742971L;
	// 个人基本信息
	private String id; // 员工编号
	private String name; // 员工姓名
	private String age; // 出生年月
	private String idCard; // 身份证号码
	private boolean gender; // 性别 (true 男 false 女）
	private String address; // 家庭住址
	private String phoneNum; // 联系电话

	// 公司内部员工信息
	private String job; // 职位
	private double essentialSalary; // 基本工资
	private String salaryStrategy; // 工资计算方式（提成、按次、月薪）
	private double rate;            //各种工资计算方式下的数据信息（提成率，每次的单价，月薪模式下位0）
	private String organization; // 所属机构（总经理&财务人员：公司 营业厅业务员&快递员：营业厅
									// 中转中心业务员&中转中心仓库管理员：中转中心 系统管理员：公司）

	public StaffPO(String id, String name, String age, boolean gender,
			String idCard, String address, String phoneNum, String job,
			double essentialSalary, String salaryStrategy, double rate,String organization) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.idCard = idCard;
		this.address = address;
		this.phoneNum = phoneNum;
		this.job = job;
		this.essentialSalary = essentialSalary;
		this.salaryStrategy = salaryStrategy;
		this.rate = rate;
		this.organization = organization;
	}

	public StaffPO() {
		// TODO 自动生成的构造函数存根
	}
	
	public String getID(){
		return this.id;
	}

	public String getName(){
		return this.name;
	}
	
	public String getAge(){
		return this.age;
	}
	
	public boolean getGender(){
		return this.gender;
	}
	
	public String getIdCard(){
		return this.idCard;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getPhoneNum(){
		return this.phoneNum;
	}
	
	public String getJob(){
		return this.job;
	}
	
	public double getEssentialSalary(){
		return this.essentialSalary;
	}
	
	public String getSalaryStrategy(){
		return this.salaryStrategy;
	}
	
	public double getRate(){
		return this.rate;
	}
	
	public String getOrganization(){
		return this.organization;
	}

}
