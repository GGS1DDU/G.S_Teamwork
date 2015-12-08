package elms.vo;

public class CarVO{
	String id;
	String plateNumber;
	String usingTime;

	public CarVO(String i,String pn,String ut){
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


