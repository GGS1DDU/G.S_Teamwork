package ELMS.vo;

public class StorageVO {
	String id;
	String area;
	String seat;
	String order;
	String timeIn;
	String timeOut;
	String state;
	String name;
	public StorageVO(String id, String area, String seat, String order,
			String timeIn, String timeOut, String state, String name) {
		this.id = id;
		this.area = area;
		this.seat = seat;
		this.order = order;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.state = state;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getArea() {
		return area;
	}
	public String getSeat() {
		return seat;
	}
	public String getOrder() {
		return order;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public String getState() {
		return state;
	}
	public String getName() {
		return name;
	}
	
}
