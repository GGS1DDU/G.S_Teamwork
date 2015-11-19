package ELMS.vo;

import ELMS.businesslogic.LogBL.Operation;

public class LogVO {
	String id;
	String time;
	Enum<Operation> category;
	String name;
	public LogVO(String id, String time, Enum<Operation> category, String name) {
		this.id = id;
		this.time = time;
		this.category = category;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getTime() {
		return time;
	}
	public Enum<Operation> getCategory() {
		return category;
	}
	public String getName() {
		return name;
	}
}
