package elms.po;

import java.io.Serializable;

public class AccountPO implements Serializable{
String name;
String operator;
String date;
public String getName() {
	return name;
}
public String getOperator() {
	return operator;
}
public String getDate() {
	return date;
}
public AccountPO(String name, String operator, String date) {
	super();
	this.name = name;
	this.operator = operator;
	this.date = date;
}
}
