package elms.vo;

import java.util.ArrayList;

public class LoadingListZZVO {
	//ZZZX loadingList
			String id;//单据id
			String time;//装车日期
			String transportNumber;//汽运编号
			String arrival;//到达地
			String carNumber;//车辆代号
			String surpervisor;//监装员
			String supercargo;//押运员
			ArrayList<String> orderNumber;
			double cost;//运费

			public LoadingListZZVO(String id,String time,String transportNumber,String arrival,String carNumber,
					String surpervisor,String supercargo,ArrayList<String> orderNumber,double cost){
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
