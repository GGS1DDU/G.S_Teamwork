package elms.po;

import java.io.Serializable;

public class CarPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1469386425581087186L;
	String id;
	String plateNumber;
	String usingTime;

	public CarPO(String i,String pn,String ut){
		super();
		this.id=i;
		this.plateNumber=pn;
		this.usingTime=ut;

	}
	public String getID(){
		return id;
	}
	public String getPlateNumber(){
		return plateNumber;
	}
	public String getUsingTime(){
		return usingTime;
	}


}
