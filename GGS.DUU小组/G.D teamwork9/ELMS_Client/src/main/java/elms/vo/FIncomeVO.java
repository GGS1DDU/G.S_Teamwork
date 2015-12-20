package elms.vo;



public class FIncomeVO{
	String bankAccountName;
	String id;
	String time;
	double income;
	String hall;//Ӫҵ����Ϣ��
	String clerk;
	
	public FIncomeVO(String bankAccountName,String i,String t,double ic,String h,String c){
		this(i,t,ic,h,c);
		this.bankAccountName = bankAccountName;
	}
	
	public FIncomeVO(String i,String t,double ic,String h,String c){
		id=i;
		time=t;
		income=ic;
		hall=h;
		clerk=c;	
	}
	
	public FIncomeVO() {
		// TODO 自动生成的构造函数存根
	}

	public String getBankAccountName(){
		return bankAccountName;
	}
	
	public void setBankAccountName(String accountName){
		this.bankAccountName = accountName;
	}
	
	public String getID(){
		return id;
	}

	public void setID(String id){
		this.id = id;
	}

	public String getTime(){
		return time;
	}

	public void setTime(String time){
		this.time = time;
	}

	public double getIncome(){
		return income;
	}

	public void setIncome(double income){
		this.income = income;
	}

	public String getShop(){
		return hall;
	}

	public void setShop(String hall){
		this.hall = hall;
	}

	public String getClerk(){
		return clerk;
	}

	public void setClerk(String clerk){
		this.clerk = clerk;
	}
}
