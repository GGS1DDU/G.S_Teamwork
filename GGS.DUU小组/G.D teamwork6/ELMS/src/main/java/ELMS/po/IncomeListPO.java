package ELMS.po;
import java.io.Serializable;
/**
 * 功能：收款单
 * 作者：郑闻昊
 */
import java.util.ArrayList;

public class IncomeListPO implements Serializable {
	
	
	 String ID;
	 ArrayList<Long> AllOrderID;        //当天该快递员所有快递单号
	 String receivaltime;   //收款日期
	 String courier_name;   //收款快递员
	 double fee; //费用之和
	 
	 
	public IncomeListPO(String iD, ArrayList<Long> allOrderID,
			String receivaltime, String courier_name, double fee) {
		super();
		ID = iD;
		AllOrderID = allOrderID;
		this.receivaltime = receivaltime;
		this.courier_name = courier_name;
		this.fee = fee;
	}


	public String getID() {
		return ID;
	}


	public ArrayList<Long> getAllOrderID() {
		return AllOrderID;
	}


	public String getReceivaltime() {
		return receivaltime;
	}


	public String getCourier_name() {
		return courier_name;
	}


	public double getFee() {
		return fee;
	}
	 
	 

}
