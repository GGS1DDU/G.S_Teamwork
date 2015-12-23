package elms.businesslogic;

public class HallInfo {

	private String time;
	private double amount;
	private String hall;
	public HallInfo(String time,double amount,String hall){
		this.time = time;
		this.amount = amount;
		this.hall = hall;
	}
	
	public String getTime(){
		return this.time;
	}
	
	public double getAmount(){
		return this.amount;
	}
	
	public String getHall(){
		return this.hall;
	}
}
