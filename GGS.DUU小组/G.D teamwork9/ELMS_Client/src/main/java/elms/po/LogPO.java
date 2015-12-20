package elms.po;

import java.io.Serializable;
import elms.businesslogic.logbl.Operation;


public class LogPO implements Serializable{
String id;
Enum<Operation> category;
String time;
String name;

public LogPO(String id, Enum<Operation> category, String time, String name) {
	super();
	this.id = id;
	this.category = category;
	this.time = time;
	this.name = name;
}
public String getId() {
	return id;
}
public Enum<Operation> getCategory() {
	return category;
}
public String getTime() {
	return time;
}
public String getName() {
	return name;
}

}