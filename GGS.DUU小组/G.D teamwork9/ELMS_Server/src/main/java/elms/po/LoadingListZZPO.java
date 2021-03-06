package elms.po;

import java.io.Serializable;
import java.util.ArrayList;

public class LoadingListZZPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -451114294366844449L;
			//ZZZX loadingList
			String id;//单据id
			String time;//装车日期
			String transportNumber;//汽运编号
			String arrival;//到达地
			String carNumber;//车辆代号
			String surpervisor;//监装员
			String supercargo;//押运员
			ArrayList<String> orderNumber;//托运单号
			double cost;//运费

			public LoadingListZZPO(String id,String time,String transportNumber,String arrival,String carNumber,
					String surpervisor,String supercargo,ArrayList<String> orderNumber,double cost){
				super();
				this.id=id;
				this.time=time;
				this.transportNumber=transportNumber;
				this.arrival=arrival;
				this.carNumber=carNumber;
				this.surpervisor=surpervisor;
				this.supercargo=supercargo;
				this.orderNumber=orderNumber;
				this.cost=cost;		
			}
			public LoadingListZZPO() {
				// TODO 自动生成的构造函数存根
			}
			public String getID(){
				return id;
			}
			public String getTime(){
				return time;
			}
			public String getTransportNumber(){
				return transportNumber;
			}
			public String getArrival(){
				return arrival;
			}
			public String getCarNumber(){
				return carNumber;
			}
			public String getSurpervior(){
				return surpervisor;
			}
			public String getSupercargo(){
				return supercargo;
			}
			public ArrayList<String> getOrderNumber(){
				return orderNumber;
			}
			public double getCost(){
				return cost;
			}

}
