package ELMS.vo;



public class FExpenseVO {
	String id;
	String category;
	String time;
	double expense;
	String assistantID;
	String clerkID;
	public FExpenseVO(String i,String ct,String t,double e,String a,String c){
		id=i;
		category=ct;
		time=t;
		expense=e;
		assistantID=a;
		clerkID=c;
	}
	public String getID(){
		return id;
	}

	public void setID(String id){
		this.id = id;
	}

	public String getCategory(){
		return category;
	}

	public void setCategory(String categoty){
		this.category = category;
	}

	public String getTime(){
		return time;
	}

	public void setTime(String time){
		this.time = time;
	}

	public double getExpense(){
		return expense;
	}

	public void setExpense(double expense){
		this.expense = expense;
	}

	public String getAssistant(){
		return assistantID;
	}                                  //???????????���֣�
	public String getClerk(){
		return clerkID;
	}

	public void setClerk(String clerkID){
		this.clerkID = clerkID;
	}
}
