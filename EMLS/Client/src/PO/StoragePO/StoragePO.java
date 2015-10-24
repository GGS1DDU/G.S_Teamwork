package StoragePO;

import java.io.Serializable;

public class StoragePO implements Serializable{
	String id;
	String area;
	String seat;
	String order;
	String timeIn;
	String timeOut;
	String state;
	String name;
public StoragePO(String i,String a,String st,String o,
		String ti,String to,String se ,String n){
	id=i;
	area=a;
	seat=st;
	order=o;
	timeIn=ti;
	timeOut=to;
	state=se;
	name=n;
}
public String getID(){
	return id;
}
public String getArea(){
	return area;
}
public String getSeat(){
	return seat;
}
public String getOrder(){
	return order;
}
public String getTimeIn(){
	return timeIn;
}
public String getTimeOut(){
	return timeOut;
}
public String getState(){
	return state;
}
public String getName(){
	return name;
}
}
