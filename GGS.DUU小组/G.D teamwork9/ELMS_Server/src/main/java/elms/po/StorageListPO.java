package elms.po;

import java.io.Serializable;

public class StorageListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7582414198025670599L;
	String id;
	String area;//分区
	String seat;//位置
	String order;//订单编号
	String timeIn;//入库时间
	String timeOut;//出库时间
	String state;//状态
	String name;//中转中心
	public StorageListPO(String id, String area, String seat, String order,
			String timeIn, String timeOut, String state, String name) {
		super();
		this.id = id;
		this.area = area;
		this.seat = seat;
		this.order = order;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.state = state;
		this.name = name;
	}
	public StorageListPO() {
		// TODO Auto-generated constructor stub
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
