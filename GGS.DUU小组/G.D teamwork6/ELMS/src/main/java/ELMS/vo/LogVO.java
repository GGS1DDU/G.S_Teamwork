package ELMS.vo;

public class LogVO {
	String id;
	String time;
	String category;
	String name;
	public LogVO(String id, String time, String category, String name) {
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
	public String getCategory() {
		return category;
	}
	public String getName() {
		return name;
	}
}
