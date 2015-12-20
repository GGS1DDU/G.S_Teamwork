package elms.vo;


import elms.businesslogic.logbl.Operation;

public class LogVO{
	String id;
	Enum<Operation> category;
	String time;
	String name;

	public LogVO(String id, Enum<Operation> category, String time, String name) {
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