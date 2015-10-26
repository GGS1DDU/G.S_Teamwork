package ELMS.po;

import java.io.Serializable;

public class LogPO implements Serializable{
String id;
String category;
String time;
String name;

public LogPO(String id, String category, String time, String name) {
	this.id = id;
	this.category = category;
	this.time = time;
	this.name = name;
}
public String getId() {
	return id;
}
public String getCategory() {
	return category;
}
public String getTime() {
	return time;
}
public String getName() {
	return name;
}

}