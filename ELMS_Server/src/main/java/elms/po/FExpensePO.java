package elms.po;

import java.io.Serializable;

//import UserPO.UserPO;

public class FExpensePO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String bankAccountName;
String id;
String category;
String time;
double expense;
String assistantID;
String clerkID;

public FExpensePO(String bankAccountName,String i,String ct,String t,double e,String a,String c){
	this(i,ct,t,e,a,c);
	this.bankAccountName = bankAccountName;
}

public FExpensePO(String i,String ct,String t,double e,String a,String c){
	id=i;
	category=ct;
	time=t;
	expense=e;
	assistantID=a;
	clerkID=c;
}

public FExpensePO() {
	// TODO 自动生成的构造函数存根
}

public String getBankAccountName() {
	// TODO 自动生成的方法存根
	return bankAccountName;
}

public void setBankAccountName(String name){
	this.bankAccountName = name;
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
