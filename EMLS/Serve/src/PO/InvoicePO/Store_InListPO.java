package InvoicePO;

import java.io.Serializable;

import StoragePO.StoragePO;

public class Store_InListPO extends InvoicePO implements Serializable {
	String id;
	String area;
	String seat;
	String order;
	String timeIn;
	String state;
	public Store_InListPO(StoragePO sp){
		id=sp.getID();
		area=sp.getArea();
		seat=sp.getSeat();
		order=sp.getOrder();
		timeIn=sp.getTimeIn();
		state=sp.getState();
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
	public String getState(){
		return state;
	}
}
