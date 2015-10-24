package InvoicePO;

import java.io.Serializable;

import UserPO.UserPO;

public class SendingListPO extends InvoicePO implements Serializable{
UserPO courier;
String time;
String id;
public SendingListPO(String i,UserPO u,String t){
	id= i;
	courier =u;
	time =t;
}
public String getID(){
	return id;
}
public UserPO getCourier(){
	return courier;
}
public String getTime(){
	return time;
}
}
